/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.calculartallasubsystem.Interfaz;

/**
 *
 * @author santi
 */
public interface ICalcularTalla {
    String CalcularTalla(double pecho, double cintura, double cadera, String genero);
    
    String ValidarDatos(double pecho, double cintura, double cadera, String genero);
}
