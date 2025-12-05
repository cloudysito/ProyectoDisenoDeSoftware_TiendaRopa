/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import com.mycompany.dto_negocio.EmpleadoDTO;
import com.mycompany.dto_negocio.SolicitudReembolsoDTO;
import com.mycompany.dto_negocio.VentaDTO;

/**
 * Interfaz pública del subsistema de Devolución de Prendas.
 * Define los métodos necesarios para gestionar el flujo completo de un reembolso,
 * desde la autenticación del empleado hasta el procesamiento del pago.
 * * @author emiim
 */
public interface IDevolverPrenda {
    /**
     * Verifica las credenciales de un empleado para permitirle realizar devoluciones.
     * * @param usuario El nombre de usuario o ID del empleado.
     * @param contrasenia La contraseña del empleado.
     * @return Un objeto {@link EmpleadoDTO} si las credenciales son válidas, o null si fallan.
     */
    EmpleadoDTO autenticar(String usuario, String contrasenia);

    /**
     * Busca una venta realizada en el sistema mediante su identificador único.
     * * @param idVenta El ID de la venta a buscar.
     * @return Un objeto {@link VentaDTO} con los detalles de la venta encontrada, o null si no existe.
     */
    VentaDTO buscarVenta(String idVenta);

    /**
     * Valida que las cantidades solicitadas para devolución no excedan
     * las cantidades compradas originalmente ni las ya devueltas previamente.
     * * @param solicitud El objeto {@link SolicitudReembolsoDTO} con los detalles de la devolución propuesta.
     * @return true si las cantidades son válidas, false en caso contrario.
     */
    boolean validarCantidades(SolicitudReembolsoDTO solicitud);

    /**
     * Ejecuta el proceso de devolución final: actualiza el inventario, registra el reembolso
     * en la base de datos y dispara la transacción monetaria (sistema de pagos).
     * * @param solicitud El objeto {@link SolicitudReembolsoDTO} con la información final del reembolso.
     * @return true si el proceso se completó exitosamente, false si ocurrió algún error.
     */
    boolean procesarReembolso(SolicitudReembolsoDTO solicitud);
}
