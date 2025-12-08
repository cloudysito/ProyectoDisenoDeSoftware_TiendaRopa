/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recomendarprendasubsystem;

import BOs.RopaTallaBO;
import com.mycompany.dto_negocio.BuscarPrendaDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;
import com.mycompany.recomendarprendasubsystem.Interfaz.IRecomendarPrenda;

/**
 *
 * @author santi
 */
public class FachadaRecomendarPrenda implements IRecomendarPrenda {
    /**
     * Implementación del método que recomienda una prenda específica (incluyendo su talla)
     * basándose en los criterios de búsqueda proporcionados.
    *
    * Delega la búsqueda de la prenda y su filtrado a la capa de Lógica de Negocio (BO).
    *
    * @param busqueda El DTO que contiene los parámetros para la búsqueda.
    * @return Un objeto {@code RopaTallaDTO} que representa la prenda recomendada.
    */
    @Override
    public RopaTallaDTO recomentarPrenda(BuscarPrendaDTO busqueda) {
        return RopaTallaBO.getInstance().buscarPorFiltro(busqueda);
    }
    
}
