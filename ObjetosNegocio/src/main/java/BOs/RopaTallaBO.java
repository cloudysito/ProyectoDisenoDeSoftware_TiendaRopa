/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import Exceptions.BOException;
import Exceptions.DAOException;
import Implementaciones.RopaTallaDAO;
import Interfaces.IRopaTallaDAO;
import com.mycompany.dto_negocio.RopaTallaDTO;
import mappers.RopaTallaMapper;
import objetosnegocio.dominioPojo.RopaTalla;

/**
 *
 * @author riosr
 */
public class RopaTallaBO {
    private static RopaTallaBO instance; 
    
    private IRopaTallaDAO ropaTallaDAO;

    public RopaTallaBO() {
        this.ropaTallaDAO = new RopaTallaDAO();
    }
    
    public static RopaTallaBO getInstance(){
        if(instance == null){
            instance = new RopaTallaBO();
        }
        return instance;
    }
    
    //BO guardar 
    public RopaTallaDTO guardar(RopaTallaDTO ropaTallaDTO) throws BOException{
        try{
            RopaTalla ropaTalla = RopaTallaMapper.toEntity(ropaTallaDTO);
            
            RopaTalla ropaTallaGuardar = ropaTallaDAO.guardar(ropaTalla);
            
            return RopaTallaMapper.toDTO(ropaTallaGuardar);
            
        }catch(DAOException e){
            throw new BOException("Error al guardar empleado", e);
        }
    }
    
    //BO buscar por id ropaTalla
    public String buscarPorId(String id) throws BOException{
        try{
            
            return RopaTallaDAO.buscarPorId(id);
            
        }catch(DAOException e){
            throw new BOException("Error al buscar por id empleado", e);
        }
    }
    
    //BO buscar por codigo ropaTalla
    public String buscarPorId(String codigo) throws BOException{
        try{
            
            return RopaTallaDAO.buscarPorId(codigo);
            
        }catch(DAOException e){
            throw new BOException("Error al buscar por id empleado", e);
        }
    }
}
