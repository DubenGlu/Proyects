/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautymarshely;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rey_r
 */
public class Lashistas extends javax.swing.JFrame {
    
    Servicios obser = new Servicios();

    /**
     * Creates new form Lashistas
     */
    public Lashistas() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("src/imagenes/BeautyMarshe_Ly.png");
        this.setIconImage(img.getImage());
        
    }
    
    public static void cargarTabla() {
        
                DefaultTableModel tabla = new DefaultTableModel();
                
                tabla.addColumn("ID");
                tabla.addColumn("Nombre");
                tabla.addColumn("Apellido");
                tabla.addColumn("Servicio");
                
                String [] datos_lash = new String[4];
                
                try {
                    ConexionDB con = new ConexionDB();
                    Connection conect = con.getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("SELECT ID_LASHISTA,initcap(L.NOMBRE),initcap(AP_PATERNO),S.NOMBRE FROM LASHISTAS L JOIN SERVICIOS S ON (L.ID_SERVICIO = S.ID_SERVICIO) ORDER BY ID_LASHISTA");
                    
                    while (result.next()) {
                        datos_lash[0] = result.getString(1);
                        datos_lash[1] = result.getString(2);
                        datos_lash[2] = result.getString(3);
                        datos_lash[3] = result.getString(4);
                        tabla.addRow(datos_lash);
                    }
                    
                    tablaLashistas.setModel(tabla);
                    if (datos_lash[0] == null) {
                        JOptionPane.showMessageDialog(null, "No se ha insertado ninguna lashista");
                    }else{
                        JOptionPane.showMessageDialog(null, "La tabla ha cargado correctamente" );
                    }
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en la consulta: "+e);
                }
        
    }
    
    public static void limpiarTabla(){
        
        DefaultTableModel tb = (DefaultTableModel) tablaLashistas.getModel();
        int a = tablaLashistas.getRowCount()-1;
        int b = tablaLashistas.getColumnCount()-1;
        for (int i = a; i >= 0; i--) {          
        tb.removeRow(tb.getRowCount()-1);
        
        }
        tb.setColumnCount(0);
        
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLashistas = new javax.swing.JTable();
        txf_buscar = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        btn_lashdesp = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_anterior = new javax.swing.JLabel();
        btn_editar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lashistas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("LASHISTAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(204, 153, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 210, 40));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tablaLashistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaLashistas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, 440));
        getContentPane().add(txf_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 360, 25));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, 20));

        btn_lashdesp.setText("Lashistas despedidas");
        btn_lashdesp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lashdespActionPerformed(evt);
            }
        });
        getContentPane().add(btn_lashdesp, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, 200, -1));

        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, -1, -1));

        btn_agregar.setText("Agregar");
        btn_agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_agregarMousePressed(evt);
            }
        });
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 80, -1));

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 80, -1));

        btn_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Anterior.png"))); // NOI18N
        btn_anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_anteriorMousePressed(evt);
            }
        });
        getContentPane().add(btn_anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 30));

        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 80, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Plantilla.jpg"))); // NOI18N
        fondo.setText("jLabel1");
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
       
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        insertar_lashista ob_il = new insertar_lashista();
        ob_il.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_agregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarMousePressed
      
    }//GEN-LAST:event_btn_agregarMousePressed

    private void btn_anteriorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_anteriorMousePressed
        Menu obm = new Menu();
        obm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_anteriorMousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        limpiarTabla();
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        limpiarTabla();
        cargarTabla();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        eliminar_lashista ob = new eliminar_lashista();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        editar_lashista ob = new editar_lashista();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_lashdespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lashdespActionPerformed
        lashistas_despedidas ob = new lashistas_despedidas();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_lashdespActionPerformed

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
            java.util.logging.Logger.getLogger(Lashistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lashistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lashistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lashistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lashistas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JLabel btn_anterior;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_lashdesp;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tablaLashistas;
    private javax.swing.JTextField txf_buscar;
    // End of variables declaration//GEN-END:variables
}
