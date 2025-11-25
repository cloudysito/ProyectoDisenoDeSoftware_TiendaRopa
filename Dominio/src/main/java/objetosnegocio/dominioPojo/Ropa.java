/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio.dominioPojo;

import org.bson.types.ObjectId;

public class Ropa {

    private ObjectId id;
    private String nombreArticulo;
    private double precio;
    private String descripcion;
    private String temporada;
    private String marca;
    private String material;

    public Ropa() {}

    public Ropa(String nombreArticulo, String descripcion, String temporada, String marca, String material, double precio) {
        this.nombreArticulo = nombreArticulo;
        this.descripcion = descripcion;
        this.temporada = temporada;
        this.marca = marca;
        this.material = material;
        this.precio = precio;
    }
    
    public Ropa(ObjectId id, String nombreArticulo, String descripcion, String temporada, String marca, String material, double precio) {
        this.id = id;
        this.nombreArticulo = nombreArticulo;
        this.descripcion = descripcion;
        this.temporada = temporada;
        this.marca = marca;
        this.material = material;
        this.precio = precio;
    }

    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }
    public String getNombreArticulo() { return nombreArticulo; }
    public void setNombreArticulo(String nombreArticulo) { this.nombreArticulo = nombreArticulo; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getTemporada() { return temporada; }
    public void setTemporada(String temporada) { this.temporada = temporada; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    @Override
    public String toString() { return nombreArticulo; }
}