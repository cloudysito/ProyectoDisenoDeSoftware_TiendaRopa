/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import com.mycompany.dto_negocio.DetalleVentaDTO;
import com.mycompany.dto_negocio.SolicitudDevolucionDTO;
import objetosnegocio.dominioPojo.Devolucion;
import objetosnegocio.dominioPojo.Empleado;

import Implementaciones.EmpleadoDAO;
import Implementaciones.TallaDAO;
import Implementaciones.VentaDAO;
import infraestructura.SistemaPagos;
import negocio.BODevolucion;
import negocio.IBODevolucion;
import persistencia.DevolucionDAO;

/**
 *
 * @author emiim
 */
public class FachadaDevolverPrenda implements IBODevolucion {
    private final IBODevolucion bo;

    public FachadaDevolverPrenda() {
        this.bo = new BODevolucion(
            new EmpleadoDAO(), 
            new VentaDAO(), 
            new TallaDAO(), 
            new DevolucionDAO(), 
            new SistemaPagos()
        );
    }

    @Override
    public Empleado autenticar(String usuario, String contrasenia) {
        return bo.autenticar(usuario, contrasenia);
    }

    @Override
    public DetalleVentaDTO buscarVenta(String idVenta) {
        return bo.buscarVenta(idVenta);
    }

    @Override
    public boolean validarCantidades(SolicitudDevolucionDTO solicitud) {
        return bo.validarCantidades(solicitud);
    }

    @Override
    public Devolucion procesarDevolucion(SolicitudDevolucionDTO solicitud) {
        return bo.procesarDevolucion(solicitud);
    }
}
