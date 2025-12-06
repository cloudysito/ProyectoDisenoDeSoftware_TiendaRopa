/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlPantallas;

import DisenoGUIs.GUICodigoProducto;
import DisenoGUIs.GUICompraRealizada;
import DisenoGUIs.GUIInicioSesion;
import DisenoGUIs.GUIMenu;
import DisenoGUIs.GUIPagoEfectivo;
import DisenoGUIs.GUIPagoPaypal;
import DisenoGUIs.GUIPagoTarjeta;
import DisenoGUIs.GUIPagoTransferencia;
import DisenoGUIs.GUIProducto;
import DisenoGUIs.GUISeleccionMetodoPago;
import DisenoGUIs.GUIVenderPrenda;
import GUIDevolverPrenda.GUIBuscarVenta;
import GUIDevolverPrenda.GUIConfirmacionReembolso;
import GUIDevolverPrenda.GUIReembolsoPrenda;
import GUIDevolverPrenda.GUISeleccionMetodoReembolso;
import com.mycompany.aumentarventaempleado.Fachada.FachadaAumentarVentaEmpleado;
import com.mycompany.aumentarventaempleado.Interfaz.IAumentarVentaEmpleado;
import com.mycompany.dto_negocio.DetalleVentaDTO;
import com.mycompany.dto_negocio.EmpleadoDTO;
import com.mycompany.dto_negocio.RopaTallaDTO;
import com.mycompany.dto_negocio.SolicitudReembolsoDTO;
import com.mycompany.dto_negocio.VentaDTO;
import com.mycompany.escanearproductosubsystem.FachadaEscanearProducto;
import com.mycompany.escanearproductosubsystem.Interfaz.IEscanearProducto;
import com.mycompany.metodopagosubsystem.FachadaMetodoPago;
import com.mycompany.metodopagosubsystem.Interfaz.IMetodoPago;
import com.mycompany.realizarventasubsystem.Interfaz.IRealizarVenta;
import com.mycompany.realizarventasubsystem.FachadaRealizarVenta;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author emiim
 */
public class ControlPantallas {

    private static ControlPantallas instancia;
    private static IEscanearProducto escanerSistema;
    private static IRealizarVenta realizarVentaSistema;
    private static IMetodoPago metodoPagoSistema;
    private static IAumentarVentaEmpleado EmpleadoSistema;
    
    public static synchronized ControlPantallas getInstase() {
        if (instancia == null) {
            instancia = new ControlPantallas();
            escanerSistema = new FachadaEscanearProducto();
            realizarVentaSistema = new FachadaRealizarVenta();
            metodoPagoSistema = new FachadaMetodoPago();
            EmpleadoSistema = new FachadaAumentarVentaEmpleado();
           
        }
        return instancia;
    }

    private void cerrarFrameActual(JFrame frameActual) {
        if (frameActual != null) {
            frameActual.dispose();
        }
    }

    public void iniciarFlujo(){
        GUIInicioSesion iniciar = new GUIInicioSesion();
        iniciar.setVisible(true);
    }
    
    public void navegarMenuPrincipal(JFrame frameActual, EmpleadoDTO empleado) {
        cerrarFrameActual(frameActual);
        GUIMenu menu = new GUIMenu(empleado);
        menu.setVisible(true);
    }

    public void navegarCodigoProducto(JFrame frameActual, EmpleadoDTO empleado,VentaDTO venta, boolean ven) {
        cerrarFrameActual(frameActual);
        GUICodigoProducto cp = new GUICodigoProducto(empleado,  venta, ven);
        cp.setVisible(true);
    }

    public void navegarProducto(JFrame frameActual,EmpleadoDTO empleado, RopaTallaDTO productodto,VentaDTO venta,boolean ven) {
        cerrarFrameActual(frameActual);
        GUIProducto producto = new GUIProducto(empleado, productodto, venta , ven);
        producto.setVisible(true);
    }

    public void navegarVenderPrenda(JFrame frameActual,EmpleadoDTO empleado, VentaDTO venta) {
        cerrarFrameActual(frameActual);
        GUIVenderPrenda vp = new GUIVenderPrenda(empleado,venta);
        vp.setVisible(true);
    }

    public void navegarPagoEfectivo(JFrame frameActual,EmpleadoDTO empleado, VentaDTO venta) {
        cerrarFrameActual(frameActual);
        GUIPagoEfectivo efectivo = new GUIPagoEfectivo(empleado,venta);
        efectivo.setVisible(true);
    }

    public void navegarPagoPaypal(JFrame frameActual, EmpleadoDTO empleado, VentaDTO venta) {
        cerrarFrameActual(frameActual);
        GUIPagoPaypal paypal = new GUIPagoPaypal(empleado,venta);
        paypal.setVisible(true);
    }

    public void navegarPagoTarjeta(JFrame frameActual,EmpleadoDTO empleado, VentaDTO venta) {
        cerrarFrameActual(frameActual);
        GUIPagoTarjeta tarjeta = new GUIPagoTarjeta(empleado,venta);
        tarjeta.setVisible(true);
    }

    public void navegarPagoTransferencia(JFrame frameActual,EmpleadoDTO empleado, VentaDTO venta) {
        cerrarFrameActual(frameActual);
        GUIPagoTransferencia transferencia = new GUIPagoTransferencia(empleado,venta);
        transferencia.setVisible(true);
    }

    public void navegarSeleccionMetodoPago(JFrame frameActual, EmpleadoDTO empleado, VentaDTO venta) {
        cerrarFrameActual(frameActual);
        GUISeleccionMetodoPago smp = new GUISeleccionMetodoPago(empleado,venta);
        smp.setVisible(true);
    }
    public void navegarBuscarVenta(JFrame frame) {
        cerrarFrameActual(frame);
        new GUIBuscarVenta().setVisible(true);
    }

    public void navegarReembolsoPrenda(JFrame frame, VentaDTO venta) {
        cerrarFrameActual(frame);
        new GUIReembolsoPrenda(venta).setVisible(true);
    }

    public void navegarMetodoReembolso(JFrame frame, SolicitudReembolsoDTO solicitud) {
        cerrarFrameActual(frame);
        new GUISeleccionMetodoReembolso(solicitud).setVisible(true);
    }

    public void navegarConfirmacionReembolso(JFrame frame) {
        cerrarFrameActual(frame);
        new GUIConfirmacionReembolso().setVisible(true);
    }
    
    public void mostrarYGuardarTicketComoImagen(VentaDTO venta, JFrame frame) {
        // Validar que se reciba un objeto válido
        if (venta == null) {
            JOptionPane.showMessageDialog(frame, "La venta es nula");
            return;
        }

        // --- Crear texto del ticket ---
        StringBuilder sb = new StringBuilder();
        sb.append("=========== TICKET DE VENTA ===========\n");
        sb.append("Folio: ").append(venta.getFolioVenta()).append("\n");
        sb.append("Fecha: ").append(venta.getFechaHoraVenta()).append("\n");
        sb.append("----------------------------------------\n");
        sb.append("Empleado: ").append(venta.getEmpleado().getNombre())
          .append(" ").append(venta.getEmpleado().getApellidos()).append("\n");
        sb.append("Método de pago: ").append(venta.getMetodoPago()).append("\n");
        sb.append("----------------------------------------\n");
        sb.append(String.format("%-15s %-8s %-10s %-10s\n", "Producto", "Cant.", "Precio", "Subtot."));
        sb.append("----------------------------------------\n");

        for (DetalleVentaDTO d : venta.getDetalles()) {
            sb.append(String.format("%-15s %-8d %-10.2f %-10.2f\n",
                    d.getRopaTalla().getRopa().getNombreArticulo(),
                    d.getCantidadVendida(),
                    d.getRopaTalla().getRopa().getPrecio(),
                    d.getSubtotal()));
        }

        sb.append("----------------------------------------\n");
        sb.append(String.format("TOTAL: $%.2f\n", venta.getTotalVenta()));
        sb.append("========================================\n");

        String[] lineas = sb.toString().split("\n");

        // --- Configuración de la imagen ---
        int ancho = 400;
        int alto = lineas.length * 20 + 20; // 20px por línea
        BufferedImage image = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();

        // Fondo blanco
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, ancho, alto);

        // Texto negro
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Monospaced", Font.PLAIN, 14));

        int y = 20;
        for (String linea : lineas) {
            g2.drawString(linea, 10, y);
            y += 20;
        }
        g2.dispose();

        // --- Mostrar en JOptionPane centrado en el frame ---
        ImageIcon icon = new ImageIcon(image);
        JOptionPane.showMessageDialog(frame, new JLabel(icon), "Ticket de venta", JOptionPane.PLAIN_MESSAGE);

        // --- Guardar imagen ---
        try {
            File carpeta = new File("tickets");
            if (!carpeta.exists()) carpeta.mkdirs();

            String nombreArchivo = "ticket_" + venta.getFolioVenta() + ".png";
            File archivo = new File(carpeta, nombreArchivo);

            ImageIO.write(image, "png", archivo);

            JOptionPane.showMessageDialog(frame,
                    "Ticket guardado en: " + archivo.getAbsolutePath(),
                    "Guardado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame,
                    "Error al guardar el ticket: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ControlPantallas getInstancia() {
        return instancia;
    }

    public IEscanearProducto getEscanerSistema() {
        return escanerSistema;
    }

    public IRealizarVenta getRealizarVentaSistema() {
        return realizarVentaSistema;
    }

    public  IMetodoPago getMetodoPagoSistema() {
        return metodoPagoSistema;
    }

    public IAumentarVentaEmpleado getEmpleadoSistema() {
        return EmpleadoSistema;
    }
    
    public void mostrarImagenEnLabel(String ruta, JLabel label) {

    SwingUtilities.invokeLater(() -> {
        File archivo = new File(ruta);

        if (!archivo.exists()) {
            System.out.println("ERROR: La imagen no existe: " + ruta);
            return;
        }

        int w = label.getWidth();
        int h = label.getHeight();

        if (w == 0 || h == 0) {
            System.out.println("Label aún no tiene tamaño, intentando de nuevo...");
            return; 
        }

        ImageIcon icon = new ImageIcon(ruta);

        Image img = icon.getImage().getScaledInstance(
                w,
                h,
                Image.SCALE_SMOOTH
        );

        label.setIcon(new ImageIcon(img));
        label.revalidate();
        label.repaint();
    });
}


    
    
}
