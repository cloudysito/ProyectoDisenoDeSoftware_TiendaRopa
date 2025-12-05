/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import objetosnegocio.dominioPojo.Recompensa;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import Interfaces.IRecompensaDAO;

/**
 * Implementación del patrón Data Access Object (DAO) para la entidad {@code Recompensa}.
 * <p>
 * Se encarga de las operaciones de persistencia (guardar y buscar) contra la colección
 * "Recompensa" en la base de datos MongoDB. Utiliza la conexión configurada para interactuar
 * con la colección tipada.
 * </p>
 *
 * @author riosr
 * @version 1.0
 */
public class RecompensaDAO implements IRecompensaDAO{
    
    /** Nombre de la colección de MongoDB que almacena las recompensas. */
    private static final String NOMBRE_COLLECTION = "Recompensa";
    
    /** Objeto para gestionar la conexión con MongoDB. */
    private final ConnectionMongoDB connection;

    /**
     * Constructor por defecto.
     * Inicializa el gestor de conexión a la base de datos.
     */
    public RecompensaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    /**
     * Método auxiliar para obtener la referencia a la colección de Recompensas.
     * @param client La conexión activa al servidor de MongoDB.
     * @return La colección tipada para la entidad Recompensa.
     */
    private MongoCollection<Recompensa> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Recompensa.class);
    }
    
    /**
     * Persiste un nuevo objeto Recompensa en la base de datos.
     *
     * @param recompensa El objeto {@code Recompensa} a guardar.
     * @return La recompensa guardada (posiblemente con el ID asignado).
     * @throws MongoException Si ocurre un error durante la inserción en la base de datos.
     */
    @Override
    public Recompensa guardarRecompensa(Recompensa recompensa) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Recompensa> collection = getCollection(client);
            collection.insertOne(recompensa);
            System.out.println("Recompensa insertada con éxito.");
            return recompensa;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la recompensa.", e.getCause());
        }
    }
    
    /**
     * Busca una Recompensa por su identificador único (ID de MongoDB).
     *
     * @param idRecompensa El identificador ({@code String}) de la recompensa a buscar.
     * @return El objeto {@code Recompensa} encontrado, o {@code null} si no existe.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public Recompensa buscarPorId(String idRecompensa) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Recompensa> collection = getCollection(client);

            // Crea un filtro para buscar por el ID convertido a ObjectId
            Bson filtroId = eq("_id", new ObjectId(idRecompensa));

            // Ejecuta la consulta y obtiene el primer resultado
            Recompensa recompensa = collection.find(filtroId).first();

            return recompensa;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar recompensa por ID: " + idRecompensa, e.getCause());
        }
    }

}