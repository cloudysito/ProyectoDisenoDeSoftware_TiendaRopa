/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import BOs.Exception.BOException;
import Exceptions.DAOException;
import Implementaciones.VentaDAO;
import Interfaces.IVentaDAO;
import com.mycompany.dto_negocio.VentaDTO;
import java.util.ArrayList;
import java.util.List;
import mappers.VentaMapper;
import objetosnegocio.dominioPojo.Venta;


/**
 * Objeto de Negocio para la gestión de Ventas.
 * Maneja el registro, modificación, eliminación y consulta del historial de ventas.
 * @author riosr
 */
public class VentaBO {
    
    private static VentaBO instance; 
    
    private IVentaDAO ventaDAO;

    public VentaBO() {
        this.ventaDAO = new VentaDAO();
    }
    
    public static VentaBO getInstance(){
        if(instance == null){
            instance = new VentaBO();
        }
        return instance;
    }
    
    /**
     * Registra una nueva venta en el sistema.
     * @param ventaDTO DTO con los detalles de la venta (productos, cliente, total).
     * @return La venta registrada con su ID y Folio generados.
     * @throws BOException Error al guardar.
     */
    public VentaDTO guardarVenta(VentaDTO ventaDTO) throws BOException{
        try{
            Venta venta = VentaMapper.toEntity(ventaDTO);
            
            Venta ventaGuardar = ventaDAO.guardarVenta(venta);
            
            return VentaMapper.toDTO(ventaGuardar);
            
        }catch(DAOException e){
            throw new BOException("Error al guardar empleado", e);
        }
    }
    
    //BO modificar venta
    public VentaDTO modificarVenta(VentaDTO ventaDTO) throws BOException{
        try{
            Venta venta = VentaMapper.toEntity(ventaDTO);
            
            Venta ventaModificar = ventaDAO.modificarVenta(venta);
            
            return VentaMapper.toDTO(ventaModificar);
            
        }catch(DAOException e){
            throw new BOException("Error al guardar empleado", e);
        }
    }
    
    //BO eliminar venta
    public VentaDTO eliminarVenta(VentaDTO ventaDTO) throws BOException{
        try{
            Venta venta = VentaMapper.toEntity(ventaDTO);
            
            Venta ventaEliminar = ventaDAO.eliminarVenta(venta);
            
            return VentaMapper.toDTO(ventaEliminar);
            
        }catch(DAOException e){
            throw new BOException("Error al guardar empleado", e);
        }
    }
    
    /**
     * Busca una venta por su ID único de base de datos.
     * @param idVenta ID string.
     * @return VentaDTO encontrada.
     * @throws BOException Error en búsqueda.
     */
    public VentaDTO buscarPorId(String idVenta) throws BOException{
        try{
            
            return VentaMapper.toDTO(ventaDAO.buscarPorId(idVenta));
            
        }catch(DAOException e){
            throw new BOException("Error al buscar por id empleado", e);
        }
    }
    
    /**
     * Busca una venta por su número de folio legible.
     * @param folio Número de folio.
     * @return VentaDTO encontrada.
     * @throws BOException Error en búsqueda.
     */
    public VentaDTO buscarPorFolio(int folio)throws BOException{
        try{
            
            return VentaMapper.toDTO(ventaDAO.buscarPorFolio(folio));
            
        }catch(DAOException e){
            throw new BOException("Error al buscar por id empleado", e);
        }
    }
    
    /**
     * Recupera el historial completo de ventas.
     * @return Lista de todas las ventas registradas.
     * @throws BOException Error al consultar.
     */
    public List<VentaDTO> buscarTodas() throws BOException {
        try {
            List<Venta> listaRopa = ventaDAO.buscarTodas();

            List<VentaDTO> listaDTO = new ArrayList<>();
            
            for (Venta v : listaRopa) {
                listaDTO.add(VentaMapper.toDTO(v));
            }

            return listaDTO;

        } catch (DAOException e) {
            throw new BOException("Error al obtener todas las ventas", e);
        }
    }
    
}
