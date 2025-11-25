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
public interface IEmpleadoDAO {
    
    Empleado guardarEmpleado(Empleado empleado) throws MongoException;
    
    Empleado buscarPorId(String idEmpleado) throws MongoException;

}
