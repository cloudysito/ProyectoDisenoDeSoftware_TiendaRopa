/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.IRecompenzaDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import objetosnegocio.dominioPojo.Recompenza;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public abstract class RecompenzaDAO implements IRecompenzaDAO{
    private static final String NOMBRE_COLLECTION = "Bonificacion";
    private final ConnectionMongoDB connection;

    public RecompenzaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Recompenza> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Recompenza.class);
    }
    
    /**
     *
     * @param idCapacitacion
     * @return
     * @throws MongoException
     */
    
    @Override
    public Recompenza buscarPorId(String idRecompenza) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Recompenza> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idRecompenza));

            Recompenza bonificacion = collection.find(filtroId).first();

            return bonificacion;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar ropa por ID: " + idRecompenza, e.getCause());
        }
    }
}
