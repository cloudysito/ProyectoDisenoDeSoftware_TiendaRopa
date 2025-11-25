/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.objetosnegocio.dominio.Ropa;
import com.mycompany.objetosnegocio.dto.RopaDTO;

/**
 *
 * @author garfi
 */
public class RopaMapper {
    
    public Ropa toEntity(RopaDTO dto) {
        if (dto == null) {
            return null;
        }
        Ropa ropa = new Ropa();
        ropa.setIdRopa(dto.getIdRopa());
        ropa.setNombreArticulo(dto.getNombreArticulo());
        ropa.setDescripcion(dto.getDescripcion());
        ropa.setPrecio(dto.getPrecio());
        ropa.setTemporada(dto.getTemporada());
        ropa.setMarca(dto.getMarca());
        ropa.setMaterial(dto.getMaterial());        
        
        return ropa;
    }
    
    public RopaDTO toDTO(Ropa ropa) {
        if (ropa == null) {
            return null;
        }
        RopaDTO dto = new RopaDTO();
        dto.setIdRopa(ropa.getIdRopa());
        dto.setNombreArticulo(ropa.getNombreArticulo());
        dto.setDescripcion(ropa.getDescripcion());
        dto.setPrecio(ropa.getPrecio());
        dto.setTemporada(ropa.getTemporada());
        dto.setMarca(ropa.getMarca());
        dto.setMaterial(ropa.getMaterial());
        
        return dto;
    }
    
}
