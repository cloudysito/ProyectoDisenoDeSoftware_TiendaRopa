/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import BOs.Exception.BOException;
import Exceptions.DAOException;
import Implementaciones.CapacitacionDAO;
import Interfaces.ICapacitacionDAO;
import com.mycompany.dto_negocio.CapacitacionDTO;
import mappers.CapacitacionMapper;

/**
 *
 * @author riosr
 */
public class CapacitacionBO {
    private static CapacitacionBO instance;

    private ICapacitacionDAO capacitacionDAO;

    public CapacitacionBO() {
        this.capacitacionDAO = new CapacitacionDAO() {};
    }

    public static CapacitacionBO getInstance() {
        if (instance == null) {
            instance = new CapacitacionBO();
        }
        return instance;
    }
    
    public CapacitacionDTO buscarPorId(String id) throws BOException {
        try {

            return CapacitacionMapper.toDTO(capacitacionDAO.buscarPorId(id));

        } catch (DAOException e) {
            throw new BOException("Error al buscar por id empleado", e);
        }
    }
}
