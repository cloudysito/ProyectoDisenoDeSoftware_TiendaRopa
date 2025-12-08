/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlPantallas;

import RecomendarPrenda.GUIRecomendarPrenda;
import com.mycompany.dto_negocio.EmpleadoDTO;
import com.mycompany.recomendarprendasubsystem.FachadaRecomendarPrenda;
import com.mycompany.recomendarprendasubsystem.Interfaz.IRecomendarPrenda;
import javax.swing.JFrame;

/**
 *
 * @author santi
 */
public class ControlRecomendarPrenda {
    /**
     * Instancia única de la clase ControlRecomendarPrenda (Patrón Singleton).
     */
    private static ControlRecomendarPrenda instancia;
    
    /**
     * Interfaz para acceder a la lógica de negocio de la recomendación de prendas.
     * Se inicializa con la implementación de la Fachada.
     */
    private IRecomendarPrenda recomendarPrenda;
    
    /**
     * Constructor privado para prevenir la instanciación externa (requisito del Singleton).
     * Inicializa la interfaz de lógica de negocio con la implementación de la Fachada.
     */
    private ControlRecomendarPrenda() {
        this.recomendarPrenda = new FachadaRecomendarPrenda();
    }
    
    /**
     * Devuelve la única instancia de ControlRecomendarPrenda. Si la instancia
     * es null, la crea de forma sincronizada para garantizar la seguridad
     * en entornos multihilo.
     *
     * @return La instancia única de ControlRecomendarPrenda.
     */
    public static synchronized ControlRecomendarPrenda  getInstance(){
        if (instancia == null) {
            instancia = new ControlRecomendarPrenda();
        }
        return  instancia;
    }
    
    /**
     * Proporciona acceso a la interfaz de lógica de negocio (IRecomendarPrenda)
     * para que las GUIs o servicios puedan solicitar recomendaciones.
     *
     * @return La implementación de la interfaz IRecomendarPrenda (FachadaRecomendarPrenda).
     */
    private void cerrarFrameActual(JFrame frame) {
        if (frame != null) {
            frame.dispose();
        }
    }

    /**
     * Cierra y libera los recursos del JFrame proporcionado si no es nulo,
     * utilizando el método dispose().
     *
     * @param frame El JFrame que se desea cerrar.
     */
    public void navegarRecomendarPrenda(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIRecomendarPrenda menu = new GUIRecomendarPrenda(empleado);
        menu.setVisible(true);
    }
    
    /**
     * Cierra el frame de interfaz de usuario actual y navega a la
     * ventana de recomendación de prenda (GUIRecomendarPrenda).
     *
     * @param frameActual El JFrame actual que será cerrado.
     * @param empleado El DTO del empleado que está iniciando la operación,
     * utilizado para la sesión o la configuración de la GUI.
     */
    public IRecomendarPrenda getRecomendarPrenda() {
        return recomendarPrenda;
    }
    
    
}
