/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import com.mycompany.dto_negocio.EmpleadoDTO;
import com.mycompany.dto_negocio.SolicitudReembolsoDTO;
import com.mycompany.dto_negocio.VentaDTO;

/**
 *
 * @author emiim
 */
public interface IDevolverPrenda {
    EmpleadoDTO autenticar(String usuario, String contrasenia);
    VentaDTO buscarVenta(String idVenta);
    boolean validarCantidades(SolicitudReembolsoDTO solicitud);
    boolean procesarReembolso(SolicitudReembolsoDTO solicitud);
}
