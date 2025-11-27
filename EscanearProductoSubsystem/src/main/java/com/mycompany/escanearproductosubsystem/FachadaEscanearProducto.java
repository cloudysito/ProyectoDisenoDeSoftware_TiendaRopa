/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escanearproductosubsystem;

import com.mycompany.dto_negocio.RopaDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;
import com.mycompany.dto_negocio.TallaDTO;
import com.mycompany.escanearproductosubsystem.Interfaz.IEscanearProducto;


/**
 *
 * @author santi
 */
public class FachadaEscanearProducto implements IEscanearProducto {
    @Override
    public String escanearCodigo() {
        return "COD123456";
    }

    @Override
    public RopaTallaDTO encontrarProducto(String codigo) {
        RopaDTO prenda = new RopaDTO("Playera wow", 235.00, "una muy buena playeraaaa", "Verano", "santi", "tela");
        TallaDTO talla = new  TallaDTO("M","una talla mediana");
        return new RopaTallaDTO(prenda, talla, codigo, 10);
    }
}
