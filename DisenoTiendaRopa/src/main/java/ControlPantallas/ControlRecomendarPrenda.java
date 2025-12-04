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

    private static ControlRecomendarPrenda instancia;
    private IRecomendarPrenda recomendarPrenda;
    
    private ControlRecomendarPrenda() {
        this.recomendarPrenda = new FachadaRecomendarPrenda();
    }
    
    public static synchronized ControlRecomendarPrenda  getInstance(){
        if (instancia == null) {
            instancia = new ControlRecomendarPrenda();
        }
        return  instancia;
    }
    
    private void cerrarFrameActual(JFrame frame) {
        if (frame != null) {
            frame.dispose();
        }
    }

    public void navegarRecomendarPrenda(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIRecomendarPrenda menu = new GUIRecomendarPrenda(empleado);
        menu.setVisible(true);
    }
    
    public IRecomendarPrenda getRecomendarPrenda() {
        return recomendarPrenda;
    }
    
    
}
