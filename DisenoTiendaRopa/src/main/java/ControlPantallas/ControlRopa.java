/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlPantallas;

import DisenoGUIs.GUIsCUIAgregarPrenda.GUIAñadirPrenda;
import DisenoGUIs.GUIsCUIAgregarPrenda.GUIEditarPrenda;
import DisenoGUIs.GUIsCUIAgregarPrenda.GUIGestionCatalogo;
import GenerarCodigo.Fachada.FachadaGeneradorCodigoBarras;
import GenerarReporte.Fachada.FachadaGenerarReporte;
import GenerarReporte.Fachada.FachadaGestionarCatalogo;
import GenerarCodigo.Interfaz.IGeneradorCodigoBarras;
import GenerarReporte.Interfaz.IGenerarReporte;
import GenerarReporte.Interfaz.IGestionarCatalogo;
import com.mycompany.dto_negocio.RopaTallaDTO;
import java.util.List;
import javax.swing.JFrame;

/**
 * Controlador encargado de gestionar el flujo de las pantallas relacionadas con el Catálogo de Ropa.
 * <p>
 * Esta clase centraliza la navegación entre la gestión del catálogo, añadir prendas y editar prendas.
 * Además, conecta la interfaz gráfica con los subsistemas de generación de reportes, códigos de barras
 * y gestión de inventario.
 * </p>
 * * @author garfi
 * @version 1.0
 */
public class ControlRopa {

    /** Instancia única del controlador (Singleton). */
    private static ControlRopa instancia;
    
    /** Fachada para la gestión del catálogo (Inventario). */
    private static IGestionarCatalogo gestionCatalogo;
    
    /** Fachada para la generación de reportes (PDFs). */
    private static IGenerarReporte generarReportes;
    
    /** Fachada para la generación de códigos de barras. */
    private static IGeneradorCodigoBarras generarCodigoBarras;

    /**
     * Obtiene la instancia única de la clase (Singleton) e inicializa las dependencias.
     * <p>
     * Si la instancia no existe, la crea junto con las fachadas necesarias
     * (Gestión de Catálogo, Reportes y Códigos de Barras).
     * </p>
     * @return La instancia única de {@code ControlRopa}.
     */
    public static synchronized ControlRopa getInstase() {
        if (instancia == null) {
            instancia = new ControlRopa();
            gestionCatalogo = new FachadaGestionarCatalogo();
            generarReportes = new FachadaGenerarReporte();
            generarCodigoBarras = new FachadaGeneradorCodigoBarras();
        }
        return instancia;
    }
    
    /**
     * Método auxiliar para cerrar y liberar los recursos de un JFrame.
     * @param frameActual La ventana actual que se desea cerrar.
     */
    private void cerrarFrameActual(JFrame frameActual) {
        if (frameActual != null) {
            frameActual.dispose();
        }
    }
    
    /**
     * Navega hacia la pantalla principal de Gestión del Catálogo.
     * @param frameActual La ventana desde la que se realiza la navegación (será cerrada).
     */
    public void navegarGestionCatalogo(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIGestionCatalogo gc = new GUIGestionCatalogo();
        gc.setVisible(true);
    }
    
    /**
     * Navega hacia la pantalla de Añadir una nueva Prenda.
     * @param frameActual La ventana desde la que se realiza la navegación.
     */
    public void navegarAñadirPrenda(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIAñadirPrenda ap = new GUIAñadirPrenda();
        ap.setVisible(true);
    }
    
    /**
     * Navega hacia la pantalla de Editar una Prenda existente.
     * <p>
     * Carga los datos de la prenda seleccionada en la ventana de edición.
     * </p>
     * @param frameActual La ventana desde la que se realiza la navegación.
     * @param prendaAEditar El DTO con la información de la prenda a modificar.
     */
    public void navegarEditarPrenda(JFrame frameActual, RopaTallaDTO prendaAEditar) {
        cerrarFrameActual(frameActual);
        GUIEditarPrenda ep = new GUIEditarPrenda();
        ep.setDatos(prendaAEditar);
        ep.setVisible(true);
    }

    /**
     * Obtiene la instancia actual del controlador.
     * @return La instancia de {@code ControlRopa}.
     */
    public ControlRopa getInstancia() {
        return instancia;
    }
    
    /**
     * Obtiene la interfaz de gestión del catálogo.
     * @return El objeto que implementa {@code IGestionarCatalogo}.
     */
    public IGestionarCatalogo getGestionCatalogo() {
        return gestionCatalogo;
    }
    
    /**
     * Coordina la generación del reporte completo del inventario.
     * <p>
     * 1. Obtiene la lista completa de ropa desde la fachada de catálogo.<br>
     * 2. Envía la lista a la fachada de reportes para generar el archivo PDF.
     * </p>
     * @param rutaDestino La ruta del sistema de archivos donde se guardará el PDF.
     * @return {@code true} si el proceso fue exitoso, {@code false} si ocurrió una excepción.
     */
    public boolean generarReporteDeCatalogo(String rutaDestino) {
        try {
            
            List<RopaTallaDTO> inventario = gestionCatalogo.obtenerInventarioCompleto();
            return generarReportes.generarReporteInventario(inventario, rutaDestino);
            
        } catch (Exception e) {
            System.out.println("Error en ControlRopa al generar reporte: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Obtiene la interfaz para la generación de códigos de barras.
     * @return El objeto que implementa {@code IGeneradorCodigoBarras}.
     */
    public IGeneradorCodigoBarras getGenerarCodigoBarras() {
        return generarCodigoBarras;
    }
    
}