/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.ISugerenciaDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import objetosnegocio.dominioPojo.Empleado;
import objetosnegocio.dominioPojo.Sugerencia;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author santi
 */
public class SugerenciaDAO implements ISugerenciaDAO {

    private static final String NOMBRE_COLLECTION = "Empleado";
    private final ConnectionMongoDB connection;

    public SugerenciaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Sugerencia> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Sugerencia.class);
    }

    @Override
    public Sugerencia guardarSugerencia(Sugerencia sugerencia) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Sugerencia> collection = getCollection(client);
            collection.insertOne(sugerencia);
            System.out.println("Empleado insertado con éxito.");
            return sugerencia;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar al empleado.", e.getCause());
        }
    }

    @Override
    public Sugerencia modificarSugerencia(Sugerencia sugerencia) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Sugerencia> collection = getCollection(client);

            Bson filtroId = eq("_id", sugerencia.getId());

            Bson actualizaciones = Updates.combine(
                    Updates.set("empleado", sugerencia.getEmpleado()),
                    Updates.set("descripcion", sugerencia.getDescripcion()),
                    Updates.set("estado", sugerencia.getEstado()),
                    Updates.set("fechaPublicacion", sugerencia.getFechaPublicacion())
            );

            collection.updateOne(filtroId, actualizaciones);

            System.out.println("Sugerencia actualizada con éxito.");
            return sugerencia;

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar la sugerencia.", e.getCause());
        }
    }

    @Override
    public Sugerencia buscarPorId(String idBonificacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Sugerencia> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idBonificacion));

            Sugerencia sugerencia = collection.find(filtroId).first();

            return sugerencia;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar empleado por ID: " + idBonificacion, e.getCause());
        }
    }

    @Override
    public List<Sugerencia> buscarTodos() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<Sugerencia> collection = getCollection(client);
            return collection.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new MongoException("Error al buscar todos los empleados", e);
        }
    }

    @Override
    public List<Sugerencia> buscarPorNombre(String nombreEmpleado) {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Sugerencia> collection = getCollection(client);

            Bson filtroNombre = Filters.regex("nombre", nombreEmpleado, "i");

            List<Sugerencia> listaResultados = collection.find(filtroNombre).into(new ArrayList<>());

            return listaResultados;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar ropa por ID: " + nombreEmpleado, e.getCause());
        }
    }

    public List<Sugerencia> buscarPorEstado(String estado) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<Sugerencia> collection = getCollection(client);

            Bson filtroEstado = Filters.regex("estado", "^" + estado + "$", "i");

            return collection.find(filtroEstado).into(new ArrayList<>());

        } catch (MongoException e) {
            throw new MongoException("Error al buscar sugerencias por estado: " + estado, e.getCause());
        }
    }

    public boolean actualizarEstado(String idSugerencia, String nuevoEstado) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<Sugerencia> collection = getCollection(client);

            Bson filtroId = Filters.eq("_id", new org.bson.types.ObjectId(idSugerencia));

            Bson actualizacion = Updates.set("estado", nuevoEstado);

            UpdateResult resultado = collection.updateOne(filtroId, actualizacion);

            return resultado.getModifiedCount() > 0;

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar el estado de la sugerencia: " + idSugerencia, e.getCause());
        }
    }

}
