/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escanearproductosubsystem;

import Interfaz.IEscanearProducto;
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
    public ProductoDTO encontrarProducto(String codigo) {
        return new ProductoDTO(1, "Playera básica", "M", 10);
    }
}
