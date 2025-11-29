/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import java.util.List;

import objetosnegocio.dominioPojo.Ropa;


/**
 *
 * @author garfi
 */
public interface IRopaDAO {

    Ropa guardarRopa(Ropa ropa) throws MongoException;
    
    Ropa modificarRopa(Ropa ropa) throws MongoException;
    
    Ropa eliminarRopa(Ropa ropa) throws MongoException;

    Ropa buscarPorId(String id) throws MongoException;
    
    List<Ropa> buscarPorNombre(String nombreArticulo) throws MongoException;
    
    public List<Ropa> buscarTodos() throws MongoException;
    
}
