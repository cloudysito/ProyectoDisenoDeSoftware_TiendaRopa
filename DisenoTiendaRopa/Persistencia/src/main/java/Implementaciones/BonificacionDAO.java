/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.IBonificacionDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import objetosnegocio.dominioPojo.Bonificacion;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class BonificacionDAO implements IBonificacionDAO {
    private static final String NOMBRE_COLLECTION = "Bonificacion";
    private final ConnectionMongoDB connection;

    public BonificacionDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Bonificacion> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Bonificacion.class);
    }
    
    @Override
    public Bonificacion guardarBonificacion(Bonificacion bonificacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Bonificacion> collection = getCollection(client);
            collection.insertOne(bonificacion);
            System.out.println("Bonificacion insertada con éxito.");
            return bonificacion;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la bonificacion.", e.getCause());
        }
    }
    
    @Override
    public Bonificacion modificarBonificacion(Bonificacion bonificacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Bonificacion> collection = getCollection(client);

            Bson filtroId = eq("_id", bonificacion.getIdBonificacion());

            Bson actualizaciones = Updates.combine(
                    Updates.set("nombreEmpleado", bonificacion.getNombreEmpleado()),
                    Updates.set("nombreRecompensa", bonificacion.getNombreRecompensa()),
                    Updates.set("puntosTotales", bonificacion.getPuntosTotales())
            );

            collection.updateOne(filtroId, actualizaciones);

            System.out.println("Bonificacion actualizada con exito.");
            return bonificacion;

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar la bonificacion.", e.getCause());
        }
    }
    
    /**
     *
     * @param idBonificacion
     * @return
     * @throws MongoException
     */
    
    @Override
    public Bonificacion buscarPorId(String idBonificacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Bonificacion> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idBonificacion));

            Bonificacion bonificacion = collection.find(filtroId).first();

            return bonificacion;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar bonificacion por ID: " + idBonificacion, e.getCause());
        }
    }
    
}
