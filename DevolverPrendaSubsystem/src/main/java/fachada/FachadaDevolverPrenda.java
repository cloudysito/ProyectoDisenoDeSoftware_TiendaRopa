/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import BOs.ReembolsoBO;
import Implementaciones.EmpleadoDAO;
import Implementaciones.ReembolsoDAO;
import Implementaciones.RopaTallaDAO;
import Implementaciones.VentaDAO;
import Interfaces.ISistemaPagos;
import com.mycompany.dto_negocio.EmpleadoDTO;
import com.mycompany.dto_negocio.SolicitudReembolsoDTO;
import com.mycompany.dto_negocio.VentaDTO;
import interfaz.IDevolverPrenda;
import infraestructura.SistemaPagos;

/**
 *
 * @author emiim
 */
public class FachadaDevolverPrenda implements IDevolverPrenda {

    public FachadaDevolverPrenda() {
        ReembolsoBO bo = ReembolsoBO.getInstance();

        bo.setDependencias(
            new EmpleadoDAO(),   
            new VentaDAO(),        
            new RopaTallaDAO(),     
            new ReembolsoDAO(), (ISistemaPagos) new SistemaPagos());
    }

    @Override
    public EmpleadoDTO autenticar(String usuario, String contrasenia) {
        return ReembolsoBO.getInstance().autenticar(usuario, contrasenia);
    }

    @Override
    public VentaDTO buscarVenta(String idVenta) {
        return ReembolsoBO.getInstance().buscarVenta(idVenta);
    }

    @Override
    public boolean validarCantidades(SolicitudReembolsoDTO solicitud) {
        return ReembolsoBO.getInstance().validarCantidades(solicitud);
    }

    @Override
    public boolean procesarDevolucion(SolicitudReembolsoDTO solicitud) {
        return ReembolsoBO.getInstance().procesarReembolso(solicitud);
    }
}
