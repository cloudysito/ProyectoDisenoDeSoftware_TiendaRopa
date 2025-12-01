/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import objetosnegocio.dominioPojo.Reembolso;

/**
 *
 * @author emiim
 */
public interface IReembolsoDAO {
    Reembolso guardar(Reembolso devolucion) throws MongoException;
}
