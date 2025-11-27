/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.RopaTallaDTO;
import objetosnegocio.dominioPojo.Ropa;
import objetosnegocio.dominioPojo.RopaTalla;
import objetosnegocio.dominioPojo.Talla;
import org.bson.types.ObjectId;

/**
 *
 * @author garfi
 */
public class RopaTallaMapper {
    
    
    public static RopaTalla toEntity(RopaTallaDTO dto) {
        if (dto == null) {
            return null;
        }
        RopaTalla rt = new RopaTalla();
        rt.setId(new ObjectId(dto.getIdRopaTalla()));
        rt.setCodigo(dto.getCodigoBarras());
        rt.setCantidad(dto.getCantidad());
        Ropa ropaEntidad = RopaMapper.toEntity(dto.getRopa());
        rt.setRopa(ropaEntidad);
        Talla tallaEntidad = TallaMapper.toEntity(dto.getTalla());
        rt.setTalla(tallaEntidad);
        
        return rt;
    }
    
    public static RopaTallaDTO toDTO(RopaTalla rt) {
        if (rt == null) {
            return null;
        }
        RopaTallaDTO dto = new RopaTallaDTO();
        dto.setIdRopaTalla(String.valueOf(rt.getId()));
        dto.setRopa(RopaMapper.toDTO(rt.getRopa()));
        dto.setTalla(TallaMapper.toDTO(rt.getTalla()));
        dto.setCodigoBarras(rt.getCodigo());
        dto.setCantidad(rt.getCantidad());
        
        return dto;
    }
    
}
