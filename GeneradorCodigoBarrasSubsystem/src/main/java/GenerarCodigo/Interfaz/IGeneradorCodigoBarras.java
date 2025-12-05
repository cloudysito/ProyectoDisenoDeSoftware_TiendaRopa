/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GenerarCodigo.Interfaz;

import java.awt.image.BufferedImage;

/**
 * Interfaz que define el contrato para el subsistema de Generación de Códigos de Barras.
 * <p>
 * Esta interfaz establece las operaciones fundamentales para trabajar con códigos de barras,
 * permitiendo desacoplar la lógica de la aplicación de la librería específica de generación de imágenes (ZXing, Barbecue, etc.).
 * </p>
 * * @author garfi
 * @version 1.0
 */
public interface IGeneradorCodigoBarras {

    /**
     * Genera una nueva cadena de texto o numérica que servirá como identificador del código de barras.
     * <p>
     * Este método se encarga solo de crear el valor (ej. "123456789012"), no la imagen visual.
     * </p>
     * * @return Una cadena {@code String} con el código generado (generalmente aleatorio o secuencial).
     */
    public String generarCodigoBarras();

    /**
     * Crea la representación visual (imagen) de un código de barras en memoria.
     * <p>
     * Es útil para mostrar el código en la pantalla (GUIs) sin necesidad de guardarlo primero en el disco.
     * </p>
     * * @param textoCodigo El texto o número que se va a codificar en las barras.
     * @return Un objeto {@code BufferedImage} con el gráfico del código generado.
     * @throws Exception Si ocurre un error durante la codificación o creación de la imagen.
     */
    public BufferedImage generarImagenCodigo(String textoCodigo) throws Exception;

    /**
     * Genera la imagen del código de barras y la guarda directamente en el sistema de archivos.
     * * @param codigo El texto o número que se codificará.
     * @param rutaCarpeta La ruta del directorio donde se debe guardar el archivo de imagen resultante.
     * @return {@code true} si la imagen se generó y guardó exitosamente; {@code false} si hubo un error.
     */
    public boolean guardarCodigoEnRuta(String codigo, String rutaCarpeta);

}