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
import java.util.List;
import objetosnegocio.dominioPojo.Bonificacion;
import objetosnegocio.dominioPojo.Empleado;
import objetosnegocio.dominioPojo.Recompensa;
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
    
    public Bonificacion getBonificacionPorEmpleado(String idEmpleado) {
        // Lógica de MongoDB para buscar el documento Bonificacion
        // Donde el campo 'idEmpleado' coincide con el valor proporcionado.
        // Debe mapear el Document MongoDB a un objeto BonificacionDTO.
        
        System.out.println("DAO: Buscando bonificación para empleado ID: " + idEmpleado);
        // ... (Implementación de findOne)
        
        // *** Placeholder de retorno para ejemplo ***
        Bonificacion dto = new Bonificacion();
        dto.setIdBonificacion("ObjectID_de_Bonificacion"); 
        dto.setPuntosTotales(0); // Ejemplo: Retorna 500 puntos actuales
        return dto; 
    }
    
    public boolean actualizarPuntosTotales(Bonificacion bonificacion) {
        // Lógica de MongoDB usando updateOne:
        // 1. Filtrar por el ID de la bonificación (bonificacion.getId())
        // 2. Usar $set para cambiar solo el campo "puntosTotales" al valor de bonificacion.getPuntosTotales()
        
        System.out.println("DAO: Persistiendo nuevo total de puntos: " + bonificacion.getPuntosTotales());
        // ... (Implementación de updateOne)

        return true; // Asumiendo éxito en la operación
    }
    
    public Recompensa obtenerEstadoRecompensa(Empleado empleado) {
        
        // 1. Inicializar DAOs
        BonificacionDAO bonificacionDAO = new BonificacionDAO();
        RecompensaDAO recompensaDAO = new RecompensaDAO(); // Nuevo DAO para la entidad Recompensa

        // 2. Obtener los puntos totales del empleado
        Bonificacion bonificacion = bonificacionDAO.getBonificacionPorEmpleado(empleadoDTO.getId());
        if (bonificacion == null) {
            return new Recompensa(0, "Bonificación no encontrada");
        }
        int puntosActuales = bonificacion.getPuntosTotales();

        // 3. Obtener la lista de todas las recompensas
        List<Recompensa> recompensas = recompensaDAO.obtenerTodasLasRecompensas();

        // 4. Lógica de Proporcionalidad (Encontrar la recompensa más alta alcanzable)
        String nombreRecompensaAlcanzada = "Sin Recompensa Alcanzada";
        int maxPuntosAlcanzados = 0;

        for (Recompensa recompensa : recompensas) {
            int puntosRequeridos = recompensa.getCantidadPuntos();
            
            // Si los puntos actuales superan o igualan los requeridos, es una recompensa alcanzable.
            if (puntosActuales >= puntosRequeridos) {
                // Se busca la recompensa que requiera la MAYOR cantidad de puntos.
                if (puntosRequeridos > maxPuntosAlcanzados) {
                    maxPuntosAlcanzados = puntosRequeridos;
                    nombreRecompensaAlcanzada = recompensa.getNombreRecompensa();
                }
            }
        }
        
        // 5. Devolver el DTO de respuesta con los datos filtrados
        return new Recompensa(puntosActuales, nombreRecompensaAlcanzada);
    }
}
