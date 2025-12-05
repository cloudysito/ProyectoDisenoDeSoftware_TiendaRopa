/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 * Excepción personalizada para manejar errores específicos de la base de datos MongoDB.
 * <p>
 * Esta clase extiende de {@link RuntimeException} (no chequeada), lo que permite capturar
 * excepciones lanzadas por el driver de MongoDB (como timeouts, fallos de conexión o errores de sintaxis BSON)
 * y re-lanzarlas envueltas en una excepción propia del dominio de la aplicación.
 * </p>
 *
 * @author garfi
 * @version 1.0
 */
public class MongoException extends RuntimeException {

    /**
     * Constructor por defecto.
     * Crea una instancia de la excepción sin mensaje ni causa.
     */
    public MongoException() {
        super();
    }

    /**
     * Constructor con mensaje de detalle.
     * * @param message Descripción del error ocurrido en la operación de MongoDB.
     */
    public MongoException(String message) {
        super(message);
    }
    
    /**
     * Constructor para encadenamiento de excepciones (Exception Chaining).
     * <p>
     * Este es el constructor ideal para atrapar una excepción nativa del driver
     * (ej. {@code com.mongodb.MongoTimeoutException}) y lanzarla hacia arriba
     * sin perder la traza original del error.
     * </p>
     * * @param message Mensaje descriptivo del error.
     * @param cause La excepción original (causa raíz) que provocó este error.
     */
    public MongoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}