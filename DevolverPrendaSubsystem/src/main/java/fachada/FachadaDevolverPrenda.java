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
 * Implementación del patrón Fachada para el subsistema de Devolución.
 * Esta clase oculta la complejidad de la configuración de dependencias (DAOs y APIs externas)
 * y delega la lógica de negocio al objeto de negocio {@link ReembolsoBO}.
 * * @author emiim
 */
public class FachadaDevolverPrenda implements IDevolverPrenda {

    private ISistemaPagos sistemaPagos;
    
    public FachadaDevolverPrenda() {
        ReembolsoBO bo = ReembolsoBO.getInstance();
        sistemaPagos = new SistemaPagos();
    }

    /**
     * Delega la autenticación al BO.
     */
    @Override
    public EmpleadoDTO autenticar(String usuario, String contrasenia) {
        return ReembolsoBO.getInstance().autenticar(usuario, contrasenia);
    }

    /**
     * Delega la búsqueda de ventas al BO.
     */
    @Override
    public VentaDTO buscarVenta(String idVenta) {
        return ReembolsoBO.getInstance().buscarVenta(idVenta);
    }

    /**
     * Delega la validación de cantidades al BO.
     */
    @Override
    public boolean validarCantidades(SolicitudReembolsoDTO solicitud) {
        return ReembolsoBO.getInstance().validarCantidades(solicitud);
    }

    /**
     * Delega el procesamiento final de la devolución al BO.
     */
    @Override
    public boolean procesarReembolso(SolicitudReembolsoDTO solicitud) {
         boolean pagoExitoso = sistemaPagos.ejecutarReembolso(
            solicitud.getMontoTotal(),
            solicitud.getMetodoReembolso()
        );
        return ReembolsoBO.getInstance().procesarReembolso(solicitud, pagoExitoso);
    }
}
