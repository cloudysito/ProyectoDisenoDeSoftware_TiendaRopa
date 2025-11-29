/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import Implementaciones.GestorPDF;
import Interfaz.IGenerarReporte;
import com.mycompany.dto_negocio.RopaTallaDTO;
import java.util.List;

/**
 *
 * @author garfi
 */
public class FachadaGenerarReporte implements IGenerarReporte {

    private final GestorPDF gestor;

    public FachadaGenerarReporte() {
        this.gestor = new GestorPDF();
    }

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
}
