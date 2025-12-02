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
import objetosnegocio.dominioPojo.Bonificacion;

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
    
    public BonificacionDTO guardarEmpleado(BonificacionDTO empleadoDTO) throws BOException {
        try {
            Bonificacion bonificacion = BonificacionMapper.toEntity(empleadoDTO);

            Bonificacion bonificacionGuardar = bonificacionDAO.guardarBonificacion(bonificacion);

            return BonificacionMapper.toDTO(bonificacionGuardar);

        } catch (DAOException e) {
            throw new BOException("Error al guardar bonificacion", e);
        }
    }
    
    public BonificacionDTO modificarCapacitacion(BonificacionDTO bonificacionDTO) throws BOException {
        try {
            Bonificacion bonificacion = BonificacionMapper.toEntity(bonificacionDTO);

            Bonificacion bonificacionModificar = bonificacionDAO.modificarBonificacion(bonificacion);

            return BonificacionMapper.toDTO(bonificacionModificar);
        } catch (DAOException e) {
            throw new BOException("Error al modificar capacitacion", e);
        }
    }
    
    public BonificacionDTO buscarPorId(String idBonificacion) throws BOException {
        try {

            return BonificacionMapper.toDTO(bonificacionDAO.buscarPorId(idBonificacion));

        } catch (DAOException e) {
            throw new BOException("Error al buscar por id bonificacion", e);
        }
    }
}
