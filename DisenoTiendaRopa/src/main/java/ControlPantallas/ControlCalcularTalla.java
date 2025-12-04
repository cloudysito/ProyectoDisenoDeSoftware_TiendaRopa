/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlPantallas;

import CalcularTalla.GUICalcularTalla;
import DisenoGUIs.GUIMenu;
import com.mycompany.calculartallasubsystem.FachadaCalcularTalla;
import com.mycompany.calculartallasubsystem.Interfaz.ICalcularTalla;
import com.mycompany.dto_negocio.EmpleadoDTO;
import javax.swing.JFrame;

/**
 *
 * @author santi
 */
public class ControlCalcularTalla {
    private static ControlCalcularTalla instancia;
    private static ICalcularTalla calcularTalla;
    
    public  static synchronized ControlCalcularTalla getIntase(){
        if(instancia == null){
            instancia = new ControlCalcularTalla();
            calcularTalla = new FachadaCalcularTalla();
        }
        return instancia;
    }
    
    private void cerrarFrameActual(JFrame frameActual) {
        if (frameActual != null) {
            frameActual.dispose();
        }
    }
    
    public void navegarCalcularTalla(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUICalcularTalla menu = new GUICalcularTalla(empleado);
        menu.setVisible(true);
    }

    public static ICalcularTalla getCalcularTalla() {
        return calcularTalla;
    }
    
    
}
