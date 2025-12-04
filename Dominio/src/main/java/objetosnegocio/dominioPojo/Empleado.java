/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Representa a un empleado dentro del sistema, incluyendo información personal,
 * laboral, contacto, capacitación y horario asignado.
 */
public class Empleado {

    /** Identificador único del empleado. */
    private ObjectId id;

    /** Nombre del empleado. */
    private String nombre;

    /** Apellidos del empleado. */
    private String apellidos;

    /** Puesto o cargo del empleado. */
    private String puesto;

    /** URL de la imagen asociada al empleado. */
    private String urlImagen;

    /** Número telefónico del empleado. */
    private String telefono;

    /** Correo electrónico del empleado. */
    private String email;

    /** Contraseña utilizada para el inicio de sesión del empleado. */
    private String contrasenia;

    /** Información relacionada con la capacitación del empleado. */
    private Capacitacion capacitacion;

    /** Horario laboral asignado al empleado. */
    private Horario horario;

    /** Salario del empleado. */
    private int salario;

    /** Fecha de contratación del empleado. */
    private Date fechaContratacion;

    /** RFC del empleado. */
    private String rfc;

    /** Constructor vacío. */
    public Empleado() {}

    /**
     * Constructor para crear un empleado sin especificar id.
     *
     * @param nombre Nombre del empleado.
     * @param apellidos Apellidos del empleado.
     * @param puesto Puesto asignado.
     * @param telefono Teléfono del empleado.
     * @param email Correo electrónico.
     * @param salario Salario asignado.
     * @param fechaContratacion Fecha de contratación.
     * @param rfc RFC del empleado.
     * @param contrasenia Contraseña de acceso.
     */
    public Empleado(String nombre, String apellidos, String puesto, String telefono,
                    String email, int salario, Date fechaContratacion, String rfc, String contrasenia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.puesto = puesto;
        this.telefono = telefono;
        this.email = email;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.rfc = rfc;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructor para crear un empleado especificando id.
     *
     * @param id Identificador único.
     * @param nombre Nombre del empleado.
     * @param apellidos Apellidos del empleado.
     * @param puesto Puesto asignado.
     * @param telefono Teléfono del empleado.
     * @param email Correo electrónico.
     * @param salario Salario asignado.
     * @param fechaContratacion Fecha de contratación.
     * @param rfc RFC del empleado.
     * @param contrasenia Contraseña de acceso.
     */
    public Empleado(ObjectId id, String nombre, String apellidos, String puesto, String telefono,
                    String email, int salario, Date fechaContratacion, String rfc, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.puesto = puesto;
        this.telefono = telefono;
        this.email = email;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
        this.rfc = rfc;
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene la URL de la imagen del empleado.
     *
     * @return URL de la imagen.
     */
    public String getUrlImagen() {
        return urlImagen;
    }

    /**
     * Establece la URL de la imagen del empleado.
     *
     * @param urlImagen URL de la imagen.
     */
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    /**
     * Obtiene la capacitación del empleado.
     *
     * @return Objeto de tipo Capacitacion.
     */
    public Capacitacion getCapacitacion() {
        return capacitacion;
    }

    /**
     * Establece la capacitación del empleado.
     *
     * @param capacitacion Objeto de tipo Capacitacion.
     */
    public void setCapacitacion(Capacitacion capacitacion) {
        this.capacitacion = capacitacion;
    }

    /**
     * Obtiene el horario del empleado.
     *
     * @return Objeto Horario asignado.
     */
    public Horario getHorario() {
        return horario;
    }

    /**
     * Establece el horario del empleado.
     *
     * @param horario Objeto Horario.
     */
    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    /** @return Identificador del empleado. */
    public ObjectId getId() { return id; }

    /** @param id Identificador del empleado. */
    public void setId(ObjectId id) { this.id = id; }

    /** @return Nombre del empleado. */
    public String getNombre() { return nombre; }

    /** @param nombre Nombre del empleado. */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return Apellidos del empleado. */
    public String getApellidos() { return apellidos; }

    /** @param apellidos Apellidos del empleado. */
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    /** @return Puesto del empleado. */
    public String getPuesto() { return puesto; }

    /** @param puesto Puesto del empleado. */
    public void setPuesto(String puesto) { this.puesto = puesto; }

    /** @return Teléfono del empleado. */
    public String getTelefono() { return telefono; }

    /** @param telefono Teléfono del empleado. */
    public void setTelefono(String telefono) { this.telefono = telefono; }

    /** @return Correo del empleado. */
    public String getEmail() { return email; }

    /** @param email Correo del empleado. */
    public void setEmail(String email) { this.email = email; }

    /** @return Contraseña del empleado. */
    public String getContrasenia() { return contrasenia; }

    /** @param contrasenia Contraseña del empleado. */
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }

    /** @return Salario del empleado. */
    public int getSalario() { return salario; }

    /** @param salario Salario del empleado. */
    public void setSalario(int salario) { this.salario = salario; }

    /** @return Fecha de contratación. */
    public Date getFechaContratacion() { return fechaContratacion; }

    /** @param fechaContratacion Fecha de contratación. */
    public void setFechaContratacion(Date fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    /** @return RFC del empleado. */
    public String getRfc() { return rfc; }

    /** @param rfc RFC del empleado. */
    public void setRfc(String rfc) { this.rfc = rfc; }

    /**
     * Retorna el nombre completo del empleado.
     *
     * @return Nombre y apellidos como una cadena.
     */
    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
}

