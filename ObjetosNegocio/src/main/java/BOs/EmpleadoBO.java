/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

/**
 *
 * @author riosr
 */
public class EmpleadoBO {
    private static EmpleadoBO instance; 
    
    private IEmpleadoDAO empleadoDAO;

    public EmpleadoBO() {
        this.empleadoDAO = new EmpleadoDAO();
    }
    
    public static EmpleadoBO getInstance(){
        if(instance == null){
            instance = new EmpleadoBO();
        }
        return instance;
    }
    
}
