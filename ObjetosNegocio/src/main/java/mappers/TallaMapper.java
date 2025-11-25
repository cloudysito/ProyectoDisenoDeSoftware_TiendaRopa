/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.objetosnegocio.dominio.Talla;
import com.mycompany.objetosnegocio.dto.TallaDTO;

/**
 *
 * @author garfi
 */
public class TallaMapper {
    
    public Talla toEntity(TallaDTO dto) {
        if (dto == null) {
            return null;
        }
        Talla talla = new Talla();
        talla.setIdTalla(dto.getIdTalla());
        talla.setNombreTalla(dto.getNombreTalla());
        talla.setDescripcion(dto.getDescripcion());
        
        return talla;
    }
    
    public TallaDTO toDTO(Talla talla) {
        if (talla == null) {
            return null;
        }
        TallaDTO dto = new TallaDTO();
        dto.setIdTalla(talla.getIdTalla());
        dto.setNombreTalla(talla.getNombreTalla());
        dto.setDescripcion(talla.getDescripcion());
        
        return dto;
    }
    
}
