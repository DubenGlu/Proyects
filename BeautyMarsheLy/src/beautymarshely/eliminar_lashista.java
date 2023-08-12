/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautymarshely;

import static beautymarshely.ConexionDB.getConexion;
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
public class eliminar_lashista extends javax.swing.JFrame {

    Menu obm = new Menu();
    int contlash = 0;
    public eliminar_lashista() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("src/imagenes/BeautyMarshe_Ly.png");
        this.setIconImage(img.getImage());
    }
    
    public void llenarComboBox() {
        try {
            Connection conect = getConexion();
            Statement leer = conect.createStatement();    
            ResultSet result = leer.executeQuery("select count(*) from lashistas");
                    
            int[] datos = new int[1];
                    
            while (result.next()) {
                datos[0] = result.getInt(1);
            }
                    
            contlash = datos[0];
                    
                    
                    
        } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el count de lashista: "+e);
                }
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select id_lashista from lashistas");
                    
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

        ElimDat = new javax.swing.JPanel();
        txt_id = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JLabel();
        txf_nombre = new javax.swing.JTextField();
        txt_appaterno = new javax.swing.JLabel();
        txf_appaterno = new javax.swing.JTextField();
        txt_servicio = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        txf_servicio = new javax.swing.JTextField();
        cb_id = new javax.swing.JComboBox<>();
        txt_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eliminar Lashista");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ElimDat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id.setText("ID:");
        ElimDat.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 20, -1));

        txt_nombre.setText("Nombre:");
        ElimDat.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        txf_nombre.setEditable(false);
        ElimDat.add(txf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 300, -1));

        txt_appaterno.setText("Apellido:");
        ElimDat.add(txt_appaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        txf_appaterno.setEditable(false);
        ElimDat.add(txf_appaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 300, -1));

        txt_servicio.setText("Servicio:");
        ElimDat.add(txt_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_cancelarMousePressed(evt);
            }
        });
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        ElimDat.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_eliminarMousePressed(evt);
            }
        });
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        ElimDat.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        txf_servicio.setEditable(false);
        ElimDat.add(txf_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 300, -1));

        cb_id.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_idItemStateChanged(evt);
            }
        });
        cb_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_idActionPerformed(evt);
            }
        });
        ElimDat.add(cb_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 87, 80, -1));

        txt_titulo.setText("Eliminar Datos");
        ElimDat.add(txt_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        getContentPane().add(ElimDat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMousePressed

        obm.ob_l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelarMousePressed

    private void btn_eliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarMousePressed
        try {
            String id = cb_id.getSelectedItem().toString();
            Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM LASHISTAS WHERE ID_LASHISTA = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.toString(), "", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } 

        btn_cancelarMousePressed(evt);

    }//GEN-LAST:event_btn_eliminarMousePressed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    this.llenarComboBox();
    }//GEN-LAST:event_formWindowOpened

    private void cb_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_idItemStateChanged
        try {
            String id = cb_id.getSelectedItem().toString();
            Connection con = ConexionDB.getConexion();
            Statement leer = con.createStatement();
            ResultSet res = leer.executeQuery("SELECT L.NOMBRE,AP_PATERNO,S.NOMBRE FROM LASHISTAS L JOIN SERVICIOS S ON (L.ID_SERVICIO = S.ID_SERVICIO) WHERE ID_LASHISTA = "+id);
            String[] datos = new String[3];
            while (res.next()) {
                datos[0]=res.getString(1);
                datos[1]=res.getString(2);
                datos[2]=res.getString(3);
            }
            txf_nombre.setText(datos[0]);
            txf_appaterno.setText(datos[1]);
            txf_servicio.setText(datos[2]);
            

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.toString(), "", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_cb_idItemStateChanged

    private void cb_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_idActionPerformed

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
            java.util.logging.Logger.getLogger(eliminar_lashista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(eliminar_lashista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(eliminar_lashista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(eliminar_lashista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new eliminar_lashista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ElimDat;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JComboBox<String> cb_id;
    private javax.swing.JTextField txf_appaterno;
    private javax.swing.JTextField txf_nombre;
    private javax.swing.JTextField txf_servicio;
    private javax.swing.JLabel txt_appaterno;
    private javax.swing.JLabel txt_id;
    private javax.swing.JLabel txt_nombre;
    private javax.swing.JLabel txt_servicio;
    private javax.swing.JLabel txt_titulo;
    // End of variables declaration//GEN-END:variables
}
