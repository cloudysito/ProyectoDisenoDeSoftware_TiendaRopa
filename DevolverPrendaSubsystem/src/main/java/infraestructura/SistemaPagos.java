/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura;

import java.util.Random;

/**
 * Implementación concreta del sistema de pagos.
 * Simula la comunicación con una API bancaria externa para procesar reembolsos.
 * * @author emiim
 */
public class SistemaPagos implements ISistemaPagos {

    public SistemaPagos() {
    }

    /**
     * Ejecuta una simulación de reembolso.
     * Incluye un retraso artificial para simular latencia de red y 
     * una probabilidad aleatoria de éxito/fracaso.
     * * @param monto Monto a reembolsar.
     * @param metodo Método de pago seleccionado.
     * @return true si la "transacción bancaria" fue aprobada.
     */
    @Override
    public boolean ejecutarReembolso(double monto, String metodo) {
        System.out.println("------------------------------------------------");
        System.out.println("Iniciando conexión segura con el Banco...");
        System.out.println("Solicitando reembolso por: $" + monto);
        System.out.println("Método de abono: " + metodo);
        
        try {
            Thread.sleep(1500); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
        boolean exito = new Random().nextInt(10) > 0; 

        if (exito) {
            System.out.println("Transacción APROBADA.");
        } else {
            System.out.println("Transacción RECHAZADA.");
        }
        System.out.println("------------------------------------------------");

        return exito;
    }
}  

