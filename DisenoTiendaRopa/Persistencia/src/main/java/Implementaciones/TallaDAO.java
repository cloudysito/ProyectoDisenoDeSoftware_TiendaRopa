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
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mycompany.objetosnegocio.dominioPojo.Talla;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author garfi
 */
public class TallaDAO implements ITallaDAO{
    
    private static final String NOMBRE_COLLECTION = "Talla";
    private final ConnectionMongoDB connection;

    public TallaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Talla> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Talla.class);
    }
    
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

    @Override
    public Talla buscarPorId(String idTalla) throws MongoException {
       try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Talla> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idTalla));

            Talla talla = collection.find(filtroId).first();

            return talla;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar talla por ID: " + idTalla, e.getCause());
        }
    }
}
