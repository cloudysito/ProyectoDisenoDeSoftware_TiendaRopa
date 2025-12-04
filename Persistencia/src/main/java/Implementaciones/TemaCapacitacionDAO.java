/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.ITemaCapacitacionDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import objetosnegocio.dominioPojo.Bonificacion;
import objetosnegocio.dominioPojo.TemaCapacitacion;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class TemaCapacitacionDAO implements ITemaCapacitacionDAO{
    private static final String NOMBRE_COLLECTION = "TemaCapacitacion";
    private final ConnectionMongoDB connection;

    public TemaCapacitacionDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<TemaCapacitacion> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, TemaCapacitacion.class);
    }
    
    @Override
    public TemaCapacitacion guardarTemaCapacitacion(TemaCapacitacion temaCapacitacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<TemaCapacitacion> collection = getCollection(client);
            collection.insertOne(temaCapacitacion);
            System.out.println("Tema de capacitacion insertado con éxito.");
            return temaCapacitacion;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar el tema de capacitacion.", e.getCause());
        }
    }
    
    @Override
    public TemaCapacitacion buscarPorId(String idTemaCapacitacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<TemaCapacitacion> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idTemaCapacitacion));

            TemaCapacitacion temaCapacitacion = collection.find(filtroId).first();

            return temaCapacitacion;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar tema de capacitacion por ID: " + idTemaCapacitacion, e.getCause());
        }
    }

}
