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
public class editar_cliente extends javax.swing.JFrame {

    static Menu obm = new Menu();
    int contlash = 0;
    int cantserv = 0;
    static int contadordatos = 0;
    
    public editar_cliente() {
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
                    ResultSet result = leer.executeQuery("select count(*) from clientes");
                    
                    int[] datos = new int[1];
                    
                    while (result.next()) {
                        datos[0] = result.getInt(1);
                    }
                    
                    contlash = datos[0];
                    
                    
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el count de cliente: "+e);
                }
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select id_cliente from clientes");
                    
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
        txt_id = new javax.swing.JLabel();
        txt_appaterno = new javax.swing.JLabel();
        txf_appaterno = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        txt_Titulo = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JLabel();
        txf_nombre = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        txt_edad = new javax.swing.JLabel();
        txt_Teléfono = new javax.swing.JLabel();
        txf_telefono = new javax.swing.JTextField();
        txf_edad = new javax.swing.JTextField();
        txt_Comp = new javax.swing.JLabel();
        cb_id = new javax.swing.JComboBox<>();
        cb_comp = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_id.setText("ID:");
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 30, 40));

        txt_appaterno.setText("Apellido:");
        jPanel1.add(txt_appaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, 20));

        txf_appaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_appaternoActionPerformed(evt);
            }
        });
        jPanel1.add(txf_appaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 300, -1));

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
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, -1, -1));

        txt_Titulo.setText("Insertar Datos");
        jPanel1.add(txt_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        txt_nombre.setText("Nombre:");
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        txf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_nombreActionPerformed(evt);
            }
        });
        jPanel1.add(txf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 300, -1));

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
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        txt_edad.setText("Edad:");
        jPanel1.add(txt_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        txt_Teléfono.setText("Teléfono:");
        jPanel1.add(txt_Teléfono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));
        jPanel1.add(txf_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 250, -1));
        jPanel1.add(txf_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 70, -1));

        txt_Comp.setText("Comprobante:");
        jPanel1.add(txt_Comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        cb_id.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_idItemStateChanged(evt);
            }
        });
        jPanel1.add(cb_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 80, -1));

        cb_comp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "si", "no" }));
        jPanel1.add(cb_comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txf_appaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_appaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_appaternoActionPerformed

    private void btn_guardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_guardarMousePressed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
       try {
             
            String nombre = txf_nombre.getText();
            String ap_paterno = txf_appaterno.getText();
            String comprobante = cb_comp.getSelectedItem().toString();
            long telefono = Long.parseLong(txf_telefono.getText());
            int edad = Integer.parseInt(txf_edad.getText());
            int id_cliente = Integer.parseInt(cb_id.getSelectedItem().toString());
            Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Clientes SET NOMBRE = ?, AP_PATERNO = ?, TELEFONO = ?, COMPROBANTE = ?, EDAD = ? WHERE ID_cliente = ?");
            
            ps.setString(1, nombre);
            ps.setString(2, ap_paterno);
            ps.setLong(3, telefono);
            ps.setString(4, comprobante);
            ps.setInt(5, edad);
            ps.setInt(6,id_cliente);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente");
            
            PreparedStatement ps2 = con.prepareStatement("commit");
            ps2.executeUpdate();
           
            

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error en el update: "+sql, "Error en SQL", JOptionPane.ERROR_MESSAGE);

        }
        
        btn_cancelarActionPerformed(evt);
                                     
        

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_nombreActionPerformed

    private void btn_cancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMousePressed
        // TODO add your handling code here:
        Clientes ob_cl = new Clientes();
        ob_cl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelarMousePressed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
         Clientes ob_cl = new Clientes();
        ob_cl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.llenarComboBoxID();
    }//GEN-LAST:event_formWindowOpened

    private void cb_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_idItemStateChanged
        try {
            String id = cb_id.getSelectedItem().toString();
            Connection con = ConexionDB.getConexion();
            Statement leer = con.createStatement();
            ResultSet res = leer.executeQuery("SELECT NOMBRE,AP_PATERNO,TELEFONO,COMPROBANTE,EDAD FROM CLIENTES WHERE ID_CLIENTE = "+id);
            String[] datos = new String[5];
            while (res.next()) {
                datos[0]=res.getString(1);
                datos[1]=res.getString(2);
                datos[2]=res.getString(3);
                datos[3]=res.getString(4);
                datos[4]=res.getString(5);
            }
            txf_nombre.setText(datos[0]);
            txf_appaterno.setText(datos[1]);
            txf_telefono.setText(datos[2]);
            cb_comp.setSelectedItem(datos[3]);
            txf_edad.setText(datos[4]);

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.toString(), "", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_cb_idItemStateChanged

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
            java.util.logging.Logger.getLogger(editar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editar_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cb_comp;
    private javax.swing.JComboBox<String> cb_id;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txf_appaterno;
    private javax.swing.JTextField txf_edad;
    private javax.swing.JTextField txf_nombre;
    private javax.swing.JTextField txf_telefono;
    private javax.swing.JLabel txt_Comp;
    private javax.swing.JLabel txt_Teléfono;
    private javax.swing.JLabel txt_Titulo;
    private javax.swing.JLabel txt_appaterno;
    private javax.swing.JLabel txt_edad;
    private javax.swing.JLabel txt_id;
    private javax.swing.JLabel txt_nombre;
    // End of variables declaration//GEN-END:variables
}
