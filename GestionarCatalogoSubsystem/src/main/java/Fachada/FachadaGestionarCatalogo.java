/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import Interfaz.IGestionarCatalogo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author garfi
 */
public class FachadaGestionarCatalogo implements IGestionarCatalogo {

    @Override
    public boolean agregarRopa(RopaDTO ropa) {
        try {
            RopaBO.getInstance().guardarRopa(ropa);
            return true;
        } catch (Exception e) {
            System.err.println("Error en Fachada al agregar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean editarRopa(RopaDTO ropa) {
        try {
            RopaBO.getInstance().modificarRopa(ropa);
            return true;
        } catch (Exception e) {
            System.err.println("Error en Fachada al editar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarRopa(RopaDTO ropa) {
        try {
            RopaBO.getInstance().eliminarRopa(ropa);
            return true;
        } catch (Exception e) {
            System.err.println("Error en Fachada al eliminar: " + e.getMessage());
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
    public List<RopaDTO> obtenerTodaLaRopa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody 
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
