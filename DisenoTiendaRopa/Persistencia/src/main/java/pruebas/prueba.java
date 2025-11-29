/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Implementaciones.EmpleadoDAO;
import Interfaces.IEmpleadoDAO;

/**
 *
 * @author santi
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IEmpleadoDAO daoEmpleado = new EmpleadoDAO();
        
        
        
        System.out.println(daoEmpleado.iniciarSesion("Santiago", "santi"));
    }
    
}
