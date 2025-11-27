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
import com.mycompany.dto_negocio.EmpleadoDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;
import com.mycompany.dto_negocio.VentaDTO;
import com.mycompany.escanearproductosubsystem.FachadaEscanearProducto;
import com.mycompany.escanearproductosubsystem.Interfaz.IEscanearProducto;
import com.mycompany.metodopagosubsystem.FachadaMetodoPago;
import com.mycompany.metodopagosubsystem.Interfaz.IMetodoPago;
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

    public void navegarCodigoProducto(JFrame frameActual, EmpleadoDTO empleado,VentaDTO venta, boolean ven) {
        cerrarFrameActual(frameActual);
        GUICodigoProducto cp = new GUICodigoProducto(empleado,  venta, ven);
        cp.setVisible(true);
    }

    public void navegarProducto(JFrame frameActual,EmpleadoDTO empleado, RopaTallaDTO productodto,VentaDTO venta,boolean ven) {
        cerrarFrameActual(frameActual);
        GUIProducto producto = new GUIProducto(empleado, productodto, venta , ven);
        producto.setVisible(true);
    }

    public void navegarVenderPrenda(JFrame frameActual,EmpleadoDTO empleado, VentaDTO venta) {
        cerrarFrameActual(frameActual);
        GUIVenderPrenda vp = new GUIVenderPrenda(empleado,venta);
        vp.setVisible(true);
    }

    public void navegarPagoEfectivo(JFrame frameActual,EmpleadoDTO empleado, VentaDTO venta) {
        cerrarFrameActual(frameActual);
        GUIPagoEfectivo efectivo = new GUIPagoEfectivo(empleado,venta);
        efectivo.setVisible(true);
    }

    public void navegarPagoPaypal(JFrame frameActual, EmpleadoDTO empleado, VentaDTO venta) {
        cerrarFrameActual(frameActual);
        GUIPagoPaypal paypal = new GUIPagoPaypal(empleado,venta);
        paypal.setVisible(true);
    }

    public void navegarPagoTarjeta(JFrame frameActual,EmpleadoDTO empleado, VentaDTO venta) {
        cerrarFrameActual(frameActual);
        GUIPagoTarjeta tarjeta = new GUIPagoTarjeta(empleado,venta);
        tarjeta.setVisible(true);
    }

    public void navegarPagoTransferencia(JFrame frameActual,EmpleadoDTO empleado, VentaDTO venta) {
        cerrarFrameActual(frameActual);
        GUIPagoTransferencia transferencia = new GUIPagoTransferencia(empleado,venta);
        transferencia.setVisible(true);
    }

    public void navegarSeleccionMetodoPago(JFrame frameActual, EmpleadoDTO empleado, VentaDTO venta) {
        cerrarFrameActual(frameActual);
        GUISeleccionMetodoPago smp = new GUISeleccionMetodoPago(empleado,venta);
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
