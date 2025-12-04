/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import java.util.List;
import objetosnegocio.dominioPojo.Sugerencia;

/**
 *
 * @author santi
 */
/**
 * Interfaz DAO para gestionar operaciones relacionadas con la entidad {@link Sugerencia}.
 * Contiene métodos para CRUD, búsquedas específicas y actualización de estado.
 */
public interface ISugerenciaDAO {

    /**
     * Guarda una nueva sugerencia en la base de datos.
     *
     * @param sugerencia La sugerencia que se desea registrar.
     * @return La sugerencia guardada con su ID asignado.
     * @throws MongoException Si ocurre un error durante el guardado.
     */
    Sugerencia guardarSugerencia(Sugerencia sugerencia) throws MongoException;

    /**
     * Modifica una sugerencia existente.
     *
     * @param sugerencia Objeto Sugerencia con los datos actualizados.
     * @return La sugerencia modificada.
     * @throws MongoException Si ocurre un error durante la modificación.
     */
    Sugerencia modificarSugerencia(Sugerencia sugerencia) throws MongoException;

    /**
     * Busca una sugerencia por su identificador único.
     *
     * @param idBonificacion ID de la sugerencia que se desea buscar.
     * @return La sugerencia encontrada o null si no existe.
     * @throws MongoException Si ocurre un error en la consulta.
     */
    Sugerencia buscarPorId(String idBonificacion) throws MongoException;

    /**
     * Obtiene todas las sugerencias almacenadas.
     *
     * @return Lista completa de sugerencias.
     * @throws MongoException Si ocurre un error al recuperar la lista.
     */
    List<Sugerencia> buscarTodos() throws MongoException;

    /**
     * Busca sugerencias por el nombre del empleado asociado.
     *
     * @param nombreEmpleado Nombre del empleado que generó la sugerencia.
     * @return Lista de sugerencias relacionadas con ese empleado.
     */
    List<Sugerencia> buscarPorNombre(String nombreEmpleado);

    /**
     * Busca sugerencias filtrando por su estado.
     *
     * @param estado Estado por el cual se desea filtrar (ej. "Pendiente", "Revisada").
     * @return Lista de sugerencias con ese estado.
     * @throws MongoException Si ocurre un error en la consulta.
     */
    List<Sugerencia> buscarPorEstado(String estado) throws MongoException;

    /**
     * Actualiza únicamente el estado de una sugerencia específica.
     *
     * @param idSugerencia ID de la sugerencia a actualizar.
     * @param nuevoEstado Nuevo estado a asignar.
     * @return true si la actualización fue exitosa; false si no se encontró o no se actualizó.
     * @throws MongoException Si ocurre un error durante la operación.
     */
    boolean actualizarEstado(String idSugerencia, String nuevoEstado) throws MongoException;
}
