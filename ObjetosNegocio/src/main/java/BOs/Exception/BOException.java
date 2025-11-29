/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs.Exception;

/**
 *
 * @author riosr
 */
public class BOException extends RuntimeException{
    
    public BOException() {
        super();
    }

    public BOException(String message) {
        super(message);
    }
    
    public BOException(String message, Throwable cause) {
        super(message, cause);
    }

}
