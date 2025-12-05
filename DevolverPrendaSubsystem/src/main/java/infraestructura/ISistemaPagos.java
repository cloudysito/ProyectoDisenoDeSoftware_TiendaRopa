/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura;

/**
 * Interfaz para la capa de infraestructura de pagos.
 * Define el contrato para comunicarse con pasarelas de pago externas.
 * * @author emiim
 */
public interface ISistemaPagos {
    /**
     * Solicita la ejecución de un reembolso monetario a través de un proveedor externo.
     * * @param monto La cantidad de dinero a devolver.
     * @param metodo El método de pago donde se realizará el abono (Efectivo, Tarjeta, etc.).
     * @return true si la transacción financiera fue exitosa, false si fue rechazada.
     */
    boolean ejecutarReembolso(double monto, String metodo);
}
