/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import Exceptions.BOException;
import Exceptions.DAOException;
import Implementaciones.VentaDAO;
import Interfaces.IVentaDAO;
import com.mycompany.dto_negocio.VentaDTO;
import mappers.VentaMapper;
import objetosnegocio.dominioPojo.Venta;


/**
 *
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
    
    //BO guardar venta
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
    
    //Buacar por id venta
    public VentaDTO buscarPorId(String idVenta) throws BOException{
        try{
            
            return VentaMapper.toDTO(ventaDAO.buscarPorId(idVenta));
            
        }catch(DAOException e){
            throw new BOException("Error al buscar por id empleado", e);
        }
    }
    
}
