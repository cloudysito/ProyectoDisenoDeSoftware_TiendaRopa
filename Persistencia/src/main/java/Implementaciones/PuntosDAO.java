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
import objetosnegocio.dominioPojo.Puntos;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import Interfaces.IPuntosDAO;
import com.mongodb.client.model.Updates;

/**
 *
 * @author riosr
 */
public class PuntosDAO implements IPuntosDAO{
    private static final String NOMBRE_COLLECTION = "Puntos";
    private final ConnectionMongoDB connection;

    public PuntosDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Puntos> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Puntos.class);
    }
    
    @Override
    public Puntos guardarPuntos(Puntos puntos) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Puntos> collection = getCollection(client);
            collection.insertOne(puntos);
            System.out.println("Puntos insertados con éxito.");
            return puntos;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar los puntos.", e.getCause());
        }
    }
    
    /**
     *
     * @param idPuntos
     * @return
     * @throws MongoException
     */
    
    @Override
    public Puntos buscarPorId(String idPuntos) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Puntos> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idPuntos));

            Puntos bonificacion = collection.find(filtroId).first();

            return bonificacion;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar puntos por ID: " + idPuntos, e.getCause());
        }
    }

}
