/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GuiaInteractiva.Fachada;

import BOs.CapacitacionBO;
import GuiaInteractiva.Interfaz.IGuiaInteractiva;
import com.mycompany.dto_negocio.EmpleadoDTO;
import javax.swing.JFrame;

/**
 *
 * @author riosr
 */
public class FachadaGuiaInteractiva implements IGuiaInteractiva{
   
    public boolean finalizarGuia(JFrame frameActual, EmpleadoDTO empleado) {
    
    
    String nuevoEstado = "Capacitado";
    boolean exitoActualizacion = false;

    try {
        
        CapacitacionBO capacitacionBO = new CapacitacionBO();
        exitoActualizacion = capacitacionBO.modificarCapacitacion(empleado, nuevoEstado);

        if (exitoActualizacion) {
            System.out.println("LOG: Estado de capacitación actualizado a: " + nuevoEstado);
            
            
            Navegador.navegarMenuGuia(frameActual, empleado); 
            
            return true;
        } else {
            System.err.println("ERROR: No se pudo actualizar el estado de capacitación en la BD.");
            return false;
        }

    } catch (Exception e) {
        System.err.println("ERROR FATAL en FachadaSeguridad: " + e.getMessage());
        return false;
    }
    }
    
    
}
