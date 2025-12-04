/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.ITallaDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.List;
import objetosnegocio.dominioPojo.Talla;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author garfi
 */
public class TallaDAO implements ITallaDAO{
    
    private static final String NOMBRE_COLLECTION = "Talla";
    private final ConnectionMongoDB connection;

    public TallaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Talla> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Talla.class);
    }
    
    @Override
    public Talla guardarTalla(Talla talla) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Talla> collection = getCollection(client);
            collection.insertOne(talla);
            System.out.println("Talla insertada con éxito.");
            return talla;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la talla.", e.getCause());
        }
    }
    
    @Override
    public Talla modificarTalla(Talla talla) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Talla> collection = getCollection(client);

            Bson filtroId = eq("_id", talla.getId());

            Bson actualizaciones = Updates.combine(
                    Updates.set("nombreTalla", talla.getNombreTalla()),
                    Updates.set("descripcion", talla.getDescripcion())
            );

            collection.updateOne(filtroId, actualizaciones);

            System.out.println("Talla actualizada con exito.");
            return talla;

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar la talla.", e.getCause());
        }
    }

    @Override
    public Talla eliminarTalla(Talla talla) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Talla> collection = getCollection(client);

            Bson filtroId = eq("_id", talla.getId());

            collection.deleteOne(filtroId);
            System.out.println("Talla eliminada con exito.");
            return talla;

        } catch (MongoException e) {
            throw new MongoException("Error al eliminar la talla.", e.getCause());
        }
    }

    @Override
    public Talla buscarPorId(String idTalla) throws MongoException {
       try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Talla> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idTalla));

            Talla talla = collection.find(filtroId).first();

            return talla;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar talla por ID: " + idTalla, e.getCause());
        }
    }

    @Override
    public List<Talla> consultarTallas() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
        
        MongoCollection<Talla> collection = getCollection(client);
        
        List<Talla> listaResultados = collection.find().into(new ArrayList<>());
        
        return listaResultados;

    } catch (MongoException e) {
        throw new MongoException("Error al buscar toda la ropa del catálogo", e.getCause());
    }
    }

}
