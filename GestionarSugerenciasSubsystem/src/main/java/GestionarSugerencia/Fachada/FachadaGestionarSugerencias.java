package GestionarSugerencia.Fachada;

import BOs.SugerenciaBO;
import GestionarSugerencia.Interfaz.IGestionarSugerencias;
import com.mycompany.dto_negocio.SugerenciaDTO;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author garfi
 */
public class FachadaGestionarSugerencias implements IGestionarSugerencias{

    @Override
    public List<SugerenciaDTO> filtrarSugerencias(String filtro) {
        try {
            return SugerenciaBO.getIntance().filtrarSugerencias(filtro);
        } catch (Exception e) {
            System.err.println("Error en fachada al filtrar sugerencias: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public boolean cambiarEstadoSugerencia(SugerenciaDTO sugerencia, String nuevoEstado) {
       try {
            SugerenciaBO.getIntance().cambiarEstado(sugerencia , nuevoEstado);
            return true;
        } catch (Exception e) {
            System.err.println("Error en fachada al cambiar estado de sugerencia: " + e.getMessage());
            return false;
        }
    }

    @Override
    public SugerenciaDTO guardarSugerencia(SugerenciaDTO sugerenciaDTO) {
       sugerenciaDTO.setFechaPublicacion(Date.from(Instant.now()));
       sugerenciaDTO.setEstado("Pendiente");
        return  SugerenciaBO.getIntance().guardarSugerencia(sugerenciaDTO);
    }
    
}
