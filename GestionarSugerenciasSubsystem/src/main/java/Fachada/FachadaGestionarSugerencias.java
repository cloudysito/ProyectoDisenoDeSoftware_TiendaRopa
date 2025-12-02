package Fachada;

import Interfaz.IGestionarSugerencias;
import com.mycompany.dto_negocio.SugerenciaDTO;
import java.util.ArrayList;
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
            return SugerenciaBO.getInstance().filtrarSugerencias(filtro);
        } catch (Exception e) {
            System.err.println("Error en fachada al filtrar sugerencias: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public boolean cambiarEstadoSugerencia(SugerenciaDTO sugerencia, String nuevoEstado) {
       try {
            SugerenciaBO.getInstance().cambiarEstadoSugerencia(sugerencia.getId(), nuevoEstado);
            return true;
        } catch (Exception e) {
            System.err.println("Error en fachada al cambiar estado de sugerencia: " + e.getMessage());
            return false;
        }
    }
    
}
