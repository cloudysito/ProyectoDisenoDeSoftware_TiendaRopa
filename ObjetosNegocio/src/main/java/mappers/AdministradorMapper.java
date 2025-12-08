/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.AdministradorDTO;
import objetosnegocio.dominioPojo.Administrador;
import org.bson.types.ObjectId;

/**
 *
 * @author santi
 */
public class AdministradorMapper {
    public static Administrador toEntity(AdministradorDTO dto) {
        
        Administrador administrador = new Administrador();
        
        if (dto.getId() != null && !dto.getId().isEmpty()) {
            administrador.setId(new ObjectId(dto.getId()));
        }
        administrador.setNombre(dto.getNombre());
        administrador.setContrasenia(dto.getContrasenia());
        
        
        return administrador;
    }
    
    public static AdministradorDTO toDTO(Administrador administrador) {
        if (administrador == null) {
            return  null;
        }
        
        AdministradorDTO dto = new AdministradorDTO();
        
        
        if (administrador.getId() != null) {
            dto.setId(administrador.getId().toHexString());
        }
        dto.setNombre(administrador.getNombre());
        dto.setContrasenia(administrador.getContrasenia());

        return dto;
    }

}
