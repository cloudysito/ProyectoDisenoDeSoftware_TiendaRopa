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
    PagoDTO procesarPagoEfectivo(int monto);
    PagoDTO procesarPagoPaypal(int monto);
    PagoDTO procesarPagoTarjeta(int monto);
    PagoDTO procesarPagoTransferencia(int monto);
}
