/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GuiaInteractiva.Interfaz;

import com.mycompany.dto_negocio.EmpleadoDTO;
import javax.swing.JFrame;

/**
 *
 * @author riosr
 */
public interface IGuiaInteractiva {
    public boolean finalizarGuia(JFrame frameActual, EmpleadoDTO empleado);
    
}
