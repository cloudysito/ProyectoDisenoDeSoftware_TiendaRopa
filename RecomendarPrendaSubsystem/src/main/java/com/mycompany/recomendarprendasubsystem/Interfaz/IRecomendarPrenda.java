/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.recomendarprendasubsystem.Interfaz;

import com.mycompany.dto_negocio.BuscarPrendaDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;

/**
 *
 * @author santi
 */
public interface IRecomendarPrenda {
    RopaTallaDTO recomentarPrenda(BuscarPrendaDTO busqueda);
}
