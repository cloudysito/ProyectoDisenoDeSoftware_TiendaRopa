/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import com.mycompany.dto_negocio.DetalleVentaDTO;
import com.mycompany.dto_negocio.SolicitudDevolucionDTO;
import com.mycompany.objetosnegocio.dominioPojo.Empleado;
import objetosnegocio.dominioPojo.Devolucion;

public interface IBODevolucion {
    
    Empleado autenticar(String usuario, String contrasenia);
    
    DetalleVentaDTO buscarVenta(String idVenta);
    
    boolean validarCantidades(SolicitudDevolucionDTO solicitud);
    
    Devolucion procesarDevolucion(SolicitudDevolucionDTO solicitud);
}