/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs.Exception;
/**
 * Excepción personalizada utilizada para señalar errores o condiciones inesperadas
 * dentro de la capa de Lógica de Negocio (Business Object - BO).
 * Extiende RuntimeException o Exception (se asume que extiende Exception o es una checked exception)
 */
/**
 *
 * @author riosr
 */
public class BOException extends RuntimeException{
    
    /**
     * Constructor por defecto.
     */
    public BOException() {
        super();
    }

    /**
     * Constructor que acepta un mensaje detallado.
     * @param message El mensaje que describe la causa de la excepción.
     */
    public BOException(String message) {
        super(message);
    }
    
    /**
     * Constructor que acepta un mensaje detallado y una causa subyacente.
     * @param message El mensaje que describe la causa de la excepción.
     * @param cause La causa subyacente de la excepción (ej. otra excepción de la capa de persistencia).
     */
    public BOException(String message, Throwable cause) {
        super(message, cause);
    }

}
