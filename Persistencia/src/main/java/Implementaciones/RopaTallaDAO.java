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
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.regex;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import objetosnegocio.dominioPojo.Ropa;
import objetosnegocio.dominioPojo.RopaTalla;
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

    public RopaTallaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    private MongoCollection<RopaTalla> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, RopaTalla.class);
    }

    @Override
    public RopaTalla guardar(RopaTalla rt) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<RopaTalla> collection = getCollection(client);

            collection.insertOne(rt);
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

            RopaTalla rp = collection.find(filtroId).first();

            return rp;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar la relación RopaTalla por ID: " + id, e.getCause());
        }
    }

    @Override
    public RopaTalla buscarPorCodigo(String codigo) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<RopaTalla> collection = getCollection(client);
            Bson filtroCodigo = eq("codigo", codigo);

            RopaTalla rt = collection.find(filtroCodigo).first();

            return rt;
        } catch (MongoException e) {
            throw new MongoException("Error al buscar RopaTalla por código.", e.getCause());
        }
    }

    @Override
    public List<RopaTalla> buscarTodos() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<RopaTalla> collection = getCollection(client);
            return collection.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new MongoException("Error buscando inventario", e);
        }
    }
    
    @Override
    public List<RopaTalla> buscarPorFiltro(String textoBusqueda) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
        MongoCollection<RopaTalla> collection = getCollection(client);

        Pattern regex = Pattern.compile(Pattern.quote(textoBusqueda), Pattern.CASE_INSENSITIVE);

        Bson filtroNombre = Filters.regex("ropa.nombreArticulo", regex);

        Bson filtroCodigo = Filters.regex("codigoBarras", regex);

        Bson consultaFinal = Filters.or(filtroNombre, filtroCodigo);

        return collection.find(consultaFinal).into(new ArrayList<>());
        
    } catch (Exception e) {
        throw new MongoException("Error buscando productos por filtro", e);
    }
    }

    @Override
    public void reducirStock(String idRopaTalla, int cantidadVendida) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<RopaTalla> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idRopaTalla));

            Bson actualizacion = Updates.inc("cantidad", -cantidadVendida);

            collection.updateOne(filtroId, actualizacion);

            System.out.println("Stock actualizado con exito.");

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar el stock.", e.getCause());
        }
    }
    
    @Override
    public void actualizarStock(ObjectId idRopaTalla, int cantidad) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<RopaTalla> collection = getCollection(client);
            
            // Usamos $inc para incrementar o decrementar el campo "cantidad"
            collection.updateOne(
                Filters.eq("_id", idRopaTalla), 
                Updates.inc("cantidad", cantidad)
            );
            
        } catch (Exception e) {
            throw new MongoException("Error al actualizar stock: " + e.getMessage(), e);
        }
    }
    
    @Override
    public RopaTalla buscarPorFiltroAproximado(String temporada,String material, String marca, Double precio,String nombreTalla) throws MongoException {

        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<RopaTalla> collection = getCollection(client);

            List<Bson> filtros = new ArrayList<>();

            if (temporada != null && !temporada.isBlank()) {
                filtros.add(regex("ropa.temporada", temporada, "i")); // ignoreCase
            }
            if (material != null && !material.isBlank()) {
                filtros.add(regex("ropa.material", material, "i"));
            }
            if (marca != null && !marca.isBlank()) {
                filtros.add(regex("ropa.marca", marca, "i"));
            }
            if (nombreTalla != null && !nombreTalla.isBlank()) {
                filtros.add(regex("talla.nombreTalla", nombreTalla, "i"));
            }

            if (precio != null) {
                filtros.add(eq("ropa.precio", precio));
            }

            filtros.add(gt("cantidad", 1));

            Bson filtroFinal = filtros.isEmpty() ? new Document() : and(filtros);

            List<RopaTalla> resultados = collection.find(filtroFinal).into(new ArrayList<>());

            if (resultados.isEmpty()) {
                return null;
            }

            return resultados.get(new Random().nextInt(resultados.size()));

        } catch (MongoException e) {
            throw new MongoException("Error al buscar RopaTalla con filtros aproximados.", e.getCause());
        }
    }

    @Override
    public RopaTalla buscarRopaTalla(Ropa ropa, String nombreTalla) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<RopaTalla> collection = getCollection(client);
            List<Bson> filtros = new ArrayList<>();

            // Filtrar por la ropa exacta (por su _id)
            if (ropa != null && ropa.getId() != null) {
                filtros.add(eq("ropa._id", ropa.getId()));
            }

            // Coincidencia parcial de talla
            if (nombreTalla != null && !nombreTalla.isBlank()) {
                filtros.add(regex("talla.nombreTalla", nombreTalla, "i")); // "i" = ignore case
            }

            // Cantidad mayor a 1
            filtros.add(gt("cantidad", 1));

            Bson filtroFinal = and(filtros);

            // Buscar todas las coincidencias
            List<RopaTalla> lista = collection.find(filtroFinal).into(new ArrayList<>());

            if (lista.isEmpty()) {
                return null;
            }

            // Regresar una al azar
            return lista.get(new Random().nextInt(lista.size()));

        } catch (MongoException e) {
            throw new MongoException("Error al buscar RopaTalla.", e.getCause());
        }
    }


}
