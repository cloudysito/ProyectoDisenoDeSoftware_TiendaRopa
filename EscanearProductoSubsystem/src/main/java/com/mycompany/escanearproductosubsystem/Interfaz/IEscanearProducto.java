/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.escanearproductosubsystem.Interfaz;

import com.mycompany.dto_negocio.RopaTallaDTO;
import java.awt.image.BufferedImage;


/**
 *
 * @author santi
 */
public interface IEscanearProducto {
  
    public abstract String escanearCodigo(BufferedImage image);
    
    public abstract RopaTallaDTO encontrarProducto(String codigo);
}
