/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GenerarCodigo.Interfaz;

import java.awt.image.BufferedImage;

/**
 *
 * @author garfi
 */
public interface IGeneradorCodigoBarras {
    
    public String generarCodigoBarras();
    
    public BufferedImage generarImagenCodigo(String textoCodigo) throws Exception;
    
    public boolean guardarCodigoEnRuta(String codigo, String rutaCarpeta);
    
}
