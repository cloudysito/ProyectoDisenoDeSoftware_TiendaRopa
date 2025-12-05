/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementaciones;

import Exceptions.MongoException;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.*;
import static org.bson.codecs.configuration.CodecRegistries.*;
import org.bson.codecs.pojo.*;

/**
 * Clase encargada de establecer y gestionar la conexión con la base de datos MongoDB.
 * <p>
 * Configura la URL, el nombre de la base de datos, y el crucial <b>POJO Codec Registry</b> 
 * para permitir el mapeo automático entre las clases Java de dominio y los documentos de Mongo (BSON).
 * </p>
 *
 * @author garfi
 * @version 1.0
 */
public class ConnectionMongoDB {

    /** URL estática para la conexión local del servidor de MongoDB (puerto estándar 27017). */
    public static final String URL = "mongodb://localhost:27017/";
    
    /** Nombre de la base de datos utilizada para la aplicación de la Tienda de Ropa. */
    public static final String NOMBRE_DB = "TiendaRopa";

    /**
     * Crea y retorna un nuevo cliente de conexión a MongoDB con el Codec Registry configurado.
     * <p>
     * Configura el {@code PojoCodecProvider} con la opción automática, lo que permite al driver
     * serializar y deserializar automáticamente las clases Java (POJOs) sin necesidad de código extra.
     * </p>
     *
     * @return Una instancia de {@code MongoClient} lista para interactuar con la base de datos.
     * @throws MongoException Si ocurre un error al intentar establecer la conexión o al configurar el Codec Registry.
     */
    public MongoClient crearNuevoCliente() throws MongoException {
        try {
            // 1. Configuración del Codec Registry para POJOs
            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
            
            // 2. Combinación del Codec Registry por defecto y el de POJOs
            CodecRegistry customCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

            // 3. Configuración de los ajustes del cliente con el nuevo Codec Registry
            MongoClientSettings settings = MongoClientSettings.builder()
                    .codecRegistry(customCodecRegistry)
                    .build();

            // 4. Creación de la conexión utilizando la URL estática
            MongoClient cliente = MongoClients.create(settings);


            System.out.println("Conexion exitosa a " + NOMBRE_DB);
            return cliente;

        } catch (Exception e) {
            // Envuelve cualquier excepción subyacente en la excepción personalizada del dominio.
            throw new MongoException("Error al crear la conexión con el POJO Codec Registry.", e);
        }
    }
}