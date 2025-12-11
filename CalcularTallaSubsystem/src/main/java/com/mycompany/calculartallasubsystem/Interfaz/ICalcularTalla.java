/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.calculartallasubsystem.Interfaz;

/**
 * Interfaz que define el contrato para el subsistema de Cálculo de Tallas.
 * <p>
 * Establece los métodos esenciales para la validación de medidas corporales 
 * y la determinación algorítmica de la talla de ropa más adecuada (ej. XS, M, L).
 * </p>
 *
 * @author c
 * @version 1.0
 */
public interface ICalcularTalla {
    
    /**
     * Ejecuta el algoritmo principal para determinar la talla de ropa (ej. XS, M, XL) 
     * basándose en las medidas antropométricas y el género.
     * <p>
     * Se espera que esta implementación utilice rangos predefinidos y un sistema de votación
     * para encontrar la talla más probable.
     * </p>
     * * @param pecho Medida del pecho o busto en centímetros.
     * @param cintura Medida de la cintura en centímetros.
     * @param cadera Medida de la cadera en centímetros.
     * @param genero Género del cliente ("MASCULINO", "FEMENINO", etc.).
     * @return La talla resultante como una cadena (String).
     */
    String CalcularTalla(double pecho, double cintura, double cadera, String genero);
    
    /**
     * Realiza validaciones preliminares sobre los datos de entrada antes de proceder con el cálculo.
     * <p>
     * Típicamente verifica que los valores sean positivos o que el campo de género no esté vacío.
     * Si los datos pasan las validaciones (o si la validación es nula), llama a {@code CalcularTalla}.
     * </p>
     * * @param pecho Medida del pecho o busto.
     * @param cintura Medida de la cintura.
     * @param cadera Medida de la cadera.
     * @param genero Género del cliente.
     * @return La talla resultante del proceso de cálculo.
     */
    String ValidarDatos(double pecho, double cintura, double cadera, String genero);
}