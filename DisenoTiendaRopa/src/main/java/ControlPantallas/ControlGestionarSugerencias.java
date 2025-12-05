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
 * Controlador encargado de gestionar el flujo de las pantallas relacionadas con las Sugerencias.
 * <p>
 * Esta clase actúa como intermediario entre la Capa de Presentación (GUIs) y la Capa de Negocio (Fachadas).
 * Implementa el patrón de diseño <b>Singleton</b> para asegurar una única instancia del controlador
 * durante la ejecución de la aplicación.
 * </p>
 * * @author garfi
 * @version 1.0
 */
public class ControlGestionarSugerencias {

    /** Instancia única de la clase (Singleton). */
    private static ControlGestionarSugerencias instancia;
    
    /** Interfaz para acceder a la lógica de negocio de gestión de sugerencias. */
    private IGestionarSugerencias gestionSugerencias;
    
    /** Interfaz para acceder al subsistema de generación de reportes. */
    private IGenerarReporte generadorReportes;

    /**
     * Constructor privado para prevenir la instanciación directa.
     * Inicializa las fachadas necesarias para la lógica de negocio y reportes.
     */
    private ControlGestionarSugerencias() {
        this.gestionSugerencias = new FachadaGestionarSugerencias();
        this.generadorReportes = new FachadaGenerarReporte(); 
    }

    /**
     * Obtiene la instancia única del controlador.
     * Si la instancia no existe, la crea.
     * * @return La instancia única de {@code ControlGestionarSugerencias}.
     */
    public static synchronized ControlGestionarSugerencias getInstance() {
        if (instancia == null) {
            instancia = new ControlGestionarSugerencias();
        }
        return instancia;
    }

    /**
     * Método auxiliar para cerrar y liberar los recursos de un JFrame.
     * * @param frame La ventana actual que se desea cerrar. Si es null, no hace nada.
     */
    private void cerrarFrameActual(JFrame frame) {
        if (frame != null) {
            frame.dispose();
        }
    }
    
    /**
     * Navega hacia la pantalla del Menú de Sugerencias.
     * Cierra la ventana actual y abre la {@code GUIMenuSugerencia}.
     * * @param frameActual La ventana desde la que se realiza la navegación (será cerrada).
     */
    public void navegarMenuSugerencias(JFrame frameActual) {
        cerrarFrameActual(frameActual);
        GUIMenuSugerencia ms = new GUIMenuSugerencia();
        ms.setVisible(true);
    }

    /**
     * Navega hacia la pantalla de detalles de una sugerencia específica.
     * Cierra la ventana actual, abre {@code GUIDetallesSugerencia} y carga los datos del DTO.
     * * @param frameActual La ventana desde la que se realiza la navegación.
     * @param sugerencia El objeto de transferencia de datos (DTO) con la información de la sugerencia a visualizar.
     */
    public void navegarDetalleSugerencia(JFrame frameActual, SugerenciaDTO sugerencia) {
        cerrarFrameActual(frameActual);
        GUIDetallesSugerencia ds = new GUIDetallesSugerencia();
        ds.setDatos(sugerencia); 
        ds.setVisible(true);
    }
    
    /**
     * Solicita a la capa de negocio una lista de sugerencias filtradas.
     * * @param filtro Cadena de texto o criterio para filtrar las sugerencias.
     * @return Una lista de {@code SugerenciaDTO} que coinciden con el filtro.
     */
    public List<SugerenciaDTO> obtenerSugerenciasFiltradas(String filtro) {
        return gestionSugerencias.filtrarSugerencias(filtro);
    }

    /**
     * Procesa el cambio de estado de una sugerencia.
     * * @param s El DTO de la sugerencia a modificar.
     * @param nuevoEstado El nuevo estado que se asignará (ej. "Aprobada", "Rechazada").
     * @return {@code true} si el cambio de estado fue exitoso, {@code false} en caso contrario.
     */
    public boolean procesarSugerencia(SugerenciaDTO s, String nuevoEstado) {
        return gestionSugerencias.cambiarEstadoSugerencia(s, nuevoEstado);
    }

    /**
     * Coordina la generación de un reporte PDF basado en el filtro actual.
     * <p>
     * Primero obtiene los datos filtrados desde la lógica de negocio y luego
     * los envía al subsistema de reportes para crear el archivo.
     * </p>
     * * @param ruta La ruta del sistema de archivos donde se guardará el PDF.
     * @param filtroActual El filtro aplicado actualmente en la pantalla para obtener los datos correctos.
     * @return {@code true} si el reporte se generó exitosamente, {@code false} si hubo error.
     */
    public boolean generarReportePDF(String ruta, String filtroActual) {
        // Obtiene los datos frescos desde la lógica de negocio usando el filtro
        List<SugerenciaDTO> datos = gestionSugerencias.filtrarSugerencias(filtroActual);
        // Envía los datos y la ruta al generador de reportes
        return generadorReportes.generarReporteSugerencias(datos, ruta, filtroActual);
    }
    
    /**
     * Guarda una nueva sugerencia o actualiza una existente a través de la capa de negocio.
     * * @param sugerenciaDTO El objeto con los datos de la sugerencia.
     * @return El {@code SugerenciaDTO} guardado (posiblemente con ID actualizado) o null si falló.
     */
    public SugerenciaDTO guardarSugerencia(SugerenciaDTO sugerenciaDTO){
        return gestionSugerencias.guardarSugerencia(sugerenciaDTO);
    }
}