/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import java.util.List;

/**
 *
 * @author garfi
 */
public interface ITallaDAO {
    
    Talla guardarTalla(Talla talla) throws MongoException;

    Talla buscarPorId(String idTalla) throws MongoException;

    List<Talla> buscarTodas() throws MongoException;

    void actualizarTalla(Talla talla) throws MongoException;

    void eliminarTalla(String idTalla) throws MongoException;
    
}
