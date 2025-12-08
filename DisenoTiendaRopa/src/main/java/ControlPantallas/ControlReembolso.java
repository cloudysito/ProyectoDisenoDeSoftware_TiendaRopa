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
    /**
     * Instancia única de la clase ControlReembolso (Patrón Singleton).
     */
    private static ControlReembolso  instancia;
    
    /**
     * Interfaz de la Fachada que proporciona acceso a la lógica de negocio
     * (Búsqueda de Venta, Validación, Procesamiento de Reembolso).
     */
    private static IDevolverPrenda fachada;
    
    /**
     * Objeto DTO del empleado que está realizando la operación de reembolso.
     */
    private EmpleadoDTO empleadoActual;
    
    /**
     * Objeto DTO de la venta que ha sido encontrada y sobre la cual
     * se realizará la operación.
     */
    private VentaDTO ventaEncontrada;
    
    /**
     * Objeto DTO que almacena toda la información (detalles, monto, empleado)
     * de la solicitud de reembolso en curso.
     */
    private SolicitudReembolsoDTO solicitudActual;
    
    /**
     * Constructor de la clase. Inicializa el atributo fachada con la
     * implementación concreta de la lógica de negocio.
     */
    public ControlReembolso() {
        this.fachada = new FachadaDevolverPrenda();
    }
    
    /**
     * Implementa el patrón Singleton. Devuelve la instancia única de
     * ControlReembolso, creándola si aún no existe. La sincronización
     * es crucial en entornos multihilo.
     *
     * @return La instancia única de ControlReembolso.
     */
    public static synchronized ControlReembolso getInstase() {
        if (instancia == null) {
            instancia = new ControlReembolso();
            fachada = new FachadaDevolverPrenda();
           
        }
        return instancia;
    }
    
    /**
     * Inicia el flujo de trabajo del reembolso. Cierra el frame de interfaz
     * anterior y navega a la interfaz para buscar la venta (GUIBuscarVenta).
     *
     * @param frameAnterior El JFrame actual que será cerrado.
     * @param empleado El DTO del empleado que inicia el proceso.
     */
    public void iniciarFlujo(JFrame frameAnterior, EmpleadoDTO empleado) {
        this.empleadoActual = empleado;
        if (frameAnterior != null) frameAnterior.dispose();
        
        GUIBuscarVenta gui = new GUIBuscarVenta();
        gui.setVisible(true);
    }

    /**
     * Valida el ID de la venta y, si es válido, utiliza la Fachada
     * para buscar la venta. Si la venta se encuentra, navega a la
     * interfaz de selección de prendas (GUIReembolsoPrenda).
     * Si no se encuentra o el ID es nulo/vacío, muestra un mensaje de error.
     *
     * @param frameActual El JFrame de la búsqueda de venta (se cierra si la venta es encontrada).
     * @param idVenta El identificador de la venta a buscar.
     */
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

    /**
     * Construye la solicitud preliminar de reembolso. Luego, utiliza la Fachada
     * para validar las cantidades a devolver. Si la validación es exitosa,
     * navega a la interfaz de selección del método de reembolso (GUISeleccionMetodoReembolso).
     *
     * @param frameActual El JFrame de selección de detalles de productos.
     * @param detalles Lista de DTOs con los productos y cantidades a devolver.
     * @param montoTotal El valor total del reembolso calculado.
     */
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
   
    /**
     * Establece el método de pago y llama a la Fachada para procesar el reembolso
     * en la base de datos. Si el procesamiento es exitoso, navega a la interfaz
     * de confirmación (GUIConfirmacionReembolso).
     *
     * @param frameActual El JFrame de selección del método de reembolso.
     * @param metodoPago El método de pago seleccionado para el reembolso.
     */
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
