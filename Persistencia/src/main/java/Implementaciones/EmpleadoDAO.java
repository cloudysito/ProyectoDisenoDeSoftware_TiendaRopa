/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.IEmpleadoDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.List;
import objetosnegocio.dominioPojo.Empleado;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementación del patrón Data Access Object (DAO) para la entidad {@code Empleado}.
 * <p>
 * Gestiona todas las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y consultas
 * específicas (búsqueda por nombre, inicio de sesión) contra la colección "Empleado" en MongoDB.
 * Encapsula la interacción con el driver de MongoDB.
 * </p>
 *
 * @author garfi
 * @version 1.0
 */
public class EmpleadoDAO implements IEmpleadoDAO {

    /** Nombre de la colección de MongoDB que almacena los empleados. */
    private static final String NOMBRE_COLLECTION = "Empleado";
    
    /** Objeto para gestionar la conexión con MongoDB. */
    private final ConnectionMongoDB connection;

    /**
     * Constructor por defecto.
     * Inicializa la clase de conexión a MongoDB.
     */
    public EmpleadoDAO() {
        this.connection = new ConnectionMongoDB();
    }

    /**
     * Método auxiliar para obtener la referencia a la colección de Empleados.
     * @param client La conexión activa al servidor de MongoDB.
     * @return La colección tipada para la entidad Empleado.
     */
    private MongoCollection<Empleado> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Empleado.class);
    }
    

    /**
     * Persiste un nuevo objeto Empleado en la base de datos.
     *
     * @param empleado El objeto {@code Empleado} a guardar.
     * @return El empleado guardado (posiblemente con el ID asignado).
     * @throws MongoException Si ocurre un error durante la inserción.
     */
    @Override
    public Empleado guardarEmpleado(Empleado empleado) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Empleado> collection = getCollection(client);
            collection.insertOne(empleado);
            System.out.println("Empleado insertado con éxito.");
            return empleado;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar al empleado.", e.getCause());
        }
    }
    
    /**
     * Modifica los atributos de un Empleado existente.
     * <p>
     * Utiliza el ID del empleado para filtrar y aplica múltiples actualizaciones atómicas
     * a todos los campos modificables.
     * </p>
     *
     * @param empleado El objeto {@code Empleado} con los nuevos datos.
     * @return El empleado actualizado.
     * @throws MongoException Si ocurre un error durante la actualización.
     */
    @Override
    public Empleado modificarEmpleado(Empleado empleado) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Empleado> collection = getCollection(client);

            // Filtro por el ID del empleado
            Bson filtroId = eq("_id", empleado.getId());

            // Combinación de todas las actualizaciones
            Bson actualizaciones = Updates.combine(
                    Updates.set("nombre", empleado.getNombre()),
                    Updates.set("apellidos", empleado.getApellidos()),
                    Updates.set("puesto", empleado.getPuesto()),
                    Updates.set("urlImagen", empleado.getUrlImagen()),
                    Updates.set("telefono", empleado.getTelefono()),
                    Updates.set("horario", empleado.getHorario()),
                    Updates.set("email", empleado.getEmail()),
                    Updates.set("salario", empleado.getSalario()),
                    Updates.set("fechaContratacion", empleado.getFechaContratacion()),
                    Updates.set("rfc", empleado.getRfc())
            );

            collection.updateOne(filtroId, actualizaciones);

            System.out.println("Empleado actualizado con exito.");
            return empleado;

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar al empleado.", e.getCause());
        }
    }

    /**
     * Elimina un Empleado de la base de datos.
     *
     * @param empleado El objeto {@code Empleado} a eliminar.
     * @return El empleado eliminado.
     * @throws MongoException Si ocurre un error durante la eliminación.
     */
    @Override
    public Empleado eliminarEmpleado(Empleado empleado) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Empleado> collection = getCollection(client);

            // Filtro por el ID del empleado
            Bson filtroId = eq("_id", empleado.getId());

            collection.deleteOne(filtroId);
            System.out.println("Empleado eliminado con exito.");
            return empleado;

        } catch (MongoException e) {
            throw new MongoException("Error al eliminar al empleado.", e.getCause());
        }
    }

    /**
     * Busca un Empleado por su identificador único (ID de MongoDB).
     *
     * @param idEmpleado El ID de tipo {@code String} de la entidad a buscar.
     * @return El objeto {@code Empleado} encontrado, o {@code null} si no existe.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public Empleado buscarPorId(String idEmpleado) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Empleado> collection = getCollection(client);

            // Convierte el ID String a ObjectId para la búsqueda
            Bson filtroId = eq("_id", new ObjectId(idEmpleado));

            Empleado empleado = collection.find(filtroId).first();

            return empleado;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar empleado por ID: " + idEmpleado, e.getCause());
        }
    }

    /**
     * Intenta iniciar sesión buscando un empleado que coincida con el correo y la contraseña.
     * <p>
     * Nota: Utiliza el campo "nombre" para el correo y "contrasenia" para la contraseña.
     * </p>
     *
     * @param correo Correo electrónico (asociado al campo 'nombre' en el filtro).
     * @param contrasenia Contraseña del empleado.
     * @return El objeto {@code Empleado} si las credenciales son correctas, o {@code null} en caso contrario.
     * @throws MongoException Si ocurre un error de conexión o consulta.
     */
    @Override
    public Empleado iniciarSesion(String correo, String contrasenia) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Empleado> collection = getCollection(client);

            // Filtro para buscar por correo y contraseña
            Bson filtro = and(
                    eq("nombre", correo),
                    eq("contrasenia", contrasenia)
            );

            // Buscar el empleado que coincida con los filtros
            Empleado empleado = collection.find(filtro).first();

            return empleado;

        } catch (MongoException e) {
            throw new MongoException("Error al iniciar sesión", e);
        }
}

    /**
     * Recupera una lista de todos los empleados en la base de datos.
     *
     * @return Una lista de {@code Empleado}.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Empleado> buscarTodos() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<Empleado> collection = getCollection(client);
            return collection.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new MongoException("Error al buscar todos los empleados", e);
        }
    }

    /**
     * Realiza una búsqueda de empleados por nombre utilizando una expresión regular insensible a mayúsculas.
     *
     * @param nombreEmpleado El nombre o parte del nombre a buscar.
     * @return Una lista de {@code Empleado} que coinciden con el filtro.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Empleado> buscarPorNombre(String nombreEmpleado) {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Empleado> collection = getCollection(client);

            // Filtro de expresión regular insensible a mayúsculas ("i")
            Bson filtroNombre = Filters.regex("nombreEmpleado", nombreEmpleado,"i");

            List<Empleado> listaResultados = collection.find(filtroNombre).into(new ArrayList<>());

            return listaResultados;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar ropa por ID: " + nombreEmpleado, e.getCause());
        }
    }

    /**
     * Busca un Empleado por sus credenciales (correo y contraseña).
     * <p>
     * Es funcionalmente idéntico a {@code iniciarSesion}, buscando una coincidencia 
     * exacta en los campos 'email' y 'contrasenia'.
     * </p>
     * * @param correo El correo electrónico del empleado.
     * @param contrasenia La contraseña del empleado.
     * @return El objeto {@code Empleado} si las credenciales son correctas, o {@code null}.
     * @throws MongoException Si ocurre un error de conexión o consulta.
     */
    @Override
    public Empleado buscarPorCredenciales(String correo, String contrasenia) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Empleado> collection = getCollection(client);

            // Filtro que combina las condiciones de correo y contraseña (AND)
            Bson filtro = and(
                    eq("nombre", correo), 
                    eq("contrasenia", contrasenia)
            );

            Empleado empleado = collection.find(filtro).first();

            return empleado;

        } catch (MongoException e) {
            throw new MongoException("Error al iniciar sesión", e);
    }
  }
}