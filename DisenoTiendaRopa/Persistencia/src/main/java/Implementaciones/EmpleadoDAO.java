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
import com.mycompany.objetosnegocio.dominioPojo.Empleado;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
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
    
//    @Override
//    private Document dtoToEntity(EmpleadoDTO dto) {
//        if (dto == null) return null;
//        Document doc = new Document();
//        if (dto.getId() != null && !dto.getId().isEmpty()) {
//            doc.append("_id", new ObjectId(dto.getId()));
//        }
//        doc.append("nombreCompleto", dto.getNombreCompleto());
//        doc.append("puesto", dto.getPuesto());
//        doc.append("email", dto.getEmail());
//        return doc;
//    }
//    
//    @Override
//    private EmpleadoDTO entityToDTO(Document doc) {
//        if (doc == null) return null;
//        
//        EmpleadoDTO dto = new EmpleadoDTO();
//        if (doc.containsKey("_id")) {
//            dto.setId(doc.getObjectId("_id").toHexString());
//        }
//        dto.setNombreCompleto(doc.getString("nombreCompleto"));
//        dto.setPuesto(doc.getString("puesto"));
//        dto.setEmail(doc.getString("email"));
//        return dto;
//    }

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

            Empleado empleado = collection.find(filtroId).first();

            return empleado;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar empleado por ID: " + idEmpleado, e.getCause());
        }
    }

    
}
