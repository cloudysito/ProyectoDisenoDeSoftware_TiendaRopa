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
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
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
    public Talla buscarPorId(String idTalla) throws MongoException {
       try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Talla> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idTalla));

            Talla tallaEncontrada = collection.find(filtroId).first();

            return tallaEncontrada;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar talla por ID: " + idTalla, e.getCause());
        }
    }

    @Override
    public List<Talla> buscarTodas() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Talla> collection = getCollection(client);

            List<Talla> listaTalla = new ArrayList<>();
            collection.find().into(listaTalla);

            System.out.println("Se encontraron " + listaTalla.size() + " tallas.");

            return listaTalla;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar todas las tallas.", e.getCause());
        }
    }

    @Override
    public void actualizarTalla(Talla talla) throws MongoException {
        if (talla.getId() == null) {
            throw new MongoException("No se puede actualizar una talla sin su ID.");
        }

        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Talla> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(talla.getId()));

            UpdateResult resultado = collection.replaceOne(filtroId, talla);

            if (resultado.getModifiedCount() == 0) {
                if (resultado.getMatchedCount() == 0) {
                    throw new MongoException("No se encontró ninguna talla con el ID: " + talla.getId() + " para actualizar.");
                }
            } else {
                System.out.println("Se actualizó la talla con ID: " + talla.getId());
            }

        } catch (IllegalArgumentException e) {
            throw new MongoException("El ID de la talla a actualizar no tiene el formato correcto.", e);

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar talla: " + talla.getId(), e.getCause());
        }
    }

    @Override
    public void eliminarTalla(String idTalla) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Talla> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idTalla));

            DeleteResult resultado = collection.deleteOne(filtroId);

            if (resultado.getDeletedCount() == 0) {
                throw new MongoException("No se encontró la talla con ID: " + idTalla + " para eliminar.");
            } else {
                System.out.println("Se eliminó la talla con ID: " + idTalla + " exitosamente.");
            }

        } catch (IllegalArgumentException e) {
            throw new MongoException("El ID de la talla a eliminar no tiene el formato correcto.", e);

        } catch (MongoException e) {
            throw new MongoException("Error al eliminar talla con ID: " + idTalla, e.getCause());
        }
    }
    
}
