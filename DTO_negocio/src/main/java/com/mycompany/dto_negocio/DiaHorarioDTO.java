/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *
 * @author santi
 */
public class DiaHorarioDTO {
    
    private String id;
    private DayOfWeek dia;         // LUNES, MARTES, etc.
    private LocalTime horaEntrada; // Formato HH:mm
    private LocalTime horaSalida;  // Formato HH:mm

    public DiaHorarioDTO() {
    }

    public DiaHorarioDTO(String id, DayOfWeek dia, LocalTime horaEntrada, LocalTime horaSalida) {
        this.id = id;
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    

    public DayOfWeek getDia() {
        return dia;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }
}
