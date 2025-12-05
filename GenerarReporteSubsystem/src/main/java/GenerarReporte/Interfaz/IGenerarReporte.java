/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GenerarReporte.Interfaz;

import com.mycompany.dto_negocio.RopaTallaDTO;
import com.mycompany.dto_negocio.SugerenciaDTO;
import java.util.List;

/**
 * Interfaz que define el contrato para el subsistema de Generación de Reportes.
 * <p>
 * Esta interfaz desacopla la lógica de control (Controladores) de la implementación específica
 * de la generación de documentos (PDF, Excel, etc.). Permite que los controladores soliciten
 * reportes sin conocer los detalles de cómo se construyen internamente.
 * </p>
 * * @author garfi
 * @version 1.0
 */
public interface IGenerarReporte {

    /**
     * Solicita la generación de un reporte de inventario completo.
     * * @param datos Lista de objetos {@code RopaTallaDTO} que contienen la información de las prendas y tallas.
     * @param rutaDestino La ruta del sistema de archivos donde se debe guardar el reporte generado.
     * @return {@code true} si el reporte se generó y guardó exitosamente; {@code false} si hubo algún error.
     */
    public boolean generarReporteInventario(List<RopaTallaDTO> datos, String rutaDestino);

    /**
     * Solicita la generación de un reporte de sugerencias.
     * * @param datos Lista de objetos {@code SugerenciaDTO} a incluir en el reporte.
     * @param rutaDestino La ruta del sistema de archivos donde se debe guardar el reporte.
     * @param tituloReporte Un texto adicional para el título del reporte (por ejemplo, para indicar el filtro aplicado: "Pendientes", "Aprobadas").
     * @return {@code true} si el reporte se generó y guardó exitosamente; {@code false} si hubo algún error.
     */
    public boolean generarReporteSugerencias(List<SugerenciaDTO> datos, String rutaDestino, String tituloReporte);
}