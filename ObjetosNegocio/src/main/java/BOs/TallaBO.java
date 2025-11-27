/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import Exceptions.BOException;
import Exceptions.DAOException;
import Implementaciones.TallaDAO;
import Interfaces.ITallaDAO;
import com.mycompany.dto_negocio.TallaDTO;
import mappers.TallaMapper;
import objetosnegocio.dominioPojo.Talla;
/**
 *
 * @author riosr
 */
public class TallaBO {
    
    private static TallaBO instance; 
    
    private ITallaDAO tallaDAO;

    public TallaBO() {
        this.tallaDAO = new TallaDAO();
    }
    
    public static TallaBO getInstance(){
        if(instance == null){
            instance = new TallaBO();
        }
        return instance;
    }
    
    //BO guardar talla
    public TallaDTO guardarTalla(TallaDTO tallaDTO) throws BOException{
        try{
            Talla talla = TallaMapper.toEntity(tallaDTO);
            
            Talla tallaGuardar = tallaDAO.guardarTalla(talla);
            
            return TallaMapper.toDTO(tallaGuardar);
            
        }catch(DAOException e){
            throw new BOException("Error al guardar empleado", e);
        }
    }
    
    //BO modificar talla
    public TallaDTO modificarTalla(TallaDTO tallaDTO) throws BOException{
        try{
            Talla talla = TallaMapper.toEntity(tallaDTO);
            
            Talla tallaModificar = tallaDAO.modificarTalla(talla);
            
            return TallaMapper.toDTO(tallaModificar);
            
        }catch(DAOException e){
            throw new BOException("Error al guardar empleado", e);
        }
    }
    
    //BO eliminar talla
    public TallaDTO eliminarTalla(TallaDTO tallaDTO) throws BOException{
        try{
            Talla talla = TallaMapper.toEntity(tallaDTO);
            
            Talla tallaEliminar = tallaDAO.eliminarTalla(talla);
            
            return TallaMapper.toDTO(tallaEliminar);
            
        }catch(DAOException e){
            throw new BOException("Error al guardar empleado", e);
        }
    }
    
    //BO buscar por id talla
    public TallaDTO buscarPorId(String idTalla) throws BOException{
        try{
            
            return TallaMapper.toDTO(tallaDAO.buscarPorId(idTalla));
            
        }catch(DAOException e){
            throw new BOException("Error al buscar por id empleado", e);
        }
    }
    
}
