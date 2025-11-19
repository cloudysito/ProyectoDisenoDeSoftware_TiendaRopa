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

            RopaTalla ropaTallaEncontrada = collection.find(filtroId).first();

            return ropaTallaEncontrada;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar la relación RopaTalla por ID: " + id, e.getCause());
        }
    }

    @Override
    public RopaTalla buscarPorCodigo(String codigo) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<RopaTalla> collection = getCollection(client);
            Bson filtroCodigo = eq("codigo", codigo);
            return collection.find(filtroCodigo).first();
        } catch (MongoException e) {
            throw new MongoException("Error al buscar RopaTalla por código.", e.getCause());
        }
    }

}
