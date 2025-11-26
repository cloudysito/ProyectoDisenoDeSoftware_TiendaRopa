/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import com.mycompany.objetosnegocio.dominioPojo.Ropa;


/**
 *
 * @author garfi
 */
public interface IRopaDAO {

    Ropa guardarRopa(Ropa ropa) throws MongoException;

    Ropa buscarPorId(String id) throws MongoException;
    
}
