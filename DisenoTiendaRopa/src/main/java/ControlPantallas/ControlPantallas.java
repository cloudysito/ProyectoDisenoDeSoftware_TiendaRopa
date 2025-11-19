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
import com.mycompany.aumentarventaempleado.Fachada.FachadaAumentarVentaEmpleado;
import com.mycompany.aumentarventaempleado.Interfaz.IAumentarVentaEmpleado;
import com.mycompany.escanearproductosubsystem.FachadaEscanearProducto;
import com.mycompany.escanearproductosubsystem.Interfaz.IEscanearProducto;
import com.mycompany.metodopagosubsystem.FachadaMetodoPago;
import com.mycompany.metodopagosubsystem.Interfaz.IMetodoPago;
import com.mycompany.objetosnegocio.dominio.RopaTalla;
import com.mycompany.objetosnegocio.dto.EmpleadoDTO;
import com.mycompany.objetosnegocio.dto.ProductoDTO;
import com.mycompany.realizarventasubsystem.Interfaz.IRealizarVenta;
import com.mycompany.realizarventasubsystem.FachadaRealizarVenta;
import javax.swing.JFrame;

/**
 *
 * @author emiim
 */
public class ControlPantallas {

    private static ControlPantallas instancia;
    private static IEscanearProducto escanerSistema;
    private static IRealizarVenta realizarVentaSistema;
    private static IMetodoPago metodoPagoSistema;
    private static IAumentarVentaEmpleado EmpleadoSistema;
    
    public static synchronized ControlPantallas getInstase() {
        if (instancia == null) {
            instancia = new ControlPantallas();
            escanerSistema = new FachadaEscanearProducto();
            realizarVentaSistema = new FachadaRealizarVenta();
            metodoPagoSistema = new FachadaMetodoPago();
            EmpleadoSistema = new FachadaAumentarVentaEmpleado();
        }
        return instancia;
    }

    private void cerrarFrameActual(JFrame frameActual) {
        if (frameActual != null) {
            frameActual.dispose();
        }
    }

    public void navegarMenuPrincipal(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIMenu menu = new GUIMenu(empleado);
        menu.setVisible(true);
    }

    public void navegarCodigoProducto(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUICodigoProducto cp = new GUICodigoProducto(empleado);
        cp.setVisible(true);
    }

    public void navegarProducto(JFrame frameActual,EmpleadoDTO empleado, RopaTalla productodto) {
        cerrarFrameActual(frameActual);
        GUIProducto producto = new GUIProducto(empleado, productodto);
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

    public ControlPantallas getInstancia() {
        return instancia;
    }

    public IEscanearProducto getEscanerSistema() {
        return escanerSistema;
    }

    public IRealizarVenta getRealizarVentaSistema() {
        return realizarVentaSistema;
    }

    public  IMetodoPago getMetodoPagoSistema() {
        return metodoPagoSistema;
    }

    public IAumentarVentaEmpleado getEmpleadoSistema() {
        return EmpleadoSistema;
    }
    
    
    
    
}
