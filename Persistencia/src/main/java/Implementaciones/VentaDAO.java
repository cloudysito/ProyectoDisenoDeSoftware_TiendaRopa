/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.IVentaDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.List;
import objetosnegocio.dominioPojo.Venta;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Implementación del patrón Data Access Object (DAO) para la entidad {@code Venta}.
 * <p>
 * Gestiona las operaciones CRUD y consultas específicas (búsqueda por ID y por folio) 
 * relacionadas con las transacciones de venta en la colección "Venta" de MongoDB.
 * </p>
 *
 * @author garfi
 * @version 1.0
 */
public class VentaDAO implements IVentaDAO {

    /** Nombre de la colección de MongoDB que almacena las ventas. */
    private static final String NOMBRE_COLLECTION = "Venta";
    
    /** Objeto para gestionar la conexión con MongoDB. */
    private final ConnectionMongoDB connection;

    /**
     * Constructor por defecto.
     * Inicializa la clase de conexión a MongoDB.
     */
    public VentaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    /**
     * Método auxiliar para obtener la referencia a la colección de Ventas.
     * @param client La conexión activa al servidor de MongoDB.
     * @return La colección tipada para la entidad Venta.
     */
    private MongoCollection<Venta> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Venta.class);
    }

    /**
     * Persiste un nuevo objeto Venta en la base de datos.
     *
     * @param venta El objeto {@code Venta} a guardar.
     * @return La venta guardada (posiblemente con el ID asignado).
     * @throws MongoException Si ocurre un error durante la inserción.
     */
    @Override
    public Venta guardarVenta(Venta venta) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);

            collection.insertOne(venta);
            System.out.println("Venta insertada con éxito.");

            return venta;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la venta.", e.getCause());
        }
    }

    /**
     * Modifica los atributos de una Venta existente.
     * <p>
     * Utiliza el ID de la venta para filtrar y aplica múltiples actualizaciones atómicas
     * a campos como el folio, fecha, total, método de pago y detalles de la venta.
     * </p>
     *
     * @param venta El objeto {@code Venta} con los nuevos datos.
     * @return La venta actualizada.
     * @throws MongoException Si ocurre un error durante la actualización.
     */
    @Override
    public Venta modificarVenta(Venta venta) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);

            // Filtro por el ID de la venta
            Bson filtroId = eq("_id", venta.getId());

            // Combinación de todas las actualizaciones
            Bson actualizaciones = Updates.combine(
                    Updates.set("folioVenta", venta.getFolioVenta()),
                    Updates.set("fechaHoraVenta", venta.getFechaHoraVenta()),
                    Updates.set("totalVenta", venta.getTotalVenta()),
                    Updates.set("metodoPago", venta.getMetodoPago()),
                    Updates.set("empleado", venta.getEmpleado()),
                    Updates.set("detalles", venta.getDetalles())
            );

            collection.updateOne(filtroId, actualizaciones);

            System.out.println("Venta actualizada con exito.");
            return venta;

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar la venta.", e.getCause());
        }
    }

    /**
     * Elimina una Venta de la base de datos.
     *
     * @param venta El objeto {@code Venta} a eliminar (se elimina por su ID).
     * @return La venta eliminada.
     * @throws MongoException Si ocurre un error durante la eliminación.
     */
    @Override
    public Venta eliminarVenta(Venta venta) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);

            // Filtro por el ID de la venta
            Bson filtroId = eq("_id", venta.getId());

            collection.deleteOne(filtroId);
            System.out.println("Venta eliminada con exito.");
            return venta;

        } catch (MongoException e) {
            throw new MongoException("Error al eliminar la venta.", e.getCause());
        }
    }

    /**
     * Busca una Venta por su identificador único (ID de MongoDB).
     *
     * @param idVenta El ID de tipo {@code String} de la entidad a buscar.
     * @return El objeto {@code Venta} encontrado, o {@code null} si no existe.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public Venta buscarPorId(String idVenta) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);

            // Convierte el ID String a ObjectId para la búsqueda
            Bson filtroId = eq("_id", new ObjectId(idVenta));

            Venta doc = collection.find(filtroId).first();

            return doc;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar venta por ID: " + idVenta, e.getCause());
        }
    }

    /**
     * Busca una Venta por su número de folio único.
     *
     * @param folio El número de folio de la venta a buscar.
     * @return El objeto {@code Venta} encontrado, o {@code null} si no existe.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public Venta buscarPorFolio(int folio) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);

            // Filtro por el campo 'folioVenta'
            Bson filtroId = eq("folioVenta", folio);

            Venta doc = collection.find(filtroId).first();

            return doc;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar venta por folio: " + folio, e.getCause());
        }
    }

    /**
     * Recupera una lista de todas las ventas registradas en la base de datos.
     *
     * @return Una lista de {@code Venta}.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public List<Venta> buscarTodas() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<Venta> collection = getCollection(client);
            return collection.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new MongoException("Error al buscar todas las ventas", e);
        }
    }
}