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
import com.mongodb.client.model.Filters;
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
    
    /**
 * Busca una Capacitacion por el nombre del empleado y el tema de capacitación.
 * * @param nombreEmpleado El nombre del empleado a buscar (ej: "12").
 * @param temaCapacitacion El tema de capacitación a buscar (ej: "agresividad").
 * @return El objeto Capacitacion encontrado o null si no existe.
 * @throws MongoException Si ocurre un error durante la operación de la base de datos.
 */
public Capacitacion buscarPorNombreYTema(String nombreEmpleado, String temaCapacitacion) throws MongoException {
    try (MongoClient client = connection.crearNuevoCliente()) { // Asumo que tienes una forma de obtener el cliente
        MongoCollection<Capacitacion> collection = getCollection(client);

        // 1. Crear el filtro para el nombre del empleado. 
        // El campo es nombreEmpleado.nombre
        Bson filtroNombre = Filters.eq("nombreEmpleado.nombre", nombreEmpleado);

        // 2. Crear el filtro para el tema de capacitación. 
        // El campo es temaCapacitacion.temaCapacitacion
        Bson filtroTema = Filters.eq("temaCapacitacion.temaCapacitacion", temaCapacitacion);

        // 3. Combinar los filtros usando AND.
        Bson filtroCombinado = Filters.and(filtroNombre, filtroTema);

        // 4. Ejecutar la búsqueda y obtener el primer resultado.
        Capacitacion capacitacionEncontrada = collection.find(filtroCombinado).first();

        return capacitacionEncontrada;
        
    } catch (MongoException e) {
        // Capturar cualquier excepción de MongoDB y relanzarla con más contexto
        throw new MongoException("Error al buscar capacitacion por nombre de empleado ('" 
            + nombreEmpleado + "') y tema ('" + temaCapacitacion + "')", e.getCause());
    }
}

}
