/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import java.time.DayOfWeek;
import java.time.LocalTime;
import org.bson.types.ObjectId;

/**
 *
 * @author santi
 */
/**
 * Representa el horario de un día específico, incluyendo el día de la semana,
 * la hora de entrada y la hora de salida.
 */
public class DiaHorario {

    /** Identificador único del registro de horario por día. */
    private ObjectId id;

    /** Día de la semana (LUNES, MARTES, etc.). */
    private DayOfWeek dia;

    /** Hora de entrada en formato HH:mm. */
    private LocalTime horaEntrada;

    /** Hora de salida en formato HH:mm. */
    private LocalTime horaSalida;

    /** Constructor vacío. */
    public DiaHorario() {
    }

    /**
     * Constructor que inicializa todos los atributos del día de horario.
     *
     * @param id Identificador único.
     * @param dia Día de la semana.
     * @param horaEntrada Hora de entrada.
     * @param horaSalida Hora de salida.
     */
    public DiaHorario(ObjectId id, DayOfWeek dia, LocalTime horaEntrada, LocalTime horaSalida) {
        this.id = id;
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    /**
     * Obtiene el día de la semana.
     *
     * @return Día en formato DayOfWeek.
     */
    public DayOfWeek getDia() {
        return dia;
    }

    /**
     * Obtiene la hora de entrada.
     *
     * @return Hora de entrada.
     */
    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * Obtiene la hora de salida.
     *
     * @return Hora de salida.
     */
    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    /**
     * Obtiene el identificador del registro.
     *
     * @return Identificador ObjectId.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el identificador del registro.
     *
     * @param id Identificador ObjectId.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Establece el día de la semana.
     *
     * @param dia Día de la semana.
     */
    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }

    /**
     * Establece la hora de entrada.
     *
     * @param horaEntrada Hora de entrada.
     */
    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * Establece la hora de salida.
     *
     * @param horaSalida Hora de salida.
     */
    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }
}
