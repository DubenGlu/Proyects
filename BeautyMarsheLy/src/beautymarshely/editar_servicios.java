/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautymarshely;

import static beautymarshely.ConexionDB.getConexion;
import static beautymarshely.insertar_lashista.obm;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author rey_r
 */
public class editar_servicios extends javax.swing.JFrame {

    int contlash=0;
    
    public editar_servicios() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("src/imagenes/BeautyMarshe_Ly.png");
        this.setIconImage(img.getImage());
    }
    
    public void llenarComboBoxID() {
        cb_id.removeAllItems();
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select count(*) from servicios");
                    
                    int[] datos = new int[1];
                    
                    while (result.next()) {
                        datos[0] = result.getInt(1);
                    }
                    
                    contlash = datos[0];
                    
                    
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el count de servicios: "+e);
                }
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select id_servicio from servicios");
                    
                    String[] datos = new String[contlash];
                    int i=0;
                    cb_id.addItem(null);
                    while (result.next()) {
                        datos[i] = result.getString(i+1);
                        cb_id.addItem(datos[i]);
                    }
                    
 
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el llenado del combo box: "+e);
                }
    }

   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_titulo = new javax.swing.JLabel();
        cb_id = new javax.swing.JComboBox<>();
        txt_id = new javax.swing.JLabel();
        txf_nombre = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JLabel();
        txt_precio = new javax.swing.JLabel();
        txf_precio = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        txf_descripcion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_titulo.setText("Insertar Datos");
        jPanel1.add(txt_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        cb_id.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_idItemStateChanged(evt);
            }
        });
        jPanel1.add(cb_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 80, -1));

        txt_id.setText("ID:");
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 20, -1));
        jPanel1.add(txf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 300, -1));

        txt_nombre.setText("Nombre:");
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        txt_precio.setText("Precio:");
        jPanel1.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));
        jPanel1.add(txf_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 80, -1));

        txt_descripcion.setText("Descripcion:");
        jPanel1.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_cancelarMousePressed(evt);
            }
        });
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        btn_guardar.setText("Guardar");
        btn_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_guardarMousePressed(evt);
            }
        });
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));
        jPanel1.add(txf_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 300, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_idItemStateChanged
        try {
            String id = cb_id.getSelectedItem().toString();
            Connection con = ConexionDB.getConexion();
            Statement leer = con.createStatement();
            ResultSet res = leer.executeQuery("SELECT NOMBRE, PRECIO, DESCRIPCION FROM SERVICIOS WHERE ID_SERVICIO = "+id);
            String[] datos = new String[3];
            while (res.next()) {
                datos[0]=res.getString(1);
                datos[1]=res.getString(2);
                datos[2]=res.getString(3);
            }
            txf_nombre.setText(datos[0]);
            txf_precio.setText(datos[1]);
            txf_descripcion.setText(datos[2]);

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.toString(), "", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_cb_idItemStateChanged

    private void btn_cancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMousePressed
        obm.ob_se.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelarMousePressed

    private void btn_guardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMousePressed
        try {
            ConexionDB.getConexion();
            String nombre = txf_nombre.getText();
            int precio = Integer.parseInt(txf_precio.getText());
            String descripcion = txf_descripcion.getText();
            int id_servicio = Integer.parseInt(cb_id.getSelectedItem().toString());
            Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE SERVICIOS SET NOMBRE = ?, PRECIO = ?, DESCRIPCION = ? WHERE ID_SERVICIO = ?");

            ps.setString(1, nombre);
            ps.setInt(2, precio);
            ps.setString(3, descripcion);
            ps.setInt(4, id_servicio);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente");

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error en el insert: "+sql, "Error en SQL", JOptionPane.ERROR_MESSAGE);

        }

        btn_cancelarMousePressed(evt);
    }//GEN-LAST:event_btn_guardarMousePressed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarComboBoxID();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(editar_servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editar_servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editar_servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editar_servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editar_servicios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cb_id;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txf_descripcion;
    private javax.swing.JTextField txf_nombre;
    private javax.swing.JTextField txf_precio;
    private javax.swing.JLabel txt_descripcion;
    private javax.swing.JLabel txt_id;
    private javax.swing.JLabel txt_nombre;
    private javax.swing.JLabel txt_precio;
    private javax.swing.JLabel txt_titulo;
    // End of variables declaration//GEN-END:variables
}
