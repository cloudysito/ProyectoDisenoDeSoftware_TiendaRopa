/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.recomendarprendasubsystem.Interfaz;

import com.mycompany.dto_negocio.BuscarPrendaDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;

/**
 *
 * @author santi
 */
public interface IRecomendarPrenda {
    /**
 * Recomienda una prenda específica (incluyendo su talla) basándose en los criterios de búsqueda proporcionados.
 *
 * Este método implementa la lógica central del sistema de recomendación, que típicamente
 * implica consultar el inventario y aplicar reglas o algoritmos para encontrar la prenda
 * más adecuada que cumpla con las características definidas en el DTO de búsqueda.
 *
 * @param busqueda El DTO (Data Transfer Object) que contiene los parámetros necesarios
 * para realizar la búsqueda y la recomendación (ej. tipo de prenda, color, talla inicial, etc.).
 * @return Un objeto {@code RopaTallaDTO} que representa la prenda recomendada junto con su talla disponible.
 * Devuelve {@code null} si no se encuentra ninguna prenda que cumpla con los criterios o si el inventario está agotado.
 */
    RopaTallaDTO recomentarPrenda(BuscarPrendaDTO busqueda);
}
