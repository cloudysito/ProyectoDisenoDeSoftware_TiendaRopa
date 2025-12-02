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
 *
 * @author garfi
 */
public class GeneradorCodigoBarras {

    public String generarCodigoBarras() {
        // Genera un código de 12 dígitos al azar
        Random r = new Random();
        long numero = (long) (r.nextDouble() * 1000000000000L);
        return String.format("%012d", numero);
    }

    public BufferedImage generarImagenCodigo(String textoCodigo) throws Exception {
        Code128Writer writer = new Code128Writer();
        //Crea matriz de bits
        BitMatrix bitMatrix = writer.encode(textoCodigo, BarcodeFormat.CODE_128, 200, 80);
        //Convierte a imagen Java
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    public void guardarImagen(BufferedImage imagen, String codigo, String rutaCarpeta) throws IOException {
        //Se asegura de que la carpeta existe
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        String nombreArchivo = codigo + ".png";
        File archivoSalida = new File(carpeta, nombreArchivo);
        //Escribe la imagen
        ImageIO.write(imagen, "png", archivoSalida);

        System.out.println("Imagen guardada en: " + archivoSalida.getAbsolutePath());
    }

}
