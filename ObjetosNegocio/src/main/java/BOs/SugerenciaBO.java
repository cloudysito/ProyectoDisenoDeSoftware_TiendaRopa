/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import BOs.Exception.BOException;
import Exceptions.DAOException;
import Implementaciones.SugerenciaDAO;
import Interfaces.ISugerenciaDAO;
import com.mycompany.dto_negocio.SugerenciaDTO;
import java.util.ArrayList;
import java.util.List;
import mappers.SugerenciaMapper;
import objetosnegocio.dominioPojo.Sugerencia;

/**
 *
 * @author santi
 */
public class SugerenciaBO {

    private static SugerenciaBO instance;

    private ISugerenciaDAO sugerenciaDAO;

    public SugerenciaBO() {
        this.sugerenciaDAO = new SugerenciaDAO();
    }

    public static SugerenciaBO getIntance() {
        if (instance == null) {
            instance = new SugerenciaBO();
        }
        return instance;
    }

    SugerenciaDTO guardarSugerencia(SugerenciaDTO sugerenciaDTO) throws BOException {
        try {
            Sugerencia sugerencia = SugerenciaMapper.toEntity(sugerenciaDTO);
            Sugerencia sugerenciaGuardada = sugerenciaDAO.guardarSugerencia(sugerencia);
            return SugerenciaMapper.toDTO(sugerenciaGuardada);
        } catch (Exception e) {
            throw new BOException("Error al guardar empleado", e);
        }
    }

    SugerenciaDTO modificarSugerencia(SugerenciaDTO sugerenciaDTO) throws BOException {
        try {
            Sugerencia sugerencia = SugerenciaMapper.toEntity(sugerenciaDTO);
            Sugerencia sugerenciaModificar = sugerenciaDAO.modificarSugerencia(sugerencia);
            return SugerenciaMapper.toDTO(sugerenciaModificar);
        } catch (Exception e) {
            throw new BOException("Error al guardar empleado", e);
        }
    }

    SugerenciaDTO buscarPorId(String idBonificacion) throws BOException {
        try {
            return SugerenciaMapper.toDTO(sugerenciaDAO.buscarPorId(idBonificacion));
        } catch (Exception e) {
            throw new BOException("Error al guardar empleado", e);
        }
    }

    List<SugerenciaDTO> buscarTodos() throws BOException {
        try {

            List<Sugerencia> listaSugerencia = sugerenciaDAO.buscarTodos();

            List<SugerenciaDTO> listaDTO = new ArrayList<>();

            for (Sugerencia rt : listaSugerencia) {
                listaDTO.add(SugerenciaMapper.toDTO(rt));
            }

            return listaDTO;

        } catch (DAOException e) {

            throw new BOException("Error al obtener todos los empleados", e);
        }
    }

    List<SugerenciaDTO> buscarPorNombre(String BOException) {
        try {

            List<Sugerencia> listaSugerencia = sugerenciaDAO.buscarPorNombre(BOException);

            List<SugerenciaDTO> listaDTO = new ArrayList<>();

            for (Sugerencia rt : listaSugerencia) {
                listaDTO.add(SugerenciaMapper.toDTO(rt));
            }

            return listaDTO;

        } catch (DAOException e) {

            throw new BOException("Error al obtener todos los empleados", e);
        }
    }

    public List<SugerenciaDTO> filtrarSugerencias(String filtro) throws BOException {
        try {
            List<Sugerencia> listaEntidades;

            if (filtro.equalsIgnoreCase("Todas")) {
                listaEntidades = sugerenciaDAO.buscarTodos();
            } else {

                String estadoBusqueda = filtro;
                if (filtro.endsWith("s")) {
                    estadoBusqueda = filtro.substring(0, filtro.length() - 1);
                }
                listaEntidades = sugerenciaDAO.buscarPorEstado(estadoBusqueda);
            }

            List<SugerenciaDTO> listaDTO = new ArrayList<>();
            for (Sugerencia s : listaEntidades) {
                listaDTO.add(SugerenciaMapper.toDTO(s));
            }
            return listaDTO;

        } catch (Exception e) {
            throw new BOException("Error al filtrar sugerencias", e);
        }

    }

    public void cambiarEstado(SugerenciaDTO sugerencia, String nuevoEstado) throws BOException {
        try {
            sugerenciaDAO.actualizarEstado(sugerencia.getId(), nuevoEstado);
        } catch (Exception e) {
            throw new BOException("Error cambiando estado", e);
        }
    }

}
