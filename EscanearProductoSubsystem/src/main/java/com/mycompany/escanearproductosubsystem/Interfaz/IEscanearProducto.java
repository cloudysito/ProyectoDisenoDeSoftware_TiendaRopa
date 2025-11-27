/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.escanearproductosubsystem.Interfaz;

import com.mycompany.dto_negocio.RopaTallaDTO;


/**
 *
 * @author santi
 */
public interface IEscanearProducto {
  
    public abstract String escanearCodigo();
    
    public abstract RopaTallaDTO encontrarProducto(String codigo);
}
