/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import com.mycompany.dto_negocio.RopaTallaDTO;
import java.util.List;

/**
 *
 * @author garfi
 */
public interface IGenerarReporte {
    
    public boolean generarReporteInventario(List<RopaTallaDTO> datos, String rutaDestino);
    
}
