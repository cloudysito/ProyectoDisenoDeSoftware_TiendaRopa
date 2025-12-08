/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GuiaInteractivaEmpleado.Fachada;

import BOs.CapacitacionBO;
import GuiaInteractivaEmpleado.Interfaz.IGuiaInteractivaEmpleado;
import com.mycompany.dto_negocio.CapacitacionDTO;
import com.mycompany.dto_negocio.EmpleadoDTO;

/**
 *
 * @author riosr
 */
public class FachadaGuiaInteractivaEmpleado implements IGuiaInteractivaEmpleado{
    
    @Override
    public CapacitacionDTO capacitacionTema(EmpleadoDTO empleado, String temaCapacitacion) {
        return CapacitacionBO.getInstance().buscarPorNombreYTema(empleado.getNombre(), temaCapacitacion);
    }

    @Override
    public CapacitacionDTO cambiarEstado(CapacitacionDTO capacitacion) {
        capacitacion.setEstado("capacitado");
        
        return CapacitacionBO.getInstance().modificarCapacitacion(capacitacion);
    }
   
}
