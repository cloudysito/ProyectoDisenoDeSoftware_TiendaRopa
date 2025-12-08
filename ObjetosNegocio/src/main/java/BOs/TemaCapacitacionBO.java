/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import BOs.Exception.BOException;
import Exceptions.DAOException;
import Implementaciones.TemaCapacitacionDAO;
import Interfaces.ITemaCapacitacionDAO;
import com.mycompany.dto_negocio.TemaCapacitacionDTO;
import mappers.TemaCapacitacionMapper;
import objetosnegocio.dominioPojo.TemaCapacitacion;

/**
 *
 * @author riosr
 */
public class TemaCapacitacionBO {
    
    private static TemaCapacitacionBO instance; 
    
    private ITemaCapacitacionDAO temaCapacitacionDAO;

    public TemaCapacitacionBO() {
        this.temaCapacitacionDAO = new TemaCapacitacionDAO();
    }
    
    public static TemaCapacitacionBO getInstance(){
        if(instance == null){
            instance = new TemaCapacitacionBO();
        }
        return instance;
    }
    
    public TemaCapacitacionDTO guardarTemaCapacitacion(TemaCapacitacionDTO temaCapacitacionDTO) throws BOException {
        try {
            TemaCapacitacion temaCapacitacion = TemaCapacitacionMapper.toEntity(temaCapacitacionDTO);

            TemaCapacitacion temaCapacitacionGuardar = temaCapacitacionDAO.guardarTemaCapacitacion(temaCapacitacion);

            return TemaCapacitacionMapper.toDTO(temaCapacitacionGuardar);

        } catch (DAOException e) {
            throw new BOException("Error al guardar tema de capacitacion", e);
        }
    }
    
    public TemaCapacitacionDTO buscarPorNombre(String temaCapacitacion) throws BOException{
        try{
            
            return TemaCapacitacionMapper.toDTO(temaCapacitacionDAO.buscarPorNombre(temaCapacitacion));
            
        }catch(DAOException e){
            throw new BOException("Error al buscar por id tema de capacitacion", e);
        }
    }
}
