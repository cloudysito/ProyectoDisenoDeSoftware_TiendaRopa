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
public interface IPuntosDAO {
    
    Puntos guardarPuntos(Puntos puntos) throws MongoException;
    
    Puntos buscarPorId(String idPuntos) throws MongoException;
    
}
