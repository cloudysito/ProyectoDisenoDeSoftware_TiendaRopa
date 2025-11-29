/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.IRopaDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.List;
import objetosnegocio.dominioPojo.Ropa;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author garfi
 */
public class RopaDAO implements IRopaDAO {

    private static final String NOMBRE_COLLECTION = "Ropa";
    private final ConnectionMongoDB connection;

    public RopaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Ropa> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Ropa.class);
    }

    @Override
    public Ropa guardarRopa(Ropa ropa) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);
            collection.insertOne(ropa);
            System.out.println("Ropa insertada con exito.");
            return ropa;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la ropa.", e.getCause());
        }
    }    

    @Override
    public Ropa modificarRopa(Ropa ropa) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            Bson filtroId = eq("_id", ropa.getId());

            Bson actualizaciones = Updates.combine(
                    Updates.set("nombreArticulo", ropa.getNombreArticulo()),
                    Updates.set("descripcion", ropa.getDescripcion()),
                    Updates.set("precio", ropa.getPrecio()),
                    Updates.set("temporada", ropa.getTemporada()),
                    Updates.set("marca", ropa.getMarca()),
                    Updates.set("material", ropa.getMaterial())
            );

            collection.updateOne(filtroId, actualizaciones);

            System.out.println("Ropa actualizada con exito.");
            return ropa;

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar la ropa.", e.getCause());
        }
    }

    @Override
    public Ropa eliminarRopa(Ropa ropa) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            Bson filtroId = eq("_id", ropa.getId());

            collection.deleteOne(filtroId);
            System.out.println("Ropa eliminada con exito.");
            return ropa;

        } catch (MongoException e) {
            throw new MongoException("Error al eliminar la ropa.", e.getCause());
        }
    }
    
    @Override
    public Ropa buscarPorId(String id) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(id));

            Ropa ropa = collection.find(filtroId).first();

            return ropa;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar ropa por ID: " + id, e.getCause());
        }
    }

    @Override
    public List<Ropa> buscarPorNombre(String nombreArticulo) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            Bson filtroNombre = Filters.regex("nombreArticulo", nombreArticulo,"i");

            List<Ropa> listaResultados = collection.find(filtroNombre).into(new ArrayList<>());

            return listaResultados;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar ropa por ID: " + nombreArticulo, e.getCause());
        }
    }

    @Override
    public List<Ropa> buscarTodos() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
        
        MongoCollection<Ropa> collection = getCollection(client);
        
        List<Ropa> listaResultados = collection.find().into(new ArrayList<>());
        
        return listaResultados;

    } catch (MongoException e) {
        throw new MongoException("Error al buscar toda la ropa del catálogo", e.getCause());
    }
    }
    
    

}
