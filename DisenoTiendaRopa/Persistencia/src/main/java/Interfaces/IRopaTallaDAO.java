/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import objetosnegocio.dominioPojo.RopaTalla;

/**
 *
 * @author garfi
 */
public interface IRopaTallaDAO {
    
    RopaTalla guardar(RopaTalla rt) throws MongoException;
    
    RopaTalla buscarPorId(String id) throws MongoException;
    
    RopaTalla buscarPorCodigo(String codigo) throws MongoException;
}
