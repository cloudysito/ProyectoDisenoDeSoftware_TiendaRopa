/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FachadaBonificacion;

/**
 *
 * @author riosr
 */
public class FachadaBonificacion implements IBonificacion{
    public boolean sumarPuntosPrendaABonificacion(PuntosDTO puntosPrendaDTO, EmpleadoDTO empleadoDTO) {
    
    try {
        // --- LLAMADA A LA CAPA BO ---
        BonificacionBO bonificacionBO = new BonificacionBO();
        
        // El BO maneja la lógica de obtener, sumar y persistir los cambios.
        return bonificacionBO.procesarSumaPuntos(puntosPrendaDTO, empleadoDTO);

    } catch (Exception e) {
        System.err.println("ERROR FATAL en FachadaPuntos: " + e.getMessage());
        return false;
    }
    }
    
    public Recompensa consultarEstadoRecompensa(BonificacionDTO bonificacionDTO) {
    try {
        // --- LLAMADA A LA CAPA BO (LÓGICA DE NEGOCIO) ---
        BonificacionBO bonificacionBO = new BonificacionBO();
        
        // El BO realiza la lógica de cálculo y trae todos los datos necesarios.
        return bonificacionBO.obtenerEstadoRecompensa(bonificacionDTO);

    } catch (Exception e) {
        System.err.println("ERROR FATAL en FachadaPuntos al consultar estado: " + e.getMessage());
        
        // Retorna un DTO de error o nulo si falla.
        return new Recompensa(0, "Error en la consulta");
    }
}
}
