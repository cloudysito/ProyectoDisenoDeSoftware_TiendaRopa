/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GenerarReporte.Implementaciones;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.dto_negocio.EmpleadoDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;
import com.mycompany.dto_negocio.SugerenciaDTO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Clase encargada de la generación física de archivos PDF utilizando la librería iText.
 * <p>
 * Esta clase contiene la lógica de diseño, formateo y escritura de los documentos.
 * Define fuentes estáticas y estructuras de tablas para mantener la consistencia visual
 * en todos los reportes del sistema.
 * </p>
 * * @author garfi
 * @version 1.0
 */
public class GestorPDF {

    /** Fuente utilizada para los títulos principales de los reportes (Helvetica, 18, Negrita). */
    private static final Font FUENTE_TITULO = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    
    /** Fuente utilizada para las cabeceras de las columnas en las tablas (Helvetica, 12, Negrita). */
    private static final Font FUENTE_CABECERA = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

    /**
     * Genera un reporte tabular del inventario actual de ropa.
     * <p>
     * Crea un documento PDF con una tabla de 5 columnas: Código, Prenda, Talla, Precio y Stock.
     * Maneja valores nulos insertando guiones ("-") o textos predeterminados ("S/N") 
     * para evitar errores durante la generación.
     * </p>
     * * @param inventario Lista de {@code RopaTallaDTO} con los datos a imprimir.
     * @param rutaDestino Ruta del archivo donde se guardará el PDF.
     * @throws DocumentException Si ocurre un error propio de la librería iText al construir el documento.
     * @throws IOException Si ocurre un error de entrada/salida al crear el archivo físico.
     */
    public void generarReportePDF(List<RopaTallaDTO> inventario, String rutaDestino) throws DocumentException, IOException {
        Document documento = new Document();
        PdfWriter.getInstance(documento, new FileOutputStream(rutaDestino));
        documento.open();

        Paragraph titulo = new Paragraph("Reporte de Inventario", FUENTE_TITULO);
        titulo.setAlignment(Element.ALIGN_CENTER);
        documento.add(titulo);
        documento.add(new Paragraph("Fecha: " + new Date().toString()));
        documento.add(new Paragraph(" "));

        PdfPTable tabla = new PdfPTable(5);
        tabla.setWidthPercentage(100);

        agregarCabecera(tabla, "Código");
        agregarCabecera(tabla, "Prenda");
        agregarCabecera(tabla, "Talla");
        agregarCabecera(tabla, "Precio");
        agregarCabecera(tabla, "Stock");

        for (RopaTallaDTO item : inventario) {

            // Validaciones ternarias para evitar NullPointerException si faltan datos
            String codigo = (item.getCodigoBarras() != null) ? item.getCodigoBarras() : "-";
            String nombre = (item.getRopa() != null) ? item.getRopa().getNombreArticulo() : "S/N";
            String talla = (item.getTalla() != null) ? item.getTalla().getNombreTalla() : "-";
            String precio = (item.getRopa() != null) ? String.valueOf(item.getRopa().getPrecio()) : "0";
            String stock = String.valueOf(item.getCantidad());

            tabla.addCell(codigo);
            tabla.addCell(nombre);
            tabla.addCell(talla);
            tabla.addCell(precio);
            tabla.addCell(stock);
        }

        documento.add(tabla);
        documento.close();
    }

    /**
     * Método auxiliar para crear celdas de cabecera con estilo uniforme.
     * * @param tabla La tabla a la que se agregará la celda.
     * @param texto El texto que irá dentro de la cabecera.
     */
    private void agregarCabecera(PdfPTable tabla, String texto) {
        PdfPCell celda = new PdfPCell(new Phrase(texto, FUENTE_CABECERA));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabla.addCell(celda);
    }

    /**
     * Genera un reporte de las sugerencias realizadas por los empleados.
     * <p>
     * Crea un documento PDF con una tabla de 4 columnas. Incluye lógica para formatear
     * el nombre completo del empleado o asignar "Anónimo" si no hay datos del empleado asociado.
     * </p>
     * * @param lista Lista de {@code SugerenciaDTO} a incluir en el reporte.
     * @param ruta Ruta del archivo donde se guardará el PDF.
     * @param tituloFiltro Texto adicional para el título del reporte (ej. filtro aplicado).
     * @throws Exception Puede lanzar excepciones de tipo DocumentException o IOException.
     */
    public void generarPDFSugerencias(List<SugerenciaDTO> lista, String ruta, String tituloFiltro) throws Exception {
        Document documento = new Document();
        PdfWriter.getInstance(documento, new FileOutputStream(ruta));
        documento.open();

        Paragraph titulo = new Paragraph("Reporte de Sugerencias " + tituloFiltro, FUENTE_TITULO);
        titulo.setAlignment(Element.ALIGN_CENTER);
        documento.add(titulo);
        documento.add(new Paragraph(" "));

        PdfPTable tabla = new PdfPTable(4);
        agregarCabecera(tabla, "Fecha");
        agregarCabecera(tabla, "Nombre del Empleado");
        agregarCabecera(tabla, "Descripción");
        agregarCabecera(tabla, "Estado");

        for (SugerenciaDTO s : lista) {
            String fecha = (s.getFechaPublicacion() != null) ? s.getFechaPublicacion().toString() : "-";
            EmpleadoDTO empleado = s.getEmpleadoDTO();

            String nombreCompleto = "Anónimo";

            // Construcción segura del nombre del empleado
            if (empleado != null) {
                String nombre = (empleado.getNombre() != null) ? empleado.getNombre() : "";
                String apellido = (empleado.getApellidos() != null) ? empleado.getApellidos() : "";

                nombreCompleto = (nombre + " " + apellido).trim();

                if (nombreCompleto.isEmpty()) {
                    nombreCompleto = "Anónimo";
                }
            }

            tabla.addCell(fecha);
            tabla.addCell(nombreCompleto);
            tabla.addCell(s.getDescripcion());
            tabla.addCell(s.getEstado());
        }
        documento.add(tabla);
        documento.close();
    }

}