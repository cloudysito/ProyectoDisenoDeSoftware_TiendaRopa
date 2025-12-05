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
 * Objeto de Negocio para la entidad Ropa.
 * Gestiona el catálogo general de productos (creación, modificación, eliminación y consulta).
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
    
    /**
     * Registra una nueva prenda en el catálogo general.
     * @param ropaDTO Datos de la prenda.
     * @return La prenda registrada como DTO.
     * @throws BOException Error al guardar.
     */
    public RopaDTO guardarRopa(RopaDTO ropaDTO) throws BOException{
        try{
            Ropa ropa = RopaMapper.toEntity(ropaDTO);
            
            Ropa ropaGuardar = ropaDAO.guardarRopa(ropa);
            
            return RopaMapper.toDTO(ropaGuardar);
            
        }catch(DAOException e){
            throw new BOException("Error al guardar empleado", e);
        }
    }
        
    /**
     * Actualiza la información de una prenda existente.
     * @param ropaDTO Datos actualizados.
     * @return La prenda modificada.
     * @throws BOException Error al modificar.
     */
    public RopaDTO modificarRopa(RopaDTO ropaDTO) throws BOException{
        try{
            Ropa ropa = RopaMapper.toEntity(ropaDTO);
            
            Ropa ropaModificar = ropaDAO.modificarRopa(ropa);
            
            return RopaMapper.toDTO(ropaModificar);
            
        }catch(DAOException e){
            throw new BOException("Error al guardar empleado", e);
        }
    }
    
    /**
     * Elimina (física o lógicamente) una prenda del catálogo.
     * @param ropaDTO Prenda a eliminar.
     * @return La prenda eliminada.
     * @throws BOException Error al eliminar.
     */
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
    
    /**
     * Busca prendas que coincidan con un nombre específico.
     * @param nombreArticulo Nombre o parte del nombre a buscar.
     * @return Lista de prendas encontradas.
     * @throws BOException Error en la búsqueda.
     */
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
    
    /**
     * Recupera el catálogo completo de ropa.
     * @return Lista de todas las prendas.
     * @throws BOException Error al consultar.
     */
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
