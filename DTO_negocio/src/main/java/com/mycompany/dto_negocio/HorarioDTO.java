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
/**
 * Representa un horario compuesto por varios días y sus respectivos intervalos.
 */
public class HorarioDTO {

    private String id;
    private List<DiaHorarioDTO> dias = new ArrayList<>();

    /**
     * Constructor vacío para HorarioDTO.
     */
    public HorarioDTO() {
    }

    /**
     * Obtiene el identificador del horario.
     *
     * @return el id del horario
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del horario.
     *
     * @param id el id del horario
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Agrega un día al horario.
     *
     * @param diaHorario el día con su horario correspondiente
     */
    public void agregarDia(DiaHorarioDTO diaHorario) {
        dias.add(diaHorario);
    }

    /**
     * Obtiene la lista de días del horario.
     *
     * @return la lista de días
     */
    public List<DiaHorarioDTO> getDias() {
        return dias;
    }

    /**
     * Establece la lista de días del horario.
     *
     * @param dias la lista de días
     */
    public void setDias(List<DiaHorarioDTO> dias) {
        this.dias = dias;
    }

}
