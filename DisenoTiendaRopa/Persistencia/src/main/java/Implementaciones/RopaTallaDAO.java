/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import Interfaces.IRopaTallaDAO;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author garfi
 */
public class RopaTallaDAO implements IRopaTallaDAO {

    private static final String NOMBRE_COLLECTION = "RopaTalla";
    private final ConnectionMongoDB connection;
    private final RopaTallaMapper mapper;

    public RopaTallaDAO() {
        this.connection = new ConnectionMongoDB();
        this.mapper = new RopaTallaMapper();
    }

    private MongoCollection<RopaTalla> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION);
    }
    
    @Override
    private Document dtoToEntity(RopaTallaDTO dto) {
        if (dto == null) return null;
        
        Document doc = new Document();
        if (dto.getId() != null && !dto.getId().isEmpty()) {
            doc.append("_id", new ObjectId(dto.getId()));
        }
        doc.append("ropaId", new ObjectId(dto.getIdRopa));
        doc.append("tallaId", new ObjectId(dto.getIdTalla));
        doc.append("codigo", dto.getCodigo());
        doc.append("cantidad", dto.getCantidad);
        return doc;
    }
    
    @Override
    private RopaTallaDTO entityToDTO(Document doc) {
        if (doc == null) return null;
        
        RopaTallaDTO dto = new RopaTallaDTO();
        if (doc.containsKey("_id")) {
            dto.setId(doc.getObjectId("_id").toHexString());
        }
        dto.setIdRopa(doc.getObjectId("ropaId").toHexString());
        dto.setIdTalla(doc.getObjectId("tallaId").toHexString());
        dto.setCodigo(doc.getString("codigo"));
        dto.setCantidad(doc.getInteger("cantidad"));
        return dto;
    }

    @Override
    public RopaTalla guardar(RopaTalla rt) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<RopaTalla> collection = getCollection(client);
            RopaTallaDTO dto = mapper.toDTO(rt);
            Document doc = dtoToEntity(dto);
            
            if(doc.get("_id")==null) {
                doc.remove("_id");
            }
            
            collection.insertOne(doc);
            
            ObjectId id = doc.getObjectId("_id");
            rt.setId(id.toHexString());

            System.out.println("Relación RopaTalla guardada con ID: " + rt.getId());
            return rt;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la relación RopaTalla.", e.getCause());
        }
    }

    @Override
    public RopaTalla buscarPorId(String id) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<RopaTalla> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(id));

            Document doc = collection.find(filtroId).first();

            return mapper.toEntity(entityToDTO(doc));

        } catch (MongoException e) {
            throw new MongoException("Error al buscar la relación RopaTalla por ID: " + id, e.getCause());
        }
    }

    @Override
    public RopaTalla buscarPorCodigo(String codigo) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<RopaTalla> collection = getCollection(client);
            Bson filtroCodigo = eq("codigo", codigo);
            
            Document doc = collection.find(filtroCodigo).first();

            return mapper.toEntity(entityToDTO(doc));
        } catch (MongoException e) {
            throw new MongoException("Error al buscar RopaTalla por código.", e.getCause());
        }
    }

}
