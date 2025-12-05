/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GenerarReporte.Interfaz;

import com.mycompany.dto_negocio.RopaDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio para la gestión del Catálogo de Ropa.
 * <p>
 * Establece los métodos necesarios para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre las prendas y el inventario, así como búsquedas específicas. Esta interfaz permite que 
 * los controladores interactúen con la capa de datos sin conocer los detalles de implementación.
 * </p>
 * * @author garfi
 * @version 1.0
 */
public interface IGestionarCatalogo {

    /**
     * Agrega un nuevo producto (Prenda + Talla + Stock) al catálogo.
     * * @param producto El objeto {@code RopaTallaDTO} que contiene toda la información del nuevo ítem.
     * @return {@code true} si la operación de guardado fue exitosa; {@code false} en caso contrario.
     */
    public boolean agregarRopa(RopaTallaDTO producto);

    /**
     * Modifica la información general de una prenda existente.
     * * @param ropa El objeto {@code RopaDTO} con los datos actualizados (nombre, precio, descripción, etc.).
     * @return {@code true} si la edición se realizó correctamente; {@code false} si hubo un error.
     */
    public boolean editarRopa(RopaDTO ropa);

    /**
     * Elimina una prenda del catálogo.
     * * @param ropa El objeto {@code RopaDTO} que representa la prenda a eliminar.
     * @return {@code true} si la eliminación fue exitosa; {@code false} si falló.
     */
    public boolean eliminarRopa(RopaDTO ropa);

    /**
     * Busca una prenda específica utilizando su identificador único.
     * * @param id El ID único de la prenda (generalmente un String o ObjectId).
     * @return El {@code RopaDTO} encontrado, o {@code null} si no existe ninguna prenda con ese ID.
     */
    public RopaDTO buscarRopaPorId(String id);
    
    /**
     * Realiza una búsqueda flexible de productos basada en un texto.
     * <p>
     * Este método es útil para barras de búsqueda generales, donde el usuario puede ingresar
     * parte del nombre, código o descripción.
     * </p>
     * * @param texto El criterio de búsqueda ingresado.
     * @return Una lista de {@code RopaTallaDTO} que coinciden con el filtro.
     */
    public List<RopaTallaDTO> buscarPorFiltro(String texto);

    /**
     * Recupera el listado completo de productos en el inventario.
     * <p>
     * Utilizado para llenar tablas principales o generar reportes globales.
     * </p>
     * * @return Una lista conteniendo todos los {@code RopaTallaDTO} disponibles en la base de datos.
     */
    public List<RopaTallaDTO> obtenerInventarioCompleto();

    /**
     * Busca prendas que coincidan exactamente o parcialmente con un nombre de artículo.
     * * @param nombreArticulo El nombre o parte del nombre a buscar.
     * @return Una lista de {@code RopaDTO} con las prendas encontradas.
     */
    public List<RopaDTO> buscarRopaPorNombre(String nombreArticulo);

}