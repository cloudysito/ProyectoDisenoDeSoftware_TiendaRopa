/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import Implementaciones.*;
import Interfaces.*;
import java.time.Instant;
import java.util.Date;
import objetosnegocio.dominioPojo.*;

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
        Empleado empleado  = daoEmpleado.iniciarSesion("Santiago", "santi");
        Sugerencia sugerencia = new Sugerencia(empleado, "Limpiar mas seguido la terrasa", "Pendiente", Date.from(Instant.now()));
        
        ISugerenciaDAO sugerenciaDAO = new SugerenciaDAO();
        
        sugerenciaDAO.guardarSugerencia(sugerencia);
    }
    
}
