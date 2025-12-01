/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import BOs.Exception.BOException;
import Exceptions.DAOException;
import Implementaciones.RecompenzaDAO;
import Interfaces.IRecompenzaDAO;
import com.mycompany.dto_negocio.RecompensaDTO;
import mappers.RecompenzaMapper;

/**
 *
 * @author riosr
 */
public class RecompenzaBO {
    private static RecompenzaBO instance;

    private IRecompenzaDAO recompenzaDAO;

    public RecompenzaBO() {
        this.recompenzaDAO = new RecompenzaDAO() {};
    }

    public static RecompenzaBO getInstance() {
        if (instance == null) {
            instance = new RecompenzaBO();
        }
        return instance;
    }
    
    public RecompensaDTO buscarPorId(String id) throws BOException {
        try {

            return RecompenzaMapper.toDTO(recompenzaDAO.buscarPorId(id));

        } catch (DAOException e) {
            throw new BOException("Error al buscar por id empleado", e);
        }
    }
}
