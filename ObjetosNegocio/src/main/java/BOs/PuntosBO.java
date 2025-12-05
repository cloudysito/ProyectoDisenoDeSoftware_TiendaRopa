/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import BOs.Exception.BOException;
import Exceptions.DAOException;
import Implementaciones.PuntosDAO;
import com.mycompany.dto_negocio.PuntosDTO;
import mappers.PuntosMapper;
import objetosnegocio.dominioPojo.Puntos;
import Interfaces.IPuntosDAO;
/**
 *
 * @author riosr
 */
public class PuntosBO {
    
    private static PuntosBO instance; 
    
    private IPuntosDAO puntosDAO;

    public PuntosBO() {
        this.puntosDAO = new PuntosDAO();
    }
    
    public static PuntosBO getInstance(){
        if(instance == null){
            instance = new PuntosBO();
        }
        return instance;
    }
    
    /**
     * Asigna puntos a un producto o transacción.
     */
    public PuntosDTO guardarPuntos(PuntosDTO puntosDTO) throws BOException {
        try {
            Puntos puntos = PuntosMapper.toEntity(puntosDTO);

            Puntos puntosGuardar = puntosDAO.guardarPuntos(puntos);

            return PuntosMapper.toDTO(puntosGuardar);

        } catch (DAOException e) {
            throw new BOException("Error al guardar puntos", e);
        }
    }
    
    public PuntosDTO buscarPorId(String idPuntos) throws BOException{
        try{
            
            return PuntosMapper.toDTO(puntosDAO.buscarPorId(idPuntos));
            
        }catch(DAOException e){
            throw new BOException("Error al buscar por id puntos", e);
        }
    }
}
