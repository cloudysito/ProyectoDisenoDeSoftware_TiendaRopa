/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import java.util.List;
import objetosnegocio.dominioPojo.Talla;

/**
 *
 * @author garfi
 */
/**
 * Interfaz DAO para gestionar operaciones relacionadas con la entidad {@link Talla}.
 * Define métodos CRUD y de consulta general para manejar tallas en la base de datos.
 */
public interface ITallaDAO {

    /**
     * Guarda una nueva talla en la base de datos.
     *
     * @param talla Objeto de tipo Talla que se desea registrar.
     * @return La talla guardada con su ID asignado.
     * @throws MongoException Si ocurre un error durante la operación en la base de datos.
     */
    Talla guardarTalla(Talla talla) throws MongoException;

    /**
     * Modifica una talla existente en la base de datos.
     *
     * @param talla Objeto Talla con los datos actualizados.
     * @return La talla modificada.
     * @throws MongoException Si ocurre un error durante la actualización.
     */
    Talla modificarTalla(Talla talla) throws MongoException;

    /**
     * Elimina una talla de la base de datos.
     *
     * @param talla La talla que se desea eliminar.
     * @return La talla eliminada.
     * @throws MongoException Si ocurre un error al intentar eliminar el registro.
     */
    Talla eliminarTalla(Talla talla) throws MongoException;

    /**
     * Busca una talla usando su identificador único.
     *
     * @param idTalla ID de la talla que se desea consultar.
     * @return La talla encontrada o null si no existe.
     * @throws MongoException Si ocurre un error al realizar la consulta.
     */
    Talla buscarPorId(String idTalla) throws MongoException;

    /**
     * Consulta todas las tallas registradas en la base de datos.
     *
     * @return Lista de objetos Talla existentes.
     * @throws MongoException Si ocurre un error al obtener la información.
     */
    List<Talla> consultarTallas() throws MongoException;
}
