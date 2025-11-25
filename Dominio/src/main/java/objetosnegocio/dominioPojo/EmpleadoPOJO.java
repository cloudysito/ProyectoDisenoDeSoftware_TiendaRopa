/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import java.io.Serializable;
import java.util.Date;

public class EmpleadoPOJO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String id;
    private String nombre;
    private String apellidos;
    private String puesto;
    private String telefono;
    private String email;
    private String contrasenia;
    private int salario;
    private Date fechaContratacion;
    private String rfc;

    public EmpleadoPOJO() {}
    
    public EmpleadoPOJO(String nombre, String apellidos, String puesto, String telefono, 
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

    public EmpleadoPOJO(String id, String nombre, String apellidos, String puesto, String telefono, 
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

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }
    public int getSalario() { return salario; }
    public void setSalario(int salario) { this.salario = salario; }
    public Date getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(Date fechaContratacion) { this.fechaContratacion = fechaContratacion; }
    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }

    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
}

