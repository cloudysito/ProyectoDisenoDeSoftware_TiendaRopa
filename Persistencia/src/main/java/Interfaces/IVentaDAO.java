/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import java.util.List;
import objetosnegocio.dominioPojo.Venta;

/**
 *
 * @author garfi
 */
/**
 * Interfaz DAO para gestionar operaciones CRUD relacionadas con la entidad {@link Venta}.
 * Define los métodos para almacenar, modificar, eliminar y consultar ventas en la base de datos.
 */
public interface IVentaDAO {
    
    /**
     * Guarda una nueva venta en la base de datos.
     *
     * @param venta Objeto de tipo Venta que se desea almacenar.
     * @return La venta guardada con su información actualizada.
     * @throws MongoException Si ocurre un error al interactuar con la base de datos.
     */
    Venta guardarVenta(Venta venta) throws MongoException;
    
    /**
     * Modifica una venta existente en la base de datos.
     *
     * @param venta Objeto Venta con los datos actualizados.
     * @return La venta modificada.
     * @throws MongoException Si ocurre un error al modificar la venta en la base de datos.
     */
    Venta modificarVenta(Venta venta) throws MongoException;
    
    /**
     * Elimina una venta de la base de datos.
     *
     * @param venta Venta que se desea eliminar.
     * @return La venta eliminada.
     * @throws MongoException Si ocurre un error durante la eliminación.
     */
    Venta eliminarVenta(Venta venta) throws MongoException;
    
    /**
     * Busca una venta por su identificador único.
     *
     * @param idVenta ID de la venta a consultar.
     * @return La venta correspondiente al ID, o null si no existe.
     * @throws MongoException Si ocurre un error en la consulta.
     */
    Venta buscarPorId(String idVenta) throws MongoException;
    
    /**
     * Busca una venta por su número de folio.
     *
     * @param folio Número de folio asignado a la venta.
     * @return La venta correspondiente al folio, o null si no se encuentra.
     * @throws MongoException Si ocurre un error en la búsqueda.
     */
    Venta buscarPorFolio(int folio) throws MongoException;
    
    /**
     * Recupera todas las ventas registradas en la base de datos.
     *
     * @return Lista con todas las ventas almacenadas.
     * @throws MongoException Si ocurre algún problema al acceder a la base de datos.
     */
    List<Venta> buscarTodas() throws MongoException;
}

