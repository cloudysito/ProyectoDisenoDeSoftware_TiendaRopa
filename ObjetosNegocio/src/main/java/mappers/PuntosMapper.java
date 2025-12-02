/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import com.mycompany.dto_negocio.PuntosDTO;
import objetosnegocio.dominioPojo.Bonificacion;
import objetosnegocio.dominioPojo.Puntos;
import objetosnegocio.dominioPojo.Empleado;
import objetosnegocio.dominioPojo.Recompensa;
import objetosnegocio.dominioPojo.Ropa;
import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class PuntosMapper {
    
    public static Puntos toEntity(PuntosDTO dto) {
        if (dto == null) {
            return null;
        }
        Puntos p = new Puntos();
        if (dto.getIdPuntos()!= null) {
            p.setIdPuntos(new ObjectId(dto.getIdPuntos()));
        }
        Ropa nombreArticulo = RopaMapper.toEntity(dto.getNombreArticulo());
        p.setNombreArticulo(nombreArticulo);
        p.setPuntosIndividuales(dto.getPuntosIndividuales());
        
        return p;
    }
    
    public static PuntosDTO toDTO(Puntos p) {
        if (p == null) {
            return null;
        }
        PuntosDTO dto = new PuntosDTO();
        dto.setIdPuntos(
            p.getIdPuntos()!= null ? p.getIdPuntos().toHexString() : null
        );
        dto.setNombreArticulo(RopaMapper.toDTO(p.getNombreArticulo()));
        dto.setPuntosIndividuales(p.getPuntosIndividuales());
        
        return dto;
    }
}
