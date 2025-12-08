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
public interface ITemaCapacitacionDAO {
    TemaCapacitacion guardarTemaCapacitacion(TemaCapacitacion temaCapacitacion) throws MongoException;
    
    TemaCapacitacion buscarPorNombre(String nombreCapacitacion) throws MongoException;
}
