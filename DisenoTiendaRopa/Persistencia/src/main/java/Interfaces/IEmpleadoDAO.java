/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import java.util.List;
import objetosnegocio.dominioPojo.Empleado;

/**
 *
 * @author garfi
 */
public interface IEmpleadoDAO {
    
    Empleado guardarEmpleado(Empleado empleado) throws MongoException;
    
    Empleado modificarEmpleado(Empleado empleado) throws MongoException;
    
    Empleado eliminarEmpleado(Empleado empleado) throws MongoException;
    
    Empleado buscarPorId(String idEmpleado) throws MongoException;
    
    Empleado iniciarSesion(String correo, String contrasenia) throws MongoException;
    
    List<Empleado> buscarTodos() throws MongoException;
    
    List<Empleado> buscarPorNombre(String nombreEmpleado);
    
    // Igual al otro para no causar problemas
    Empleado buscarPorCredenciales(String correo, String contrasenia) throws MongoException;

}
