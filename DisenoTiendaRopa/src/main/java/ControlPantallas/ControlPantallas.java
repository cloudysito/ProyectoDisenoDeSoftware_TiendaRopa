/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlPantallas;

import DisenoGUIs.GUICodigoProducto;
import DisenoGUIs.GUICompraRealizada;
import DisenoGUIs.GUIMenu;
import DisenoGUIs.GUIPagoEfectivo;
import DisenoGUIs.GUIPagoPaypal;
import DisenoGUIs.GUIPagoTarjeta;
import DisenoGUIs.GUIPagoTransferencia;
import DisenoGUIs.GUIProducto;
import DisenoGUIs.GUISeleccionMetodoPago;
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

    public void navegarCompraRealizada(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUICompraRealizada cr = new GUICompraRealizada();
        cr.setVisible(true);
    }

    public void navegarPagoEfectivo(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIPagoEfectivo efectivo = new GUIPagoEfectivo();
        efectivo.setVisible(true);
    }

    public void navegarPagoPaypal(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIPagoPaypal paypal = new GUIPagoPaypal();
        paypal.setVisible(true);
    }

    public void navegarPagoTarjeta(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIPagoTarjeta tarjeta = new GUIPagoTarjeta();
        tarjeta.setVisible(true);
    }

    public void navegarPagoTransferencia(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIPagoTransferencia transferencia = new GUIPagoTransferencia();
        transferencia.setVisible(true);
    }

    public void navegarSeleccionMetodoPago(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUISeleccionMetodoPago smp = new GUISeleccionMetodoPago();
        smp.setVisible(true);
    }

}
