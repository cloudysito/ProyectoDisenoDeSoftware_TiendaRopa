/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import BOs.Exception.BOException;
import Implementaciones.EmpleadoDAO;
import Interfaces.IEmpleadoDAO;
import com.mycompany.dto_negocio.EmpleadoDTO;
import mappers.EmpleadoMapper;
import objetosnegocio.dominioPojo.Empleado;
import Exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lógica de negocio para la gestión de Empleados.
 * Incluye autenticación, altas, bajas, cambios y búsquedas avanzadas.
 */
public class EmpleadoBO {

    private static EmpleadoBO instance;

    private IEmpleadoDAO empleadoDAO;

    public EmpleadoBO() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    public static EmpleadoBO getInstance() {
        if (instance == null) {
            instance = new EmpleadoBO();
        }
        return instance;
    }

    /**
     * Registra un nuevo empleado en la base de datos.
     * @param empleadoDTO Datos del empleado.
     * @return Empleado registrado.
     * @throws BOException Si falla el guardado.
     */
    public EmpleadoDTO guardarEmpleado(EmpleadoDTO empleadoDTO) throws BOException {
        try {
            Empleado empleado = EmpleadoMapper.toEntity(empleadoDTO);

            Empleado empleadoGuardar = empleadoDAO.guardarEmpleado(empleado);

            return EmpleadoMapper.toDTO(empleadoGuardar);

        } catch (DAOException e) {
            throw new BOException("Error al guardar empleado", e);
        }
    }

    //BO de modificar empleado.
    public EmpleadoDTO modificarEmpleado(EmpleadoDTO empleadoDTO) throws BOException {
        try {
            Empleado empleado = EmpleadoMapper.toEntity(empleadoDTO);

            Empleado empleadoModificar = empleadoDAO.modificarEmpleado(empleado);

            return EmpleadoMapper.toDTO(empleadoModificar);
        } catch (DAOException e) {
            throw new BOException("Error al modificar empleado", e);
        }
    }

    //BO de eliminar empleado.
    public EmpleadoDTO eliminarEmpleado(EmpleadoDTO empleadoDTO) throws BOException {
        try {
            Empleado empleado = EmpleadoMapper.toEntity(empleadoDTO);

            Empleado empleadoEliminar = empleadoDAO.eliminarEmpleado(empleado);

            return EmpleadoMapper.toDTO(empleadoEliminar);

        } catch (DAOException e) {
            throw new BOException("Error al eliminar empleado", e);
        }
    }

    //BO de buscar por id empleado
    public EmpleadoDTO buscarPorId(String idEmpleado) throws BOException {
        try {

            return EmpleadoMapper.toDTO(empleadoDAO.buscarPorId(idEmpleado));

        } catch (DAOException e) {
            throw new BOException("Error al buscar por id empleado", e);
        }
    }

    /**
     * Valida las credenciales de acceso para el inicio de sesión.
     * @param correo Correo electrónico.
     * @param contrasenia Contraseña.
     * @return EmpleadoDTO si es válido, o null/excepción.
     */
    public EmpleadoDTO iniciarSesion(String correo, String contrasenia) {
        try {

            return EmpleadoMapper.toDTO(empleadoDAO.iniciarSesion(correo, contrasenia));

        } catch (DAOException e) {
            throw new BOException("Error al buscar por id empleado", e);
        }
    }
    
    public List<EmpleadoDTO> buscarProductos(String texto) throws BOException {
        try {

            List<Empleado> resultados = empleadoDAO.buscarPorNombre(texto);

            List<EmpleadoDTO> listaDTO = new ArrayList<>();
            for (Empleado e : resultados) {
                listaDTO.add(EmpleadoMapper.toDTO(e));
            }
            return listaDTO;
            
        } catch (DAOException e) {
            throw new BOException("Error en la búsqueda", e);
        }
    }
    
    //BO buscar todo ropaTalla
    public List<EmpleadoDTO> buscarTodos() throws BOException {
        try {

            List<Empleado> listaRopaTalla = empleadoDAO.buscarTodos();

            List<EmpleadoDTO> listaDTO = new ArrayList<>();

            for (Empleado rt : listaRopaTalla) {
                listaDTO.add(EmpleadoMapper.toDTO(rt));
            }

            return listaDTO;

        } catch (DAOException e) {

            throw new BOException("Error al obtener todos los empleados", e);
        }
    }

    //BO de buscar a los empleados por su nombre
    public List<EmpleadoDTO> buscarPorNombre(String nombreEmpleado) throws BOException {
        try {
            List<Empleado> listaEmpleados = empleadoDAO.buscarPorNombre(nombreEmpleado);

            List<EmpleadoDTO> listaDTO = new ArrayList<>();

            for (Empleado e : listaEmpleados) {
                listaDTO.add(EmpleadoMapper.toDTO(e));
            }

            return listaDTO;

        } catch (DAOException e) {
            throw new BOException("Error al buscar por id empleado", e);
        }
    }


}
