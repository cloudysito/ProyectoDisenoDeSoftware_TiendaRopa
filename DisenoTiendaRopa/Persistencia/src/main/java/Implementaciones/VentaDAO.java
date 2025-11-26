/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.IVentaDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mycompany.objetosnegocio.dominioPojo.Venta;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author garfi
 */
public class VentaDAO implements IVentaDAO {

    private static final String NOMBRE_COLLECTION = "Venta";
    private final ConnectionMongoDB connection;
    
    public VentaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Venta> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Venta.class);
    }

    @Override
    public Venta guardarVenta(Venta venta) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);
            
            collection.insertOne(venta);
            System.out.println("Venta insertada con éxito.");

            return venta;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la venta.", e.getCause());
        }
    }

    @Override
    public Venta buscarPorId(String idVenta) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idVenta));

            Venta doc = collection.find(filtroId).first();

            return doc;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar venta por ID: " + idVenta, e.getCause());
        }
    }

}
