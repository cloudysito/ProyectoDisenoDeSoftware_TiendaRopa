/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aumentarventaempleado.Fachada;

import com.mycompany.aumentarventaempleado.Interfaz.IAumentarVentaEmpleado;
import com.mycompany.objetosnegocio.dto.EmpleadoDTO;

/**
 *
 * @author LABCISCO-PC095
 */
public class FachadaAumentarVentaEmpleado implements IAumentarVentaEmpleado {
    @Override
    public EmpleadoDTO recuperarEmpleado(String email) {
        return new EmpleadoDTO(1, "Luis Martínez", "Cajero", email);
    }

    @Override
    public boolean aumentarVenta(EmpleadoDTO empleado) {
        return true;
    }
}
