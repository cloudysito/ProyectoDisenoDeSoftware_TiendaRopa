/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.aumentarventaempleado.Interfaz;

import com.mycompany.objetosnegocio.dto.EmpleadoDTO;

/**
 *
 * @author LABCISCO-PC095
 */
public interface IAumentarVentaEmpleado {
    EmpleadoDTO recuperarEmpleado(String email);
    boolean aumentarVenta(EmpleadoDTO empleado);
}
