/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlPantallas;

import DisenoGUIs.GUIsCUIAgregarPrenda.GUIAñadirPrenda;
import DisenoGUIs.GUIsCUIAgregarPrenda.GUIEditarPrenda;
import DisenoGUIs.GUIsCUIAgregarPrenda.GUIGestionCatalogo;
import Fachada.FachadaGeneradorCodigoBarras;
import Fachada.FachadaGenerarReporte;
import Fachada.FachadaGestionarCatalogo;
import Interfaz.IGeneradorCodigoBarras;
import Interfaz.IGenerarReporte;
import Interfaz.IGestionarCatalogo;
import com.mycompany.dto_negocio.RopaTallaDTO;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author garfi
 */
public class ControlRopa {

    private static ControlRopa instancia;
    private static IGestionarCatalogo gestionCatalogo;
    private static IGenerarReporte generarReportes;
    private static IGeneradorCodigoBarras generarCodigoBarras;

    public static synchronized ControlRopa getInstase() {
        if (instancia == null) {
            instancia = new ControlRopa();
            gestionCatalogo = new FachadaGestionarCatalogo();
            generarReportes = new FachadaGenerarReporte();
            generarCodigoBarras = new FachadaGeneradorCodigoBarras();
        }
        return instancia;
    }
    
    private void cerrarFrameActual(JFrame frameActual) {
        if (frameActual != null) {
            frameActual.dispose();
        }
    }
    
    public void navegarGestionCatalogo(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIGestionCatalogo gc = new GUIGestionCatalogo();
        gc.setVisible(true);
    }
    
    public void navegarAñadirPrenda(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIAñadirPrenda ap = new GUIAñadirPrenda();
        ap.setVisible(true);
    }
    
    public void navegarEditarPrenda(JFrame frameActual, RopaTallaDTO prendaAEditar) {
        cerrarFrameActual(frameActual);
        GUIEditarPrenda ep = new GUIEditarPrenda();
        ep.setDatos(prendaAEditar);
        ep.setVisible(true);
    }

    public ControlRopa getInstancia() {
        return instancia;
    }
    
    public IGestionarCatalogo getGestionCatalogo() {
        return gestionCatalogo;
    }
    
    public boolean generarReporteDeCatalogo(String rutaDestino) {
        try {
            
            List<RopaTallaDTO> inventario = gestionCatalogo.obtenerInventarioCompleto();
            return generarReportes.generarReporteInventario(inventario, rutaDestino);
            
        } catch (Exception e) {
            System.out.println("Error en ControlRopa al generar reporte: " + e.getMessage());
            return false;
        }
    }
    
    public IGeneradorCodigoBarras getGenerarCodigoBarras() {
        return generarCodigoBarras;
    }
    
}
