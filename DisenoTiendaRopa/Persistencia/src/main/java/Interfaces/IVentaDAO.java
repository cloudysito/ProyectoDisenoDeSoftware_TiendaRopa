/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import com.mycompany.objetosnegocio.dominioPojo.Venta;
import java.util.List;

/**
 *
 * @author garfi
 */
public interface IVentaDAO {
    
    Venta guardarVenta(Venta venta) throws MongoException;
    
    Venta buscarPorId(String idVenta) throws MongoException;
    
}
