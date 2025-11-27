/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.EmpleadoDTO;
import objetosnegocio.dominioPojo.Empleado;
import org.bson.types.ObjectId;



/**
 *
 * @author garfi
 */
public class EmpleadoMapper {
    public Empleado toEntity(EmpleadoDTO dto) {
        if (dto == null) {
            return null;
        }
        Empleado empleado = new Empleado();
        empleado.setId(new ObjectId(dto.getIdEmpleado()));
        empleado.setNombre(dto.getNombre());
        empleado.setApellidos(dto.getApellidos());
        empleado.setEmail(dto.getEmail());
        empleado.setFechaContratacion(dto.getFechaContratacion());
        empleado.setPuesto(dto.getPuesto());
        empleado.setRfc(dto.getRfc());
        empleado.setSalario(dto.getSalario());
        empleado.setTelefono(dto.getTelefono());
        
        return empleado;
    }
    
    public EmpleadoDTO toDTO(Empleado empleado) {
        if (empleado == null) {
            return null;
        }
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setIdEmpleado(empleado.getId().toHexString());
        dto.setNombre(empleado.getNombre());
        dto.setApellidos(empleado.getApellidos());
        dto.setEmail(empleado.getEmail());
        dto.setFechaContratacion(empleado.getFechaContratacion());
        dto.setPuesto(empleado.getPuesto());
        dto.setRfc(empleado.getRfc());
        dto.setSalario(empleado.getSalario());
        dto.setTelefono(empleado.getTelefono());        
        
        return dto;
    }
}
