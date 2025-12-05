/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculartallasubsystem;

import com.mycompany.calculartallasubsystem.Interfaz.ICalcularTalla;

/**
 * Implementación del patrón Fachada para el subsistema de Cálculo de Tallas.
 * <p>
 * Centraliza la lógica algorítmica para determinar la talla de ropa más adecuada 
 * (XS a XXL) basándose en las medidas de pecho, cintura y cadera. 
 * Utiliza un sistema de "votación" ponderado basado en rangos predefinidos para 
 * tallas masculinas y femeninas.
 * </p>
 *
 * @author santi
 * @version 1.0
 */
public class FachadaCalcularTalla implements ICalcularTalla{

    /**
     * Calcula la talla de ropa más probable basándose en las medidas y el género.
     * <p>
     * El algoritmo asigna "votos" a las posibles tallas (XS a XXL) por cada medida 
     * que cae dentro de un rango predefinido. La talla con el mayor número de votos
     * es seleccionada como resultado.
     * </p>
     * <ul>
     * <li>Las tallas masculinas dan doble peso al pecho.</li>
     * <li>Si todas las medidas son cero, retorna "Desconocida".</li>
     * </ul>
     *
     * @param pecho Medida del pecho en centímetros.
     * @param cintura Medida de la cintura en centímetros.
     * @param cadera Medida de la cadera en centímetros.
     * @param genero Género del cliente ("FEMENINO", "MASCULINO" o cualquier otro para "UNISEX").
     * @return La talla resultante como una cadena (ej. "M", "XL").
     */
    @Override
    public String CalcularTalla(double pecho, double cintura, double cadera, String genero) {
        // Asegura que las medidas no sean negativas
        pecho = Math.max(0, pecho);
        cintura = Math.max(0, cintura);
        cadera = Math.max(0, cadera);

        // Rangos aproximados (asumiendo medidas en cm)
        double[][] femPecho = { {0,80},{80,88},{88,96},{96,104},{104,112},{112,Double.MAX_VALUE} };
        double[][] femCintura = { {0,62},{62,70},{70,78},{78,88},{88,96},{96,Double.MAX_VALUE} };
        double[][] femCadera = { {0,88},{88,96},{96,104},{104,112},{112,120},{120,Double.MAX_VALUE} };

        double[][] mascPecho = { {0,88},{88,94},{94,100},{100,106},{106,112},{112,Double.MAX_VALUE} };
        double[][] mascCintura = { {0,78},{78,86},{86,94},{94,102},{102,110},{110,Double.MAX_VALUE} };

        String[] tallas = {"XS","S","M","L","XL","XXL"};

        // Función lambda que determina el índice de la talla a la que corresponde un valor dentro de sus rangos
        java.util.function.BiFunction<double[][], Double, Integer> indicePara = (rangos, valor) -> {
            for (int i = 0; i < rangos.length; i++) {
                if (valor >= rangos[i][0] && valor < rangos[i][1]) return i;
            }
            // Si supera el rango, se asigna al máximo (XXL)
            return rangos.length - 1;
        };

        int votes[] = new int[tallas.length];
        genero = genero == null ? "UNISEX" : genero.toUpperCase();

        // Asignación de votos por género
        switch (genero) {
            case "FEMENINO":
                votes[indicePara.apply(femPecho, pecho)]++;
                votes[indicePara.apply(femCintura, cintura)]++;
                votes[indicePara.apply(femCadera, cadera)]++;
                break;
            case "MASCULINO":
                votes[indicePara.apply(mascPecho, pecho)] += 2; // pecho más peso
                votes[indicePara.apply(mascCintura, cintura)]++;
                // Usa rangos femeninos para la cadera si se proporciona, aunque es menos relevante para ropa masculina
                if (cadera > 0) votes[indicePara.apply(femCadera, cadera)]++; 
                break;
            default: // UNISEX (Usa rangos masculinos o femeninos por defecto)
                votes[indicePara.apply(mascPecho, pecho)]++;
                votes[indicePara.apply(mascCintura, cintura)]++;
                votes[indicePara.apply(femCadera, cadera)]++;
                break;
        }

        // Búsqueda de la talla ganadora (mayor número de votos)
        int mejor = 0;
        int mejorVotos = votes[0];
        for (int i = 1; i < votes.length; i++) {
            // Elige la talla con más votos, o la talla más grande en caso de empate (i > mejor)
            if (votes[i] > mejorVotos || (votes[i] == mejorVotos && i > mejor)) {
                mejor = i;
                mejorVotos = votes[i];
            }
        }

        // Caso especial si no se proporcionaron medidas
        if (pecho == 0 && cintura == 0 && cadera == 0) return "Desconocida";

        return tallas[mejor];
    }

    /**
     * Valida los parámetros de entrada y, si son válidos, procede a calcular la talla.
     * <p>
     * Aunque el método incluye bloques de validación {@code if} vacíos, su propósito es 
     * asegurar la calidad de los datos antes de llamar al algoritmo de cálculo. 
     * Retorna el resultado del cálculo independientemente del estado de las validaciones.
     * </p>
     *
     * @param pecho Medida del pecho.
     * @param cintura Medida de la cintura.
     * @param cadera Medida de la cadera.
     * @param genero Género del cliente.
     * @return La talla calculada por {@code CalcularTalla}.
     */
    @Override
    public String ValidarDatos(double pecho, double cintura, double cadera, String genero) {
        if (pecho <= 0) {
            
        }
        if (cintura <= 0) {
            
        }
        if (cadera <= 0) {
            
        }
        if (genero == null || genero == "") {
        
        
        } 
        // Si las validaciones pasan (o están vacías), se procede al cálculo
        return CalcularTalla(pecho, cintura, cadera, genero);
    }
    
}