/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import objetosnegocio.dominioPojo.DetalleDevolucion;
import objetosnegocio.dominioPojo.Devolucion;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author emiim
 */
public class DevolucionDAO implements IDevolucionDAO {
    private final MongoDatabase database;

    public DevolucionDAO() {
        this.database = MongoClients.create("mongodb://localhost:27017").getDatabase("tienda_ropa"); // CAMBIAR NOMBRE BD, NO SE COMO SE LLAMA :(
    }

    @Override
    public Devolucion guardar(Devolucion devolucion) {
        MongoCollection<Document> collection = database.getCollection("devoluciones");

        List<Document> detallesDocs = new ArrayList<>();
        if (devolucion.getDetalles() != null) {
            for (DetalleDevolucion det : devolucion.getDetalles()) {
                Document docDet = new Document()
                    .append("_id", new ObjectId())
                    .append("cantidadDevuelta", det.getCantidadDevuelta())
                    .append("subtotalReembolsado", det.getSubtotalReembolsado());
                
                // Si tuviéramos el objeto RopaTalla completo, pondríamos su ID aquí
                // docDet.append("idRopaTalla", det.getRopaTalla().getId());
                
                detallesDocs.add(docDet);
            }
        }

        Document doc = new Document()
            .append("idVentaOriginal", devolucion.getIdVentaOriginal())
            .append("fechaDevolucion", devolucion.getFechaDevolucion())
            .append("totalReembolsado", devolucion.getTotalReembolsado())
            .append("metodoReembolso", devolucion.getMetodoReembolso())
            .append("detalles", detallesDocs);

        collection.insertOne(doc);
        devolucion.setId(doc.getObjectId("_id"));
        
        return devolucion;
    }
}
