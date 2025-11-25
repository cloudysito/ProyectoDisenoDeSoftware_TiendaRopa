/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import java.io.Serializable;

public class TallaPOJO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String nombreTalla;
    private String descripcion;

    public TallaPOJO() {}

    public TallaPOJO(String nombreTalla, String descripcion) {
        this.nombreTalla = nombreTalla;
        this.descripcion = descripcion;
    }
    
    public TallaPOJO(String id, String nombreTalla, String descripcion) {
        this.id = id;
        this.nombreTalla = nombreTalla;
        this.descripcion = descripcion;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombreTalla() { return nombreTalla; }
    public void setNombreTalla(String nombreTalla) { this.nombreTalla = nombreTalla; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() { return nombreTalla; }
}