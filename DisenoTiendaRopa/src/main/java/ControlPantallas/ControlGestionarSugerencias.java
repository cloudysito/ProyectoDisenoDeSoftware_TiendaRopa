/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlPantallas;


import GUIsCUIAdminTendenciaSugerencia.GUIDetallesSugerencia;
import GUIsCUIAdminTendenciaSugerencia.GUIMenuSugerencia;
import GenerarReporte.Fachada.FachadaGenerarReporte;
import GenerarReporte.Interfaz.IGenerarReporte;
import GestionarSugerencia.Fachada.FachadaGestionarSugerencias;
import GestionarSugerencia.Interfaz.IGestionarSugerencias;
import com.mycompany.dto_negocio.SugerenciaDTO;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author garfi
 */
public class ControlGestionarSugerencias {

    private static ControlGestionarSugerencias instancia;
    private IGestionarSugerencias gestionSugerencias;
    private IGenerarReporte generadorReportes;

    private ControlGestionarSugerencias() {
        this.gestionSugerencias = new FachadaGestionarSugerencias();
        this.generadorReportes = new FachadaGenerarReporte(); 
    }

    public static synchronized ControlGestionarSugerencias getInstance() {
        if (instancia == null) {
            instancia = new ControlGestionarSugerencias();
        }
        return instancia;
    }

    private void cerrarFrameActual(JFrame frame) {
        if (frame != null) {
            frame.dispose();
        }
    }
    
    public void navegarMenuSugerencias(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIMenuSugerencia ms = new GUIMenuSugerencia();
        ms.setVisible(true);
    }

    public void navegarDetalleSugerencia(JFrame frameActual, SugerenciaDTO sugerencia) {
        cerrarFrameActual(frameActual);
        GUIDetallesSugerencia ds = new GUIDetallesSugerencia();
        ds.setDatos(sugerencia); 
        ds.setVisible(true);
    }
    
    public List<SugerenciaDTO> obtenerSugerenciasFiltradas(String filtro) {
        return gestionSugerencias.filtrarSugerencias(filtro);
    }

    public boolean procesarSugerencia(SugerenciaDTO s, String nuevoEstado) {
        return gestionSugerencias.cambiarEstadoSugerencia(s, nuevoEstado);
    }

    public boolean generarReportePDF(String ruta, String filtroActual) {

        List<SugerenciaDTO> datos = gestionSugerencias.filtrarSugerencias(filtroActual);
        return generadorReportes.generarReporteSugerencias(datos, ruta, filtroActual);
    }

}
