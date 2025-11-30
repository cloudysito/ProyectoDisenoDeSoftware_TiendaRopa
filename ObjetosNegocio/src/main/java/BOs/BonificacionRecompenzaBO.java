/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import BOs.Exception.BOException;
import Exceptions.DAOException;
import Implementaciones.BonificacionRecompenzaDAO;
import Interfaces.IBonificacionRecompenzaDAO;
import com.mycompany.dto_negocio.BonificacionRecompenzaDTO;
import mappers.BonificacionRecompenzaMapper;
import objetosnegocio.dominioPojo.BonificacionRecompenza;
/**
 *
 * @author riosr
 */
public class BonificacionRecompenzaBO {
    
    private static BonificacionRecompenzaBO instance; 
    
    private IBonificacionRecompenzaDAO bonificacionRecompenzaDAO;

    public BonificacionRecompenzaBO() {
        this.bonificacionRecompenzaDAO = new BonificacionRecompenzaDAO();
    }
    
    public static BonificacionRecompenzaBO getInstance(){
        if(instance == null){
            instance = new BonificacionRecompenzaBO();
        }
        return instance;
    }
    
    public BonificacionRecompenzaDTO buscarPorId(String idEmpleado) throws BOException{
        try{
            
            return BonificacionRecompenzaMapper.toDTO(BonificacionRecompenzaDAO.buscarPorId(idBonificacionRecompenza));
            
        }catch(DAOException e){
            throw new BOException("Error al buscar por id empleado", e);
        }
    }
}
