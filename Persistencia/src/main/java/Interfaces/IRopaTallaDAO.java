/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Exceptions.MongoException;
import java.util.List;
import objetosnegocio.dominioPojo.Ropa;
import objetosnegocio.dominioPojo.RopaTalla;
import org.bson.types.ObjectId;

/**
 *
 * @author garfi
 */
/**
 * Interfaz DAO para gestionar operaciones relacionadas con la entidad {@link RopaTalla}.
 * Proporciona métodos CRUD, búsquedas avanzadas y operaciones para administración de stock.
 */
public interface IRopaTallaDAO {

    /**
     * Guarda una nueva instancia de {@link RopaTalla} en la base de datos.
     *
     * @param rt Objeto RopaTalla a guardar.
     * @return El objeto RopaTalla guardado con su ID asignado.
     * @throws MongoException Si ocurre un error al guardar el dato.
     */
    RopaTalla guardar(RopaTalla rt) throws MongoException;

    /**
     * Busca una instancia de {@link RopaTalla} por su identificador único.
     *
     * @param id ID del objeto RopaTalla.
     * @return El objeto encontrado o null si no existe.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    RopaTalla buscarPorId(String id) throws MongoException;

    /**
     * Busca una instancia de {@link RopaTalla} usando su código único.
     *
     * @param codigo Código de la prenda con talla.
     * @return La coincidencia encontrada o null si no existe.
     * @throws MongoException Si ocurre una falla en la consulta.
     */
    RopaTalla buscarPorCodigo(String codigo) throws MongoException;

    /**
     * Recupera todas las prendas con talla almacenadas.
     *
     * @return Lista con todos los registros de RopaTalla.
     * @throws MongoException Si ocurre un error durante la recuperación.
     */
    List<RopaTalla> buscarTodos() throws MongoException;

    /**
     * Busca registros usando coincidencias parciales sobre texto (nombre, marca, categoría, etc.).
     *
     * @param textoBusqueda Cadena a buscar dentro de atributos relevantes.
     * @return Lista de coincidencias encontradas.
     * @throws MongoException Si la consulta falla.
     */
    List<RopaTalla> buscarPorFiltro(String textoBusqueda) throws MongoException;

    /**
     * Reduce el stock disponible de una prenda-talla específica.
     *
     * @param idRopaTalla ID del registro a modificar.
     * @param cantidadVendida Cantidad a restar del stock actual.
     * @throws MongoException Si ocurre un error o la actualización falla.
     */
    void reducirStock(String idRopaTalla, int cantidadVendida) throws MongoException;

    /**
     * Actualiza el stock de una instancia de {@link RopaTalla} directamente.
     *
     * @param idRopaTalla ID de la prenda con talla.
     * @param cantidad Nueva cantidad de stock.
     * @throws MongoException En caso de error durante la actualización.
     */
    void actualizarStock(ObjectId idRopaTalla, int cantidad) throws MongoException;

    /**
     * Realiza una búsqueda aproximada basándose en los filtros proporcionados.
     *
     * @param temporada Temporada de la prenda (ej. verano, invierno).
     * @param material Material principal (algodón, mezclilla, etc.).
     * @param marca Marca de la ropa.
     * @param precio Rango de precio o precio exacto.
     * @param nombreTalla Nombre de la talla (S, M, L, XL...).
     * @return El objeto encontrado o null si no hay coincidencias.
     */
    RopaTalla buscarPorFiltroAproximado(String temporada, String material, String marca, Double precio, String nombreTalla);

    /**
     * Busca una instancia de {@link RopaTalla} combinando prenda y talla.
     *
     * @param ropa Objeto Ropa principal.
     * @param nombreTalla Nombre de la talla buscada.
     * @return La coincidencia encontrada o null si no existe.
     * @throws MongoException Si ocurre un error durante la consulta.
     */
    RopaTalla buscarRopaTalla(Ropa ropa, String nombreTalla) throws MongoException;
}
