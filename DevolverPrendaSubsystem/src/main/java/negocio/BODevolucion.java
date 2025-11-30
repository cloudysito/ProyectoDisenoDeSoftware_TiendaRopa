/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import Interfaces.IEmpleadoDAO;
import Interfaces.ITallaDAO;
import Interfaces.IVentaDAO;


import com.mycompany.dto_negocio.DetalleDevolucionDTO;
import com.mycompany.dto_negocio.DetalleVentaDTO;
import com.mycompany.dto_negocio.ItemVentaDTO;
import com.mycompany.dto_negocio.SolicitudDevolucionDTO;
import com.mycompany.dto_negocio.TicketVentaDTO;
import infraestructura.ISistemaPagos;

import objetosnegocio.dominioPojo.DetalleDevolucion;
import objetosnegocio.dominioPojo.DetalleVenta;
import objetosnegocio.dominioPojo.Devolucion;
import objetosnegocio.dominioPojo.Empleado;
import objetosnegocio.dominioPojo.RopaTalla;
import objetosnegocio.dominioPojo.Venta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import persistencia.IDevolucionDAO;

public class BODevolucion implements IBODevolucion {
    private IEmpleadoDAO empleadoDAO;
    private IVentaDAO ventaDAO;
    private ITallaDAO tallaDAO;
    private IDevolucionDAO devolucionDAO;
    private ISistemaPagos sistemaPagos;

    public BODevolucion(IEmpleadoDAO empleadoDAO, IVentaDAO ventaDAO, ITallaDAO tallaDAO, 
                        IDevolucionDAO devolucionDAO, ISistemaPagos sistemaPagos) {
        this.empleadoDAO = empleadoDAO;
        this.ventaDAO = ventaDAO;
        this.tallaDAO = tallaDAO;
        this.devolucionDAO = devolucionDAO;
        this.sistemaPagos = sistemaPagos;
    }

    @Override
    public Empleado autenticar(String usuario, String contrasenia) {
        return empleadoDAO.buscarPorCredenciales(usuario, contrasenia);
    }

    @Override
    public TicketVentaDTO buscarVenta(String idVentaString) {
        try {
            ObjectId id = new ObjectId(idVentaString);
            Venta venta = ventaDAO.buscarPorId(id);
            
            if (venta == null) return null;

            DetalleVentaDTO dto = new DetalleVentaDTO();
            dto.setIdVenta(venta.getId().toString());
            dto.setFechaCompra(venta.getFechaHoraVenta());
            
            List<ItemVentaDTO> itemsDTO = new ArrayList<>();
            if (venta.getDetalles() != null) {
                for (DetalleVenta dv : venta.getDetalles()) {
                    ItemVentaDTO item = new ItemVentaDTO();
                    if(dv.getRopaTalla() != null) {
                        item.setIdRopaTalla(dv.getRopaTalla().getId().toString());
                        String nombre = (dv.getRopaTalla().getRopa() != null) ? dv.getRopaTalla().getRopa().getNombreArticulo() : "Sin Nombre";
                        String talla = (dv.getRopaTalla().getTalla() != null) ? dv.getRopaTalla().getTalla().getNombreTalla() : "?";
                        item.setNombrePrenda(nombre);
                        item.setTalla(talla);
                    }
                    item.setCantidadComprada(dv.getCantidadVendida());
                    if (dv.getCantidadVendida() > 0) {
                        item.setPrecioUnitario(dv.getSubtotal() / dv.getCantidadVendida());
                    }
                    itemsDTO.add(item);
                }
            }
            dto.setItemsComprados(itemsDTO);
            return dto;
        } catch (Exception e) {
            System.out.println("Error buscando venta: " + e.getMessage());
            return null; 
        }
    }

    @Override
    public boolean validarCantidades(SolicitudDevolucionDTO solicitud) {
        try {
            ObjectId id = new ObjectId(solicitud.getIdVentaOriginal());
            Venta ventaOriginal = ventaDAO.buscarPorId(id);
            
            if (ventaOriginal == null) return false;

            for (DetalleDevolucionDTO itemDevolver : solicitud.getListaDetalles()) {
                boolean encontrado = false;
                for (DetalleVenta itemVendido : ventaOriginal.getDetalles()) {
                    String idVendido = itemVendido.getRopaTalla().getId().toString();
                    if (idVendido.equals(itemDevolver.getIdRopaTalla())) {
                        if (itemDevolver.getCantidadDevuelta() > itemVendido.getCantidadVendida()) {
                            return false; 
                        }
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Devolucion procesarDevolucion(SolicitudDevolucionDTO solicitud) {
        boolean pagoExitoso = sistemaPagos.ejecutarReembolso(solicitud.getMontoTotal(), solicitud.getMetodoReembolso());
        if (!pagoExitoso) throw new RuntimeException("Fallo en el reembolso.");

        Devolucion nuevaDevolucion = new Devolucion();
        nuevaDevolucion.setIdVentaOriginal(new ObjectId(solicitud.getIdVentaOriginal()));
        nuevaDevolucion.setFechaDevolucion(new Date());
        nuevaDevolucion.setTotalReembolsado(solicitud.getMontoTotal());
        nuevaDevolucion.setMetodoReembolso(solicitud.getMetodoReembolso());

        List<DetalleDevolucion> detalles = new ArrayList<>();
        for (DetalleDevolucionDTO itemDTO : solicitud.getListaDetalles()) {
            DetalleDevolucion detalle = new DetalleDevolucion();
            detalle.setCantidadDevuelta(itemDTO.getCantidadDevuelta());
            detalle.setSubtotalReembolsado(itemDTO.getSubtotalReembolsado());
            
            ObjectId idRopaTalla = new ObjectId(itemDTO.getIdRopaTalla());
            tallaDAO.actualizarStock(idRopaTalla, itemDTO.getCantidadDevuelta());
            
            detalles.add(detalle);
        }
        nuevaDevolucion.setDetalles(detalles);

        return devolucionDAO.guardar(nuevaDevolucion);
    }
}