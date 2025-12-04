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
 *
 * @author garfi
 */
public class ConnectionMongoDB {

    public static final String URL = "mongodb://localhost:27017/";
    public static final String NOMBRE_DB = "TiendaRopa";

    public MongoClient crearNuevoCliente() throws MongoException {
        try {
            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
            CodecRegistry customCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

            MongoClientSettings settings = MongoClientSettings.builder()
                    .codecRegistry(customCodecRegistry)
                    .build();

            MongoClient cliente = MongoClients.create(settings);


            System.out.println("Conexion exitosa a " + NOMBRE_DB);
            return cliente;

        } catch (Exception e) {
            throw new MongoException("Error al crear la conexión con el POJO Codec Registry.", e);
        }
    }
}


