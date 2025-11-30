/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class Recompenza {
    private ObjectId id;
    private String nombreRecompenza;
    private int puntosNecesarios;
    
    public Recompenza() {}
    
    public Recompenza(String nombreRecompenza, int puntosNecesarios){
        this.nombreRecompenza = nombreRecompenza;
        this.puntosNecesarios = puntosNecesarios;
    }
    
    public Recompenza(ObjectId id, String nombreRecompenza, int puntosNecesarios){
        this.id = id;
        this.nombreRecompenza = nombreRecompenza;
        this.puntosNecesarios = puntosNecesarios;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreRecompenza() {
        return nombreRecompenza;
    }

    public void setNombreRecompenza(String nombreRecompenza) {
        this.nombreRecompenza = nombreRecompenza;
    }

    public int getPuntosNecesarios() {
        return puntosNecesarios;
    }

    public void setPuntosNecesarios(int puntosNecesarios) {
        this.puntosNecesarios = puntosNecesarios;
    }
    
}
