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
import com.mongodb.client.model.Updates;
import objetosnegocio.dominioPojo.Empleado;
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
    public Empleado modificarEmpleado(Empleado empleado) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Empleado> collection = getCollection(client);

            Bson filtroId = eq("_id", empleado.getId());

            Bson actualizaciones = Updates.combine(
                    Updates.set("nombre", empleado.getNombre()),
                    Updates.set("apellidos", empleado.getApellidos()),
                    Updates.set("puesto", empleado.getPuesto()),
                    Updates.set("telefono", empleado.getTelefono()),
                    Updates.set("email", empleado.getEmail()),
                    Updates.set("salario", empleado.getSalario()),
                    Updates.set("fechaContratacion", empleado.getFechaContratacion()),
                    Updates.set("rfc", empleado.getRfc())
            );

            collection.updateOne(filtroId, actualizaciones);

            System.out.println("Empleado actualizado con exito.");
            return empleado;

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar al empleado.", e.getCause());
        }
    }

    @Override
    public Empleado eliminarEmpleado(Empleado empleado) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Empleado> collection = getCollection(client);

            Bson filtroId = eq("_id", empleado.getId());

            collection.deleteOne(filtroId);
            System.out.println("Empleado eliminado con exito.");
            return empleado;

        } catch (MongoException e) {
            throw new MongoException("Error al eliminar al empleado.", e.getCause());
        }
    }

    @Override
    public Empleado buscarPorId(String idEmpleado) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Empleado> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idEmpleado));

            Empleado empleado = collection.find(filtroId).first();

            return empleado;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar empleado por ID: " + idEmpleado, e.getCause());
        }
    }

    

    
}
