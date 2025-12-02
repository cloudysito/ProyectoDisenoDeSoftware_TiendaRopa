/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author santi
 */
public class Sugerencia {
    private ObjectId id;
    private Empleado empleado;
    private String descripcion;
    private String estado;
    private Date fechaPublicacion;

    public Sugerencia(ObjectId id, Empleado empleado, String descripcion, String estado, Date fechaPublicacion) {
        this.id = id;
        this.empleado = empleado;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Sugerencia() {
    }

    public Sugerencia(Empleado empleado, String descripcion, String estado, Date fechaPublicacion) {
        this.empleado = empleado;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
    
}
