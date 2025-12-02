/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GenerarCodigo.Fachada;

import GenerarCodigo.Implementaciones.GeneradorCodigoBarras;
import GenerarCodigo.Interfaz.IGeneradorCodigoBarras;
import java.awt.image.BufferedImage;

/**
 *
 * @author garfi
 */
public class FachadaGeneradorCodigoBarras implements IGeneradorCodigoBarras {

    private final GeneradorCodigoBarras generador;

    public FachadaGeneradorCodigoBarras() {
        this.generador = new GeneradorCodigoBarras();
    }

    @Override
    public String generarCodigoBarras() {
        return generador.generarCodigoBarras();
    }

    @Override
    public BufferedImage generarImagenCodigo(String textoCodigo) throws Exception {
        try {
            return generador.generarImagenCodigo(textoCodigo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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
