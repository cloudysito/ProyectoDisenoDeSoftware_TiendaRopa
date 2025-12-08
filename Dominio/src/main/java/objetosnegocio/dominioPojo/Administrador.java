/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import org.bson.types.ObjectId;

/**
 *
 * @author santi
 */
public class Administrador {
     /** Identificador único de la bonificación. */
    private ObjectId id;
    
    /** Nombre del Administrador. */
    private String nombre;
    
    /** Contraseña utilizada para el inicio de sesión del Administrador. */
    private String contrasenia;

    public Administrador(ObjectId idBonificacion, String nombre, String contrasenia) {
        this.id = idBonificacion;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public Administrador() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    
    
}
