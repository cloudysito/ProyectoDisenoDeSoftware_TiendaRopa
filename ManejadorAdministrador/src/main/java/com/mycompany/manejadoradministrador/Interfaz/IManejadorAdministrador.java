/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.manejadoradministrador.Interfaz;

import com.mycompany.dto_negocio.AdministradorDTO;

/**
 *
 * @author santi
 */
public interface IManejadorAdministrador {
    AdministradorDTO iniciarSesion(String correo, String contrasenia);
}
