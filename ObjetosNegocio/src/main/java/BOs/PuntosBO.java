/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import BOs.Exception.BOException;
import Exceptions.DAOException;
import Implementaciones.BonificacionDAO;
import Implementaciones.PuntosDAO;
import com.mycompany.dto_negocio.PuntosDTO;
import mappers.PuntosMapper;
import objetosnegocio.dominioPojo.Puntos;
import Interfaces.IPuntosDAO;
import com.mycompany.dto_negocio.BonificacionDTO;
import com.mycompany.dto_negocio.EmpleadoDTO;
/**
 *
 * @author riosr
 */
public class PuntosBO {
    
    private static PuntosBO instance; 
    
    private IPuntosDAO puntosDAO;

    public PuntosBO() {
        this.puntosDAO = new PuntosDAO();
    }
    
    public static PuntosBO getInstance(){
        if(instance == null){
            instance = new PuntosBO();
        }
        return instance;
    }
    
    public PuntosDTO guardarPuntos(PuntosDTO puntosDTO) throws BOException {
        try {
            Puntos puntos = PuntosMapper.toEntity(puntosDTO);

            Puntos puntosGuardar = puntosDAO.guardarPuntos(puntos);

            return PuntosMapper.toDTO(puntosGuardar);

        } catch (DAOException e) {
            throw new BOException("Error al guardar puntos", e);
        }
    }
    
    public PuntosDTO buscarPorId(String idPuntos) throws BOException{
        try{
            
            return PuntosMapper.toDTO(puntosDAO.buscarPorId(idPuntos));
            
        }catch(DAOException e){
            throw new BOException("Error al buscar por id puntos", e);
        }
    }
    
    public boolean procesarSumaPuntos(PuntosDTO puntosPrenda, EmpleadoDTO empleado) {
        
        // --- 1. Obtener la cantidad de puntos a sumar ---
        int puntosIndividuales = puntosPrenda.getPuntosIndividuales(); 
        
        // --- 2. Obtener la entidad Bonificacion actual (a través del DAO) ---
        BonificacionDAO bonificacionDAO = new BonificacionDAO();
        
        // Se asume que getBonificacionPorEmpleado() devuelve la entidad BonificacionDTO
        // usando el ID del empleado.
        BonificacionDTO bonificacionActual = bonificacionDAO.getBonificacionPorEmpleado(empleado.getIdEmpleado()); 
        
        if (bonificacionActual == null) {
            System.err.println("ERROR BO: No se encontró la bonificación para el empleado.");
            return false;
        }

        // --- 3. Realizar la SUMA (Lógica Central) ---
        int puntosTotalesActuales = bonificacionActual.getPuntosTotales();
        int nuevosPuntosTotales = puntosTotalesActuales + puntosIndividuales;
        
        // --- 4. Actualizar el DTO ---
        bonificacionActual.setPuntosTotales(nuevosPuntosTotales);
        
        System.out.println("LOG BO: Suma realizada: " + puntosTotalesActuales + " + " + puntosIndividuales 
                           + " = " + nuevosPuntosTotales);

        // --- 5. Persistir el cambio (Llamada al DAO) ---
        return bonificacionDAO.actualizarPuntosTotales(bonificacionActual);
    }
}
