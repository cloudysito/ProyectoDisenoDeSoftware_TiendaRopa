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
public interface ICapacitacionDAO {
    
    Capacitacion guardarEmpleado(Capacitacion capacitacion) throws MongoException;
    
    Capacitacion modificarEmpleado(Capacitacion capacitacion) throws MongoException;
    
    Capacitacion buscarPorId(String idCapacitacion) throws MongoException;
    
}
