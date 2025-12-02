/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import BOs.Exception.BOException;
import Exceptions.DAOException;
import Implementaciones.RecompensaDAO;
import com.mycompany.dto_negocio.RecompensaDTO;
import mappers.RecompensaMapper;
import Interfaces.IRecompensaDAO;
import objetosnegocio.dominioPojo.Recompensa;

/**
 *
 * @author riosr
 */
public class RecompensaBO {
    private static RecompensaBO instance;

    private IRecompensaDAO recompensaDAO;

    public RecompensaBO() {
        this.recompensaDAO = new RecompensaDAO() {};
    }

    public static RecompensaBO getInstance() {
        if (instance == null) {
            instance = new RecompensaBO();
        }
        return instance;
    }
    
    public RecompensaDTO guardarRecompensa(RecompensaDTO recompensaDTO) throws BOException {
        try {
            Recompensa recompensa = RecompensaMapper.toEntity(recompensaDTO);

            Recompensa recompensaGuardar = recompensaDAO.guardarRecompensa(recompensa);

            return RecompensaMapper.toDTO(recompensaGuardar);

        } catch (DAOException e) {
            throw new BOException("Error al guardar recompensa", e);
        }
    }
    
    public RecompensaDTO buscarPorId(String idRecompensa) throws BOException {
        try {

            return RecompensaMapper.toDTO(recompensaDAO.buscarPorId(idRecompensa));

        } catch (DAOException e) {
            throw new BOException("Error al buscar por id recompensa", e);
        }
    }
}
