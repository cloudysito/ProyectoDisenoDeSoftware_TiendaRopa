/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.escanearproductosubsystem.Interfaz;

import com.mycompany.dto_negocio.RopaTallaDTO;
import java.awt.image.BufferedImage;


/**
 * Interfaz que define el contrato para el subsistema de Escaneo y Búsqueda de Productos.
 * <p>
 * Abstrae la lógica de lectura de códigos de barras a partir de una imagen y la búsqueda 
 * del ítem de inventario asociado ({@code RopaTallaDTO}).
 * </p>
 *
 * @author santi
 * @version 1.0
 */
public interface IEscanearProducto {
    
    /**
     * Procesa una imagen que contiene un código de barras (o QR) para extraer la cadena de texto codificada.
     * <p>
     * Este método se encarga de la decodificación visual y algorítmica.
     * </p>
     * * @param image La imagen {@code BufferedImage} que se desea escanear.
     * @return La cadena de texto (código) leída, o {@code null} si no se encuentra ningún código válido.
     */
    public abstract String escanearCodigo(BufferedImage image);
    
    /**
     * Busca y recupera el objeto de inventario (producto específico con talla y stock)
     * basándose en el código de barras previamente escaneado.
     * * @param codigo El código de barras (string) que identifica al producto.
     * @return El objeto {@code RopaTallaDTO} asociado al código, o {@code null} si el producto no existe.
     */
    public abstract RopaTallaDTO encontrarProducto(String codigo);
}