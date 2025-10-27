/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlPantallas;

import DisenoGUIs.GUICodigoProducto;
import DisenoGUIs.GUIMenu;
import DisenoGUIs.GUIProducto;
import DisenoGUIs.GUIVenderPrenda;
import javax.swing.JFrame;

/**
 *
 * @author emiim
 */
public class ControlPantallas {
    private static ControlPantallas instancia;
    
    public static synchronized ControlPantallas getInstase() {
        if (instancia == null) {
            instancia = new ControlPantallas();
        }
        return instancia;
    }
    
    private void cerrarFrameActual(JFrame frameActual) {
        if (frameActual != null) {
            frameActual.dispose();
        }
    }
    
    public void navegarMenuPrincipal(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIMenu menu = new GUIMenu();
        menu.setVisible(true);
    }
    
    public void navegarCodigoProducto(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUICodigoProducto cp = new GUICodigoProducto();
        cp.setVisible(true);
    }
    
    public void navegarProducto(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIProducto producto = new GUIProducto();
        producto.setVisible(true);
    }
    
    public void navegarVenderPrenda(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIVenderPrenda vp = new GUIVenderPrenda();
        vp.setVisible(true);
    }
}
