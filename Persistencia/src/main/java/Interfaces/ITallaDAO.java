/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import java.util.List;
import objetosnegocio.dominioPojo.Talla;

/**
 *
 * @author garfi
 */
public interface ITallaDAO {
    
    Talla guardarTalla(Talla talla) throws MongoException;
    
    Talla modificarTalla(Talla talla) throws MongoException;
    
    Talla eliminarTalla(Talla talla) throws MongoException;

    Talla buscarPorId(String idTalla) throws MongoException;
    
    List<Talla> consultarTallas() throws MongoException;
    
}
