/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import objetosnegocio.dominioPojo.Puntos;

/**
 *
 * @author riosr
 */
/**
 * Interfaz DAO para gestionar las operaciones de persistencia relacionadas con la entidad {@link Puntos}.
 * Permite almacenar y consultar los puntos asignados a artículos.
 */
public interface IPuntosDAO {

    /**
     * Guarda un registro de puntos asociado a un artículo.
     *
     * @param puntos Objeto {@link Puntos} que será almacenado.
     * @return El objeto Puntos guardado, incluyendo su ID generado.
     * @throws MongoException Si ocurre un error durante la inserción en la base de datos.
     */
    Puntos guardarPuntos(Puntos puntos) throws MongoException;

    /**
     * Busca un registro de puntos utilizando su identificador.
     *
     * @param idPuntos ID del registro de puntos a consultar.
     * @return El objeto Puntos encontrado, o null si no existe.
     * @throws MongoException Si ocurre un problema al realizar la consulta en la base de datos.
     */
    Puntos buscarPorId(String idPuntos) throws MongoException;
}

