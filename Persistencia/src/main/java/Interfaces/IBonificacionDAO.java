/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import objetosnegocio.dominioPojo.Bonificacion;

/**
 *
 * @author riosr
 */
public interface IBonificacionDAO {
    
    Bonificacion guardarBonificacion(Bonificacion bonificacion) throws MongoException;
    
    Bonificacion modificarBonificacion(Bonificacion bonificacion) throws MongoException;
    
    Bonificacion buscarPorId(String idBonificacion) throws MongoException;
    
}
