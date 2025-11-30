/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import objetosnegocio.dominioPojo.Recompenza;

/**
 *
 * @author riosr
 */
public interface IRecompenzaDAO {
    
    Recompenza guardarEmpleado(Recompenza recompenza) throws MongoException;
    
    Recompenza modificarEmpleado(Recompenza recompenza) throws MongoException;
    
    Recompenza buscarPorId(String idRecompenza) throws MongoException;
    
}
