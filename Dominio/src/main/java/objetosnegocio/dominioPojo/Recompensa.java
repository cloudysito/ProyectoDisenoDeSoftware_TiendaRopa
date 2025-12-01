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
public class Recompensa {
    private ObjectId idRecompensa;
    private String nombreRecompensa;
    private int puntosNecesarios;
    
    public Recompensa() {}
    
    public Recompensa(String nombreRecompenza, int puntosNecesarios){
        this.nombreRecompensa = nombreRecompenza;
        this.puntosNecesarios = puntosNecesarios;
    }
    
    public Recompensa(ObjectId idRecompensa, String nombreRecompensa, int puntosNecesarios){
        this.idRecompensa = idRecompensa;
        this.nombreRecompensa = nombreRecompensa;
        this.puntosNecesarios = puntosNecesarios;
    }

    public ObjectId getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(ObjectId idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    public String getNombreRecompensa() {
        return nombreRecompensa;
    }

    public void setNombreRecompensa(String nombreRecompensa) {
        this.nombreRecompensa = nombreRecompensa;
    }

    public int getPuntosNecesarios() {
        return puntosNecesarios;
    }

    public void setPuntosNecesarios(int puntosNecesarios) {
        this.puntosNecesarios = puntosNecesarios;
    }
    
}
