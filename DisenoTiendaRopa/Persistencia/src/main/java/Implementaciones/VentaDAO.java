/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.IVentaDAO;
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
public class VentaDAO implements IVentaDAO {

    private static final String NOMBRE_COLLECTION = "Venta";
    private final ConnectionMongoDB connection;
    private final VentaMapper mapper;

    public VentaDAO() {
        this.connection = new ConnectionMongoDB();
        this.mapper = new VentaMapper();
    }

    private MongoCollection<Venta> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION);
    }
    
    @Override
    private Document dtoToEntity(VentaDTO dto) {
        if (dto == null) return null;
        
        Document doc = new Document();
        if (dto.getId() != null && !dto.getId().isEmpty()) {
            doc.append("_id", new ObjectId(dto.getId()));
        }
        doc.append("folioVenta", dto.getFolioVenta());
        doc.append("fechaHoraVenta", dto.getFechaHoraVenta());
        doc.append("totalVenta", dto.getTotalVenta());
        doc.append("metodoPago", dto.getMetodoPago());
        doc.append("idEmpleado", dto.getIdEmpleado());
        doc.append("detalles", dto.getDetalles());
        return doc;
    }
    
    @Override
    private VentaDTO entityToDTO(Document doc) {
        if (doc == null) return null;
        
        VentaDTO dto = new VentaDTO();
        if (doc.containsKey("_id")) {
            dto.setId(doc.getObjectId("_id").toHexString());
        }
        dto.setFolioVenta(doc.getInteger("folioVenta"));
        dto.setFechaHoraVenta(doc.getDate("fechaHoraVenta"));
        dto.setTotalVenta(doc.getInteger("totalVenta"));
        dto.setMetodoPago(doc.getString("metodoPago"));
        dto.setIdEmpleado(doc.getString("idEmpleado"));
        dto.setDetalles(doc.getList("detalles", DetalleVentaDTO.class));
        return dto;
    }

    @Override
    public Venta guardarVenta(Venta venta) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);
            VentaDTO dto = mapper.toDTO(venta);
            Document doc = dtoToEntity(dto);
            
            if(doc.get("_id")==null) {
                doc.remove("_id");
            }

            collection.insertOne(doc);
            System.out.println("Venta insertada con éxito.");

            return venta;

        } catch (MongoException e) {
            throw new MongoException("Error al guardar la venta.", e.getCause());
        }
    }

    @Override
    public Venta buscarPorId(String idVenta) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Venta> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idVenta));

            Document doc = collection.find(filtroId).first();

            return mapper.toEntity(entityToDTO(doc));

        } catch (MongoException e) {
            throw new MongoException("Error al buscar venta por ID: " + idVenta, e.getCause());
        }
    }

}
