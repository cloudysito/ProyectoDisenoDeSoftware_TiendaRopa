/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guiainteractivasubsystem;

import BOs.CapacitacionBO;
import com.mycompany.dto_negocio.CapacitacionDTO;

/**
 *
 * @author riosr
 */
public class FachadaGuiaInteractiva {
    public CapacitacionDTO modificarEstado(CapacitacionDTO capacitacion){
        
        return CapacitacionBO.getInstance().modificarCapacitacion(capacitacion);
    }
}
