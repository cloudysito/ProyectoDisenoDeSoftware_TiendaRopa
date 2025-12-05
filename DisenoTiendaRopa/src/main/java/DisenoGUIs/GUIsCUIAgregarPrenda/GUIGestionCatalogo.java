/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DisenoGUIs.GUIsCUIAgregarPrenda;

import ControlPantallas.ControlEmpleados;
import ControlPantallas.ControlGestionarSugerencias;
import ControlPantallas.ControlRopa;
import com.mycompany.dto_negocio.RopaTallaDTO;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;

/**
 * Ventana principal para la Gestión del Catálogo de Ropa.
 * <p>
 * Esta interfaz actúa como un "Dashboard" o panel de control donde el administrador puede:
 * <ul>
 * <li>Visualizar todas las prendas del inventario en formato de tarjetas.</li>
 * <li>Buscar productos por nombre o código.</li>
 * <li>Agregar nuevas prendas.</li>
 * <li>Eliminar o Editar prendas existentes (a través de los botones en cada tarjeta).</li>
 * <li>Generar reportes en PDF del inventario actual.</li>
 * <li>Navegar a otros módulos (Empleados, Sugerencias).</li>
 * </ul>
 * </p>
 *
 * @author garfi
 * @version 1.0
 */
public class GUIGestionCatalogo extends javax.swing.JFrame {

    /**
     * Constructor de la ventana.
     * <p>
     * Inicializa los componentes, centra la ventana, configura el diseño fluido (FlowLayout)
     * para el panel de tarjetas y carga los datos iniciales del catálogo.
     * </p>
     */
    public GUIGestionCatalogo() {
        initComponents();
        setLocationRelativeTo(null);
        // Configura el panel para que los items se acomoden de izquierda a derecha con margen
        pnlCatalogo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 20));
        cargarCatalogo();
        
    }

    /**
     * Configura la lógica de los botones "Editar" y "Eliminar" de una tarjeta de prenda específica.
     * <p>
     * Este método se llama dinámicamente cada vez que se crea una tarjeta visual ({@code panelPrenda})
     * para asignarle el comportamiento correcto asociado al ítem que representa.
     * </p>
     *
     * @param tarjeta El panel visual que representa la prenda.
     * @param item El DTO con los datos de la prenda asociada a esa tarjeta.
     */
    private void configurarBotonesTarjeta(panelPrenda tarjeta, com.mycompany.dto_negocio.RopaTallaDTO item) {

        // --- Botón ELIMINAR ---
        // Asigna un listener lambda para manejar el evento de clic
        tarjeta.getBtnEliminar().addActionListener(e -> {
            int confirm = javax.swing.JOptionPane.showConfirmDialog(null,
                    "¿Estás seguro de eliminar " + item.getRopa().getNombreArticulo() + "?",
                    "Eliminar Prenda", javax.swing.JOptionPane.YES_NO_OPTION);

            if (confirm == javax.swing.JOptionPane.YES_OPTION) {
                // Llama al controlador para eliminar la prenda de la base de datos
                boolean exito = ControlPantallas.ControlRopa.getInstase()
                        .getGestionCatalogo()
                        .eliminarRopa(item.getRopa());

                if (exito) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Eliminado correctamente");
                    // Recarga el catálogo para reflejar los cambios
                    cargarCatalogo();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            }
        });

        // --- Botón EDITAR ---
        tarjeta.getBtnEditar().addActionListener(e -> {
            // Navega a la pantalla de edición pasando los datos del item seleccionado
            ControlPantallas.ControlRopa.getInstase()
                    .navegarEditarPrenda(this, item);
        });
    }

    /**
     * Recarga y renderiza el contenido visual del catálogo.
     * <p>
     * Realiza los siguientes pasos:
     * <ol>
     * <li>Limpia el panel de visualización.</li>
     * <li>Agrega el botón fijo de "Añadir Prenda".</li>
     * <li>Obtiene la lista completa del inventario desde el controlador.</li>
     * <li>Por cada producto, crea un {@code panelPrenda}, configura sus datos y botones, y lo añade al panel.</li>
     * <li>Refresca la interfaz gráfica.</li>
     * </ol>
     * </p>
     */
    public void cargarCatalogo() {
        pnlCatalogo.removeAll();
        pnlCatalogo.add(pnlAñadirPrenda); // Siempre mantener el botón de añadir al principio
        try {
            List<RopaTallaDTO> listaRopa = ControlRopa.getInstase().getGestionCatalogo().obtenerInventarioCompleto();

            for (RopaTallaDTO item : listaRopa) {

                panelPrenda tarjeta = new panelPrenda();
                tarjeta.setDatos(item); // Llena la tarjeta con info del DTO
                configurarBotonesTarjeta(tarjeta, item); // Activa los botones de la tarjeta
                pnlCatalogo.add(tarjeta);
            }

        } catch (Exception e) {
            System.out.println("Error al cargar catálogo: " + e.getMessage());
        }

        // Actualiza la UI para mostrar los nuevos componentes
        pnlCatalogo.revalidate();
        pnlCatalogo.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscador = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnEmpleados = new javax.swing.JButton();
        btnSugerencia = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblNombreProducto = new javax.swing.JLabel();
        pnlCatalogo = new javax.swing.JPanel();
        pnlAñadirPrenda = new javax.swing.JPanel();
        btnAñadirPrenda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnGenerarReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(234, 154, 178));
        jPanel1.setPreferredSize(new java.awt.Dimension(494, 67));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Cuidado con el Kitten");

        txtBuscador.setPreferredSize(new java.awt.Dimension(64, 30));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lupa.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gatoLogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 238, 242));
        jPanel2.setPreferredSize(new java.awt.Dimension(642, 301));

        jPanel3.setBackground(new java.awt.Color(179, 222, 226));

        btnEmpleados.setBackground(new java.awt.Color(239, 207, 227));
        btnEmpleados.setText("Empleados");
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });

        btnSugerencia.setBackground(new java.awt.Color(239, 207, 227));
        btnSugerencia.setText("Sugerencia");
        btnSugerencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSugerenciaActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(226, 115, 150));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSugerencia, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnEmpleados)
                .addGap(18, 18, 18)
                .addComponent(btnSugerencia)
                .addGap(148, 148, 148)
                .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        lblNombreProducto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblNombreProducto.setForeground(new java.awt.Color(226, 115, 150));
        lblNombreProducto.setText("Gestión del Catálogo");

        pnlCatalogo.setBackground(new java.awt.Color(255, 238, 242));

        pnlAñadirPrenda.setBackground(new java.awt.Color(255, 213, 223));

        btnAñadirPrenda.setBackground(new java.awt.Color(255, 213, 223));
        btnAñadirPrenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mas.png"))); // NOI18N
        btnAñadirPrenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirPrendaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("<html><center>Añadir nueva <br> prenda</center></html>");

        javax.swing.GroupLayout pnlAñadirPrendaLayout = new javax.swing.GroupLayout(pnlAñadirPrenda);
        pnlAñadirPrenda.setLayout(pnlAñadirPrendaLayout);
        pnlAñadirPrendaLayout.setHorizontalGroup(
            pnlAñadirPrendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAñadirPrendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAñadirPrenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAñadirPrendaLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        pnlAñadirPrendaLayout.setVerticalGroup(
            pnlAñadirPrendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAñadirPrendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAñadirPrenda, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCatalogoLayout = new javax.swing.GroupLayout(pnlCatalogo);
        pnlCatalogo.setLayout(pnlCatalogoLayout);
        pnlCatalogoLayout.setHorizontalGroup(
            pnlCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCatalogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAñadirPrenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
        );
        pnlCatalogoLayout.setVerticalGroup(
            pnlCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCatalogoLayout.createSequentialGroup()
                .addComponent(pnlAñadirPrenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        btnGenerarReporte.setBackground(new java.awt.Color(226, 115, 150));
        btnGenerarReporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerarReporte.setText("Generar Reporte");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGenerarReporte)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreProducto)
                            .addComponent(pnlCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreProducto)
                .addGap(18, 18, 18)
                .addComponent(pnlCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción del botón "Empleados".
     * Navega hacia la pantalla de gestión de empleados.
     * @param evt El evento de acción.
     */
    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        // TODO add your handling code here:
        final ControlEmpleados navegador = ControlEmpleados.getInstase();
        navegador.navegarEmpleados(this);
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    /**
     * Acción del botón "Generar Reporte".
     * <p>
     * Abre un cuadro de diálogo para seleccionar la ubicación de guardado y 
     * solicita al controlador la generación del reporte PDF del inventario actual.
     * Si la generación es exitosa, intenta abrir el archivo automáticamente.
     * </p>
     * @param evt El evento de acción.
     */
    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Reporte de Inventario");
        fileChooser.setSelectedFile(new java.io.File("Reporte_Inventario.pdf"));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String ruta = fileToSave.getAbsolutePath();

            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }

            boolean exito = ControlPantallas.ControlRopa.getInstase()
                    .generarReporteDeCatalogo(ruta);

            if (exito) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Reporte generado exitosamente en:\n" + ruta);

                try {
                    java.awt.Desktop.getDesktop().open(new java.io.File(ruta));
                } catch (Exception ex) {
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Ocurrió un error al generar el reporte.",
                        "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    /**
     * Acción del botón "Regresar".
     * Vuelve al menú principal del administrador.
     * @param evt El evento de acción.
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        ControlEmpleados.getInstase().navegarMenuAdmin(this);
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * Acción del botón "Buscar".
     * <p>
     * Filtra las prendas mostradas en el catálogo basándose en el texto ingresado en {@code txtBuscador}.
     * Si el campo está vacío, recarga el catálogo completo.
     * </p>
     * @param evt El evento de acción.
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String texto = txtBuscador.getText().trim();

        if (texto.isEmpty()) {
            cargarCatalogo();
        } else {
            try {

                List<RopaTallaDTO> resultados = ControlPantallas.ControlRopa.getInstase()
                        .getGestionCatalogo()
                        .buscarPorFiltro(texto);

                if (resultados.isEmpty()) {
                    javax.swing.JOptionPane.showMessageDialog(this, "No se encontraron prendas con ese nombre o código.");
                } else {

                    pnlCatalogo.removeAll();
                    pnlCatalogo.add(pnlAñadirPrenda);

                    for (RopaTallaDTO item : resultados) {
                        panelPrenda tarjeta = new panelPrenda();
                        tarjeta.setDatos(item);
                        configurarBotonesTarjeta(tarjeta, item);

                        pnlCatalogo.add(tarjeta);
                    }
                    pnlCatalogo.revalidate();
                    pnlCatalogo.repaint();
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * Acción del botón "Sugerencia".
     * Navega a la pantalla de gestión de sugerencias.
     * @param evt El evento de acción.
     */
    private void btnSugerenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSugerenciaActionPerformed
        // TODO add your handling code here:
        ControlGestionarSugerencias.getInstance().navegarMenuSugerencias(this);
    }//GEN-LAST:event_btnSugerenciaActionPerformed

    /**
     * Acción del botón "Añadir Prenda".
     * Navega a la pantalla de registro de nuevas prendas.
     * @param evt El evento de acción.
     */
    private void btnAñadirPrendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirPrendaActionPerformed
        // TODO add your handling code here:
        ControlRopa.getInstase().navegarAñadirPrenda(this);
    }//GEN-LAST:event_btnAñadirPrendaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIGestionCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIGestionCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIGestionCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIGestionCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIGestionCatalogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirPrenda;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSugerencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JPanel pnlAñadirPrenda;
    private javax.swing.JPanel pnlCatalogo;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
}
