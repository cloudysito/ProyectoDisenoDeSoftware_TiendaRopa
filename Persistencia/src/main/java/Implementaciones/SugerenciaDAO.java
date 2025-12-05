/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.ISugerenciaDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import objetosnegocio.dominioPojo.Empleado;
import objetosnegocio.dominioPojo.Sugerencia;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementación del patrón Data Access Object (DAO) para la entidad {@code Sugerencia}.
 * <p>
 * Gestiona las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y consultas 
 * específicas (filtrado por estado, búsqueda por nombre) contra la colección "Sugerencia" en MongoDB.
 * </p>
 *
 * @author santi
 * @version 1.0
 */
public class SugerenciaDAO implements ISugerenciaDAO {

    /** Nombre de la colección de MongoDB que almacena las sugerencias. */
    private static final String NOMBRE_COLLECTION = "Sugerencia";
    
    /** Objeto para gestionar la conexión con MongoDB. */
    private final ConnectionMongoDB connection;

    /**
     * Constructor por defecto.
     * Inicializa la clase de conexión a MongoDB.
     */
    public SugerenciaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    /**
     * Método auxiliar para obtener la referencia a la colección de Sugerencias.
     * @param client La conexión activa al servidor de MongoDB.
     * @return La colección tipada para la entidad Sugerencia.
     */
    private MongoCollection<Sugerencia> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Sugerencia.class);
    }

    /**
     * Persiste un nuevo objeto Sugerencia en la base de datos.
     *
     * @param sugerencia El objeto {@code Sugerencia} a guardar.
     * @return La sugerencia guardada (posiblemente con el ID asignado).
     * @throws MongoException Si ocurre un error durante la inserción.
     */
    @Override
    public Sugerencia guardarSugerencia(Sugerencia sugerencia) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Sugerencia> collection = getCollection(client);
            collection.insertOne(sugerencia);
            System.out.println("Empleado insertado con éxito.");
            return sugerencia;

        } catch (MongoException e) {
            // Nota: El mensaje de error parece referirse a 'empleado', aunque se guarda una 'sugerencia'.
            throw new MongoException("Error al guardar al empleado.", e.getCause());
        }
    }

    /**
     * Modifica los atributos de una Sugerencia existente.
     * <p>
     * Utiliza el ID de la sugerencia para filtrar y aplica actualizaciones atómicas a 
     * campos como el empleado asociado, la descripción y el estado.
     * </p>
     *
     * @param sugerencia El objeto {@code Sugerencia} con los nuevos datos.
     * @return La sugerencia actualizada.
     * @throws MongoException Si ocurre un error durante la actualización.
     */
    @Override
    public Sugerencia modificarSugerencia(Sugerencia sugerencia) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Sugerencia> collection = getCollection(client);

            Bson filtroId = eq("_id", sugerencia.getId());

            // Combinación de las actualizaciones necesarias
            Bson actualizaciones = Updates.combine(
                    Updates.set("empleado", sugerencia.getEmpleado()),
                    Updates.set("descripcion", sugerencia.getDescripcion()),
                    Updates.set("estado", sugerencia.getEstado()),
                    Updates.set("fechaPublicacion", sugerencia.getFechaPublicacion())
            );

            collection.updateOne(filtroId, actualizaciones);

            System.out.println("Sugerencia actualizada con éxito.");
            return sugerencia;

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar la sugerencia.", e.getCause());
        }
    }

    /**
     * Busca una Sugerencia por su identificador único (ID de MongoDB).
     *
     * @param idBonificacion El ID de tipo {@code String} de la sugerencia a buscar.
     * @return El objeto {@code Sugerencia} encontrado, o {@code null} si no existe.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public Sugerencia buscarPorId(String idBonificacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Sugerencia> collection = getCollection(client);

            // Convierte el ID String a ObjectId para la búsqueda
            Bson filtroId = eq("_id", new ObjectId(idBonificacion));

            Sugerencia sugerencia = collection.find(filtroId).first();

            return sugerencia;

        } catch (MongoException e) {
            // Nota: El mensaje de error parece referirse a 'empleado', aunque se busca una 'sugerencia'.
            throw new MongoException("Error al buscar empleado por ID: " + idBonificacion, e.getCause());
        }
    }

    /**
     * Recupera una lista de todas las sugerencias registradas en la base de datos.
     *
     * @return Una lista de {@code Sugerencia}.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Sugerencia> buscarTodos() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<Sugerencia> collection = getCollection(client);
            return collection.find().into(new ArrayList<>());
        } catch (Exception e) {
            // Nota: El mensaje de error parece referirse a 'empleados', aunque se buscan 'sugerencias'.
            throw new MongoException("Error al buscar todos los empleados", e);
        }
    }

    /**
     * Realiza una búsqueda de sugerencias por el nombre del empleado asociado.
     * <p>
     * Utiliza una expresión regular insensible a mayúsculas ("i") sobre el campo 'nombre' del empleado.
     * </p>
     *
     * @param nombreEmpleado El nombre o parte del nombre a buscar.
     * @return Una lista de {@code Sugerencia} que coinciden con el filtro.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Sugerencia> buscarPorNombre(String nombreEmpleado) {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Sugerencia> collection = getCollection(client);

            // Filtro de expresión regular para buscar en el campo 'nombre' (asociado al empleado)
            Bson filtroNombre = Filters.regex("nombre", nombreEmpleado, "i");

            List<Sugerencia> listaResultados = collection.find(filtroNombre).into(new ArrayList<>());

            return listaResultados;

        } catch (MongoException e) {
            // Nota: El mensaje de error parece referirse a 'ropa', aunque se buscan 'sugerencias'.
            throw new MongoException("Error al buscar ropa por ID: " + nombreEmpleado, e.getCause());
        }
    }

    /**
     * Busca sugerencias que coincidan con un estado específico.
     * <p>
     * Utiliza una expresión regular para asegurar que la coincidencia sea exacta
     * (con {@code ^...$}) e insensible a mayúsculas ("i").
     * </p>
     *
     * @param estado El estado a buscar (ej. "Pendiente", "Aceptada").
     * @return Una lista de {@code Sugerencia} que coinciden con el estado.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    public List<Sugerencia> buscarPorEstado(String estado) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<Sugerencia> collection = getCollection(client);

            // Filtro regex para coincidencia exacta e insensible a mayúsculas
            Bson filtroEstado = Filters.regex("estado", "^" + estado + "$", "i");

            return collection.find(filtroEstado).into(new ArrayList<>());

        } catch (MongoException e) {
            throw new MongoException("Error al buscar sugerencias por estado: " + estado, e.getCause());
        }
    }

    /**
     * Actualiza únicamente el campo {@code estado} de una sugerencia específica.
     *
     * @param idSugerencia El ID de la sugerencia a modificar.
     * @param nuevoEstado El nuevo valor del estado (ej. "Aceptada").
     * @return {@code true} si la actualización afectó a al menos un documento, {@code false} en caso contrario.
     * @throws MongoException Si ocurre un error durante la actualización.
     */
    public boolean actualizarEstado(String idSugerencia, String nuevoEstado) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<Sugerencia> collection = getCollection(client);

            // Filtra por el ID
            Bson filtroId = Filters.eq("_id", new org.bson.types.ObjectId(idSugerencia));

            // Define la actualización solo para el campo 'estado'
            Bson actualizacion = Updates.set("estado", nuevoEstado);

            // Ejecuta la actualización
            UpdateResult resultado = collection.updateOne(filtroId, actualizacion);

            // Devuelve verdadero si se modificó al menos un documento
            return resultado.getModifiedCount() > 0;

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar el estado de la sugerencia: " + idSugerencia, e.getCause());
        }
    }

}