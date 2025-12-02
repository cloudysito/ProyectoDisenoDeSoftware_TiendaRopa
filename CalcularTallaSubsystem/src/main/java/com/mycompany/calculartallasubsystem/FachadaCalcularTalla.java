/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculartallasubsystem;

import com.mycompany.calculartallasubsystem.Interfaz.ICalcularTalla;

/**
 *
 * @author santi
 */
public class FachadaCalcularTalla implements ICalcularTalla{

    @Override
    public String CalcularTalla(double pecho, double cintura, double cadera, String genero) {
        pecho = Math.max(0, pecho);
        cintura = Math.max(0, cintura);
        cadera = Math.max(0, cadera);

        // Rangos aproximados
        double[][] femPecho = { {0,80},{80,88},{88,96},{96,104},{104,112},{112,Double.MAX_VALUE} };
        double[][] femCintura = { {0,62},{62,70},{70,78},{78,88},{88,96},{96,Double.MAX_VALUE} };
        double[][] femCadera = { {0,88},{88,96},{96,104},{104,112},{112,120},{120,Double.MAX_VALUE} };

        double[][] mascPecho = { {0,88},{88,94},{94,100},{100,106},{106,112},{112,Double.MAX_VALUE} };
        double[][] mascCintura = { {0,78},{78,86},{86,94},{94,102},{102,110},{110,Double.MAX_VALUE} };

        String[] tallas = {"XS","S","M","L","XL","XXL"};

        java.util.function.BiFunction<double[][], Double, Integer> indicePara = (rangos, valor) -> {
            for (int i = 0; i < rangos.length; i++) {
                if (valor >= rangos[i][0] && valor < rangos[i][1]) return i;
            }
            return rangos.length - 1;
        };

        int votes[] = new int[tallas.length];
        genero = genero == null ? "UNISEX" : genero.toUpperCase();

        switch (genero) {
            case "FEMENINO":
                votes[indicePara.apply(femPecho, pecho)]++;
                votes[indicePara.apply(femCintura, cintura)]++;
                votes[indicePara.apply(femCadera, cadera)]++;
                break;
            case "MASCULINO":
                votes[indicePara.apply(mascPecho, pecho)] += 2; // pecho más peso
                votes[indicePara.apply(mascCintura, cintura)]++;
                if (cadera > 0) votes[indicePara.apply(femCadera, cadera)]++;
                break;
            default: // UNISEX
                votes[indicePara.apply(mascPecho, pecho)]++;
                votes[indicePara.apply(mascCintura, cintura)]++;
                votes[indicePara.apply(femCadera, cadera)]++;
                break;
        }

        int mejor = 0;
        int mejorVotos = votes[0];
        for (int i = 1; i < votes.length; i++) {
            if (votes[i] > mejorVotos || (votes[i] == mejorVotos && i > mejor)) {
                mejor = i;
                mejorVotos = votes[i];
            }
        }

        if (pecho == 0 && cintura == 0 && cadera == 0) return "Desconocida";

        return tallas[mejor];
    }

    @Override
    public void ValidarDatos(double pecho, double cintura, double cadera, String genero) {
        if (pecho == 0) {
            
        }
        if (cintura == 0) {
            
        }
        if (cadera == 0) {
            
        }
        if (genero == null || genero == "") {
        
        
        } 
        CalcularTalla(pecho, cintura, cadera, genero);
    }
    
}
