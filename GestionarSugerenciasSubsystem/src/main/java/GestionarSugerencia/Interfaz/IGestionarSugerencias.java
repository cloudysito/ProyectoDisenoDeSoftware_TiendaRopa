/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GestionarSugerencia.Interfaz;

import com.mycompany.dto_negocio.SugerenciaDTO;
import java.util.List;

/**
 *
 * @author garfi
 */
public interface IGestionarSugerencias {

    public List<SugerenciaDTO> filtrarSugerencias(String filtro);

    public boolean cambiarEstadoSugerencia(SugerenciaDTO sugerencia, String nuevoEstado);
    
    public SugerenciaDTO guardarSugerencia(SugerenciaDTO sugerenciaDTO);
}
