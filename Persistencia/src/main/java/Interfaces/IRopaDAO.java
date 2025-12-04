/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import java.util.List;

import objetosnegocio.dominioPojo.Ropa;


/**
 *
 * @author garfi
 */
/**
 * Interfaz DAO para gestionar las operaciones relacionadas con la entidad {@link Ropa}.
 * Proporciona métodos para operaciones CRUD y consultas específicas.
 */
public interface IRopaDAO {

    /**
     * Guarda una nueva instancia de {@link Ropa} en la base de datos.
     *
     * @param ropa Objeto Ropa a guardar.
     * @return El objeto Ropa guardado con su identificador asignado.
     * @throws MongoException Si ocurre un error durante la operación de guardado.
     */
    Ropa guardarRopa(Ropa ropa) throws MongoException;

    /**
     * Modifica una instancia existente de {@link Ropa}.
     *
     * @param ropa Objeto Ropa con los datos actualizados.
     * @return El objeto Ropa modificado.
     * @throws MongoException Si ocurre un error al intentar modificar el registro.
     */
    Ropa modificarRopa(Ropa ropa) throws MongoException;

    /**
     * Elimina una instancia de {@link Ropa} de la base de datos.
     *
     * @param ropa Objeto Ropa a eliminar.
     * @return El objeto eliminado, o null si no existía.
     * @throws MongoException Si ocurre un error durante la operación de eliminación.
     */
    Ropa eliminarRopa(Ropa ropa) throws MongoException;

    /**
     * Busca una prenda por su identificador único.
     *
     * @param id Identificador del objeto Ropa.
     * @return La instancia encontrada, o null si no existe.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    Ropa buscarPorId(String id) throws MongoException;

    /**
     * Busca prendas por su nombre o coincidencias parciales del mismo.
     *
     * @param nombreArticulo Nombre o fragmento del nombre del artículo.
     * @return Lista de coincidencias encontradas.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    List<Ropa> buscarPorNombre(String nombreArticulo) throws MongoException;

    /**
     * Recupera todas las prendas almacenadas en la base de datos.
     *
     * @return Lista de todas las instancias de Ropa.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    List<Ropa> buscarTodos() throws MongoException;
}
