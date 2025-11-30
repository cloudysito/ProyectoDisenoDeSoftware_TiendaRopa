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
import objetosnegocio.dominioPojo.BonificacionRecompenza;
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

    private MongoCollection<BonificacionRecompenza> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, BonificacionRecompenza.class);
    }
    
    /**
     *
     * @param idCapacitacion
     * @return
     * @throws MongoException
     */
    
    public BonificacionRecompenza buscarPorId(String idBonificacionRecompenza) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<BonificacionRecompenza> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idBonificacionRecompenza));

            BonificacionRecompenza bonificacion = collection.find(filtroId).first();

            return bonificacion;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar ropa por ID: " + idBonificacionRecompenza, e.getCause());
        }
    }

    @Override
    public BonificacionRecompenza guardarEmpleado(BonificacionRecompenza br) throws MongoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public BonificacionRecompenza modificarEmpleado(BonificacionRecompenza br) throws MongoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
