/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import java.util.List;

/**
 *
 * @author garfi
 */
public interface IRopaDAO {

    Ropa guardarRopa(Ropa ropa) throws MongoException;

    Ropa buscarPorCodigoBarras(String codigoBarras) throws MongoException;
    
    Ropa buscarPorId(String idRopa) throws MongoException;

    List<Ropa> buscarTodas() throws MongoException;

    void actualizarRopa(Ropa ropa) throws MongoException;

    void eliminarRopa(String idRopa) throws MongoException;
}
