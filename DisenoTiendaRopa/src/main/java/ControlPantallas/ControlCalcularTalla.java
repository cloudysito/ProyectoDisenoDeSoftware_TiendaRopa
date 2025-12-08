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
    /**
     * Instancia única de la clase ControlCalcularTalla (Singleton).
     */
    private static ControlCalcularTalla instancia;

    /**
     * Interfaz para acceder a la lógica de negocio de cálculo de talla.
     * Se inicializa con la implementación de la Fachada.
     */
    private static ICalcularTalla calcularTalla;

    // El constructor debe ser privado para asegurar el patrón Singleton.
    private ControlCalcularTalla() {
        // Constructor privado.
    }

    // 
    // Métodos Singleton y de Acceso a Lógica de Negocio
    // 

    /**
     * Devuelve la única instancia de ControlCalcularTalla. Si la instancia
     * es null, la crea y también inicializa la Fachada para la lógica de negocio.
     * La sincronización asegura que solo se cree una instancia en entornos multihilo.
     *
     * @return La instancia única de ControlCalcularTalla.
     */
    public static synchronized ControlCalcularTalla getIntase() {
        if (instancia == null) {
            instancia = new ControlCalcularTalla();
            // Inicializa la interfaz de lógica de negocio con la implementación de la Fachada.
            calcularTalla = new FachadaCalcularTalla();
        }
        return instancia;
    }

    /**
     * Proporciona acceso a la interfaz de lógica de negocio (ICalcularTalla).
     *
     * @return La implementación de la interfaz ICalcularTalla (FachadaCalcularTalla).
     */
    public static ICalcularTalla getCalcularTalla() {
        return calcularTalla;
    }

    /**
     * Cierra y libera los recursos del JFrame actual si no es nulo.
     * Este método se utiliza típicamente para cerrar la ventana anterior
     * antes de abrir una nueva.
     *
     * @param frameActual El JFrame que se desea cerrar.
     */
    private void cerrarFrameActual(JFrame frameActual) {
        if (frameActual != null) {
            frameActual.dispose();
        }
    }

    /**
     * Cierra el frame de interfaz de usuario actual y navega a la
     * ventana de cálculo de talla (GUICalcularTalla).
     *
     * @param frameActual El JFrame actual que será cerrado.
     * @param empleado El DTO del empleado que requiere acceso a la nueva ventana,
     * usualmente para manejar permisos o información de sesión.
     */
    public void navegarCalcularTalla(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        // Crea y muestra la nueva ventana de cálculo de talla.
        GUICalcularTalla menu = new GUICalcularTalla(empleado);
        menu.setVisible(true);
    }

}
