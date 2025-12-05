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
 * Implementación del patrón Data Access Object (DAO) para la entidad {@code RopaTalla}.
 * <p>
 * Esta clase es responsable de gestionar el inventario por talla y stock. 
 * Maneja operaciones de búsqueda, guardado y actualización de la cantidad (stock) 
 * de una combinación específica de prenda y talla.
 * </p>
 *
 * @author garfi
 * @version 1.0
 */
public class RopaTallaDAO implements IRopaTallaDAO {

    /** Nombre de la colección de MongoDB que almacena las combinaciones de Ropa y Talla (Inventario). */
    private static final String NOMBRE_COLLECTION = "RopaTalla";
    
    /** Objeto para gestionar la conexión con MongoDB. */
    private final ConnectionMongoDB connection;

    /**
     * Constructor por defecto.
     * Inicializa la clase de conexión a MongoDB.
     */
    public RopaTallaDAO() {
        this.connection = new ConnectionMongoDB();
    }

    /**
     * Método auxiliar para obtener la referencia a la colección de RopaTalla.
     * @param client La conexión activa al servidor de MongoDB.
     * @return La colección tipada para la entidad RopaTalla.
     */
    private MongoCollection<RopaTalla> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, RopaTalla.class);
    }

    /**
     * Persiste una nueva combinación de RopaTalla (un nuevo ítem de stock) en la base de datos.
     *
     * @param rt El objeto {@code RopaTalla} a guardar.
     * @return El objeto guardado.
     * @throws MongoException Si ocurre un error durante la inserción.
     */
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

    /**
     * Busca una combinación de RopaTalla por su identificador único (ID de MongoDB).
     *
     * @param id El ID de tipo {@code String} de la entidad a buscar.
     * @return El objeto {@code RopaTalla} encontrado, o {@code null}.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public RopaTalla buscarPorId(String id) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<RopaTalla> collection = getCollection(client);

            // Convierte el ID String a ObjectId para la búsqueda
            Bson filtroId = eq("_id", new ObjectId(id));

            RopaTalla rp = collection.find(filtroId).first();

            return rp;

        } catch (MongoException e) {
            throw new MongoException("Error al buscar la relación RopaTalla por ID: " + id, e.getCause());
        }
    }

    /**
     * Busca una combinación de RopaTalla por su código de barras específico.
     *
     * @param codigo El código de barras ({@code String}) a buscar.
     * @return El objeto {@code RopaTalla} que coincide con el código, o {@code null}.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
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

    /**
     * Recupera una lista de todas las combinaciones de RopaTalla (inventario completo).
     *
     * @return Una lista de {@code RopaTalla}.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public List<RopaTalla> buscarTodos() throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
            MongoCollection<RopaTalla> collection = getCollection(client);
            return collection.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new MongoException("Error buscando inventario", e);
        }
    }
    
    /**
     * Realiza una búsqueda de productos en el inventario por nombre de artículo o código de barras.
     * <p>
     * Utiliza una expresión regular insensible a mayúsculas para buscar coincidencias.
     * </p>
     *
     * @param textoBusqueda El texto a buscar (nombre de prenda o código de barras).
     * @return Una lista de {@code RopaTalla} que coinciden con el filtro.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public List<RopaTalla> buscarPorFiltro(String textoBusqueda) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {
        MongoCollection<RopaTalla> collection = getCollection(client);

        // Patrón para búsqueda insensible a mayúsculas
        Pattern regex = Pattern.compile(Pattern.quote(textoBusqueda), Pattern.CASE_INSENSITIVE);

        // Filtro 1: Coincidencia en el nombre del artículo (dentro del subdocumento 'ropa')
        Bson filtroNombre = Filters.regex("ropa.nombreArticulo", regex);

        // Filtro 2: Coincidencia en el código de barras
        Bson filtroCodigo = Filters.regex("codigoBarras", regex);

        // Consulta Final: OR entre nombre y código
        Bson consultaFinal = Filters.or(filtroNombre, filtroCodigo);

        return collection.find(consultaFinal).into(new ArrayList<>());
        
    } catch (Exception e) {
        throw new MongoException("Error buscando productos por filtro", e);
    }
    }

    /**
     * Reduce la cantidad (stock) de una combinación de RopaTalla específica.
     * <p>
     * Este método se utiliza típicamente durante una venta para decrementar el stock.
     * Utiliza el operador {@code $inc} de MongoDB para realizar una actualización atómica.
     * </p>
     *
     * @param idRopaTalla El ID de la combinación RopaTalla a actualizar ({@code String}).
     * @param cantidadVendida La cantidad a restar del stock (debe ser un valor positivo).
     * @throws MongoException Si ocurre un error durante la actualización.
     */
    @Override
    public void reducirStock(String idRopaTalla, int cantidadVendida) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<RopaTalla> collection = getCollection(client);

            Bson filtroId = eq("_id", new ObjectId(idRopaTalla));

            // $inc incrementa el campo 'cantidad' por el valor negativo de cantidadVendida
            Bson actualizacion = Updates.inc("cantidad", -cantidadVendida);

            collection.updateOne(filtroId, actualizacion);

            System.out.println("Stock actualizado con exito.");

        } catch (MongoException e) {
            throw new MongoException("Error al actualizar el stock.", e.getCause());
        }
    }
    
    /**
     * Actualiza la cantidad (stock) de una combinación de RopaTalla específica.
     * <p>
     * Utiliza el operador {@code $inc} de MongoDB para incrementar o decrementar el stock
     * en la cantidad dada (si {@code cantidad} es positiva, suma; si es negativa, resta).
     * </p>
     *
     * @param idRopaTalla El {@code ObjectId} de la combinación RopaTalla a actualizar.
     * @param cantidad El valor por el que se debe incrementar o decrementar el stock.
     * @throws MongoException Si ocurre un error durante la actualización.
     */
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
    
    /**
     * Busca una {@code RopaTalla} disponible (stock > 1) que coincida con varios filtros aproximados.
     * <p>
     * Este método se utiliza para buscar una prenda que se ajuste a criterios de tendencia 
     * o recomendaciones. Los filtros de texto son insensibles a mayúsculas y minúsculas (regex "i").
     * Si encuentra múltiples resultados, devuelve uno **aleatoriamente**.
     * </p>
     *
     * @param temporada Filtro por temporada (ej. "Verano").
     * @param material Filtro por material (ej. "Algodon").
     * @param marca Filtro por marca.
     * @param precio Filtro por precio exacto (opcional).
     * @param nombreTalla Filtro por nombre de talla (ej. "M").
     * @return Un objeto {@code RopaTalla} que cumpla con los filtros y tenga stock > 1, 
     * seleccionado al azar si hay múltiples coincidencias, o {@code null} si no hay resultados.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public RopaTalla buscarPorFiltroAproximado(String temporada,String material, String marca, Double precio,String nombreTalla) throws MongoException {

        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<RopaTalla> collection = getCollection(client);

            List<Bson> filtros = new ArrayList<>();

            // Se añaden filtros solo si los parámetros no son nulos o vacíos.
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

            // Filtro obligatorio: Stock mayor a 1
            filtros.add(gt("cantidad", 1));

            // Si hay filtros, se combinan con AND; si no hay filtros (sólo cantidad), se usa un Document vacío para buscar todo.
            Bson filtroFinal = filtros.isEmpty() ? new Document() : and(filtros);

            List<RopaTalla> resultados = collection.find(filtroFinal).into(new ArrayList<>());

            if (resultados.isEmpty()) {
                return null;
            }

            // Selecciona un resultado aleatorio
            return resultados.get(new Random().nextInt(resultados.size()));

        } catch (MongoException e) {
            throw new MongoException("Error al buscar RopaTalla con filtros aproximados.", e.getCause());
        }
    }

    /**
     * Busca una {@code RopaTalla} disponible (stock > 1) que coincida exactamente con la prenda base y el nombre de la talla.
     * <p>
     * Se utiliza para encontrar una unidad de stock específica cuando se conoce la prenda general (por su ID) y la talla. 
     * Si hay múltiples unidades, devuelve una **aleatoriamente**.
     * </p>
     *
     * @param ropa El objeto {@code Ropa} que identifica la prenda base (se usa su ID).
     * @param nombreTalla El nombre exacto de la talla a buscar (ej. "S", "M").
     * @return Un objeto {@code RopaTalla} con stock disponible que coincida, o {@code null} si no se encuentra.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    @Override
    public RopaTalla buscarRopaTalla(Ropa ropa, String nombreTalla) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<RopaTalla> collection = getCollection(client);
            List<Bson> filtros = new ArrayList<>();

            // 1. Filtrar por la ropa exacta (por su _id), ya que es un subdocumento
            if (ropa != null && ropa.getId() != null) {
                filtros.add(eq("ropa._id", ropa.getId()));
            }

            // 2. Coincidencia de talla (regex "i" para manejar mayúsculas/minúsculas)
            if (nombreTalla != null && !nombreTalla.isBlank()) {
                filtros.add(regex("talla.nombreTalla", nombreTalla, "i")); 
            }

            // 3. Filtro obligatorio: Cantidad mayor a 1
            filtros.add(gt("cantidad", 1));

            Bson filtroFinal = and(filtros);

            // Buscar todas las coincidencias
            List<RopaTalla> lista = collection.find(filtroFinal).into(new ArrayList<>());

            if (lista.isEmpty()) {
                return null;
            }

            // Regresar una al azar de las unidades de stock disponibles
            return lista.get(new Random().nextInt(lista.size()));

        } catch (MongoException e) {
            throw new MongoException("Error al buscar RopaTalla.", e.getCause());
        }
    }


}