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
 * Objeto de Negocio para la gestión de Bonificaciones.
 * Encapsula la lógica relacionada con el registro y modificación de bonos para empleados.
 */
public class BonificacionBO {
    private static BonificacionBO instance;

    private IBonificacionDAO bonificacionDAO;

    /**
     * Constructor privado para Singleton.
     * Inicializa el DAO por defecto.
     */
    public BonificacionBO() {
        this.bonificacionDAO = new BonificacionDAO();
    }

    /**
     * Obtiene la instancia única de la clase.
     * @return Instancia de BonificacionBO.
     */
    public static BonificacionBO getInstance() {
        if (instance == null) {
            instance = new BonificacionBO();
        }
        return instance;
    }
    
    /**
     * Guarda una nueva bonificación en el sistema.
     * @param bonificacionDTO DTO con los datos de la bonificación.
     * @return El DTO de la bonificación guardada con su ID generado.
     * @throws BOException Si ocurre un error en la capa de datos.
     */
    public BonificacionDTO guardarBonificacion(BonificacionDTO bonificacionDTO) throws BOException {
        try {
            Bonificacion bonificacion = BonificacionMapper.toEntity(bonificacionDTO);
            Bonificacion bonificacionGuardar = bonificacionDAO.guardarBonificacion(bonificacion);
            return BonificacionMapper.toDTO(bonificacionGuardar);
        } catch (DAOException e) {
            throw new BOException("Error al guardar bonificacion", e);
        }
    }
    
    /**
     * Modifica una bonificación existente.
     * @param bonificacionDTO DTO con los datos actualizados.
     * @return El DTO actualizado.
     * @throws BOException Si ocurre un error al modificar.
     */
    public BonificacionDTO modificarBonificacion(BonificacionDTO bonificacionDTO) throws BOException {
        try {
            Bonificacion bonificacion = BonificacionMapper.toEntity(bonificacionDTO);
            Bonificacion bonificacionModificar = bonificacionDAO.modificarBonificacion(bonificacion);
            return BonificacionMapper.toDTO(bonificacionModificar);
        } catch (DAOException e) {
            throw new BOException("Error al modificar bonificacion", e);
        }
    }
    
    /**
     * Busca una bonificación por su identificador.
     * @param idBonificacion ID de la bonificación.
     * @return El DTO encontrado.
     * @throws BOException Si ocurre un error en la búsqueda.
     */
    public BonificacionDTO buscarPorId(String idBonificacion) throws BOException {
        try {

            return BonificacionMapper.toDTO(bonificacionDAO.buscarPorId(idBonificacion));

        } catch (DAOException e) {
            throw new BOException("Error al buscar por id bonificacion", e);
        }
    }
}
