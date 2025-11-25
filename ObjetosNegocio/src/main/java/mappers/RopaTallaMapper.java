/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.objetosnegocio.dominio.RopaTalla;
import com.mycompany.objetosnegocio.dto.RopaTallaDTO;

/**
 *
 * @author garfi
 */
public class RopaTallaMapper {
    
    public RopaTalla toEntity(RopaTallaDTO dto) {
        if (dto == null) {
            return null;
        }
        RopaTalla rt = new RopaTalla();
        rt.setId(dto.getIdRopaTalla());
        rt.setCodigoBarras(dto.getCodigoBarras());
        rt.setCantidad(dto.getCantidad());
        rt.setRopa(dto.getIdRopa());
        rt.setTalla(dto.getIdTalla());
        
        return rt;
    }
    
    public RopaTallaDTO toDTO(RopaTalla rt) {
        if (rt == null) {
            return null;
        }
        RopaTallaDTO dto = new RopaTallaDTO();
        dto.setIdRopaTalla(String.valueOf(rt.getId()));
        dto.setIdTalla(String.valueOf(rt.getTalla().getIdTalla()));
        dto.setIdRopa(String.valueOf(rt.getRopa().getIdRopa()));
        dto.setCodigoBarras(rt.getCodigoBarras());
        dto.setCantidad(rt.getCantidad());
        
        return dto;
    }
    
}
