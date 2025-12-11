/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.metodopagosubsystem.Interfaz;

import com.mycompany.dto_negocio.PagoDTO;
import com.mycompany.dto_negocio.PagoEfectivoDTO;
import com.mycompany.dto_negocio.PagoPaypalDTO;
import com.mycompany.dto_negocio.PagoTarjetaDTO;
import com.mycompany.dto_negocio.PagoTransferenciaDTO;


/**
 *
 * @author santi
 */
public interface IMetodoPago {
    PagoDTO procesarPagoEfectivo(PagoEfectivoDTO pagoEfectivo) throws Exception;
    PagoDTO procesarPagoPaypal(PagoPaypalDTO pagoPaypal) throws Exception;
    PagoDTO procesarPagoTarjeta(PagoTarjetaDTO pagoTarjeta) throws Exception;
    PagoDTO procesarPagoTransferencia(PagoTransferenciaDTO pagoTransferencia) throws Exception;
}
