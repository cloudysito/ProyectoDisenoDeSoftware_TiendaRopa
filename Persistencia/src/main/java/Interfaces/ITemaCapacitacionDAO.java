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

    
    TemaCapacitacion buscarPorNombre(String nombreCapacitacion) throws MongoException;
}

