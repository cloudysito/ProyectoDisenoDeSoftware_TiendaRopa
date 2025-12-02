/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import java.util.List;
import objetosnegocio.dominioPojo.Sugerencia;

/**
 *
 * @author santi
 */
public interface ISugerenciaDAO {
    Sugerencia guardarSugerencia(Sugerencia sugerencia) throws MongoException;
    
    Sugerencia modificarSugerencia(Sugerencia sugerencia) throws MongoException;
    
    Sugerencia buscarPorId(String idBonificacion) throws MongoException;
    
     List<Sugerencia> buscarTodos() throws MongoException;
    
    List<Sugerencia> buscarPorNombre(String nombreEmpleado);
    
    List<Sugerencia> buscarPorEstado(String estado) throws MongoException;
    
    boolean actualizarEstado(String idSugerencia, String nuevoEstado) throws MongoException;
}
