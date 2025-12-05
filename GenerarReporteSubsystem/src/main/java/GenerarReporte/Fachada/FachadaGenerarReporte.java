/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GenerarReporte.Fachada;

import GenerarReporte.Implementaciones.GestorPDF;
import GenerarReporte.Interfaz.IGenerarReporte;
import com.mycompany.dto_negocio.RopaTallaDTO;
import com.mycompany.dto_negocio.SugerenciaDTO;
import java.util.List;

/**
 * Implementación del patrón Fachada (Facade) para el subsistema de Generación de Reportes.
 * <p>
 * Esta clase oculta la complejidad de la creación de documentos PDF (manejada por {@code GestorPDF})
 * y proporciona una interfaz simplificada para que los controladores puedan solicitar
 * reportes de inventario y sugerencias sin conocer los detalles de la librería de PDF subyacente.
 * </p>
 *
 * @author garfi
 * @version 1.0
 */
public class FachadaGenerarReporte implements IGenerarReporte {

    /** Instancia del gestor encargado de la creación física de los archivos PDF. */
    private final GestorPDF gestor;

    /**
     * Constructor de la fachada.
     * Inicializa el {@code GestorPDF} que realizará el trabajo pesado de generación de documentos.
     */
    public FachadaGenerarReporte() {
        this.gestor = new GestorPDF();
    }

    /**
     * Genera un reporte PDF detallado del inventario de ropa.
     * <p>
     * Delega la tarea al gestor de PDF. Si ocurre algún error durante la generación
     * (e.g., problemas de escritura en disco), captura la excepción y retorna falso.
     * </p>
     *
     * @param datos Lista de {@code RopaTallaDTO} que contiene la información del inventario a imprimir.
     * @param rutaDestino La ruta completa en el sistema de archivos donde se guardará el PDF.
     * @return {@code true} si el reporte se generó correctamente, {@code false} en caso de error.
     */
    @Override
    public boolean generarReporteInventario(List<RopaTallaDTO> datos, String rutaDestino) {
        try {
            gestor.generarReportePDF(datos, rutaDestino);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Genera un reporte PDF de las sugerencias filtradas.
     * <p>
     * Permite especificar un título para el reporte, útil para diferenciar entre reportes
     * filtrados por diferentes criterios (ej. "Sugerencias Pendientes" o "Por Fecha").
     * </p>
     *
     * @param datos Lista de {@code SugerenciaDTO} con las sugerencias a incluir en el reporte.
     * @param rutaDestino La ruta completa donde se guardará el archivo PDF.
     * @param tituloReporte El título que aparecerá en el encabezado del documento.
     * @return {@code true} si el reporte se creó exitosamente, {@code false} si ocurrió una excepción.
     */
    @Override
    public boolean generarReporteSugerencias(List<SugerenciaDTO> datos, String rutaDestino, String tituloReporte) {
        try {
            gestor.generarPDFSugerencias(datos, rutaDestino, tituloReporte);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}