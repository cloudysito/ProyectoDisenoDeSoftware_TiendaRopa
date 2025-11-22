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
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author garfi
 */
public class TallaDAO implements ITallaDAO{
    
    private static final String NOMBRE_COLLECTION = "Talla";
    private final ConnectionMongoDB connection;
    private final TallaMapper mapper;

    public TallaDAO() {
        this.connection = new ConnectionMongoDB();
        this.mapper = new TallaMapper();
    }

    private MongoCollection<Talla> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION);
    }

    @Override
    private Document dtoToEntity(TallaDTO dto) {
        if (dto == null) return null;
        
        Document doc = new Document();
        if (dto.getId() != null && !dto.getId().isEmpty()) {
            doc.append("_id", new ObjectId(dto.getId()));
        }
        doc.append("nombreTalla", dto.getNombreTalla());
        doc.append("descripcion", dto.getDescripcion());
        return doc;
    }
    
    @Override
    private TallaDTO entityToDTO(Document doc) {
        if (doc == null) return null;
        
        TallaDTO dto = new TallaDTO();
        if (doc.containsKey("_id")) {
            dto.setId(doc.getObjectId("_id").toHexString());
        }
        dto.setNombreTalla(doc.getString("nombreTalla"));
        dto.setDescripcion(doc.getString("descripcion"));
        return dto;
    }
    
    @Override
    public Talla guardarTalla(Talla talla) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Talla> collection = getCollection(client);
            TallaDTO dto = mapper.toDTO(talla);
            Document doc = dtoToEntity(dto);
            
            if(doc.get("_id")==null) {
                doc.remove("_id");
            }

            collection.insertOne(doc);
            
            ObjectId id = doc.getObjectId("_id");
            talla.setId(id.toHexString());
            
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

            Document doc = collection.find(filtroId).first();

            return mapper.toEntity(entityToDTO(doc));

        } catch (MongoException e) {
            throw new MongoException("Error al buscar talla por ID: " + idTalla, e.getCause());
        }
    }
}
