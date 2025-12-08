/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import objetosnegocio.dominioPojo.Administrador;

/**
 *
 * @author santi
 */
public interface IAdministradorDAO {
    Administrador iniciarSesion(String correo, String contrasenia) throws MongoException;
}
