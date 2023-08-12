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
public class editar_direccion extends javax.swing.JFrame {

    int contadordatos;
    public editar_direccion() {
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
        txt_calle = new javax.swing.JLabel();
        txt_numero = new javax.swing.JLabel();
        txt_colonia = new javax.swing.JLabel();
        txt_ciudad = new javax.swing.JLabel();
        txt_estado = new javax.swing.JLabel();
        txf_calle = new javax.swing.JTextField();
        txf_numero = new javax.swing.JTextField();
        txf_colonia = new javax.swing.JTextField();
        txf_ciudad = new javax.swing.JTextField();
        txf_estado = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        txt_id = new javax.swing.JLabel();
        cb_iddir = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txt_titulo.setText("Insertar Direccion");

        txt_calle.setText("Calle:");

        txt_numero.setText("Numero:");

        txt_colonia.setText("Colonia:");

        txt_ciudad.setText("Ciudad:");

        txt_estado.setText("Estado");

        txf_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_ciudadActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        txt_id.setText("ID:");

        cb_iddir.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_iddirItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(txt_titulo))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_guardar)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txt_numero)
                                        .addComponent(txt_calle)
                                        .addComponent(txt_colonia)
                                        .addComponent(txt_ciudad)
                                        .addComponent(txt_estado))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txf_calle)
                                        .addComponent(txf_numero)
                                        .addComponent(txf_colonia)
                                        .addComponent(txf_ciudad)
                                        .addComponent(txf_estado, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(btn_cancelar)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(txt_id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_iddir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(txt_titulo)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id)
                    .addComponent(cb_iddir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txf_calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_calle))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_numero)
                            .addComponent(txf_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_colonia)
                            .addComponent(txf_colonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ciudad)
                            .addComponent(txf_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txt_estado))
                    .addComponent(txf_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_guardar))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txf_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_ciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_ciudadActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
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

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        try {
            ConexionDB.getConexion();
            int id = Integer.parseInt(cb_iddir.getSelectedItem().toString());
            String calle = txf_calle.getText();
            int numero = Integer.parseInt(txf_numero.getText());
            String colonia = txf_colonia.getText();
            String ciudad = txf_ciudad.getText();
            String estado = txf_estado.getText();
            Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE DIRECCION SET CALLE = ?, NUMERO = ?, COLONIA = ?, CIUDAD = ?, ESTADO = ? WHERE ID_DIRECCION = ?");

            ps.setString(1, calle);
            ps.setInt(2, numero);
            ps.setString(3, colonia);
            ps.setString(4, ciudad);
            ps.setString(5, estado);
            ps.setInt(6, id);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente");

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error en el insert: "+sql, "Error en SQL", JOptionPane.ERROR_MESSAGE);

        }

        btn_cancelarActionPerformed(evt);

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarComboBoxid();
    }//GEN-LAST:event_formWindowOpened

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
            txf_numero.setText(datos[1]);
            txf_colonia.setText(datos[2]);
            txf_ciudad.setText(datos[3]);
            txf_estado.setText(datos[4]);

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.toString(), "Error en el itemStateChanged", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_cb_iddirItemStateChanged

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
            java.util.logging.Logger.getLogger(editar_direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editar_direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editar_direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editar_direccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editar_direccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cb_iddir;
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
