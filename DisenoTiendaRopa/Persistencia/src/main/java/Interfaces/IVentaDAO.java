/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import objetosnegocio.dominioPojo.Venta;

/**
 *
 * @author garfi
 */
public interface IVentaDAO {
    
    Venta guardarVenta(Venta venta) throws MongoException;
    
    Venta modificarVenta(Venta venta) throws MongoException;
    
    Venta eliminarVenta(Venta venta) throws MongoException;
    
    Venta buscarPorId(String idVenta) throws MongoException;
    
    Venta buscarPorFolio(int folio) throws MongoException;
    
}
