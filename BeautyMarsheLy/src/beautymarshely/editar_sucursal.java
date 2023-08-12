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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class editar_sucursal extends javax.swing.JFrame {

    
    static int contadordatos = 0; 
    static int contadordatosdireccion = 0; 
    
    
    public editar_sucursal() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("src/imagenes/BeautyMarshe_Ly.png");
        this.setIconImage(img.getImage());
    }

     public void llenarComboBoxID() {
         
//        cb_id.removeAllItems();
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
                    while (result.next()) {
                        datos[i] = result.getString(i+1);
                        cb_id.addItem(datos[i]);
                    }
                    
 
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el llenado del combo box: "+e);
                }
    }
     
      public void llenarComboBoxDireccion() {
//          cb_direccion.removeAllItems();
        try {
                    
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select count(*) from direccion");
                    
                    int[] datos = new int[1];
                    
                    while (result.next()) {
                        datos[0] = result.getInt(1);
                    }
                    
                    contadordatosdireccion = datos[0];
                    
                    
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el count de direccion: "+e);
                }
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select id_direccion||' - '||calle||' #'||numero||', colonia '||colonia||', '||ciudad||', '||estado from direccion order by id_direccion");
                    
                    String[] datos = new String[contadordatosdireccion];
                    int i=0;
                    while (result.next()) {
                        datos[i] = result.getString(i+1);
                        cb_direccion.addItem(datos[i]);
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
        txt_ID = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JLabel();
        txf_telefono = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        cb_id = new javax.swing.JComboBox<>();
        cb_direccion = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txt_titulo.setText("Editar Sucursal");

        txt_ID.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_ID.setText("ID:");

        txt_direccion.setText("Dirección:");

        txt_telefono.setText("Teléfono:");

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

        cb_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cb_id.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_idItemStateChanged(evt);
            }
        });

        cb_direccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_direccion)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_cancelar)
                                .addGap(372, 372, 372)
                                .addComponent(btn_guardar))
                            .addComponent(cb_direccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_titulo)
                        .addGap(262, 262, 262))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_ID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_titulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ID)
                    .addComponent(cb_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefono))
                .addGap(30, 30, 30)
                .addComponent(txt_direccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_guardar))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
        Sucursales ob_su = new Sucursales();
        ob_su.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        try {
            ConexionDB.getConexion();
            int id_sucursal = Integer.parseInt(cb_id.getSelectedItem().toString());
            long telefono = Long.parseLong(txf_telefono.getText());
            String dir = cb_direccion.getSelectedItem().toString();
            char[] id_dir = dir.toCharArray();
            int id_direccion = Character.getNumericValue(id_dir[0]);

            Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE SUCURSALES SET TELEFONO = ?, ID_DIRECCION = ? WHERE ID_SUCURSAL = ?");
            
            ps.setLong(1, telefono);
            ps.setInt(2, id_direccion);
            ps.setInt(3, id_sucursal);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente");

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error en el insert: "+sql, "Error en SQL", JOptionPane.ERROR_MESSAGE);

        }

        btn_cancelarActionPerformed(evt);

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarComboBoxID();
    }//GEN-LAST:event_formWindowOpened

    private void cb_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_idItemStateChanged
        try {
            cb_direccion.removeAllItems();
            llenarComboBoxDireccion();
            String id = cb_id.getSelectedItem().toString();
            Connection con = ConexionDB.getConexion();
            Statement leer = con.createStatement();
            ResultSet res = leer.executeQuery("SELECT TELEFONO, id_direccion||' - '||calle||' #'||numero||', colonia '||colonia||', '||ciudad||', '||estado FROM SUCURSALES NATURAL JOIN DIRECCION WHERE ID_SUCURSAL = "+id);
            String[] datos = new String[2];
            while (res.next()) {
                datos[0]=res.getString(1);
                datos[1]=res.getString(2);
            }
            txf_telefono.setText(datos[0]);
            cb_direccion.setSelectedItem(datos[1]);

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.toString(), "", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_cb_idItemStateChanged

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(editar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editar_sucursal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cb_direccion;
    private javax.swing.JComboBox<String> cb_id;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txf_telefono;
    private javax.swing.JLabel txt_ID;
    private javax.swing.JLabel txt_direccion;
    private javax.swing.JLabel txt_telefono;
    private javax.swing.JLabel txt_titulo;
    // End of variables declaration//GEN-END:variables
}
