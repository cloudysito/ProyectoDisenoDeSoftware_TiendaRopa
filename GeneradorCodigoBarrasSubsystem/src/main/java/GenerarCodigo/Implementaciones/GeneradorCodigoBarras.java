/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GenerarCodigo.Implementaciones;

import GenerarCodigo.Interfaz.IGeneradorCodigoBarras;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 * Clase de implementación técnica para la generación de códigos de barras.
 * <p>
 * Esta clase utiliza la librería externa <b>ZXing (Zebra Crossing)</b> para crear 
 * matrices de bits que representan códigos de barras en formato CODE_128.
 * Se encarga de la lógica matemática de codificación y de la conversión a imágenes Java (BufferedImage).
 * </p>
 *
 * @author garfi
 * @version 1.0
 */
public class GeneradorCodigoBarras {

    /**
     * Genera una cadena numérica aleatoria de 12 dígitos.
     * <p>
     * Utiliza la clase {@code Random} para generar un número grande y lo formatea
     * para asegurar que siempre tenga 12 dígitos, rellenando con ceros a la izquierda si es necesario.
     * Este string sirve como el valor crudo que luego será codificado visualmente.
     * </p>
     *
     * @return Una cadena {@code String} con 12 dígitos numéricos.
     */
    public String generarCodigoBarras() {
        // Genera un código de 12 dígitos al azar
        Random r = new Random();
        long numero = (long) (r.nextDouble() * 1000000000000L);
        return String.format("%012d", numero);
    }

    /**
     * Convierte una cadena de texto en una imagen de código de barras.
     * <p>
     * Utiliza {@code Code128Writer} de ZXing para codificar el texto en una matriz de bits (BitMatrix)
     * de 200x80 píxeles. Luego, convierte esa matriz en un objeto {@code BufferedImage}
     * que puede ser manipulado por Java (mostrar en pantalla o guardar).
     * </p>
     *
     * @param textoCodigo El texto o números a codificar.
     * @return Un objeto {@code BufferedImage} conteniendo el gráfico del código de barras.
     * @throws Exception Si ocurre un error al codificar el texto (ej. caracteres no soportados por CODE_128).
     */
    public BufferedImage generarImagenCodigo(String textoCodigo) throws Exception {
        Code128Writer writer = new Code128Writer();
        //Crea matriz de bits con dimensiones 200x80
        BitMatrix bitMatrix = writer.encode(textoCodigo, BarcodeFormat.CODE_128, 200, 80);
        //Convierte a imagen Java
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    /**
     * Guarda un objeto de imagen en el disco duro como archivo PNG.
     * <p>
     * Verifica si la carpeta de destino existe; si no, la crea. El archivo se nombra
     * utilizando el código generado (ej. "123456789012.png").
     * </p>
     *
     * @param imagen La imagen {@code BufferedImage} generada previamente.
     * @param codigo El código alfanumérico que servirá como nombre del archivo.
     * @param rutaCarpeta La ruta del directorio donde se guardará el archivo.
     * @throws IOException Si hay problemas de permisos o acceso al sistema de archivos.
     */
    public void guardarImagen(BufferedImage imagen, String codigo, String rutaCarpeta) throws IOException {
        //Se asegura de que la carpeta existe
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        String nombreArchivo = codigo + ".png";
        File archivoSalida = new File(carpeta, nombreArchivo);
        //Escribe la imagen en formato PNG
        ImageIO.write(imagen, "png", archivoSalida);

        System.out.println("Imagen guardada en: " + archivoSalida.getAbsolutePath());
    }

}