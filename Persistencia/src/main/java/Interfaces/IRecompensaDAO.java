/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import objetosnegocio.dominioPojo.Recompensa;

/**
 *
 * @author riosr
 */
/**
 * Interfaz DAO para gestionar las operaciones relacionadas con la entidad {@link Recompensa}.
 * Permite realizar operaciones de persistencia y consulta de recompensas.
 */
public interface IRecompensaDAO {

    /**
     * Guarda una nueva recompensa en la base de datos.
     *
     * @param recompensa Objeto {@link Recompensa} que será almacenado.
     * @return El objeto Recompensa guardado con su ID asignado.
     * @throws MongoException Si ocurre un error durante la operación de guardado.
     */
    Recompensa guardarRecompensa(Recompensa recompensa) throws MongoException;

    /**
     * Busca una recompensa utilizando su identificador.
     *
     * @param idRecompensa ID de la recompensa a buscar.
     * @return La recompensa encontrada o null si no existe.
     * @throws MongoException Si ocurre un error durante la operación de consulta.
     */
    Recompensa buscarPorId(String idRecompensa) throws MongoException;
}

