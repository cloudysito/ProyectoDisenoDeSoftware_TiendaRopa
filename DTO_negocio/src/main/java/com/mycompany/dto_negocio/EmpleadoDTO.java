/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dto_negocio;

import java.util.Date;

/**
 *
 * @author santi
 */
public class EmpleadoDTO {
    private String idEmpleado;
    private String nombre;
    private String apellidos;
    private String urlImagen;
    private String puesto;
    private String telefono;
    private String contrasenia;
    private HorarioDTO horario;
    private CapacitacionDTO capacitacion;
    private String email;
    private int salario;
    private Date fechaContratacion;
    private String rfc;

    public EmpleadoDTO() {}

    public EmpleadoDTO(String idEmpleado, String nombre, String apellidos, String puesto, String telefono, String contrasenia, String email, int salario, Date fechaContratacion, String rfc) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.puesto = puesto;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.email = email;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.rfc = rfc;
    }

    public EmpleadoDTO(String nombre, String apellidos, String puesto, String telefono, String contrasenia, String email, int salario, Date fechaContratacion, String rfc) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.puesto = puesto;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.email = email;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.rfc = rfc;
    }

    public HorarioDTO getHorario() {
        return horario;
    }

    public void setHorario(HorarioDTO horario) {
        this.horario = horario;
    }

    public CapacitacionDTO getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(CapacitacionDTO capacitacion) {
        this.capacitacion = capacitacion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    
    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    
}

