/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlPantallas;

import AsignarHorario.GUIAgregarEmpleado;
import AsignarHorario.*;
import AsignarHorario.GUIMenu1;
import com.mycompany.dto_negocio.EmpleadoDTO;
import com.mycompany.manejadorempleadossubsystem.FachadaManejadorEmpleados;
import com.mycompany.manejadorempleadossubsystem.Interfaz.IManejadorEmpleados;
import javax.swing.JFrame;

/**
 *
 * @author santi
 */
public class ControlEmpleados {
    private static ControlEmpleados instance;
    private static IManejadorEmpleados manejadorEmpleados;
    public  static  synchronized  ControlEmpleados getInstase(){
        if (true) {
            instance = new ControlEmpleados();
            manejadorEmpleados = new FachadaManejadorEmpleados();
        }
        return instance;
    }
    
    private void cerrarFrameActual(JFrame frameActual) {
        if (frameActual != null) {
            frameActual.dispose();
        }
    }

    public static IManejadorEmpleados getManejadorEmpleados() {
        return manejadorEmpleados;
    }
    
    public void navegarMenuAdmin(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIMenu1 menu = new GUIMenu1();
        menu.setVisible(true);
    }
    
    public void navegarAgregarEmpleado(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIAgregarEmpleado empleado = new GUIAgregarEmpleado();
        empleado.setVisible(true);
    }
    
    public void navegarEmpleados(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIEmpleados empleado = new GUIEmpleados();
        empleado.setVisible(true);
    }
    
    public void navegarAsignar(JFrame frameActual,EmpleadoDTO empleadoDTO) {
        cerrarFrameActual(frameActual);
        GUIAsignarHorarios empleado = new GUIAsignarHorarios(empleadoDTO);
        empleado.setVisible(true);
    }
    
    public void navegarModificar(JFrame frameActual,EmpleadoDTO empleadoDTO){
        cerrarFrameActual(frameActual);
        GUIModificarEmpleado1 empleado = new GUIModificarEmpleado1(empleadoDTO);
        empleado.setVisible(true);
    }
}
