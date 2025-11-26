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
import com.mycompany.objetosnegocio.dominioPojo.Ropa;
import org.bson.Document;
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
            System.out.println("Ropa insertada con exito.");
            return ropa;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la ropa.", e.getCause());
        }
    }

    @Override
    public Ropa buscarPorId(String id) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(id));

            Ropa ropa = collection.find(filtroId).first();

            return ropa;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar ropa por ID: " + id, e.getCause());
        }
    }

    

}
