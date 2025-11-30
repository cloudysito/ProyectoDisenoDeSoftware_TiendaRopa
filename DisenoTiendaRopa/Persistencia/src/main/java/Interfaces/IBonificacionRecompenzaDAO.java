/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import objetosnegocio.dominioPojo.BonificacionRecompenza;

/**
 *
 * @author riosr
 */
public interface IBonificacionRecompenzaDAO {
    
    BonificacionRecompenza guardarEmpleado(BonificacionRecompenza br) throws MongoException;
    
    BonificacionRecompenza modificarEmpleado(BonificacionRecompenza br) throws MongoException;
    
    BonificacionRecompenza buscarPorId(String idBonificacionRecompenza) throws MongoException;
    
}
