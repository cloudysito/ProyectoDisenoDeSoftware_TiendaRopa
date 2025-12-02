/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import Interfaz.IGestionarCatalogo;
import com.mycompany.dto_negocio.RopaDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author garfi
 */
public class FachadaGestionarCatalogo implements IGestionarCatalogo {

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

    @Override
    public RopaDTO buscarRopaPorId(String id) {
        try {
            return RopaBO.getInstance().buscarPorId(id);
        } catch (Exception e) {
            System.err.println("Error buscando por ID: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<RopaTallaDTO> buscarPorFiltro(String texto) {
        try {
            return RopaTallaBO.getInstance().buscarProductos(texto);
        } catch (Exception e) {
            System.err.println("Error buscando: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<RopaTallaDTO> obtenerInventarioCompleto() {
        try {
            return RopaTallaBO.getInstance().buscarTodos();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

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
