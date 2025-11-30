/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import BOs.Exception.BOException;
import Exceptions.DAOException;
import Implementaciones.BonificacionDAO;
import Interfaces.IBonificacionDAO;
import com.mycompany.dto_negocio.BonificacionDTO;
import mappers.BonificacionMapper;

/**
 *
 * @author riosr
 */
public class BonificacionBO {
    private static BonificacionBO instance;

    private IBonificacionDAO bonificacionDAO;

    public BonificacionBO() {
        this.bonificacionDAO = new BonificacionDAO();
    }

    public static BonificacionBO getInstance() {
        if (instance == null) {
            instance = new BonificacionBO();
        }
        return instance;
    }
    
    public BonificacionDTO buscarPorId(String id) throws BOException {
        try {

            return BonificacionMapper.toDTO(BonificacionDAO.buscarPorId(id));

        } catch (DAOException e) {
            throw new BOException("Error al buscar por id empleado", e);
        }
    }
}
