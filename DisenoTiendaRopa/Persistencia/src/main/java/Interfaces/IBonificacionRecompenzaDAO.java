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
public interface IBonificacionRecompenzaDAO {
    
    Puntos guardarEmpleado(Puntos br) throws MongoException;
    
    Puntos modificarEmpleado(Puntos br) throws MongoException;
    
    Puntos buscarPorId(String idBonificacionRecompenza) throws MongoException;
    
}
