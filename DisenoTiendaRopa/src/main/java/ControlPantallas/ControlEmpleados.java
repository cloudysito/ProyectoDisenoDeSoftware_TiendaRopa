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
    /** Instancia única de la clase ControlEmpleados (Singleton). */
    private static ControlEmpleados instance;
    
    /** Fachada para la lógica de negocio de gestión de empleados. */
    private static IManejadorEmpleados manejadorEmpleados;
    
    /**
     * Implementa el patrón Singleton. Devuelve la instancia única de ControlEmpleados.
     * Si es la primera llamada, la crea de forma sincronizada y también inicializa
     * la Fachada para la lógica de negocio de empleados.
     *
     * @return La instancia única de ControlEmpleados.
     */
    public  static  synchronized  ControlEmpleados getInstase(){
        if (true) {
            instance = new ControlEmpleados();
            manejadorEmpleados = new FachadaManejadorEmpleados();
        }
        return instance;
    }
    
    /**
     * Método auxiliar para cerrar y liberar los recursos del frame actual.
     * @param frameActual El JFrame que se desea cerrar.
     */
    private void cerrarFrameActual(JFrame frameActual) {
        if (frameActual != null) {
            frameActual.dispose();
        }
    }

    /**
     * Proporciona acceso a la interfaz de lógica de negocio (IManejadorEmpleados).
     *
     * @return La implementación de la interfaz IManejadorEmpleados.
     */
    public static IManejadorEmpleados getManejadorEmpleados() {
        return manejadorEmpleados;
    }
    
    /**
     * Cierra el frame actual y navega al Menú Principal de Administración.
     * @param frameActual El JFrame actual que será cerrado.
     */
    public void navegarMenuAdmin(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIMenu1 menu = new GUIMenu1();
        menu.setVisible(true);
    }
    
    /**
     * Cierra el frame actual y navega a la interfaz para Agregar un nuevo Empleado.
     * @param frameActual El JFrame actual que será cerrado.
     */
    public void navegarAgregarEmpleado(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIAgregarEmpleado empleado = new GUIAgregarEmpleado();
        empleado.setVisible(true);
    }
    
    /**
     * Cierra el frame actual y navega a la interfaz de Gestión de Empleados (lista).
     * @param frameActual El JFrame actual que será cerrado.
     */
    public void navegarEmpleados(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIEmpleados empleado = new GUIEmpleados();
        empleado.setVisible(true);
    }
    
    /**
     * Cierra el frame actual y navega a la interfaz para Asignar Horarios a un Empleado.
     * @param frameActual El JFrame actual que será cerrado.
     * @param empleadoDTO El DTO del empleado al que se le asignarán los horarios.
     */
    public void navegarAsignar(JFrame frameActual,EmpleadoDTO empleadoDTO) {
        cerrarFrameActual(frameActual);
        GUIAsignarHorarios empleado = new GUIAsignarHorarios(empleadoDTO);
        empleado.setVisible(true);
    }
    
    /**
     * Cierra el frame actual y navega a la interfaz para Modificar los datos de un Empleado.
     * @param frameActual El JFrame actual que será cerrado.
     * @param empleadoDTO El DTO del empleado que será modificado.
     */
    public void navegarModificar(JFrame frameActual,EmpleadoDTO empleadoDTO){
        cerrarFrameActual(frameActual);
        GUIModificarEmpleado1 empleado = new GUIModificarEmpleado1(empleadoDTO);
        empleado.setVisible(true);
    }
}
