/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.IEmpleadoDAO;
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
public class EmpleadoDAO implements IEmpleadoDAO {

    private static final String NOMBRE_COLLECTION = "Empleado";
    private final ConnectionMongoDB connection;

    public EmpleadoDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<Empleado> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Empleado.class);
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Empleado> collection = getCollection(client);

            collection.insertOne(empleado);
            System.out.println("Empleado insertado con éxito.");

            return empleado;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar al empleado.", e.getCause());
        }
    }

    @Override
    public Empleado buscarPorId(String idEmpleado) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Empleado> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idEmpleado));

            Empleado empleadoEncontrado = collection.find(filtroId).first();

            return empleadoEncontrado;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar empleado por ID: " + idEmpleado, e.getCause());
        }
    }

    @Override
    public Empleado buscarTodos() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Empleado> collection = getCollection(client);

            List<Empleado> listaEmpleado = new ArrayList<>();
            collection.find().into(listaEmpleado);

            System.out.println("Se encontraron " + listaEmpleado.size() + " empleados.");

            return listaEmpleado;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar todos los empleados.", e.getCause());
        }
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) throws MongoException {
        if (empleado.getId() == null) {
            throw new MongoException("No se puede actualizar un empleado sin su ID.");
        }

        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Empleado> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(empleado.getId()));

            UpdateResult resultado = collection.replaceOne(filtroId, empleado);

            if (resultado.getModifiedCount() == 0) {
                if (resultado.getMatchedCount() == 0) {
                    throw new MongoException("No se encontró ningun empleado con el ID: " + empleado.getId() + " para actualizar.");
                }
            } else {
                System.out.println("Se actualizó el empleado con ID: " + empleado.getId());
            }

        } catch (IllegalArgumentException e) {
            throw new MongoException("El ID del empleado a actualizar no tiene el formato correcto.", e);

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar empleado: " + empleado.getId(), e.getCause());
        }
    }

    @Override
    public void eliminarEmpleado(String idEmpleado) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Empleado> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idEmpleado));

            DeleteResult resultado = collection.deleteOne(filtroId);

            if (resultado.getDeletedCount() == 0) {
                throw new MongoException("No se encontró el empleado con ID: " + idEmpleado + " para eliminar.");
            } else {
                System.out.println("Se eliminó el empleado con ID: " + idEmpleado + " exitosamente.");
            }

        } catch (IllegalArgumentException e) {
            throw new MongoException("El ID del empleado a eliminar no tiene el formato correcto.", e);

        } catch (MongoException e) {
            throw new MongoException("Error al eliminar empleado con ID: " + idEmpleado, e.getCause());
        }
    }
}
