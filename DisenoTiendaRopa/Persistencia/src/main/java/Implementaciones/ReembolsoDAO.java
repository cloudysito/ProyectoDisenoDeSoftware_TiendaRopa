/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.IReembolsoDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import objetosnegocio.dominioPojo.Reembolso;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author emiim
 */
public class ReembolsoDAO implements IReembolsoDAO {
    private static final String NOMBRE_COLLECTION = "Reembolso";
    private final ConnectionMongoDB connection;

    public ReembolsoDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Reembolso> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Reembolso.class);
    }

    @Override
    public Reembolso guardar(Reembolso devolucion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<Reembolso> collection = getCollection(client);
            if (devolucion.getId() == null) {
                devolucion.setId(new ObjectId());
            }
            collection.insertOne(devolucion);
            
            System.out.println("Devolución insertada con éxito: " + devolucion.getId());
            return devolucion;

        } catch (Exception e) {
            throw new MongoException("Error al guardar la devolución.", e);
        }
    }
    
    public Reembolso buscarPorId(String idDevolucion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Reembolso> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idDevolucion));

            Reembolso devolucion = collection.find(filtroId).first();

            return devolucion;

        } catch (Exception e) {
            throw new MongoException("Error al buscar devolución por ID: " + idDevolucion, e);
        }
    }
    
    public List<Reembolso> buscarTodas() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<Reembolso> collection = getCollection(client);
            return collection.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new MongoException("Error al buscar todas las devoluciones", e);
        }
    }
}
