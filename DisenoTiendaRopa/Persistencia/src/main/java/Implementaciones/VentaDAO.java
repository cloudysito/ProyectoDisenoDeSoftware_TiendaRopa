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
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
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
    public Venta buscarPorId(String idVenta) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idVenta));

            Venta ventaEncontrada = collection.find(filtroId).first();

            return ventaEncontrada;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar venta por ID: " + idVenta, e.getCause());
        }
    }

    @Override
    public List<Venta> buscarTodas() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);

            List<Venta> listaVenta = new ArrayList<>();
            collection.find().into(listaVenta);

            System.out.println("Se encontraron " + listaVenta.size() + " ventas.");

            return listaVenta;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar todas las ventas.", e.getCause());
        }
    }

    @Override
    public void actualizarVenta(Venta venta) throws MongoException {
        if (venta.getId() == null) {
            throw new MongoException("No se puede actualizar una venta sin su ID.");
        }

        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(venta.getId()));

            UpdateResult resultado = collection.replaceOne(filtroId, venta);

            if (resultado.getModifiedCount() == 0) {
                if (resultado.getMatchedCount() == 0) {
                    throw new MongoException("No se encontró ninguna venta con el ID: " + venta.getId() + " para actualizar.");
                }
            } else {
                System.out.println("Se actualizó la venta con ID: " + venta.getId());
            }

        } catch (IllegalArgumentException e) {
            throw new MongoException("El ID de la venta a actualizar no tiene el formato correcto.", e);

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar venta: " + venta.getId(), e.getCause());
        }
    }

    @Override
    public void eliminarVenta(String idVenta) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idVenta));

            DeleteResult resultado = collection.deleteOne(filtroId);

            if (resultado.getDeletedCount() == 0) {
                throw new MongoException("No se encontró la venta con ID: " + idVenta + " para eliminar.");
            } else {
                System.out.println("Se eliminó la venta con ID: " + idVenta + " exitosamente.");
            }

        } catch (IllegalArgumentException e) {
            throw new MongoException("El ID de la venta a eliminar no tiene el formato correcto.", e);

        } catch (MongoException e) {
            throw new MongoException("Error al eliminar venta con ID: " + idVenta, e.getCause());
        }
    }

}
