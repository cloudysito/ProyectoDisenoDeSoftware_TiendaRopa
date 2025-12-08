/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import objetosnegocio.dominioPojo.TemaCapacitacion;

/**
 *
 * @author riosr
 */
/**
 * Interfaz DAO para gestionar operaciones relacionadas con la entidad {@link TemaCapacitacion}.
 * Define los métodos para almacenar y consultar temas de capacitación en la base de datos.
 */
public interface ITemaCapacitacionDAO {

    /**
     * Guarda un tema de capacitación en la base de datos.
     *
     * @param temaCapacitacion Objeto de tipo TemaCapacitacion que se desea almacenar.
     * @return El tema de capacitación guardado.
     * @throws MongoException Si ocurre un error al guardar la información en la base de datos.
     */
    TemaCapacitacion guardarTemaCapacitacion(TemaCapacitacion temaCapacitacion) throws MongoException;

    /**
    * Busca y recupera un objeto TemaCapacitacion de la fuente de datos utilizando 
    * el nombre de la capacitación como criterio de búsqueda.
    * * Este método se espera que forme parte de una interfaz de acceso a datos (DAO) 
    * o de la capa de Lógica de Negocio (BO) dentro de un sistema que utiliza una
    * base de datos NoSQL como MongoDB, dado que declara lanzar una MongoException.
    *
    * @param nombreCapacitacion El nombre exacto del tema de capacitación que se desea buscar.
    * @return Un objeto {@code TemaCapacitacion} si se encuentra una coincidencia exacta. 
    * Devuelve {@code null} si no existe ningún tema con ese nombre.
    * @throws MongoException Si ocurre algún error durante la operación de acceso o 
    * consulta a la base de datos MongoDB (ej. conexión, sintaxis de consulta).
    */
    TemaCapacitacion buscarPorNombre(String nombreCapacitacion) throws MongoException;
}

