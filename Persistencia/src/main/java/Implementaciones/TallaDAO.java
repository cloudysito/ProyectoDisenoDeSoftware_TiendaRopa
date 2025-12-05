/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.ITallaDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.List;
import objetosnegocio.dominioPojo.Talla;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementación del patrón Data Access Object (DAO) para la entidad {@code Talla}.
 * <p>
 * Gestiona todas las operaciones CRUD y consultas relacionadas con las tallas de la ropa 
 * (ej. S, M, L, XXL) en la colección "Talla" de MongoDB.
 * </p>
 *
 * @author garfi
 * @version 1.0
 */
public class TallaDAO implements ITallaDAO {
    
    /** Nombre de la colección de MongoDB que almacena las tallas. */
    private static final String NOMBRE_COLLECTION = "Talla";
    
    /** Objeto para gestionar la conexión con MongoDB. */
    private final ConnectionMongoDB connection;

    /**
     * Constructor por defecto.
     * Inicializa la clase de conexión a MongoDB.
     */
    public TallaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    /**
     * Método auxiliar para obtener la referencia a la colección de Tallas.
     * @param client La conexión activa al servidor de MongoDB.
     * @return La colección tipada para la entidad Talla.
     */
    private MongoCollection<Talla> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Talla.class);
    }
    
    /**
     * Persiste un nuevo objeto Talla en la base de datos.
     *
     * @param talla El objeto {@code Talla} a guardar.
     * @return La talla guardada (posiblemente con el ID asignado).
     * @throws MongoException Si ocurre un error durante la inserción.
     */
    @Override
    public Talla guardarTalla(Talla talla) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Talla> collection = getCollection(client);
            collection.insertOne(talla);
            System.out.println("Talla insertada con éxito.");
            return talla;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la talla.", e.getCause());
        }
    }
    
    /**
     * Modifica los atributos de una Talla existente.
     * <p>
     * Utiliza el ID de la talla para filtrar y aplica actualizaciones a los campos modificables.
     * </p>
     *
     * @param talla El objeto {@code Talla} con los nuevos datos.
     * @return La talla actualizada.
     * @throws MongoException Si ocurre un error durante la actualización.
     */
    @Override
    public Talla modificarTalla(Talla talla) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Talla> collection = getCollection(client);

            // Filtro por el ID de la talla
            Bson filtroId = eq("_id", talla.getId());

            // Combinación de las actualizaciones (nombre y descripción)
            Bson actualizaciones = Updates.combine(
                    Updates.set("nombreTalla", talla.getNombreTalla()),
                    Updates.set("descripcion", talla.getDescripcion())
            );

            collection.updateOne(filtroId, actualizaciones);

            System.out.println("Talla actualizada con exito.");
            return talla;

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar la talla.", e.getCause());
        }
    }

    /**
     * Elimina una Talla de la base de datos.
     *
     * @param talla El objeto {@code Talla} a eliminar (se elimina por su ID).
     * @return La talla eliminada.
     * @throws MongoException Si ocurre un error durante la eliminación.
     */
    @Override
    public Talla eliminarTalla(Talla talla) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Talla> collection = getCollection(client);

            // Filtro por el ID de la talla
            Bson filtroId = eq("_id", talla.getId());

            collection.deleteOne(filtroId);
            System.out.println("Talla eliminada con exito.");
            return talla;

        } catch (MongoException e) {
            throw new MongoException("Error al eliminar la talla.", e.getCause());
        }
    }

    /**
     * Busca una Talla por su identificador único (ID de MongoDB).
     *
     * @param idTalla El ID de tipo {@code String} de la entidad a buscar.
     * @return El objeto {@code Talla} encontrado, o {@code null} si no existe.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public Talla buscarPorId(String idTalla) throws MongoException {
       try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Talla> collection = getCollection(client);

            // Convierte el ID String a ObjectId para la búsqueda
            Bson filtroId = eq("_id", new ObjectId(idTalla));

            Talla talla = collection.find(filtroId).first();

            return talla;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar talla por ID: " + idTalla, e.getCause());
        }
    }

    /**
     * Recupera una lista de todas las tallas registradas en el catálogo.
     *
     * @return Una lista de {@code Talla}.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Talla> consultarTallas() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
        
        MongoCollection<Talla> collection = getCollection(client);
        
        List<Talla> listaResultados = collection.find().into(new ArrayList<>());
        
        return listaResultados;

    } catch (MongoException e) {
        throw new MongoException("Error al buscar toda la ropa del catálogo", e.getCause());
    }
    }

}