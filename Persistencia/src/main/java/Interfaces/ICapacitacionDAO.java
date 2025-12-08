/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import objetosnegocio.dominioPojo.Capacitacion;

/**
 *
 * @author riosr
 */
/**
 * Interfaz DAO para gestionar operaciones de persistencia relacionadas con la entidad {@link Capacitacion}.
 * Proporciona métodos para guardar, modificar y consultar capacitaciones.
 */
public interface ICapacitacionDAO {

    /**
     * Guarda una nueva capacitación en la base de datos.
     *
     * @param capacitacion Objeto {@link Capacitacion} que se desea almacenar.
     * @return La capacitación guardada, incluyendo su ID generado.
     * @throws MongoException Si ocurre un error durante la operación de guardado.
     */
    Capacitacion guardarCapacitacion(Capacitacion capacitacion) throws MongoException;

    /**
     * Modifica una capacitación previamente registrada.
     *
     * @param capacitacion Objeto {@link Capacitacion} con los datos actualizados.
     * @return La capacitación modificada.
     * @throws MongoException Si ocurre un error al intentar modificar los datos.
     */
    Capacitacion modificarCapacitacion(Capacitacion capacitacion) throws MongoException;

    /**
     * Busca una capacitación por su identificador único.
     *
     * @param idCapacitacion ID de la capacitación a buscar.
     * @return La capacitación encontrada o null si no existe.
     * @throws MongoException Si ocurre un problema durante la consulta.
     */
    Capacitacion buscarPorId(String idCapacitacion) throws MongoException;
    
    Capacitacion buscarPorNombreYTema(String nombreEmpleado, String temaCapacitacion) throws MongoException;

}

