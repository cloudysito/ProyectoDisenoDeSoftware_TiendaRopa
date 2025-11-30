/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class HorarioDTO {
    
        
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private List<DiaHorarioDTO> dias = new ArrayList<>();

    public HorarioDTO() {
    }

    public void agregarDia(DiaHorarioDTO diaHorario) {
        dias.add(diaHorario);
    }

    public List<DiaHorarioDTO> getDias() {
        return dias;
    }

    public void setDias(List<DiaHorarioDTO> dias) {
        this.dias = dias;
    }

    

}
