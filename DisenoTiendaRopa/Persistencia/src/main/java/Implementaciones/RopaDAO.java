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
public class RopaDAO implements IRopaDAO {

    private static final String NOMBRE_COLLECTION = "Ropa";
    private final ConnectionMongoDB connection;

    public RopaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Ropa> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Ropa.class);
    }

    @Override
    public Ropa guardarRopa(Ropa ropa) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            collection.insertOne(ropa);
            System.out.println("Ropa insertada con éxito.");

            return ropa;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la ropa.", e.getCause());
        }
    }

    @Override
    public Ropa buscarPorCodigoBarras(String codigoBarras) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            Bson filtroCodigoBarras = eq("codigoBarras", codigoBarras);

            Ropa ropaEncontrada = collection.find(filtroCodigoBarras).first();

            return ropaEncontrada;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar ropa por código de barras: " + codigoBarras, e.getCause());
        }
    }

    @Override
    public Ropa buscarPorId(String idRopa) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idRopa));

            Ropa ropaEncontrada = collection.find(filtroId).first();

            return ropaEncontrada;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar ropa por ID: " + idRopa, e.getCause());
        }
    }

    @Override
    public List<Ropa> buscarTodas() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            List<Ropa> listaRopa = new ArrayList<>();
            collection.find().into(listaRopa);

            System.out.println("Se encontraron " + listaRopa.size() + " prendas.");

            return listaRopa;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar todas las prendas.", e.getCause());
        }
    }

    @Override
    public void actualizarRopa(Ropa ropa) throws MongoException {

        if (ropa.getId() == null) {
            throw new MongoException("No se puede actualizar una prenda sin su ID.");
        }

        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(ropa.getId()));

            UpdateResult resultado = collection.replaceOne(filtroId, ropa);

            if (resultado.getModifiedCount() == 0) {
                if (resultado.getMatchedCount() == 0) {
                    throw new MongoException("No se encontró ninguna prenda con el ID: " + ropa.getId() + " para actualizar.");
                }
            } else {
                System.out.println("Se actualizó la prenda con ID: " + ropa.getId());
            }

        } catch (IllegalArgumentException e) {
            throw new MongoException("El ID de la prenda a actualizar no tiene el formato correcto.", e);

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar la prenda: " + ropa.getId(), e.getCause());
        }
    }

    @Override
    public void eliminarRopa(String idRopa) throws MongoException {

        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idRopa));

            DeleteResult resultado = collection.deleteOne(filtroId);

            if (resultado.getDeletedCount() == 0) {
                throw new MongoException("No se encontró la prenda con ID: " + idRopa + " para eliminar.");
            } else {
                System.out.println("Se eliminó la prenda con ID: " + idRopa + " exitosamente.");
            }

        } catch (IllegalArgumentException e) {
            throw new MongoException("El ID de la prenda a eliminar no tiene el formato correcto.", e);

        } catch (MongoException e) {
            throw new MongoException("Error al eliminar la prenda con ID: " + idRopa, e.getCause());
        }
    }

    

}
