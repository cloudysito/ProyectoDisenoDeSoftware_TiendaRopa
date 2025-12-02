/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import objetosnegocio.dominioPojo.Recompensa;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import Interfaces.IRecompensaDAO;

/**
 *
 * @author riosr
 */
public class RecompensaDAO implements IRecompensaDAO{
    private static final String NOMBRE_COLLECTION = "Recompensa";
    private final ConnectionMongoDB connection;

    public RecompensaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Recompensa> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Recompensa.class);
    }
    
    @Override
    public Recompensa guardarRecompensa(Recompensa recompensa) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Recompensa> collection = getCollection(client);
            collection.insertOne(recompensa);
            System.out.println("Recompensa insertada con éxito.");
            return recompensa;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la recompensa.", e.getCause());
        }
    }
    
    /**
     *
     * @param idRecompensa
     * @return
     * @throws MongoException
     */
    
    @Override
    public Recompensa buscarPorId(String idRecompensa) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Recompensa> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idRecompensa));

            Recompensa recompensa = collection.find(filtroId).first();

            return recompensa;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar recompensa por ID: " + idRecompensa, e.getCause());
        }
    }

}
