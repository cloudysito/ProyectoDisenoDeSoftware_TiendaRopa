/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.IBonificacionDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import objetosnegocio.dominioPojo.Bonificacion;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementación del patrón Data Access Object (DAO) para la entidad {@code Bonificacion}.
 * <p>
 * Se encarga de las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) contra
 * la colección "Bonificacion" en la base de datos MongoDB. Gestiona la conexión
 * y mapea las operaciones a las funciones del driver de MongoDB.
 * </p>
 *
 * @author riosr
 * @version 1.0
 */
public class BonificacionDAO implements IBonificacionDAO {
    
    /** Nombre de la colección de MongoDB que almacena las bonificaciones. */
    private static final String NOMBRE_COLLECTION = "Bonificacion";
    
    /** Objeto para gestionar la conexión con MongoDB. */
    private final ConnectionMongoDB connection;

    /**
     * Constructor por defecto.
     * Inicializa el gestor de conexión a la base de datos.
     */
    public BonificacionDAO() {
        // Asumiendo que ConnectionMongoDB es una clase definida en el mismo proyecto.
        this.connection = new ConnectionMongoDB();
    }

    /**
     * Método auxiliar para obtener la referencia a la colección de Bonificaciones.
     * <p>
     * Utiliza la configuración de la base de datos y el mapeo al POJO {@code Bonificacion}.
     * </p>
     * * @param client La conexión activa al servidor de MongoDB.
     * @return La colección tipada para la entidad Bonificacion.
     */
    private MongoCollection<Bonificacion> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Bonificacion.class);
    }
    
    /**
     * Persiste un nuevo objeto Bonificación en la base de datos.
     * <p>
     * Abre una nueva conexión, inserta el documento y luego la cierra automáticamente.
     * </p>
     *
     * @param bonificacion El objeto {@code Bonificacion} a guardar.
     * @return La bonificación guardada (posiblemente con el ID generado).
     * @throws MongoException Si ocurre un error durante la inserción en la base de datos.
     */
    @Override
    public Bonificacion guardarBonificacion(Bonificacion bonificacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Bonificacion> collection = getCollection(client);
            collection.insertOne(bonificacion);
            System.out.println("Bonificacion insertada con éxito.");
            return bonificacion;

        } catch (MongoException e) {
            // Re-lanza la excepción como una excepción de dominio (no chequeada)
            throw new MongoException("Error al guardar la bonificacion.", e.getCause());
        }
    }
    
    /**
     * Modifica los atributos de una Bonificación existente.
     * <p>
     * Utiliza el ID de la bonificación para encontrar el documento y aplica las actualizaciones
     * utilizando los operadores de {@code Updates} de MongoDB.
     * </p>
     *
     * @param bonificacion El objeto {@code Bonificacion} con los nuevos datos.
     * @return La bonificación actualizada.
     * @throws MongoException Si ocurre un error durante la actualización en la base de datos.
     */
    @Override
    public Bonificacion modificarBonificacion(Bonificacion bonificacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Bonificacion> collection = getCollection(client);

            // Filtra por el campo _id utilizando el ID del POJO
            Bson filtroId = eq("_id", bonificacion.getIdBonificacion());

            // Combina todas las actualizaciones necesarias
            Bson actualizaciones = Updates.combine(
                    Updates.set("nombreEmpleado", bonificacion.getNombreEmpleado()),
                    Updates.set("nombreRecompensa", bonificacion.getNombreRecompensa()),
                    Updates.set("puntosTotales", bonificacion.getPuntosTotales())
            );

            collection.updateOne(filtroId, actualizaciones);

            System.out.println("Bonificacion actualizada con exito.");
            return bonificacion;

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar la bonificacion.", e.getCause());
        }
    }
    
    /**
     * Busca una Bonificación por su identificador único.
     *
     * @param idBonificacion El identificador ({@code String}) de la bonificación a buscar.
     * @return El objeto {@code Bonificacion} encontrado, o {@code null} si no existe.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public Bonificacion buscarPorId(String idBonificacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Bonificacion> collection = getCollection(client);

            // Crea un filtro para buscar por el ID convertido a ObjectId
            Bson filtroId = eq("_id", new ObjectId(idBonificacion));

            // Ejecuta la consulta y obtiene el primer resultado
            Bonificacion bonificacion = collection.find(filtroId).first();

            return bonificacion;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar bonificacion por ID: " + idBonificacion, e.getCause());
        }
    }
    
}