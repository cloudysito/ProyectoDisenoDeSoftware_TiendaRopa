/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escanearproductosubsystem;

import com.mycompany.escanearproductosubsystem.Interfaz.IEscanearProducto;
import com.mycompany.objetosnegocio.dominio.Ropa;
import com.mycompany.objetosnegocio.dominio.RopaTalla;
import com.mycompany.objetosnegocio.dominio.Talla;
import com.mycompany.objetosnegocio.dto.ProductoDTO;

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
    public RopaTalla encontrarProducto(String codigo) {
        Ropa prenda = new Ropa("Playera wow", "una muy buena playeraaaa", "Verano", "santi", "tela", 235.00);
        Talla talla = new  Talla("M","una talla mediana");
        return new RopaTalla(prenda, talla, codigo, 10);
    }
}
