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
/**
 * Representa a un empleado dentro del sistema, incluyendo su información
 * personal, laboral, de contacto, capacitación y horario.
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

    /**
     * Constructor vacío de EmpleadoDTO.
     */
    public EmpleadoDTO() {}

    /**
     * Constructor completo con ID.
     *
     * @param idEmpleado identificador del empleado
     * @param nombre nombre del empleado
     * @param apellidos apellidos del empleado
     * @param puesto puesto o cargo asignado
     * @param telefono número telefónico
     * @param contrasenia contraseña de acceso
     * @param email correo electrónico
     * @param salario salario asignado
     * @param fechaContratacion fecha en que fue contratado
     * @param rfc RFC del empleado
     */
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

    /**
     * Constructor sin ID.
     *
     * @param nombre nombre del empleado
     * @param apellidos apellidos del empleado
     * @param puesto puesto del empleado
     * @param telefono teléfono del empleado
     * @param contrasenia contraseña de acceso
     * @param email correo electrónico
     * @param salario salario asignado
     * @param fechaContratacion fecha de contratación
     * @param rfc RFC del empleado
     */
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

    /**
     * Obtiene el horario asignado al empleado.
     *
     * @return el horario del empleado
     */
    public HorarioDTO getHorario() {
        return horario;
    }

    /**
     * Establece el horario asignado.
     *
     * @param horario el horario del empleado
     */
    public void setHorario(HorarioDTO horario) {
        this.horario = horario;
    }

    /**
     * Obtiene la capacitación del empleado.
     *
     * @return la capacitación del empleado
     */
    public CapacitacionDTO getCapacitacion() {
        return capacitacion;
    }

    /**
     * Establece la capacitación asociada.
     *
     * @param capacitacion la capacitación del empleado
     */
    public void setCapacitacion(CapacitacionDTO capacitacion) {
        this.capacitacion = capacitacion;
    }

    /**
     * Obtiene la URL de la imagen del empleado.
     *
     * @return URL de imagen
     */
    public String getUrlImagen() {
        return urlImagen;
    }

    /**
     * Establece la URL de la imagen del empleado.
     *
     * @param urlImagen URL de imagen
     */
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    /**
     * Obtiene el ID del empleado.
     *
     * @return id del empleado
     */
    public String getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * Establece el id del empleado.
     *
     * @param idEmpleado identificador único
     */
    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre nombre del empleado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del empleado.
     *
     * @return apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del empleado.
     *
     * @param apellidos apellidos del empleado
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el puesto ocupado por el empleado.
     *
     * @return puesto
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Establece el puesto del empleado.
     *
     * @param puesto puesto del empleado
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * Obtiene el teléfono del empleado.
     *
     * @return teléfono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número telefónico del empleado.
     *
     * @param telefono teléfono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la contraseña del empleado.
     *
     * @return contraseña
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del empleado.
     *
     * @param contrasenia contraseña nueva
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el correo electrónico del empleado.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del empleado.
     *
     * @param email correo electrónico
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el salario asignado.
     *
     * @return salario
     */
    public int getSalario() {
        return salario;
    }

    /**
     * Establece el salario asignado al empleado.
     *
     * @param salario salario
     */
    public void setSalario(int salario) {
        this.salario = salario;
    }

    /**
     * Obtiene la fecha de contratación.
     *
     * @return fecha de contratación
     */
    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    /**
     * Establece la fecha de contratación.
     *
     * @param fechaContratacion fecha de entrada
     */
    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    /**
     * Obtiene el RFC del empleado.
     *
     * @return RFC
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC del empleado.
     *
     * @param rfc RFC del empleado
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    
}

