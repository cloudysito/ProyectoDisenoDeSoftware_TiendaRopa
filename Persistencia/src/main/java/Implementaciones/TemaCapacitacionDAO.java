/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.ITemaCapacitacionDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import objetosnegocio.dominioPojo.TemaCapacitacion;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementación del patrón Data Access Object (DAO) para la entidad {@code TemaCapacitacion}.
 * <p>
 * Se encarga de las operaciones de persistencia (guardar y buscar) contra la colección
 * "TemaCapacitacion" en la base de datos MongoDB, utilizando la conexión configurada.
 * </p>
 *
 * @author riosr
 * @version 1.0
 */
public class TemaCapacitacionDAO implements ITemaCapacitacionDAO {
    
    /** Nombre de la colección de MongoDB que almacena los temas de capacitación. */
    private static final String NOMBRE_COLLECTION = "TemaCapacitacion";
    
    /** Objeto para gestionar la conexión con MongoDB. */
    private final ConnectionMongoDB connection;

    /**
     * Constructor por defecto.
     * Inicializa el gestor de conexión a la base de datos.
     */
    public TemaCapacitacionDAO() {
        this.connection = new ConnectionMongoDB();
    }

    /**
     * Método auxiliar para obtener la referencia a la colección de Temas de Capacitación.
     * @param client La conexión activa al servidor de MongoDB.
     * @return La colección tipada para la entidad TemaCapacitacion.
     */
    private MongoCollection<TemaCapacitacion> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, TemaCapacitacion.class);
    }
    
    /**
     * Persiste un nuevo objeto TemaCapacitacion en la base de datos.
     *
     * @param temaCapacitacion El objeto {@code TemaCapacitacion} a guardar.
     * @return El tema de capacitación guardado (posiblemente con el ID asignado).
     * @throws MongoException Si ocurre un error durante la inserción.
     */
    @Override
    public TemaCapacitacion guardarTemaCapacitacion(TemaCapacitacion temaCapacitacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<TemaCapacitacion> collection = getCollection(client);
            collection.insertOne(temaCapacitacion);
            System.out.println("Tema de capacitacion insertado con éxito.");
            return temaCapacitacion;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar el tema de capacitacion.", e.getCause());
        }
    }
    
    /**
     * Busca un Tema de Capacitación por su identificador único (ID de MongoDB).
     *
     * @param idTemaCapacitacion El identificador ({@code String}) del tema a buscar.
     * @return El objeto {@code TemaCapacitacion} encontrado, o {@code null} si no existe.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public TemaCapacitacion buscarPorId(String idTemaCapacitacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<TemaCapacitacion> collection = getCollection(client);

            // Convierte el ID String a ObjectId para la búsqueda
            Bson filtroId = eq("_id", new ObjectId(idTemaCapacitacion));

            TemaCapacitacion temaCapacitacion = collection.find(filtroId).first();

            return temaCapacitacion;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar tema de capacitacion por ID: " + idTemaCapacitacion, e.getCause());
        }
    }
}