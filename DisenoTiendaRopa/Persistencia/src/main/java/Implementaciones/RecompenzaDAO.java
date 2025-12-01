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
import objetosnegocio.dominioPojo.Recompensa;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class RecompenzaDAO implements IRecompenzaDAO{
    private static final String NOMBRE_COLLECTION = "Bonificacion";
    private final ConnectionMongoDB connection;

    public RecompenzaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Recompensa> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Recompensa.class);
    }
    
    /**
     *
     * @param idCapacitacion
     * @return
     * @throws MongoException
     */
    
    @Override
    public Recompensa buscarPorId(String idRecompenza) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Recompensa> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idRecompenza));

            Recompensa bonificacion = collection.find(filtroId).first();

            return bonificacion;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar ropa por ID: " + idRecompenza, e.getCause());
        }
    }

    @Override
    public Recompensa guardarEmpleado(Recompensa recompenza) throws MongoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Recompensa modificarEmpleado(Recompensa recompenza) throws MongoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
