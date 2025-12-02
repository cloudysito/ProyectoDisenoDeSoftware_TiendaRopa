/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.manejadorempleadossubsystem.Interfaz;

import com.mycompany.dto_negocio.EmpleadoDTO;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IManejadorEmpleados {
    
    EmpleadoDTO guardarEmpleado(EmpleadoDTO empleadoDTO);
    
    EmpleadoDTO modificarEmpleado(EmpleadoDTO empleadoDTO);
    
    List<EmpleadoDTO> buscarEmpleados(String texto);
    
    
    
}
