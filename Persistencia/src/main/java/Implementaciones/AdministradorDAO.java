/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import Interfaces.IAdministradorDAO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import objetosnegocio.dominioPojo.Administrador;
import objetosnegocio.dominioPojo.Empleado;
import org.bson.conversions.Bson;

/**
 *
 * @author santi
 */
public class AdministradorDAO implements  IAdministradorDAO{

    /** Nombre de la colección de MongoDB que almacena los empleados. */
    private static final String NOMBRE_COLLECTION = "Administrador";
    
    /** Objeto para gestionar la conexión con MongoDB. */
    private final ConnectionMongoDB connection;

    public AdministradorDAO() {
        this.connection = new ConnectionMongoDB();
    }
    
    private MongoCollection<Administrador> getCollection(MongoClient client) {
        MongoDatabase database = client.getDatabase(ConnectionMongoDB.NOMBRE_DB);
        return database.getCollection(NOMBRE_COLLECTION, Administrador.class);
    }
    
    @Override
    public Administrador iniciarSesion(String correo, String contrasenia) throws MongoException {
        try (MongoClient client = connection.crearNuevoCliente()) {

            MongoCollection<Administrador> collection = getCollection(client);

            // Filtro para buscar por correo y contraseña
            Bson filtro = and(
                    eq("nombre", correo),
                    eq("contrasenia", contrasenia)
            );

            // Buscar el empleado que coincida con los filtros
            Administrador administrador = collection.find(filtro).first();

            return administrador;

        } catch (MongoException e) {
            throw new MongoException("Error al iniciar sesión", e);
        }
    }
    
}
