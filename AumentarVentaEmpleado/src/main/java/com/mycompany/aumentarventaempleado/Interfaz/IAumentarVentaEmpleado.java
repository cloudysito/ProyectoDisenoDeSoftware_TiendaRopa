/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.aumentarventaempleado.Interfaz;

import com.mycompany.dto_negocio.EmpleadoDTO;


/**
 * Interfaz que define el contrato para el subsistema de Aumento de Venta de Empleado.
 * <p>
 * Establece los métodos necesarios para validar las credenciales de un empleado (iniciar sesión)
 * antes de registrar una transacción, y para actualizar el registro de venta del empleado.
 * </p>
 *
 * @author LABCISCO-PC095
 * @version 1.0
 */
public interface IAumentarVentaEmpleado {
    
    /**
     * Intenta iniciar sesión con las credenciales proporcionadas para recuperar los datos del empleado.
     * <p>
     * Este paso generalmente precede a la autorización de una venta o transacción que requiere
     * identificar al empleado que la realiza.
     * </p>
     * * @param email El correo electrónico o nombre de usuario del empleado.
     * @param contrasenia La contraseña del empleado.
     * @return El objeto {@code EmpleadoDTO} si la autenticación es exitosa; {@code null} en caso contrario.
     */
    EmpleadoDTO recuperarEmpleado(String email, String contrasenia);
    
    /**
     * Procesa la lógica de negocio para registrar o aumentar el contador de ventas de un empleado.
     * <p>
     * Este método puede ser llamado después de que una venta se ha completado exitosamente
     * para actualizar las estadísticas de rendimiento del empleado.
     * </p>
     * * @param empleado El {@code EmpleadoDTO} asociado a la venta o métrica a actualizar.
     * @return {@code true} si la métrica de venta fue actualizada correctamente; {@code false} si hubo un error.
     */
    boolean aumentarVenta(EmpleadoDTO empleado);
}