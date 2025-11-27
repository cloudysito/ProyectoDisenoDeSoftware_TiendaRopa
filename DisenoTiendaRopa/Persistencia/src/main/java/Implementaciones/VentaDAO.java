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
import objetosnegocio.dominioPojo.Venta;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author garfi
 */
public class VentaDAO implements IVentaDAO {

    private static final String NOMBRE_COLLECTION = "Venta";
    private final ConnectionMongoDB connection;

    public VentaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Venta> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Venta.class);
    }

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

    @Override
    public Venta modificarVenta(Venta venta) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);

            Bson filtroId = eq("_id", venta.getId());

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

    @Override
    public Venta eliminarVenta(Venta venta) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);

            Bson filtroId = eq("_id", venta.getId());

            collection.deleteOne(filtroId);
            System.out.println("Venta eliminada con exito.");
            return venta;

        } catch (MongoException e) {
            throw new MongoException("Error al eliminar la venta.", e.getCause());
        }
    }

    @Override
    public Venta buscarPorId(String idVenta) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idVenta));

            Venta doc = collection.find(filtroId).first();

            return doc;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar venta por ID: " + idVenta, e.getCause());
        }
    }

}
