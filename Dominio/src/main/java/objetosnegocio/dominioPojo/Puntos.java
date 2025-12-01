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
public class Puntos {
    private ObjectId idPuntos;
    private Ropa nombreArticulo;
    private int puntosIndividuales;
    
    public Puntos() {}
    
    public Puntos(Ropa nombreArticulo, int puntosIndividuales){
        this.nombreArticulo = nombreArticulo;
        this.puntosIndividuales = puntosIndividuales;
    }
    
    public Puntos(ObjectId idPuntos, Ropa nombreArticulo, int puntosIndividuales){
        this.idPuntos = idPuntos;
        this.nombreArticulo = nombreArticulo;
        this.puntosIndividuales = puntosIndividuales;
    }

    public ObjectId getIdPuntos() {
        return idPuntos;
    }

    public void setIdPuntos(ObjectId idPuntos) {
        this.idPuntos = idPuntos;
    }

    public Ropa getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(Ropa nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getPuntosIndividuales() {
        return puntosIndividuales;
    }

    public void setPuntosIndividuales(int puntosIndividuales) {
        this.puntosIndividuales = puntosIndividuales;
    }
    
}
