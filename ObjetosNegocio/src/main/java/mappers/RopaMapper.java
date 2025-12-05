/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.RopaDTO;
import objetosnegocio.dominioPojo.Ropa;
import org.bson.types.ObjectId;

/**
 * Mapper para la entidad Ropa.
 * Convierte datos generales de la prenda (nombre, marca, precio base, etc.)
 * sin incluir información de stock o tallas específicas.
 * @author garfi
 */
public class RopaMapper {
    
    public static Ropa toEntity(RopaDTO dto) {
        if (dto == null) {
            return null;
        }
        Ropa ropa = new Ropa();
        
        if (dto.getIdRopa() != null && !dto.getIdRopa().isEmpty()) {
            ropa.setId(new ObjectId(dto.getIdRopa()));
        }
        
        ropa.setNombreArticulo(dto.getNombreArticulo());
        ropa.setUrlImagen(dto.getUrlImagen());
        ropa.setDescripcion(dto.getDescripcion());
        ropa.setPrecio(dto.getPrecio());
        ropa.setTemporada(dto.getTemporada());
        ropa.setMarca(dto.getMarca());
        ropa.setMaterial(dto.getMaterial());        
        
        return ropa;
    }
    
    public static RopaDTO toDTO(Ropa ropa) {
        if (ropa == null) {
            return null;
        }
        RopaDTO dto = new RopaDTO();
        
        if (ropa.getId() != null) {
            dto.setIdRopa(ropa.getId().toHexString());
        }
        
        dto.setNombreArticulo(ropa.getNombreArticulo());
        dto.setDescripcion(ropa.getDescripcion());
        dto.setUrlImagen(ropa.getUrlImagen());
        dto.setPrecio(ropa.getPrecio());
        dto.setTemporada(ropa.getTemporada());
        dto.setMarca(ropa.getMarca());
        dto.setMaterial(ropa.getMaterial());
        
        return dto;
    }
    
}
