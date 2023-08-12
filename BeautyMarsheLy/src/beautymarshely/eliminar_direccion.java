/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautymarshely;

import static beautymarshely.ConexionDB.getConexion;
import static beautymarshely.Direcciones.instanciado_como;
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
public class eliminar_direccion extends javax.swing.JFrame {

    int contadordatos;
    
    public eliminar_direccion() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("src/imagenes/BeautyMarshe_Ly.png");
        this.setIconImage(img.getImage());
    }

    public void llenarComboBoxid() {
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select count(*) from direccion");
                    
                    int[] datos = new int[1];
                    
                    while (result.next()) {
                        datos[0] = result.getInt(1);
                    }
                    
                    contadordatos = datos[0];
                    
                    
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el count de direccion: "+e);
                }
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select id_direccion from direccion");
                    
                    String[] datos = new String[contadordatos];
                    int i=0;
                    cb_iddir.addItem(null);
                    while (result.next()) {
                        datos[i] = result.getString(i+1);
                        cb_iddir.addItem(datos[i]);
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
        txt_id = new javax.swing.JLabel();
        cb_iddir = new javax.swing.JComboBox<>();
        txf_calle = new javax.swing.JTextField();
        txt_calle = new javax.swing.JLabel();
        txt_numero = new javax.swing.JLabel();
        txf_numero = new javax.swing.JTextField();
        txt_colonia = new javax.swing.JLabel();
        txf_colonia = new javax.swing.JTextField();
        txt_ciudad = new javax.swing.JLabel();
        txf_ciudad = new javax.swing.JTextField();
        txt_estado = new javax.swing.JLabel();
        txf_estado = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_titulo.setText("Eliminar direccion");
        jPanel1.add(txt_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 21, -1, -1));

        txt_id.setText("ID: ");
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        cb_iddir.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_iddirItemStateChanged(evt);
            }
        });
        jPanel1.add(cb_iddir, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 110, -1));

        txf_calle.setEditable(false);
        jPanel1.add(txf_calle, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 138, 247, -1));

        txt_calle.setText("Calle:");
        jPanel1.add(txt_calle, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 140, -1, -1));

        txt_numero.setText("Numero:");
        jPanel1.add(txt_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 177, -1, -1));

        txf_numero.setEditable(false);
        jPanel1.add(txf_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 175, 247, -1));

        txt_colonia.setText("Colonia:");
        jPanel1.add(txt_colonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 214, -1, -1));

        txf_colonia.setEditable(false);
        jPanel1.add(txf_colonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 212, 247, -1));

        txt_ciudad.setText("Ciudad:");
        jPanel1.add(txt_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 251, -1, -1));

        txf_ciudad.setEditable(false);
        txf_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_ciudadActionPerformed(evt);
            }
        });
        jPanel1.add(txf_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 249, 247, -1));

        txt_estado.setText("Estado");
        jPanel1.add(txt_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 286, -1, -1));

        txf_estado.setEditable(false);
        jPanel1.add(txf_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 282, 247, -1));

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txf_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_ciudadActionPerformed

    }//GEN-LAST:event_txf_ciudadActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        if (instanciado_como == 1) {
            insertar_sucursal ob = new insertar_sucursal();
            ob.setVisible(true);
            this.dispose();
        }else if (instanciado_como == 0) {
            Sucursales ob = new Sucursales();
            ob.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarComboBoxid();
    }//GEN-LAST:event_formWindowOpened

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        try {
            String id = cb_iddir.getSelectedItem().toString();
            Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM DIRECCION WHERE ID_DIRECCION = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null,"No se puede eliminar ya que esta direccion la esta ocupando una sucursal\n"
                    + "Elimine la sucursal "+cb_iddir.getSelectedItem().toString()+" para poder eliminar la direccion seleccionada!", "", JOptionPane.OK_OPTION);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        btn_cancelarActionPerformed(evt);
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void cb_iddirItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_iddirItemStateChanged
        try {
            String id = cb_iddir.getSelectedItem().toString();
            Connection con = ConexionDB.getConexion();
            Statement leer = con.createStatement();
            ResultSet res = leer.executeQuery("SELECT CALLE, NUMERO, COLONIA, CIUDAD, ESTADO FROM DIRECCION WHERE ID_DIRECCION = "+id);
            String[] datos = new String[5];
            while (res.next()) {
                datos[0]=res.getString(1);
                datos[1]=res.getString(2);
                datos[2]=res.getString(3);
                datos[3]=res.getString(4);
                datos[4]=res.getString(5);
            }
            txf_calle.setText(datos[0]);
            txf_numero.setText("$"+datos[1]);
            txf_colonia.setText(datos[2]);
            txf_ciudad.setText(datos[3]);
            txf_estado.setText(datos[4]);

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.toString(), "", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_cb_iddirItemStateChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(eliminar_direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(eliminar_direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(eliminar_direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(eliminar_direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new eliminar_direccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    public static javax.swing.JComboBox<String> cb_iddir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txf_calle;
    private javax.swing.JTextField txf_ciudad;
    private javax.swing.JTextField txf_colonia;
    private javax.swing.JTextField txf_estado;
    private javax.swing.JTextField txf_numero;
    private javax.swing.JLabel txt_calle;
    private javax.swing.JLabel txt_ciudad;
    private javax.swing.JLabel txt_colonia;
    private javax.swing.JLabel txt_estado;
    private javax.swing.JLabel txt_id;
    private javax.swing.JLabel txt_numero;
    private javax.swing.JLabel txt_titulo;
    // End of variables declaration//GEN-END:variables
}
