/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

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
 *
 * @author garfi
 */
public class GestorPDF {

    private static final Font FUENTE_TITULO = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    private static final Font FUENTE_CABECERA = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

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

    private void agregarCabecera(PdfPTable tabla, String texto) {
        PdfPCell celda = new PdfPCell(new Phrase(texto, FUENTE_CABECERA));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabla.addCell(celda);
    }

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
