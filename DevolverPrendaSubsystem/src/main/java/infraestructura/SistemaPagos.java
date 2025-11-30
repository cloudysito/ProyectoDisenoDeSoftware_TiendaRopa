/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura;

/**
 *
 * @author emiim
 */
public class SistemaPagos implements ISistemaPagos {
    @Override
    public boolean ejecutarReembolso(double monto, String metodo) {
        // Simulación de conexión bancaria
        System.out.println("INFRAESTRUCTURA: Reembolsando $" + monto + " mediante " + metodo);
        return true; 
    }
}
