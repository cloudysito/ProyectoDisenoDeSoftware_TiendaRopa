/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manejadoradministrador;

import BOs.AdministradorBO;
import com.mycompany.dto_negocio.AdministradorDTO;
import com.mycompany.manejadoradministrador.Interfaz.IManejadorAdministrador;

/**
 *
 * @author santi
 */
public class ManejadorAdministrador implements IManejadorAdministrador{

    @Override
    public AdministradorDTO iniciarSesion(String correo, String contrasenia) {
      return  AdministradorBO.getIntance().iniciarSesion(correo, contrasenia);
    }

    
}
