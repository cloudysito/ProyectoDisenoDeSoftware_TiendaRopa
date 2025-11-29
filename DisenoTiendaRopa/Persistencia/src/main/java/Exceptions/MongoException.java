/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author garfi
 */
public class MongoException extends RuntimeException {

    public MongoException() {
        super();
    }

    public MongoException(String message) {
        super(message);
    }
    
    public MongoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
