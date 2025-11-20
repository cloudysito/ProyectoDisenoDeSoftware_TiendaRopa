/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aumentarventaempleado.Fachada;

import com.mycompany.aumentarventaempleado.Interfaz.IAumentarVentaEmpleado;
import com.mycompany.objetosnegocio.dominio.Empleado;
import com.mycompany.objetosnegocio.dto.EmpleadoDTO;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author LABCISCO-PC095
 */
public class FachadaAumentarVentaEmpleado implements IAumentarVentaEmpleado {
    @Override
    public Empleado recuperarEmpleado(String email, String contrasenia) {
        if(email != ""){
        
        }
        if(contrasenia != "") {
        
        }
        return new Empleado(1, "Manuel", "Cortes villa", "Cajero", "644-455-4555", "manuel_cortes@gmail.com", 8000, Date.from(Instant.MIN), email, contrasenia);
    }

    @Override
    public boolean aumentarVenta(EmpleadoDTO empleado) {
        return true;
    }
}
