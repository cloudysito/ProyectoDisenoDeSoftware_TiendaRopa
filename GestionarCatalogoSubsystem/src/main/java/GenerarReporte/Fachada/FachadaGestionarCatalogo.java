/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GenerarReporte.Fachada;

import BOs.RopaBO;
import BOs.RopaTallaBO;
import GenerarReporte.Interfaz.IGestionarCatalogo;
import com.mycompany.dto_negocio.RopaDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del patrón Fachada para la gestión del Catálogo de Ropa.
 * <p>
 * Esta clase centraliza las operaciones de creación, lectura, actualización y eliminación (CRUD)
 * de prendas y sus tallas. Actúa como intermediario entre la capa de control/presentación y 
 * los Objetos de Negocio (BOs) como {@code RopaBO} y {@code RopaTallaBO}.
 * </p>
 * <p>
 * Su responsabilidad principal es capturar excepciones provenientes de la capa de datos
 * y devolver respuestas booleanas o listas vacías para mantener la estabilidad de la interfaz gráfica.
 * </p>
 *
 * @author garfi
 * @version 1.0
 */
public class FachadaGestionarCatalogo implements IGestionarCatalogo {

    /**
     * Agrega una nueva relación de Prenda y Talla al inventario.
     * <p>
     * Delega la operación al singleton {@code RopaTallaBO}.
     * </p>
     *
     * @param producto El DTO que contiene la información de la ropa, la talla y la cantidad (stock).
     * @return {@code true} si el producto se guardó correctamente; {@code false} si ocurrió un error.
     */
    @Override
    public boolean agregarRopa(RopaTallaDTO producto) {
        try {
            RopaTallaBO.getInstance().guardar(producto);
            return true;
        } catch (Exception e) {
            System.err.println("Error en Fachada al agregar ropa: " + e.getMessage());
            return false;
        }
    }

    /**
     * Actualiza la información general de una prenda de ropa.
     * <p>
     * Permite modificar atributos como el nombre, precio o descripción a través de {@code RopaBO}.
     * </p>
     *
     * @param ropa El DTO con la información actualizada de la prenda.
     * @return {@code true} si la edición fue exitosa; {@code false} en caso contrario.
     */
    @Override
    public boolean editarRopa(RopaDTO ropa) {
        try {
            RopaBO.getInstance().modificarRopa(ropa);
            return true;
        } catch (Exception e) {
            System.err.println("Error en Fachada al editar ropa: " + e.getMessage());
            return false;
        }
    }

    /**
     * Elimina una prenda del catálogo.
     * <p>
     * Solicita al {@code RopaBO} la eliminación lógica o física de la prenda especificada.
     * </p>
     *
     * @param ropa El DTO que representa la prenda a eliminar.
     * @return {@code true} si la eliminación se procesó correctamente; {@code false} si hubo un error.
     */
    @Override
    public boolean eliminarRopa(RopaDTO ropa) {
        try {
            RopaBO.getInstance().eliminarRopa(ropa);
            return true;
        } catch (Exception e) {
            System.err.println("Error en Fachada al eliminar ropa: " + e.getMessage());
            return false;
        }
    }

    /**
     * Busca una prenda específica por su identificador único.
     *
     * @param id El ID de la prenda a buscar (generalmente un ObjectId o String).
     * @return El objeto {@code RopaDTO} encontrado, o {@code null} si no existe o hubo un error.
     */
    @Override
    public RopaDTO buscarRopaPorId(String id) {
        try {
            return RopaBO.getInstance().buscarPorId(id);
        } catch (Exception e) {
            System.err.println("Error buscando por ID: " + e.getMessage());
            return null;
        }
    }

    /**
     * Realiza una búsqueda de productos en el inventario basada en un filtro de texto.
     * <p>
     * Utiliza {@code RopaTallaBO} para buscar coincidencias en nombres, descripciones o códigos.
     * </p>
     *
     * @param texto El criterio de búsqueda ingresado por el usuario.
     * @return Una lista de {@code RopaTallaDTO} con las coincidencias. Retorna una lista vacía en caso de error.
     */
    @Override
    public List<RopaTallaDTO> buscarPorFiltro(String texto) {
        try {
            return RopaTallaBO.getInstance().buscarProductos(texto);
        } catch (Exception e) {
            System.err.println("Error buscando: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Recupera el inventario completo de productos (Ropa + Talla).
     * <p>
     * Es útil para generar reportes completos o llenar tablas de gestión.
     * </p>
     *
     * @return Una lista con todos los {@code RopaTallaDTO} disponibles. Retorna lista vacía si falla.
     */
    @Override
    public List<RopaTallaDTO> obtenerInventarioCompleto() {
        try {
            return RopaTallaBO.getInstance().buscarTodos();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Busca prendas que coincidan con un nombre específico.
     * <p>
     * A diferencia de {@code buscarPorFiltro}, este método interactúa directamente con {@code RopaBO}
     * y devuelve solo la información base de la ropa (sin detalles de talla/stock).
     * </p>
     *
     * @param nombreArticulo El nombre de la prenda a buscar.
     * @return Una lista de {@code RopaDTO} que coinciden con el nombre. Retorna lista vacía si hay error.
     */
    @Override
    public List<RopaDTO> buscarRopaPorNombre(String nombreArticulo) {
        try {
            return RopaBO.getInstance().buscarPorNombre(nombreArticulo);
        } catch (Exception e) {
            System.err.println("Error buscando por nombre: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}