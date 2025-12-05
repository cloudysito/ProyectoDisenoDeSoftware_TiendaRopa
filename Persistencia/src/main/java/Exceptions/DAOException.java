/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 * Excepción personalizada para manejar errores en la capa de Acceso a Datos (DAO).
 * <p>
 * Esta clase extiende de {@link RuntimeException}, lo que la convierte en una excepción
 * no chequeada (unchecked). Se utiliza para envolver excepciones técnicas de bajo nivel 
 * (como {@code SQLException}) y propagarlas hacia capas superiores de manera más limpia,
 * sin obligar a declarar bloques try-catch en cada método de la lógica de negocio.
 * </p>
 *
 * @author riosr
 * @version 1.0
 */
public class DAOException extends RuntimeException {
    
    /**
     * Constructor por defecto.
     * Crea una nueva instancia de {@code DAOException} sin mensaje de detalle ni causa.
     */
    public DAOException() {
        super();
    }

    /**
     * Constructor con mensaje descriptivo.
     * * @param message El mensaje que detalla el error específico ocurrido (ej. "Error al conectar a la BD").
     */
    public DAOException(String message) {
        super(message);
    }
    
    /**
     * Constructor con mensaje y causa raíz (Exception Chaining).
     * <p>
     * Este constructor es el más utilizado para envolver excepciones originales (como SQLException).
     * Permite conservar el stack trace original del error para facilitar la depuración.
     * </p>
     * * @param message El mensaje descriptivo del error.
     * @param cause La causa original del error (la excepción que lanzó la base de datos o el driver).
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
    
}