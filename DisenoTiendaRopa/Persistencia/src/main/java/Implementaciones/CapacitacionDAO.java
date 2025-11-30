/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.ICapacitacionDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import objetosnegocio.dominioPojo.Capacitacion;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class CapacitacionDAO implements ICapacitacionDAO{
    private static final String NOMBRE_COLLECTION = "Bonificacion";
    private final ConnectionMongoDB connection;

    public CapacitacionDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Capacitacion> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Capacitacion.class);
    }
    
    /**
     *
     * @param idCapacitacion
     * @return
     * @throws MongoException
     */
    
    @Override
    public Capacitacion buscarPorId(String idCapacitacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Capacitacion> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idCapacitacion));

            Capacitacion bonificacion = collection.find(filtroId).first();

            return bonificacion;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar ropa por ID: " + idCapacitacion, e.getCause());
        }
    }

    @Override
    public Capacitacion guardarEmpleado(Capacitacion capacitacion) throws MongoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Capacitacion modificarEmpleado(Capacitacion capacitacion) throws MongoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
