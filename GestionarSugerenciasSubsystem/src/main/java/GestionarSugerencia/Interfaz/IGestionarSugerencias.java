/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GestionarSugerencia.Interfaz;

import com.mycompany.dto_negocio.SugerenciaDTO;
import java.util.List;

/**
 * Interfaz que define el contrato de operaciones para el subsistema de Gestión de Sugerencias.
 * <p>
 * Establece los métodos necesarios para filtrar, actualizar estados y registrar nuevas sugerencias.
 * Permite desacoplar la lógica de presentación (Controladores) de la lógica de negocio concreta.
 * </p>
 * * @author garfi
 * @version 1.0
 */
public interface IGestionarSugerencias {

    /**
     * Busca y recupera una lista de sugerencias basadas en un criterio de filtro.
     * * @param filtro Cadena de texto que puede contener palabras clave, estados o fechas para la búsqueda.
     * @return Una lista de objetos {@code SugerenciaDTO} que coinciden con el filtro proporcionado.
     */
    public List<SugerenciaDTO> filtrarSugerencias(String filtro);

    /**
     * Actualiza el estado de una sugerencia específica.
     * * @param sugerencia El DTO de la sugerencia que se desea modificar.
     * @param nuevoEstado El nuevo estado a asignar (ej. "Aprobada", "Rechazada", "Pendiente").
     * @return {@code true} si el cambio de estado se realizó con éxito; {@code false} si hubo un error.
     */
    public boolean cambiarEstadoSugerencia(SugerenciaDTO sugerencia, String nuevoEstado);
    
    /**
     * Guarda una nueva sugerencia en el sistema.
     * * @param sugerenciaDTO El objeto DTO con la información de la sugerencia a registrar.
     * @return El objeto {@code SugerenciaDTO} persistido (posiblemente con datos generados como ID o fecha).
     */
    public SugerenciaDTO guardarSugerencia(SugerenciaDTO sugerenciaDTO);
}