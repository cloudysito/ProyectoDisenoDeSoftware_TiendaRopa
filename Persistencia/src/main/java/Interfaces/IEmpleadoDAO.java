/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import java.util.List;
import objetosnegocio.dominioPojo.Empleado;

/**
 *
 * @author garfi
 */
/**
 * Interfaz DAO para gestionar las operaciones de persistencia relacionadas con la entidad {@link Empleado}.
 * Permite realizar operaciones CRUD, autenticación y consultas específicas.
 */
public interface IEmpleadoDAO {

    /**
     * Guarda un nuevo empleado en la base de datos.
     *
     * @param empleado Objeto {@link Empleado} a almacenar.
     * @return El empleado guardado, incluyendo su ID generado.
     * @throws MongoException Si ocurre un error durante la operación.
     */
    Empleado guardarEmpleado(Empleado empleado) throws MongoException;

    /**
     * Modifica la información de un empleado existente.
     *
     * @param empleado Objeto {@link Empleado} con los datos actualizados.
     * @return El empleado modificado.
     * @throws MongoException Si ocurre un error al actualizar.
     */
    Empleado modificarEmpleado(Empleado empleado) throws MongoException;

    /**
     * Elimina un empleado de la base de datos.
     *
     * @param empleado Objeto {@link Empleado} que se desea eliminar.
     * @return El empleado eliminado.
     * @throws MongoException Si ocurre un error durante la eliminación.
     */
    Empleado eliminarEmpleado(Empleado empleado) throws MongoException;

    /**
     * Busca un empleado por su identificador.
     *
     * @param idEmpleado ID del empleado a consultar.
     * @return El empleado encontrado o null si no existe.
     * @throws MongoException Si ocurre un problema con la consulta.
     */
    Empleado buscarPorId(String idEmpleado) throws MongoException;

    /**
     * Permite iniciar sesión verificando el correo y la contraseña.
     *
     * @param correo Correo electrónico del empleado.
     * @param contrasenia Contraseña asociada al empleado.
     * @return El empleado correspondiente si las credenciales son correctas.
     * @throws MongoException Si ocurre un error durante la validación.
     */
    Empleado iniciarSesion(String correo, String contrasenia) throws MongoException;

    /**
     * Obtiene todos los empleados registrados.
     *
     * @return Lista de empleados.
     * @throws MongoException Si ocurre un error en la consulta.
     */
    List<Empleado> buscarTodos() throws MongoException;

    /**
     * Busca empleados cuyo nombre coincida parcial o totalmente con el valor proporcionado.
     *
     * @param nombreEmpleado Nombre del empleado a buscar.
     * @return Lista de empleados que coinciden con la búsqueda.
     */
    List<Empleado> buscarPorNombre(String nombreEmpleado);

    /**
     * Busca un empleado utilizando correo y contraseña.
     * Funcionalmente equivalente a {@link #iniciarSesion}.
     *
     * @param correo Correo electrónico del empleado.
     * @param contrasenia Contraseña del empleado.
     * @return El empleado encontrado si las credenciales coinciden.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    Empleado buscarPorCredenciales(String correo, String contrasenia) throws MongoException;

}
