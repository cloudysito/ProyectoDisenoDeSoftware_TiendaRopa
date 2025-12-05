/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 * Interfaz que define el contrato de comunicación con un subsistema externo de pagos.
 * <p>
 * Su propósito es abstraer la lógica financiera y las transacciones, permitiendo que la capa 
 * de negocio solicite pagos o reembolsos sin conocer la implementación específica (ej. API de tarjetas, PayPal, etc.).
 * </p>
 *
 * @author emiim
 * @version 1.0
 */
public interface ISistemaPagos {
    
    /**
     * Ejecuta una transacción de reembolso (devolución de dinero) a un cliente.
     * * @param monto La cantidad de dinero a reembolsar.
     * @param metodo El método de pago original utilizado por el cliente (ej. "Tarjeta", "Efectivo").
     * @return {@code true} si el reembolso fue procesado exitosamente por el sistema de pagos; {@code false} en caso contrario.
     */
    boolean ejecutarReembolso(double monto, String metodo);
}