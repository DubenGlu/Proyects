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
public class eliminar_sucursal extends javax.swing.JFrame {

    /**
     * Creates new form eliminar_sucursal
     */
    
    Menu obm = new Menu();
    int contadordatos;
    
    public eliminar_sucursal() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("src/imagenes/BeautyMarshe_Ly.png");
        this.setIconImage(img.getImage());
    }

    public void llenarComboBox() {
        try {
            Connection conect = getConexion();
            Statement leer = conect.createStatement();    
            ResultSet result = leer.executeQuery("select count(*) from sucursales");
                    
            int[] datos = new int[1];
                    
            while (result.next()) {
                datos[0] = result.getInt(1);
            }
                    
            contadordatos = datos[0];
                    
                    
                    
        } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el count de sucursales: "+e);
                }
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select id_sucursal from sucursales");
                    
                    String[] datos = new String[contadordatos];
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
        txt_telefono = new javax.swing.JLabel();
        txf_telefono = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        cb_id = new javax.swing.JComboBox<>();
        txt_titulo = new javax.swing.JLabel();
        txf_direccion = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id.setText("ID:");

        txt_telefono.setText("Telefono:");

        txf_telefono.setEditable(false);

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

        cb_id.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_idItemStateChanged(evt);
            }
        });

        txt_titulo.setText("Eliminar Sucursal");

        txf_direccion.setEditable(false);

        txt_direccion.setText("Direccion:");

        javax.swing.GroupLayout ElimDatLayout = new javax.swing.GroupLayout(ElimDat);
        ElimDat.setLayout(ElimDatLayout);
        ElimDatLayout.setHorizontalGroup(
            ElimDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ElimDatLayout.createSequentialGroup()
                .addGroup(ElimDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ElimDatLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(txt_titulo))
                    .addGroup(ElimDatLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ElimDatLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(txt_telefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ElimDatLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(ElimDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ElimDatLayout.createSequentialGroup()
                                .addComponent(btn_cancelar)
                                .addGap(375, 375, 375)
                                .addComponent(btn_eliminar))
                            .addGroup(ElimDatLayout.createSequentialGroup()
                                .addComponent(txt_direccion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txf_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(50, 50, 50))
        );
        ElimDatLayout.setVerticalGroup(
            ElimDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ElimDatLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txt_titulo)
                .addGap(25, 25, 25)
                .addGroup(ElimDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_id)
                    .addComponent(cb_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(ElimDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_telefono)
                    .addComponent(txf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(ElimDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txf_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_direccion))
                .addGap(51, 51, 51)
                .addGroup(ElimDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_cancelar))
                .addGap(15, 15, 15))
        );

        getContentPane().add(ElimDat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMousePressed

        
    }//GEN-LAST:event_btn_cancelarMousePressed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        Sucursales ob = new Sucursales();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_eliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarMousePressed
        
    }//GEN-LAST:event_btn_eliminarMousePressed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        try {
            String id = cb_id.getSelectedItem().toString();
            Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM SUCURSALES WHERE ID_SUCURSAL = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.toString(), "", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        btn_cancelarActionPerformed(evt);
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void cb_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_idItemStateChanged
        try {
            String id = cb_id.getSelectedItem().toString();
            Connection con = ConexionDB.getConexion();
            Statement leer = con.createStatement();
            ResultSet res = leer.executeQuery("SELECT TELEFONO, calle||' #'||numero||', colonia '||colonia||', '||ciudad||', '||estado FROM SUCURSALES NATURAL JOIN DIRECCION WHERE ID_SUCURSAL = "+id);
            String[] datos = new String[3];
            while (res.next()) {
                datos[0]=res.getString(1);
                datos[1]=res.getString(2);
            }
            txf_telefono.setText(datos[0]);
            txf_direccion.setText(datos[1]);

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.toString(), "", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_cb_idItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarComboBox();
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
            java.util.logging.Logger.getLogger(eliminar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(eliminar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(eliminar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(eliminar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new eliminar_sucursal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ElimDat;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JComboBox<String> cb_id;
    private javax.swing.JTextField txf_direccion;
    private javax.swing.JTextField txf_telefono;
    private javax.swing.JLabel txt_direccion;
    private javax.swing.JLabel txt_id;
    private javax.swing.JLabel txt_telefono;
    private javax.swing.JLabel txt_titulo;
    // End of variables declaration//GEN-END:variables
}
