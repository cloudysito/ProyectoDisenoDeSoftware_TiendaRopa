/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import Interfaces.IRopaTallaDAO;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.List;
import objetosnegocio.dominioPojo.RopaTalla;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author garfi
 */
public class RopaTallaDAO implements IRopaTallaDAO {

    private static final String NOMBRE_COLLECTION = "RopaTalla";
    private final ConnectionMongoDB connection;

    public RopaTallaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<RopaTalla> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, RopaTalla.class);
    }

    @Override
    public RopaTalla guardar(RopaTalla rt) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<RopaTalla> collection = getCollection(client);

            collection.insertOne(rt);
            System.out.println("Relación RopaTalla guardada con ID: " + rt.getId());
            return rt;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la relación RopaTalla.", e.getCause());
        }
    }

    @Override
    public RopaTalla buscarPorId(String id) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<RopaTalla> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(id));

            RopaTalla rp = collection.find(filtroId).first();

            return rp;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar la relación RopaTalla por ID: " + id, e.getCause());
        }
    }

    @Override
    public RopaTalla buscarPorCodigo(String codigo) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<RopaTalla> collection = getCollection(client);
            Bson filtroCodigo = eq("codigo", codigo);

            RopaTalla rt = collection.find(filtroCodigo).first();

            return rt;
        } catch (MongoException e) {
            throw new MongoException("Error al buscar RopaTalla por código.", e.getCause());
        }
    }

    @Override
    public List<RopaTalla> buscarTodos() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<RopaTalla> collection = getCollection(client);
            return collection.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new MongoException("Error buscando inventario", e);
        }
    }

    @Override
    public void reducirStock(ObjectId idRopaTalla, int cantidadVendida) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<RopaTalla> collection = getCollection(client);

            Bson filtroId = eq("_id", idRopaTalla);

            Bson actualizacion = Updates.inc("cantidad", -cantidadVendida);

            collection.updateOne(filtroId, actualizacion);

            System.out.println("Stock actualizado con exito.");

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar el stock.", e.getCause());
        }
    }

}
