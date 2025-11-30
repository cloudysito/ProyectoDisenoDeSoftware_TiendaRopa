/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlPantallas;

import DisenoGUIs.GUICodigoProducto;
import DisenoGUIs.GUIInicioSesion;
import DisenoGUIs.GUIMenu;
import DisenoGUIs.GUIPagoEfectivo;
import DisenoGUIs.GUIPagoPaypal;
import DisenoGUIs.GUIPagoTarjeta;
import DisenoGUIs.GUIPagoTransferencia;
import DisenoGUIs.GUIProducto;
import DisenoGUIs.GUISeleccionMetodoPago;
import DisenoGUIs.GUIVenderPrenda;

import DisenoGUIs.GUIBuscarVenta;
import DisenoGUIs.GUIDetalleDevolucion;
import DisenoGUIs.GUIMetodoReembolso;
import DisenoGUIs.GUIConfirmacionDevolucion;
import DisenoGUIs.GUIReembolsoPrenda;

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
import com.mycompany.dto_negocio.TicketVentaDTO;

import objetosnegocio.dominioPojo.Empleado;
import objetosnegocio.dominioPojo.RopaTalla;
import com.mycompany.dto_negocio.DetalleVentaDTO;
import com.mycompany.dto_negocio.SolicitudDevolucionDTO;
import fachada.FachadaDevolverPrenda;

import javax.swing.JFrame;
import negocio.IBODevolucion;

/**
 * Singleton que controla la navegación y el acceso a los subsistemas.
 * @author emiim
 */
public class ControlPantallas {

    private static ControlPantallas instancia;
    
    private static IEscanearProducto escanerSistema;
    private static IRealizarVenta realizarVentaSistema;
    private static IMetodoPago metodoPagoSistema;
    private static IAumentarVentaEmpleado EmpleadoSistema;
    
    private static IBODevolucion devolverPrendaSistema;
    
    public static synchronized ControlPantallas getInstase() {
        if (instancia == null) {
            instancia = new ControlPantallas();
            
            escanerSistema = new FachadaEscanearProducto();
            realizarVentaSistema = new FachadaRealizarVenta();
            metodoPagoSistema = new FachadaMetodoPago();
            EmpleadoSistema = new FachadaAumentarVentaEmpleado();
            devolverPrendaSistema = new FachadaDevolverPrenda();
        }
        return instancia;
    }

    private void cerrarFrameActual(JFrame frameActual) {
        if (frameActual != null) {
            frameActual.dispose();
        }
    }

    public void iniciarFlujo(){
        GUIInicioSesion iniciar = new GUIInicioSesion();
        iniciar.setVisible(true);
    }
    
    public void navegarMenuPrincipal(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIMenu menu = new GUIMenu(empleado);
        menu.setVisible(true);
    }
    
    public void navegarMenuPrincipal(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIMenu menu = new GUIMenu(); 
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
    
    public void navegarBuscarVenta(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIBuscarVenta buscar = new GUIBuscarVenta();
        buscar.setVisible(true);
    }

    public void navegarDetalleDevolucion(JFrame frameActual, TicketVentaDTO ventaEncontrada) {
        cerrarFrameActual(frameActual);
        GUIReembolsoPrenda detalle = new GUIReembolsoPrenda(ventaEncontrada);
        detalle.setVisible(true);
    }

    public void navegarMetodoReembolso(JFrame frameActual, SolicitudDevolucionDTO solicitud) {
        cerrarFrameActual(frameActual);
        GUISeleccionMetodoPago metodo = new GUISeleccionMetodoPago(solicitud);
        metodo.setVisible(true);
    }
    
    public void navegarConfirmacionDevolucion(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIConfirmacionDevolucion confirmacion = new GUIConfirmacionDevolucion();
        confirmacion.setVisible(true);
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

    public IMetodoPago getMetodoPagoSistema() {
        return metodoPagoSistema;
    }

    public IAumentarVentaEmpleado getEmpleadoSistema() {
        return EmpleadoSistema;
    } 

    public IBODevolucion getDevolverPrendaSistema() {
        return devolverPrendaSistema;
    }
}