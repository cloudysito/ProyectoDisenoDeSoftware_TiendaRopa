/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escanearproductosubsystem;

import BOs.RopaTallaBO;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.mycompany.dto_negocio.RopaDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;
import com.mycompany.dto_negocio.TallaDTO;
import com.mycompany.escanearproductosubsystem.Interfaz.IEscanearProducto;
import java.awt.image.BufferedImage;


/**
 * Implementación del patrón Fachada para el subsistema de Escaneo de Productos.
 * <p>
 * Esta clase actúa como el punto de entrada para las operaciones que involucran 
 * la lectura de códigos de barras (o QR) a partir de una imagen y la posterior 
 * consulta del inventario para identificar la prenda asociada. Utiliza la librería 
 * <b>ZXing</b> para el procesamiento de la imagen.
 * </p>
 *
 * @author santi
 * @version 1.0
 */
public class FachadaEscanearProducto implements IEscanearProducto {
    
    /**
     * Procesa una imagen que contiene un código de barras o QR y extrae su texto codificado.
     * <p>
     * Utiliza las clases de ZXing ({@code MultiFormatReader}, {@code HybridBinarizer}) 
     * para intentar decodificar la imagen.
     * </p>
     * * @param image La imagen {@code BufferedImage} capturada que contiene el código.
     * @return El texto (código) extraído de la imagen, o {@code null} si no se encontró un código válido.
     */
    @Override
    public String escanearCodigo(BufferedImage image) {
        try {
            // Convierte la imagen AWT a una fuente de luminancia entendible por ZXing
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            
            // Crea el mapa de bits binario
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            
            // Intenta decodificar el código de barras/QR
            Result result = new MultiFormatReader().decode(bitmap);
            
            return result.getText();
        } catch (NotFoundException e) {
            // Si no se detecta ningún código válido en la imagen, retorna null
            return null;
        }
    }

    /**
     * Busca en la capa de negocio un producto (RopaTalla) que coincida con el código de barras proporcionado.
     * <p>
     * Delega la búsqueda al Objeto de Negocio (BO) de {@code RopaTalla}.
     * </p>
     * * @param codigo El código de barras (texto) obtenido del escaneo.
     * @return El objeto {@code RopaTallaDTO} asociado al código, o {@code null} si no se encuentra en el inventario.
     */
    @Override
    public RopaTallaDTO encontrarProducto(String codigo) {
        // Asumiendo que RopaTallaBO.getInstance().buscarPorCodigo(codigo) maneja las excepciones internas de DAO.
        return RopaTallaBO.getInstance().buscarPorCodigo(codigo);
    }
}