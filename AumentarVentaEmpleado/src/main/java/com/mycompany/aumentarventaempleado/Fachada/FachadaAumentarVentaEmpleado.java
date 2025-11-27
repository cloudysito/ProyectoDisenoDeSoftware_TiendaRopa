/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aumentarventaempleado.Fachada;

import com.mycompany.aumentarventaempleado.Interfaz.IAumentarVentaEmpleado;
import com.mycompany.dto_negocio.EmpleadoDTO;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author LABCISCO-PC095
 */
public class FachadaAumentarVentaEmpleado implements IAumentarVentaEmpleado {
    @Override
    public EmpleadoDTO recuperarEmpleado(String email, String contrasenia) {
        if(email != ""){
        
        }
        if(contrasenia != "") {
        
        }
        return new EmpleadoDTO( "Manuel", "Cortes villa", "Cajero", contrasenia, "644-455-4555", email, 8000, Date.from(Instant.MIN),"dasdadw3452");
    }

    @Override
    public boolean aumentarVenta(EmpleadoDTO empleado) {
        return true;
    }
}
