/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import BOs.ReembolsoBO;
import infraestructura.ISistemaPagos;
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

    private ISistemaPagos sistemaPagos;
    
    public FachadaDevolverPrenda() {
        ReembolsoBO bo = ReembolsoBO.getInstance();
        sistemaPagos = new SistemaPagos();
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
    public boolean procesarReembolso(SolicitudReembolsoDTO solicitud) {
         boolean pagoExitoso = sistemaPagos.ejecutarReembolso(
            solicitud.getMontoTotal(),
            solicitud.getMetodoReembolso()
        );
        return ReembolsoBO.getInstance().procesarReembolso(solicitud, pagoExitoso);
    }
}
