/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import BOs.Exception.BOException;
import Exceptions.DAOException;
import Implementaciones.RopaDAO;
import Interfaces.IRopaDAO;
import com.mycompany.dto_negocio.RopaDTO;
import java.util.ArrayList;
import java.util.List;
import mappers.RopaMapper;
import objetosnegocio.dominioPojo.Ropa;

/**
 *
 * @author riosr
 */
public class RopaBO {
    private static RopaBO instance; 
    
    private IRopaDAO ropaDAO;

    public RopaBO() {
        this.ropaDAO = new RopaDAO();
    }
    
    public static RopaBO getInstance(){
        if(instance == null){
            instance = new RopaBO();
        }
        return instance;
    }
    
    //BO guardar ropa
    public RopaDTO guardarRopa(RopaDTO ropaDTO) throws BOException{
        try{
            Ropa ropa = RopaMapper.toEntity(ropaDTO);
            
            Ropa ropaGuardar = ropaDAO.guardarRopa(ropa);
            
            return RopaMapper.toDTO(ropaGuardar);
            
        }catch(DAOException e){
            throw new BOException("Error al guardar empleado", e);
        }
    }
        
    //BO modificar ropa
    public RopaDTO modificarRopa(RopaDTO ropaDTO) throws BOException{
        try{
            Ropa ropa = RopaMapper.toEntity(ropaDTO);
            
            Ropa ropaModificar = ropaDAO.modificarRopa(ropa);
            
            return RopaMapper.toDTO(ropaModificar);
            
        }catch(DAOException e){
            throw new BOException("Error al guardar empleado", e);
        }
    }
    
    //BO eliminar ropa
    public RopaDTO eliminarRopa(RopaDTO ropaDTO) throws BOException{
        try{
            Ropa ropa = RopaMapper.toEntity(ropaDTO);
            
            Ropa ropaEliminar = ropaDAO.eliminarRopa(ropa);
            
            return RopaMapper.toDTO(ropaEliminar);
            
        }catch(DAOException e){
            throw new BOException("Error al eliminar ropa", e);
        }
    }
    
    //BO buscar por id ropa
    public RopaDTO buscarPorId(String idRopa) throws BOException{
        try{
            
            return RopaMapper.toDTO(ropaDAO.buscarPorId(idRopa));
            
        }catch(DAOException e){
            throw new BOException("Error al buscar por id ropa", e);
        }
    }
    
    //BO buscar por nombre ropa
    public List<RopaDTO> buscarPorNombre(String nombreArticulo) throws BOException{
        try{
            List<Ropa> listaRopa = ropaDAO.buscarPorNombre(nombreArticulo);

            List<RopaDTO> listaDTO = new ArrayList<>();

            for (Ropa r : listaRopa) {
                listaDTO.add(RopaMapper.toDTO(r));
            }

            return listaDTO;
            
        }catch(DAOException e){
            throw new BOException("Error al buscar por id empleado", e);
        }
    }
    
    //BO buscar toda la ropa
    public List<RopaDTO> buscarTodos() throws BOException {
        try {
            List<Ropa> listaRopa = ropaDAO.buscarTodos();

            List<RopaDTO> listaDTO = new ArrayList<>();
            
            for (Ropa r : listaRopa) {
                listaDTO.add(RopaMapper.toDTO(r));
            }

            return listaDTO;

        } catch (DAOException e) {
            throw new BOException("Error al obtener todo el catálogo de ropa", e);
        }
    }
    
    
}
