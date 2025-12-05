/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.IReembolsoDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import objetosnegocio.dominioPojo.Reembolso;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementación del patrón Data Access Object (DAO) para la entidad {@code Reembolso} (Devolución).
 * <p>
 * Gestiona las operaciones de persistencia (guardar y buscar) contra la colección
 * "Reembolso" en la base de datos MongoDB, utilizando {@code ConnectionMongoDB} para la gestión de la conexión.
 * </p>
 *
 * @author emiim
 * @version 1.0
 */
public class ReembolsoDAO implements IReembolsoDAO {
    
    /** Nombre de la colección de MongoDB que almacena los reembolsos. */
    private static final String NOMBRE_COLLECTION = "Reembolso";
    
    /** Objeto para gestionar la conexión con MongoDB. */
    private final ConnectionMongoDB connection;

    /**
     * Constructor por defecto.
     * Inicializa el gestor de conexión a la base de datos.
     */
    public ReembolsoDAO() {
        this.connection = new ConnectionMongoDB();
    }

    /**
     * Método auxiliar para obtener la referencia a la colección de Reembolsos.
     * @param client La conexión activa al servidor de MongoDB.
     * @return La colección tipada para la entidad Reembolso.
     */
    private MongoCollection<Reembolso> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Reembolso.class);
    }

    /**
     * Persiste un nuevo objeto Reembolso (Devolución) en la base de datos.
     * <p>
     * Si el objeto no tiene un ID asignado, le asigna un nuevo {@code ObjectId} antes de la inserción.
     * </p>
     *
     * @param devolucion El objeto {@code Reembolso} a guardar.
     * @return El reembolso guardado (con el ID de MongoDB asignado).
     * @throws MongoException Si ocurre un error durante la inserción en la base de datos.
     */
    @Override
    public Reembolso guardar(Reembolso devolucion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<Reembolso> collection = getCollection(client);
            // Asigna un ID si es una nueva inserción
            if (devolucion.getId() == null) {
                devolucion.setId(new ObjectId());
            }
            collection.insertOne(devolucion);
            
            System.out.println("Devolución insertada con éxito: " + devolucion.getId());
            return devolucion;

        } catch (Exception e) {
            // Envuelve la excepción para mantener la abstracción de la capa de persistencia
            throw new MongoException("Error al guardar la devolución.", e);
        }
    }
    
    /**
     * Busca un Reembolso por su identificador único (ID de MongoDB).
     *
     * @param idDevolucion El identificador ({@code String}) de la devolución a buscar.
     * @return El objeto {@code Reembolso} encontrado, o {@code null} si no existe.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    public Reembolso buscarPorId(String idDevolucion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Reembolso> collection = getCollection(client);

            // Crea un filtro para buscar por el ID convertido a ObjectId
            Bson filtroId = eq("_id", new ObjectId(idDevolucion));

            Reembolso devolucion = collection.find(filtroId).first();

            return devolucion;

        } catch (Exception e) {
            throw new MongoException("Error al buscar devolución por ID: " + idDevolucion, e);
        }
    }
    
    /**
     * Recupera una lista de todos los reembolsos registrados en la base de datos.
     *
     * @return Una lista de {@code Reembolso}.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    public List<Reembolso> buscarTodas() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<Reembolso> collection = getCollection(client);
            // Recupera todos los documentos y los mapea a una lista de Reembolso
            return collection.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new MongoException("Error al buscar todas las devoluciones", e);
        }
    }
}