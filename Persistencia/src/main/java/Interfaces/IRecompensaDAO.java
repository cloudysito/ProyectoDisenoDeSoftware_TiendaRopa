/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import objetosnegocio.dominioPojo.Recompensa;

/**
 *
 * @author riosr
 */
public interface IRecompensaDAO {
    
    Recompensa guardarRecompensa(Recompensa recompensa) throws MongoException;
    
    Recompensa buscarPorId(String idRecompensa) throws MongoException;
    
}
