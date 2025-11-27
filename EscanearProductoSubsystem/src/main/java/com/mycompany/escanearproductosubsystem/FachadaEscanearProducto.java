/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escanearproductosubsystem;

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
 *
 * @author santi
 */
public class FachadaEscanearProducto implements IEscanearProducto {
    @Override
    public String escanearCodigo(BufferedImage image) {try {
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException e) {
            return null;
        }
    }

    @Override
    public RopaTallaDTO encontrarProducto(String codigo) {
        RopaDTO prenda = new RopaDTO("Playera wow", 235.00, "una muy buena playeraaaa", "Verano", "santi", "tela");
        TallaDTO talla = new  TallaDTO("M","una talla mediana");
        return new RopaTallaDTO(prenda, talla, codigo, 10);
    }
}
