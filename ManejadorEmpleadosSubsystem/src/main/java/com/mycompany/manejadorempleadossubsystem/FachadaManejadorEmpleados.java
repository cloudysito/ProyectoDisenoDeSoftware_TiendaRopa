/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manejadorempleadossubsystem;

import BOs.EmpleadoBO;
import com.mycompany.dto_negocio.EmpleadoDTO;
import com.mycompany.manejadorempleadossubsystem.Interfaz.IManejadorEmpleados;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 *
 * @author santi
 */
public class FachadaManejadorEmpleados implements IManejadorEmpleados {

    @Override
    public EmpleadoDTO guardarEmpleado(EmpleadoDTO empleadoDTO) {
        if (empleadoDTO.getNombre() == null || empleadoDTO.getNombre().trim().isEmpty()) {

        }

        if (empleadoDTO.getApellidos() == null || empleadoDTO.getApellidos().trim().isEmpty()) {

        }

        if (empleadoDTO.getPuesto() == null || empleadoDTO.getPuesto().trim().isEmpty()) {

        }

        if (empleadoDTO.getTelefono() == null || empleadoDTO.getTelefono().trim().isEmpty()) {
            
        }

        if (empleadoDTO.getContrasenia() == null || empleadoDTO.getContrasenia().trim().isEmpty()) {

        }

        if (empleadoDTO.getEmail() == null || empleadoDTO.getEmail().trim().isEmpty()) {

        }

        if (empleadoDTO.getRfc() == null || empleadoDTO.getRfc().trim().isEmpty()) {

        }

        if (empleadoDTO.getSalario() <= 0 ) {

        }
        
        empleadoDTO.setFechaContratacion(Date.from(Instant.now()));
        
        return EmpleadoBO.getInstance().guardarEmpleado(empleadoDTO);
    }

    @Override
    public EmpleadoDTO modificarEmpleado(EmpleadoDTO empleadoDTO) {
        if (empleadoDTO.getNombre() == null || empleadoDTO.getNombre().trim().isEmpty()) {

        }

        if (empleadoDTO.getApellidos() == null || empleadoDTO.getApellidos().trim().isEmpty()) {

        }

        if (empleadoDTO.getPuesto() == null || empleadoDTO.getPuesto().trim().isEmpty()) {

        }

        if (empleadoDTO.getTelefono() == null || empleadoDTO.getTelefono().trim().isEmpty()) {
            
        }

        if (empleadoDTO.getContrasenia() == null || empleadoDTO.getContrasenia().trim().isEmpty()) {

        }

        if (empleadoDTO.getEmail() == null || empleadoDTO.getEmail().trim().isEmpty()) {

        }

        if (empleadoDTO.getRfc() == null || empleadoDTO.getRfc().trim().isEmpty()) {

        }

        if (empleadoDTO.getSalario() <= 0 ) {

        }
        
        empleadoDTO.setFechaContratacion(Date.from(Instant.now()));
        
        return EmpleadoBO.getInstance().modificarEmpleado(empleadoDTO);
    }

    @Override
    public List<EmpleadoDTO> buscarEmpleados(String texto) {
        if (texto == "") {
            return EmpleadoBO.getInstance().buscarTodos();
        }
        else {
            return EmpleadoBO.getInstance().buscarProductos(texto);
        }
    }

    
}
