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
 * Clase principal utilizada para probar la funcionalidad de la capa DAO (Data Access Object).
 * <p>
 * Contiene el método {@code main} para realizar pruebas directas, como la persistencia de datos 
 * y la verificación de la lógica de negocio básica (ej. iniciar sesión) sin depender de la interfaz gráfica.
 * </p>
 *
 * @author santi
 * @version 1.0
 */
public class prueba {

    /**
     * Punto de entrada de la aplicación de prueba.
     * <p>
     * El propósito del código es:
     * <ol>
     * <li>Inicializar el DAO de Empleados e intentar iniciar sesión con credenciales predefinidas ("Santiago", "santi").</li>
     * <li>Crear una nueva instancia de {@code Sugerencia} utilizando el empleado obtenido y asignándole el estado "Pendiente" y la fecha actual.</li>
     * <li>Utilizar el DAO de Sugerencias para persistir el objeto en la base de datos.</li>
     * </ol>
     * </p>
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // 1. Inicialización del DAO de Empleados
        IEmpleadoDAO daoEmpleado = new EmpleadoDAO();
        
        // 2. Intento de inicio de sesión
        Empleado empleado = daoEmpleado.iniciarSesion("Santiago", "santi");
        
        // 3. Creación de la sugerencia, asignando empleado, estado y fecha/hora actual
        Sugerencia sugerencia = new Sugerencia(empleado, "Limpiar mas seguido la terrasa", "Pendiente", Date.from(Instant.now()));
        
        // 4. Inicialización del DAO de Sugerencias
        ISugerenciaDAO sugerenciaDAO = new SugerenciaDAO();
        
        // 5. Persistencia de la sugerencia en la base de datos
        sugerenciaDAO.guardarSugerencia(sugerencia);
    }
    
}