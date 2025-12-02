/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlPantallas;

import GUIDevolverPrenda.GUIBuscarVenta;
import GUIDevolverPrenda.GUIConfirmacionReembolso;
import GUIDevolverPrenda.GUIReembolsoPrenda;
import GUIDevolverPrenda.GUISeleccionMetodoReembolso;
import com.mycompany.dto_negocio.DetalleReembolsoDTO;
import com.mycompany.dto_negocio.EmpleadoDTO;
import com.mycompany.dto_negocio.SolicitudReembolsoDTO;
import com.mycompany.dto_negocio.VentaDTO;
import fachada.FachadaDevolverPrenda;
import interfaz.IDevolverPrenda;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author emiim
 */
public class ControlReembolso {
    private static ControlReembolso  instancia;
    private static IDevolverPrenda fachada;
    private EmpleadoDTO empleadoActual;
    private VentaDTO ventaEncontrada;
    private SolicitudReembolsoDTO solicitudActual;
    
    public ControlReembolso() {
        this.fachada = new FachadaDevolverPrenda();
    }
    
    public static synchronized ControlReembolso getInstase() {
        if (instancia == null) {
            instancia = new ControlReembolso();
            fachada = new FachadaDevolverPrenda();
           
        }
        return instancia;
    }

    public void iniciarFlujo(JFrame frameAnterior, EmpleadoDTO empleado) {
        this.empleadoActual = empleado;
        if (frameAnterior != null) frameAnterior.dispose();
        
        GUIBuscarVenta gui = new GUIBuscarVenta();
        gui.setVisible(true);
    }

    public void buscarVenta(JFrame frameActual, String idVenta) {
        if (idVenta == null || idVenta.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frameActual, "Por favor, ingresa un ID de venta.");
            return;
        }

        try {
            this.ventaEncontrada = fachada.buscarVenta(idVenta);
            
            if (this.ventaEncontrada != null) {
                frameActual.dispose();
                GUIReembolsoPrenda gui = new GUIReembolsoPrenda(ventaEncontrada);
                gui.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(frameActual, "Venta no encontrada.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frameActual, "Error al buscar: " + e.getMessage());
        }
    }

   public void irASeleccionMetodo(JFrame frameActual, List<DetalleReembolsoDTO> detalles, double montoTotal) {
        if (detalles.isEmpty()) {
            JOptionPane.showMessageDialog(frameActual, "Seleccione al menos un producto para devolver.");
            return;
        }

        // Construimos la solicitud preliminar
        solicitudActual = new SolicitudReembolsoDTO();
        solicitudActual.setVentaOriginal(ventaEncontrada);
        solicitudActual.setEmpleado(empleadoActual);
        solicitudActual.setMontoTotal(montoTotal);
        solicitudActual.setListaDetalles(detalles);

        boolean valido = fachada.validarCantidades(solicitudActual);

        if (valido) {
            frameActual.dispose();
            GUISeleccionMetodoReembolso gui = new GUISeleccionMetodoReembolso(solicitudActual);
            gui.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(frameActual, "Error: Las cantidades superan lo comprado o ya devuelto.");
        }
    }
    
    public void procesarReembolso(JFrame frameActual, String metodoPago) {
        solicitudActual.setMetodoReembolso(metodoPago);
        
        try {
            boolean exito = fachada.procesarReembolso(solicitudActual);
            
            if (exito) {
                frameActual.dispose();
                GUIConfirmacionReembolso gui = new GUIConfirmacionReembolso(solicitudActual);
                gui.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(frameActual, "No se pudo procesar el reembolso en la base de datos.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frameActual, "Error procesando reembolso: " + e.getMessage());
        }
    }
    
    
}
