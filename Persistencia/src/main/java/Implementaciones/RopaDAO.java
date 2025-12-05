/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.IRopaDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.List;
import objetosnegocio.dominioPojo.Ropa;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementación del patrón Data Access Object (DAO) para la entidad
 * {@code Ropa}.
 * <p>
 * Gestiona todas las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y
 * consultas de inventario relativas a la definición base de las prendas
 * (nombre, precio, descripción, etc.) en la colección "Ropa" de MongoDB.
 * </p>
 *
 * @author garfi
 * @version 1.0
 */
public class RopaDAO implements IRopaDAO {

    /**
     * Nombre de la colección de MongoDB que almacena las prendas base.
     */
    private static final String NOMBRE_COLLECTION = "Ropa";

    /**
     * Objeto para gestionar la conexión con MongoDB.
     */
    private final ConnectionMongoDB connection;

    /**
     * Constructor por defecto. Inicializa la clase de conexión a MongoDB.
     */
    public RopaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    /**
     * Método auxiliar para obtener la referencia a la colección de Ropa.
     *
     * @param client La conexión activa al servidor de MongoDB.
     * @return La colección tipada para la entidad Ropa.
     */
    private MongoCollection<Ropa> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Ropa.class);
    }

    /**
     * Persiste un nuevo objeto Ropa en la base de datos.
     *
     * @param ropa El objeto {@code Ropa} a guardar.
     * @return La prenda guardada (posiblemente con el ID asignado).
     * @throws MongoException Si ocurre un error durante la inserción.
     */
    @Override
    public Ropa guardarRopa(Ropa ropa) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);
            collection.insertOne(ropa);
            System.out.println("Ropa insertada con exito.");
            return ropa;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la ropa.", e.getCause());
        }
    }

    /**
     * Modifica los atributos de una Prenda existente.
     * <p>
     * Utiliza el ID de la prenda para filtrar y aplica múltiples
     * actualizaciones atómicas a campos como nombre, precio, descripción, etc.
     * </p>
     *
     * @param ropa El objeto {@code Ropa} con los nuevos datos.
     * @return La prenda actualizada.
     * @throws MongoException Si ocurre un error durante la actualización.
     */
    @Override
    public Ropa modificarRopa(Ropa ropa) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            // Filtro por el ID de la prenda
            Bson filtroId = eq("_id", ropa.getId());

            // Combinación de todas las actualizaciones
            Bson actualizaciones = Updates.combine(
                    Updates.set("nombreArticulo", ropa.getNombreArticulo()),
                    Updates.set("descripcion", ropa.getDescripcion()),
                    Updates.set("urlImagen", ropa.getUrlImagen()),
                    Updates.set("precio", ropa.getPrecio()),
                    Updates.set("temporada", ropa.getTemporada()),
                    Updates.set("marca", ropa.getMarca()),
                    Updates.set("material", ropa.getMaterial())
            );

            collection.updateOne(filtroId, actualizaciones);

            System.out.println("Ropa actualizada con exito.");
            return ropa;

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar la ropa.", e.getCause());
        }
    }

    /**
     * Elimina una Prenda de la base de datos.
     *
     * @param ropa El objeto {@code Ropa} a eliminar (se elimina por su ID).
     * @return La prenda eliminada.
     * @throws MongoException Si ocurre un error durante la eliminación.
     */
    @Override
    public Ropa eliminarRopa(Ropa ropa) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            // Filtro por el ID de la prenda
            Bson filtroId = eq("_id", ropa.getId());

            collection.deleteOne(filtroId);
            System.out.println("Ropa eliminada con exito.");
            return ropa;

        } catch (MongoException e) {
            throw new MongoException("Error al eliminar la ropa.", e.getCause());
        }
    }

    /**
     * Busca una Prenda por su identificador único (ID de MongoDB).
     *
     * @param id El ID de tipo {@code String} de la entidad a buscar.
     * @return El objeto {@code Ropa} encontrado, o {@code null} si no existe.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public Ropa buscarPorId(String id) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            // Convierte el ID String a ObjectId para la búsqueda
            Bson filtroId = eq("_id", new ObjectId(id));

            Ropa ropa = collection.find(filtroId).first();

            return ropa;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar ropa por ID: " + id, e.getCause());
        }
    }

    /**
     * Realiza una búsqueda de prendas por nombre utilizando una expresión
     * regular insensible a mayúsculas.
     *
     * @param nombreArticulo El nombre o parte del nombre a buscar.
     * @return Una lista de {@code Ropa} que coinciden con el nombre.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Ropa> buscarPorNombre(String nombreArticulo) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            // Filtro de expresión regular insensible a mayúsculas ("i")
            Bson filtroNombre = Filters.regex("nombreArticulo", nombreArticulo, "i");

            List<Ropa> listaResultados = collection.find(filtroNombre).into(new ArrayList<>());

            return listaResultados;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar ropa por nombre: " + nombreArticulo, e.getCause());
        }
    }

    /**
     * Recupera una lista de todas las prendas base registradas en el catálogo.
     *
     * @return Una lista de {@code Ropa}.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Ropa> buscarTodos() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            List<Ropa> listaResultados = collection.find().into(new ArrayList<>());

            return listaResultados;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar toda la ropa del catálogo", e.getCause());
        }
    }

}
