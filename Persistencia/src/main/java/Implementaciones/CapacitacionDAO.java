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
 * Implementación del patrón Data Access Object (DAO) para la entidad {@code Capacitacion}.
 * <p>
 * Se encarga de las operaciones de persistencia (CRUD) contra la colección "Capacitacion" 
 * en la base de datos MongoDB. Utiliza el cliente de MongoDB para gestionar la conexión 
 * y las operaciones directas con la colección.
 * </p>
 *
 * @author riosr
 * @version 1.0
 */
public class CapacitacionDAO implements ICapacitacionDAO {
    
    /** Nombre de la colección de MongoDB que almacena las capacitaciones. */
    private static final String NOMBRE_COLLECTION = "Capacitacion";
    
    /** Objeto para gestionar la conexión con MongoDB. */
    private final ConnectionMongoDB connection;

    /**
     * Constructor por defecto.
     * Inicializa el gestor de conexión a la base de datos.
     */
    public CapacitacionDAO() {
        // Asumiendo que ConnectionMongoDB es una clase definida en el mismo proyecto.
        this.connection = new ConnectionMongoDB();
    }

    /**
     * Método auxiliar para obtener la referencia a la colección de Capacitaciones.
     * <p>
     * Obtiene la base de datos a partir del cliente y la colección tipada para el POJO {@code Capacitacion}.
     * </p>
     * * @param client La conexión activa al servidor de MongoDB.
     * @return La colección tipada para la entidad Capacitacion.
     */
    private MongoCollection<Capacitacion> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Capacitacion.class);
    }
    
    /**
     * Persiste un nuevo objeto Capacitación en la base de datos.
     *
     * @param capacitacion El objeto {@code Capacitacion} a guardar.
     * @return La capacitación guardada (posiblemente con el ID generado).
     * @throws MongoException Si ocurre un error durante la inserción en la base de datos.
     */
    @Override
    public Capacitacion guardarCapacitacion(Capacitacion capacitacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Capacitacion> collection = getCollection(client);
            collection.insertOne(capacitacion);
            System.out.println("Capacitacion insertada con éxito.");
            return capacitacion;

        } catch (MongoException e) {
            // Re-lanza la excepción envuelta para mantener la capa de abstracción
            throw new MongoException("Error al guardar la capacitacion.", e.getCause());
        }
    }
    
    /**
     * Modifica los atributos de una Capacitación existente.
     * <p>
     * Utiliza el ID de la capacitación para encontrar el documento y actualiza los campos
     * como nombre del empleado, tema de capacitación y estado.
     * </p>
     *
     * @param capacitacion El objeto {@code Capacitacion} con los nuevos datos.
     * @return La capacitación actualizada.
     * @throws MongoException Si ocurre un error durante la actualización en la base de datos.
     */
    @Override
    public Capacitacion modificarCapacitacion(Capacitacion capacitacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Capacitacion> collection = getCollection(client);

            // Filtra por el campo _id utilizando el ID del POJO
            Bson filtroId = eq("_id", capacitacion.getIdCapacitacion());

            // Combina todas las actualizaciones necesarias
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
     * Busca una Capacitación por su identificador único.
     *
     * @param idCapacitacion El identificador ({@code String}) de la capacitación a buscar.
     * @return El objeto {@code Capacitacion} encontrado, o {@code null} si no existe.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public Capacitacion buscarPorId(String idCapacitacion) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Capacitacion> collection = getCollection(client);

            // Crea un filtro para buscar por el ID convertido a ObjectId
            Bson filtroId = eq("_id", new ObjectId(idCapacitacion));

            // Ejecuta la consulta y obtiene el primer resultado
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