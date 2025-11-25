/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objetosnegocio.dto;

/**
 *
 * @author santi
 */
public class EmpleadoDTO {
    private int idEmpleado;
    private String nombreCompleto;
    private String puesto;
    private String email;

    public EmpleadoDTO() {}

    public EmpleadoDTO(int idEmpleado, String nombreCompleto, String puesto, String email) {
        this.idEmpleado = idEmpleado;
        this.nombreCompleto = nombreCompleto;
        this.puesto = puesto;
        this.email = email;
    }

    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

