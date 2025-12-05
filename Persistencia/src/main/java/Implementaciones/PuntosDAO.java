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
import objetosnegocio.dominioPojo.Puntos;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import Interfaces.IPuntosDAO;
import com.mongodb.client.model.Updates;

/**
 * Implementación del patrón Data Access Object (DAO) para la entidad {@code Puntos}.
 * <p>
 * Se encarga de las operaciones de persistencia (guardar y buscar) contra la colección
 * "Puntos" en la base de datos MongoDB. Utiliza {@code ConnectionMongoDB} para la gestión de la conexión.
 * </p>
 *
 * @author riosr
 * @version 1.0
 */
public class PuntosDAO implements IPuntosDAO {
    
    /** Nombre de la colección de MongoDB que almacena la información de puntos. */
    private static final String NOMBRE_COLLECTION = "Puntos";
    
    /** Objeto para gestionar la conexión con MongoDB. */
    private final ConnectionMongoDB connection;

    /**
     * Constructor por defecto.
     * Inicializa el gestor de conexión a la base de datos.
     */
    public PuntosDAO() {
        this.connection = new ConnectionMongoDB();
    }

    /**
     * Método auxiliar para obtener la referencia a la colección de Puntos.
     * @param client La conexión activa al servidor de MongoDB.
     * @return La colección tipada para la entidad Puntos.
     */
    private MongoCollection<Puntos> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Puntos.class);
    }
    
    /**
     * Persiste un nuevo objeto Puntos en la base de datos.
     *
     * @param puntos El objeto {@code Puntos} a guardar.
     * @return El objeto de puntos guardado.
     * @throws MongoException Si ocurre un error durante la inserción en la base de datos.
     */
    @Override
    public Puntos guardarPuntos(Puntos puntos) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Puntos> collection = getCollection(client);
            collection.insertOne(puntos);
            System.out.println("Puntos insertados con éxito.");
            return puntos;

        } catch (MongoException e) {
            // Se asume que la excepción lanzada es la personalizada MongoException
            throw new MongoException("Error al guardar los puntos.", e.getCause());
        }
    }
    
    /**
     * Busca la entidad Puntos por su identificador único (ID de MongoDB).
     *
     * @param idPuntos El identificador ({@code String}) de la entidad a buscar.
     * @return El objeto {@code Puntos} encontrado, o {@code null} si no existe.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public Puntos buscarPorId(String idPuntos) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Puntos> collection = getCollection(client);

            // Crea un filtro para buscar por el ID convertido a ObjectId
            Bson filtroId = eq("_id", new ObjectId(idPuntos));

            // El resultado se mapea al POJO Puntos
            Puntos bonificacion = collection.find(filtroId).first();

            return bonificacion;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar puntos por ID: " + idPuntos, e.getCause());
        }
    }
    
    /**
     * *Nota sobre {@code modificarPuntos}:* La interfaz {@code IPuntosDAO} 
     * usualmente incluiría un método {@code modificarPuntos}. Si bien no está 
     * visible en el código proporcionado, la estructura y los imports de {@code Updates} 
     * sugieren que esta clase está diseñada para realizar modificaciones en el futuro.
     */
}