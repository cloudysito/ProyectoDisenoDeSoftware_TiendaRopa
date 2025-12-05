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
import objetosnegocio.dominioPojo.Capacitacion;

/**
 * Objeto de Negocio para Capacitaciones.
 * Maneja el ciclo de vida de las capacitaciones (creación, edición, búsqueda).
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
    
    /**
     * Registra una nueva capacitación.
     * @param capacitacionDTO Datos de la capacitación.
     * @return DTO registrado.
     * @throws BOException Error en persistencia.
     */
    public CapacitacionDTO guardarCapacitacion(CapacitacionDTO capacitacionDTO) throws BOException {
        try {
            Capacitacion capacitacion = CapacitacionMapper.toEntity(capacitacionDTO);

            Capacitacion capacitacionGuardar = capacitacionDAO.guardarCapacitacion(capacitacion);

            return CapacitacionMapper.toDTO(capacitacionGuardar);

        } catch (DAOException e) {
            throw new BOException("Error al guardar capacitacion", e);
        }
    }
    
    public CapacitacionDTO modificarCapacitacion(CapacitacionDTO capacitacionDTO) throws BOException {
        try {
            Capacitacion capacitacion = CapacitacionMapper.toEntity(capacitacionDTO);

            Capacitacion capacitacionModificar = capacitacionDAO.modificarCapacitacion(capacitacion);

            return CapacitacionMapper.toDTO(capacitacionModificar);
        } catch (DAOException e) {
            throw new BOException("Error al modificar capacitacion", e);
        }
    }
    
    
    public CapacitacionDTO buscarPorId(String idCapacitacion) throws BOException {
        try {

            return CapacitacionMapper.toDTO(capacitacionDAO.buscarPorId(idCapacitacion));

        } catch (DAOException e) {
            throw new BOException("Error al buscar por id capacitacion", e);
        }
    }
}
