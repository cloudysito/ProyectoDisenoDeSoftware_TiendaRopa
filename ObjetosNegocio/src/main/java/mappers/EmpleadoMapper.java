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
    public static Empleado toEntity(EmpleadoDTO dto) {
        if (dto == null) {
            return null;
        }
        Empleado empleado = new Empleado();
        if (dto.getIdEmpleado()!= null) {
            empleado.setId(new ObjectId(dto.getIdEmpleado()));
        }
        empleado.setNombre(dto.getNombre());
        empleado.setApellidos(dto.getApellidos());
        empleado.setUrlImagen(dto.getUrlImagen());
        empleado.setEmail(dto.getEmail());
        empleado.setFechaContratacion(dto.getFechaContratacion());
        empleado.setPuesto(dto.getPuesto());
        empleado.setCapacitacion(CapacitacionMapper.toEntity(dto.getCapacitacion()));
        empleado.setHorario(HorarioMapper.toEntity(dto.getHorario()));
        empleado.setContrasenia(dto.getContrasenia());
        empleado.setRfc(dto.getRfc());
        empleado.setSalario(dto.getSalario());
        empleado.setTelefono(dto.getTelefono());
        
        return empleado;
    }
    
    public static EmpleadoDTO toDTO(Empleado empleado) {
        if (empleado == null) {
            return null;
        }
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setIdEmpleado(empleado.getId().toHexString());
        dto.setNombre(empleado.getNombre());
        dto.setApellidos(empleado.getApellidos());
        dto.setEmail(empleado.getEmail());
        dto.setUrlImagen(empleado.getUrlImagen());
        dto.setFechaContratacion(empleado.getFechaContratacion());
        dto.setCapacitacion(CapacitacionMapper.toDTO(empleado.getCapacitacion()));
        dto.setHorario(HorarioMapper.toDTO(empleado.getHorario()));
        dto.setPuesto(empleado.getPuesto());
        dto.setContrasenia(empleado.getContrasenia());
        dto.setRfc(empleado.getRfc());
        dto.setSalario(empleado.getSalario());
        dto.setTelefono(empleado.getTelefono());        
        
        return dto;
    }
}
