/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GuiaInteractivaEmpleado.Interfaz;

import com.mycompany.dto_negocio.CapacitacionDTO;
import com.mycompany.dto_negocio.EmpleadoDTO;

/**
 *
 * @author riosr
 */
public interface IGuiaInteractivaEmpleado {
    CapacitacionDTO capacitacionTema(EmpleadoDTO empleado, String temaCapacitacion);
    
    CapacitacionDTO cambiarEstado(CapacitacionDTO capacitacion);
}
