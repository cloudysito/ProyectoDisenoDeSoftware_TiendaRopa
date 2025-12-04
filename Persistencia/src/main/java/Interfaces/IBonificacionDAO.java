/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import objetosnegocio.dominioPojo.Bonificacion;

/**
 *
 * @author riosr
 */
/**
 * Interfaz que define las operaciones de acceso a datos (DAO) relacionadas con las bonificaciones.
 * Proporciona métodos para guardar, modificar y buscar bonificaciones en la base de datos.
 */
public interface IBonificacionDAO {

    /**
     * Guarda una nueva bonificación en la base de datos.
     *
     * @param bonificacion La bonificación que se desea almacenar.
     * @return La bonificación guardada, incluyendo su identificador generado.
     * @throws MongoException Si ocurre un error al interactuar con la base de datos.
     */
    Bonificacion guardarBonificacion(Bonificacion bonificacion) throws MongoException;

    /**
     * Modifica una bonificación existente en la base de datos.
     *
     * @param bonificacion La bonificación con los datos actualizados.
     * @return La bonificación modificada.
     * @throws MongoException Si ocurre un error al actualizar en la base de datos.
     */
    Bonificacion modificarBonificacion(Bonificacion bonificacion) throws MongoException;

    /**
     * Busca una bonificación en la base de datos según su identificador.
     *
     * @param idBonificacion El identificador de la bonificación a buscar.
     * @return La bonificación correspondiente al ID proporcionado, o {@code null} si no existe.
     * @throws MongoException Si ocurre un error al realizar la consulta en la base de datos.
     */
    Bonificacion buscarPorId(String idBonificacion) throws MongoException;
}

