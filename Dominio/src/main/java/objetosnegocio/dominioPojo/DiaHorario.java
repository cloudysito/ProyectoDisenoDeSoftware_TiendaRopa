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
public class DiaHorario {
    
    private ObjectId id;
    private DayOfWeek dia;         // LUNES, MARTES, etc.
    private LocalTime horaEntrada; // Formato HH:mm
    private LocalTime horaSalida;  // Formato HH:mm

    public DiaHorario() {
    }

    public DiaHorario(ObjectId id, DayOfWeek dia, LocalTime horaEntrada, LocalTime horaSalida) {
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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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
