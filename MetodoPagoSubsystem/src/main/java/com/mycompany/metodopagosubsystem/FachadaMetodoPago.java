/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.metodopagosubsystem;

import com.mycompany.dto_negocio.PagoDTO;
import com.mycompany.metodopagosubsystem.Interfaz.IMetodoPago;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author santi
 */
public class FachadaMetodoPago implements IMetodoPago {
    private static final String URL_BASE = "http://localhost:5000";

    @Override
    public PagoDTO procesarPagoEfectivo(PagoEfectivoDTO pagoEfectivo) throws Exception {
        PagoDTO pago = pagoEfectivo.toPagoDTO();
        boolean aprobado = enviarPagoAlServidor(pago);
        pago.setExitoso(aprobado);
        return pago;
    }

    @Override
    public PagoDTO procesarPagoPaypal(PagoPaypalDTO pagoPaypal) throws Exception {
        PagoDTO pago = pagoPaypal.toPagoDTO();
        boolean aprobado = enviarPagoAlServidor(pago);
        pago.setExitoso(aprobado);
        return pago;
    }

    @Override
    public PagoDTO procesarPagoTarjeta(PagoTarjetaDTO pagoTarjeta) throws Exception {
        PagoDTO pago = pagoTarjeta.toPagoDTO();
        boolean aprobado = enviarPagoAlServidor(pago);
        pago.setExitoso(aprobado);
        return pago;
    }

    @Override
    public PagoDTO procesarPagoTransferencia(PagoTransferenciaDTO pagoTransferencia) throws Exception {
        PagoDTO pago = pagoTransferencia.toPagoDTO();
        boolean aprobado = enviarPagoAlServidor(pago);
        pago.setExitoso(aprobado);
        return pago;
    }

    private boolean enviarPagoAlServidor(PagoDTO pago) throws Exception {

        String json = "{"
                + "\"metodo\":\"" + pago.getMetodo() + "\","
                + "\"monto\":" + pago.getMonto()
                + "}";

        URL url = new URL(URL_BASE + "/pago/validar");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setDoOutput(true);

        try (OutputStream os = con.getOutputStream()) {
            os.write(json.getBytes("UTF-8"));
        }

        BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "UTF-8")
        );

        StringBuilder respuesta = new StringBuilder();
        String linea;
        while ((linea = br.readLine()) != null) {
            respuesta.append(linea);
        }

        String r = respuesta.toString().replace(" ", "").toLowerCase();

        return r.contains("\"aprobado\":true");
    }
}