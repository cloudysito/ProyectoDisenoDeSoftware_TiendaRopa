/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.metodopagosubsystem;

import com.mycompany.dto_negocio.PagoDTO;
import com.mycompany.metodopagosubsystem.Interfaz.IMetodoPago;

/**
 *
 * @author santi
 */
public class FachadaMetodoPago implements IMetodoPago {
    @Override
    public PagoDTO procesarPagoEfectivo(double monto) {
        return new PagoDTO("Efectivo", monto, true);
    }

    @Override
    public PagoDTO procesarPagoPaypal(double monto) {
        return new PagoDTO("Paypal", monto, true);
    }

    @Override
    public PagoDTO procesarPagoTarjeta(double monto) {
        return new PagoDTO("Tarjeta", monto, true);
    }

    @Override
    public PagoDTO procesarPagoTransferencia(double monto) {
        return new PagoDTO("Transferencia", monto, true);
    }
}