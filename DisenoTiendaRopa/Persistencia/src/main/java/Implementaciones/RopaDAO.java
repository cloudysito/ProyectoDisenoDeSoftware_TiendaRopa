/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.IRopaDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author garfi
 */
public class RopaDAO implements IRopaDAO {

    private static final String NOMBRE_COLLECTION = "Ropa";
    private final ConnectionMongoDB connection;
    private final RopaMapper mapper;

    public RopaDAO() {
        this.connection = new ConnectionMongoDB();
        this.mapper = new RopaMapper();
    }

    private MongoCollection<Ropa> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION);
    }

    @Override
    private Document dtoToEntity(RopaDTO dto) {
        if (dto == null) return null;
        
        Document doc = new Document();
        if (dto.getId() != null && !dto.getId().isEmpty()) {
            doc.append("_id", new ObjectId(dto.getId()));
        }
        doc.append("codigoBarras", dto.getCodigoBarras());
        doc.append("nombreArticulo", dto.getNombreArticulo());
        doc.append("precio", dto.getPrecio());
        doc.append("descripcion", dto.getDescripcion());
        doc.append("temporada", dto.getTemporada());
        doc.append("marca", dto.getMarca());
        doc.append("material", dto.getMaterial());
        return doc;
    }

    
    @Override
    private RopaDTO entityToDTO(Document doc) {
        if (doc == null) return null;
        
        RopaDTO dto = new RopaDTO();
        if (doc.containsKey("_id")) {
            dto.setId(doc.getObjectId("_id").toHexString());
        }
        dto.setCodigoBarras(doc.getString("codigoBarras"));
        dto.setNombreArticulo(doc.getString("nombreArticulo"));
        Double precio = doc.getDouble("precio");
        dto.setPrecio(precio != null ? precio : 0.0);
        dto.setDescripcion(doc.getString("descripcion"));
        dto.setTemporada(doc.getString("temporada"));
        dto.setMarca(doc.getString("marca"));
        dto.setMaterial(doc.getString("material"));
        return dto;
    }

    @Override
    public Ropa guardarRopa(Ropa ropa) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);
            RopaDTO dto = mapper.toDTO(ropa);
            Document doc = dtoToEntity(dto);
            
            if(doc.get("_id")==null) {
                doc.remove("_id");
            }
            
            collection.insertOne(doc);
            
            ObjectId id = doc.getObjectId("_id");
            ropa.setId(id.toHexString());
            
            System.out.println("Ropa insertada con exito.");
            return ropa;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la ropa.", e.getCause());
        }
    }

    @Override
    public Ropa buscarPorCodigoBarras(String codigoBarras) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Ropa> collection = getCollection(client);

            Bson filtroCodigoBarras = eq("codigoBarras", codigoBarras);

            Document doc = collection.find(filtroCodigoBarras).first();

            return mapper.toEntity(entityToDTO(doc));

        } catch (MongoException e) {
            throw new MongoException("Error al buscar ropa por código de barras: " + codigoBarras, e.getCause());
        }
    }

    

}
