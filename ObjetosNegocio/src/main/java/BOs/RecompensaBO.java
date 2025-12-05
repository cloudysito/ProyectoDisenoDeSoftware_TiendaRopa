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
 * Objeto de Negocio para la gestión de Recompensas.
 * Permite crear y buscar recompensas disponibles para el sistema de fidelización de empleados.
 * @author riosr
 */
public class RecompensaBO {
    private static RecompensaBO instance;

    private IRecompensaDAO recompensaDAO;

    /**
     * Constructor privado. Inicializa el DAO de Recompensas.
     */
    public RecompensaBO() {
        this.recompensaDAO = new RecompensaDAO() {};
    }

    /**
     * Obtiene la instancia única del Singleton.
     * @return Instancia de RecompensaBO.
     */
    public static RecompensaBO getInstance() {
        if (instance == null) {
            instance = new RecompensaBO();
        }
        return instance;
    }
    
    /**
     * Guarda una nueva recompensa en el sistema.
     * @param recompensaDTO DTO con la información de la recompensa a crear.
     * @return La recompensa guardada convertida a DTO.
     * @throws BOException Si ocurre un error en la capa de persistencia.
     */
    public RecompensaDTO guardarRecompensa(RecompensaDTO recompensaDTO) throws BOException {
        try {
            Recompensa recompensa = RecompensaMapper.toEntity(recompensaDTO);

            Recompensa recompensaGuardar = recompensaDAO.guardarRecompensa(recompensa);

            return RecompensaMapper.toDTO(recompensaGuardar);

        } catch (DAOException e) {
            throw new BOException("Error al guardar recompensa", e);
        }
    }
    
    /**
     * Busca una recompensa específica por su identificador.
     * @param idRecompensa ID de la recompensa.
     * @return DTO de la recompensa encontrada.
     * @throws BOException Si ocurre un error durante la búsqueda.
     */
    public RecompensaDTO buscarPorId(String idRecompensa) throws BOException {
        try {

            return RecompensaMapper.toDTO(recompensaDAO.buscarPorId(idRecompensa));

        } catch (DAOException e) {
            throw new BOException("Error al buscar por id recompensa", e);
        }
    }
}
