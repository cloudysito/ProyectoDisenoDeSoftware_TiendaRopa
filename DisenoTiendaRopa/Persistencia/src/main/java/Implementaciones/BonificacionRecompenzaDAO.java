/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.IBonificacionRecompenzaDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import objetosnegocio.dominioPojo.Puntos;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class BonificacionRecompenzaDAO implements IBonificacionRecompenzaDAO{
    private static final String NOMBRE_COLLECTION = "Bonificacion";
    private final ConnectionMongoDB connection;

    public BonificacionRecompenzaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Puntos> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Puntos.class);
    }
    
    /**
     *
     * @param idCapacitacion
     * @return
     * @throws MongoException
     */
    
    public Puntos buscarPorId(String idBonificacionRecompenza) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Puntos> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idBonificacionRecompenza));

            Puntos bonificacion = collection.find(filtroId).first();

            return bonificacion;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar ropa por ID: " + idBonificacionRecompenza, e.getCause());
        }
    }

    @Override
    public Puntos guardarEmpleado(Puntos br) throws MongoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Puntos modificarEmpleado(Puntos br) throws MongoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
