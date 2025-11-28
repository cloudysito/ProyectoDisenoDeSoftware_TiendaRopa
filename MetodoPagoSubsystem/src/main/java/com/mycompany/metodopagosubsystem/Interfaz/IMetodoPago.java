/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.metodopagosubsystem.Interfaz;

import com.mycompany.dto_negocio.PagoDTO;


/**
 *
 * @author santi
 */
public interface IMetodoPago {
    PagoDTO procesarPagoEfectivo(double monto);
    PagoDTO procesarPagoPaypal(double monto);
    PagoDTO procesarPagoTarjeta(double monto);
    PagoDTO procesarPagoTransferencia(double monto);
}
