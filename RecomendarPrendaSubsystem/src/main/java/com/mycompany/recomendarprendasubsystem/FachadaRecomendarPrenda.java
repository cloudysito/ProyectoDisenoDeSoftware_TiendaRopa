/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.recomendarprendasubsystem;

import BOs.RopaTallaBO;
import com.mycompany.dto_negocio.BuscarPrendaDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;
import com.mycompany.recomendarprendasubsystem.Interfaz.IRecomendarPrenda;

/**
 *
 * @author santi
 */
public class FachadaRecomendarPrenda implements IRecomendarPrenda {

    @Override
    public RopaTallaDTO recomentarPrenda(BuscarPrendaDTO busqueda) {
        return RopaTallaBO.getInstance().buscarPorFiltro(busqueda);
    }
    
}
