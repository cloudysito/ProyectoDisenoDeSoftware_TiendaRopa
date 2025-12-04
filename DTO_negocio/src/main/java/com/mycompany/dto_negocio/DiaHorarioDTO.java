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
/**
 * Representa el horario de un día específico, incluyendo día de la semana,
 * hora de entrada y hora de salida.
 */
public class DiaHorarioDTO {

    private String id;
    private DayOfWeek dia;         // LUNES, MARTES, etc.
    private LocalTime horaEntrada; // Formato HH:mm
    private LocalTime horaSalida;  // Formato HH:mm

    /**
     * Constructor vacío para DiaHorarioDTO.
     */
    public DiaHorarioDTO() {
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param id          identificador del registro
     * @param dia         día de la semana
     * @param horaEntrada hora de entrada
     * @param horaSalida  hora de salida
     */
    public DiaHorarioDTO(String id, DayOfWeek dia, LocalTime horaEntrada, LocalTime horaSalida) {
        this.id = id;
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    /**
     * Constructor sin ID.
     *
     * @param dia         día de la semana
     * @param horaEntrada hora de entrada
     * @param horaSalida  hora de salida
     */
    public DiaHorarioDTO(DayOfWeek dia, LocalTime horaEntrada, LocalTime horaSalida) {
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    /**
     * Obtiene el día de la semana.
     *
     * @return el día
     */
    public DayOfWeek getDia() {
        return dia;
    }

    /**
     * Obtiene la hora de entrada.
     *
     * @return hora de entrada
     */
    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * Obtiene la hora de salida.
     *
     * @return hora de salida
     */
    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    /**
     * Obtiene el identificador del horario.
     *
     * @return id del horario
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador.
     *
     * @param id identificador del día-horario
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Establece el día de la semana.
     *
     * @param dia nuevo día
     */
    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }

    /**
     * Establece la hora de entrada.
     *
     * @param horaEntrada nueva hora de entrada
     */
    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * Establece la hora de salida.
     *
     * @param horaSalida nueva hora de salida
     */
    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }
}
