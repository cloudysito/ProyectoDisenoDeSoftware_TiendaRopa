/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import objetosnegocio.dominioPojo.Reembolso;

/**
 *
 * @author emiim
 */
/**
 * Interfaz DAO para gestionar las operaciones relacionadas con la entidad {@link Reembolso}.
 * Permite realizar la operación de guardado de un reembolso en la base de datos.
 */
public interface IReembolsoDAO {

    /**
     * Guarda un nuevo registro de {@link Reembolso} en la base de datos.
     *
     * @param devolucion Objeto Reembolso que será almacenado.
     * @return El objeto Reembolso guardado, incluyendo su identificador asignado.
     * @throws MongoException Si ocurre un error durante la operación de guardado.
     */
    Reembolso guardar(Reembolso devolucion) throws MongoException;
}
