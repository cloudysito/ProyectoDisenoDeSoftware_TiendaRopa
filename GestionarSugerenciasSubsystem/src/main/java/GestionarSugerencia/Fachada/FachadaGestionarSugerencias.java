/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionarSugerencia.Fachada;

import BOs.SugerenciaBO;
import GestionarSugerencia.Interfaz.IGestionarSugerencias;
import com.mycompany.dto_negocio.SugerenciaDTO;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implementación del patrón Fachada para la gestión de Sugerencias.
 * <p>
 * Esta clase actúa como intermediario entre la capa de presentación (Controladores) y la lógica de negocio 
 * encapsulada en {@code SugerenciaBO}. Su objetivo es simplificar el acceso a las operaciones de sugerencias
 * y manejar excepciones de forma segura para evitar caídas en la interfaz gráfica.
 * </p>
 *
 * @author garfi
 * @version 1.0
 */
public class FachadaGestionarSugerencias implements IGestionarSugerencias {

    /**
     * Obtiene una lista de sugerencias que coinciden con el filtro proporcionado.
     * <p>
     * Delega la búsqueda al objeto de negocio {@code SugerenciaBO}. Si ocurre un error durante
     * la consulta, captura la excepción y retorna una lista vacía para que la interfaz no falle.
     * </p>
     *
     * @param filtro Criterio de búsqueda (ej. parte del contenido, estado o fecha).
     * @return Una lista de {@code SugerenciaDTO} con los resultados. Retorna una lista vacía si hay error.
     */
    @Override
    public List<SugerenciaDTO> filtrarSugerencias(String filtro) {
        try {
            return SugerenciaBO.getIntance().filtrarSugerencias(filtro);
        } catch (Exception e) {
            System.err.println("Error en fachada al filtrar sugerencias: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Modifica el estado de una sugerencia existente.
     * <p>
     * Permite cambiar el estado de una sugerencia (por ejemplo, de "Pendiente" a "Aprobada" o "Rechazada")
     * delegando la operación al BO correspondiente.
     * </p>
     *
     * @param sugerencia El DTO que identifica a la sugerencia a modificar.
     * @param nuevoEstado El nuevo estado que se le asignará.
     * @return {@code true} si la actualización fue exitosa; {@code false} si ocurrió algún error.
     */
    @Override
    public boolean cambiarEstadoSugerencia(SugerenciaDTO sugerencia, String nuevoEstado) {
        try {
            SugerenciaBO.getIntance().cambiarEstado(sugerencia, nuevoEstado);
            return true;
        } catch (Exception e) {
            System.err.println("Error en fachada al cambiar estado de sugerencia: " + e.getMessage());
            return false;
        }
    }

    /**
     * Registra una nueva sugerencia en el sistema aplicando reglas de negocio iniciales.
     * <p>
     * Antes de guardar, este método establece automáticamente:
     * <ul>
     * <li><b>Fecha de Publicación:</b> La fecha y hora actual (Instant.now).</li>
     * <li><b>Estado:</b> "Pendiente" (estado inicial por defecto).</li>
     * </ul>
     * Luego delega el guardado al {@code SugerenciaBO}.
     * </p>
     *
     * @param sugerenciaDTO El objeto con la descripción y datos del empleado.
     * @return El {@code SugerenciaDTO} persistido con sus datos actualizados (incluyendo ID generado).
     */
    @Override
    public SugerenciaDTO guardarSugerencia(SugerenciaDTO sugerenciaDTO) {
        sugerenciaDTO.setFechaPublicacion(Date.from(Instant.now()));
        sugerenciaDTO.setEstado("Pendiente");
        return SugerenciaBO.getIntance().guardarSugerencia(sugerenciaDTO);
    }

}