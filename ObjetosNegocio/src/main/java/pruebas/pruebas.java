/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import BOs.*;
import com.mycompany.dto_negocio.DetalleVentaDTO;
import com.mycompany.dto_negocio.VentaDTO;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author santi
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setEmpleado(EmpleadoBO.getInstance().iniciarSesion("Santiago", "santi"));
        ventaDTO.agregarDetalle(new DetalleVentaDTO(RopaTallaBO.getInstance().buscarPorCodigo("9788417430948"), 1, 1));
        ventaDTO.setFechaHoraVenta(Date.from(Instant.now()));
        ventaDTO.setMetodoPago("Efectivo");
        ventaDTO.setFolioVenta(2333);
        
        VentaBO.getInstance().guardarVenta(ventaDTO);
    }
    
    
    
}
