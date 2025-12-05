/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GenerarCodigo.Fachada;

import GenerarCodigo.Implementaciones.GeneradorCodigoBarras;
import GenerarCodigo.Interfaz.IGeneradorCodigoBarras;
import java.awt.image.BufferedImage;

/**
 * Implementación del patrón Fachada (Facade) para el subsistema de Generación de Códigos de Barras.
 * <p>
 * Esta clase actúa como intermediario simplificado entre los controladores y la lógica compleja 
 * de generación de imágenes de códigos de barras (clase {@code GeneradorCodigoBarras}). 
 * Se encarga de gestionar la creación de cadenas de códigos y la persistencia de imágenes en disco.
 * </p>
 *
 * @author garfi
 * @version 1.0
 */
public class FachadaGeneradorCodigoBarras implements IGeneradorCodigoBarras {

    /** Instancia de la implementación concreta que realiza la generación de imágenes. */
    private final GeneradorCodigoBarras generador;

    /**
     * Constructor de la fachada.
     * Inicializa el generador interno que se encargará del procesamiento de imágenes.
     */
    public FachadaGeneradorCodigoBarras() {
        this.generador = new GeneradorCodigoBarras();
    }

    /**
     * Genera una cadena de texto que representa un código de barras.
     * <p>
     * Este método no genera la imagen visual, sino el valor alfanumérico o numérico único
     * (por ejemplo, un UUID o un número aleatorio de 12 dígitos) que se usará para identificar el producto.
     * </p>
     *
     * @return Una cadena {@code String} con el código generado.
     */
    @Override
    public String generarCodigoBarras() {
        return generador.generarCodigoBarras();
    }

    /**
     * Genera la representación visual (imagen) de un código de barras en memoria.
     * <p>
     * Este método es útil para previsualizar el código en la interfaz gráfica (GUI) antes de guardarlo.
     * </p>
     *
     * @param textoCodigo El texto o número que se codificará en las barras (ej. "123456789").
     * @return Un objeto {@code BufferedImage} listo para ser mostrado en un JLabel o panel, 
     * o {@code null} si ocurre un error durante la generación.
     * @throws Exception Aunque se define en la firma, las excepciones son capturadas internamente y se retorna null.
     */
    @Override
    public BufferedImage generarImagenCodigo(String textoCodigo) throws Exception {
        try {
            return generador.generarImagenCodigo(textoCodigo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Coordina la generación y el guardado de la imagen del código de barras en el disco.
     * <p>
     * Este método realiza dos pasos:
     * 1. Genera la imagen en memoria usando el código proporcionado.
     * 2. Escribe esa imagen en la ruta del sistema de archivos especificada.
     * </p>
     *
     * @param codigo El valor del código de barras a generar.
     * @param rutaCarpeta La ruta del directorio donde se guardará el archivo de imagen (generalmente en formato PNG o JPG).
     * @return {@code true} si la imagen se generó y guardó correctamente; {@code false} si hubo algún error.
     */
    @Override
    public boolean guardarCodigoEnRuta(String codigo, String rutaCarpeta) {
        try {
            //Genera la imagen en la memoria
            BufferedImage imagen = generador.generarImagenCodigo(codigo);

            //La guarda en el disco
            generador.guardarImagen(imagen, codigo, rutaCarpeta);
            return true;

        } catch (Exception e) {
            System.err.println("Error al guardar código de barras: " + e.getMessage());
            return false;
        }
    }

}