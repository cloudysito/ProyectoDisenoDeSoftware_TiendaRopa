/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import java.util.List;
import objetosnegocio.dominioPojo.RopaTalla;
import org.bson.types.ObjectId;

/**
 *
 * @author garfi
 */
public interface IRopaTallaDAO {

    RopaTalla guardar(RopaTalla rt) throws MongoException;

    RopaTalla buscarPorId(String id) throws MongoException;

    RopaTalla buscarPorCodigo(String codigo) throws MongoException;
    
    List<RopaTalla> buscarTodos() throws MongoException;

    List<RopaTalla> buscarPorFiltro(String textoBusqueda) throws MongoException;
    
    void reducirStock(String idRopaTalla, int cantidadVendida) throws MongoException;

    void actualizarStock(ObjectId idRopaTalla, int cantidad) throws MongoException;
}
