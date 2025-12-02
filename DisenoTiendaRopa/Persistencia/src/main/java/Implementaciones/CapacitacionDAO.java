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
import com.mongodb.client.model.Updates;
import objetosnegocio.dominioPojo.Capacitacion;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author riosr
 */
public class CapacitacionDAO implements ICapacitacionDAO{
    private static final String NOMBRE_COLLECTION = "Capacitacion";
    private final ConnectionMongoDB connection;

    public CapacitacionDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Capacitacion> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Capacitacion.class);
    }
    
    @Override
    public Capacitacion guardarCapacitacion(Capacitacion capacitacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Capacitacion> collection = getCollection(client);
            collection.insertOne(capacitacion);
            System.out.println("Capacitacion insertada con éxito.");
            return capacitacion;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la capacitacion.", e.getCause());
        }
    }
    
    @Override
    public Capacitacion modificarCapacitacion(Capacitacion capacitacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Capacitacion> collection = getCollection(client);

            Bson filtroId = eq("_id", capacitacion.getIdCapacitacion());

            Bson actualizaciones = Updates.combine(
                    Updates.set("nombreEmpleado", capacitacion.getNombreEmpleado()),
                    Updates.set("temaCapacitacion", capacitacion.getTemaCapacitacion()),
                    Updates.set("estado", capacitacion.getEstado())
            );

            collection.updateOne(filtroId, actualizaciones);

            System.out.println("Capacitacion actualizada con exito.");
            return capacitacion;

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar la capacitacion.", e.getCause());
        }
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
            throw new MongoException("Error al buscar capacitacion por ID: " + idCapacitacion, e.getCause());
        }
    }

}
