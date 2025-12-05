package BOs;

import Implementaciones.EmpleadoDAO;
import Implementaciones.ReembolsoDAO;
import Implementaciones.RopaTallaDAO;
import Implementaciones.VentaDAO;
import Interfaces.IEmpleadoDAO;
import Interfaces.IReembolsoDAO;
import Interfaces.IRopaTallaDAO;
import Interfaces.ISistemaPagos;
import Interfaces.ITallaDAO;
import Interfaces.IVentaDAO;

import com.mycompany.dto_negocio.EmpleadoDTO;

import com.mycompany.dto_negocio.SolicitudReembolsoDTO; 
import com.mycompany.dto_negocio.VentaDTO;
import mappers.EmpleadoMapper;
import objetosnegocio.dominioPojo.Reembolso;

import mappers.ReembolsoMapper;
import objetosnegocio.dominioPojo.Empleado;

/**
 * BO encargado del proceso de Reembolso.
 * Integra validaciones, persistencia y sistema de pagos externos.
 */
public class ReembolsoBO {
    private static ReembolsoBO instance;

    private IRopaTallaDAO ropaTallaDAO;
    
    private IEmpleadoDAO empleadoDAO;
    private IVentaDAO ventaDAO;
    private IReembolsoDAO reembolsoDAO;

    private ReembolsoBO() {
        this.ropaTallaDAO = new RopaTallaDAO();
        this.empleadoDAO = new EmpleadoDAO();
        this.ventaDAO = new VentaDAO();
        this.reembolsoDAO = new ReembolsoDAO();
    }

    public static synchronized ReembolsoBO getInstance() {
        if (instance == null) {
            instance = new ReembolsoBO();
        }
        return instance;
    }
    
    public VentaDTO buscarVenta(String idVentaString) {
        try {
            if (!org.bson.types.ObjectId.isValid(idVentaString)) {
                return null;
            }
            objetosnegocio.dominioPojo.Venta venta = ventaDAO.buscarPorId(idVentaString);
            
            if (venta == null) return null;
            return mappers.VentaMapper.toDTO(venta);
            
        } catch (Exception e) {
            System.out.println("Error en BO: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Procesa la devolución: Pago -> Stock -> BD.
     */
    public boolean procesarReembolso(SolicitudReembolsoDTO solicitudDTO, boolean  pagoExitoso) {
        Reembolso devolucionEntity = ReembolsoMapper.toEntity(solicitudDTO);

        if (!pagoExitoso) {
            return false;
        }
        if (devolucionEntity.getDetalles() != null) {
            devolucionEntity.getDetalles().forEach(detalle -> {
                if (detalle.getRopaTalla() != null) {
                    ropaTallaDAO.actualizarStock(
                        detalle.getRopaTalla().getId(), 
                        detalle.getCantidadDevuelta()
                    );
                }
            });
        }
        reembolsoDAO.guardar(devolucionEntity);

        return true;
    }
    
    public EmpleadoDTO autenticar(String usuario, String contrasenia) {
        Empleado empleadoDominio = empleadoDAO.buscarPorCredenciales(usuario, contrasenia);
        return EmpleadoMapper.toDTO(empleadoDominio);
    }

    public boolean validarCantidades(SolicitudReembolsoDTO solicitud) {
        return true; 
    }
}
