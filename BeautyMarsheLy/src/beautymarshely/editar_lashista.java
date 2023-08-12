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
public class editar_lashista extends javax.swing.JFrame {

    static Menu obm = new Menu();
    int contlash = 0;
    int cantserv = 0;
    public editar_lashista() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("src/imagenes/BeautyMarshe_Ly.png");
        this.setIconImage(img.getImage());
    }
    
    public void llenarComboBoxID() {
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
                    JOptionPane.showMessageDialog(null, "Error en el count de lashistas: "+e);
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
    
    public void llenarComboBoxServ() {
        cb_servicio.removeAllItems();
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select count(*) from servicios");
                    
                    int[] datos = new int[1];
                    
                    while (result.next()) {
                        datos[0] = result.getInt(1);
                    }
                    
                    cantserv = datos[0];
                    
                    
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el count de servicios: "+e);
                }
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select nombre from servicios");
                    
                    String[] datos = new String[cantserv];
                    int i=0;
                    cb_servicio.addItem(null);
                    while (result.next()) {
                        datos[i] = result.getString(i+1);
                        cb_servicio.addItem(datos[i]);
                    }
                    
 
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el llenado del combo box: "+e);
                }
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
        txt_titulo = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JLabel();
        txf_nombre = new javax.swing.JTextField();
        txt_appaterno = new javax.swing.JLabel();
        txf_appaterno = new javax.swing.JTextField();
        txt_servicio = new javax.swing.JLabel();
        cb_servicio = new javax.swing.JComboBox<>();
        btn_guardar = new javax.swing.JButton();
        cb_id = new javax.swing.JComboBox<>();
        txt_id = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editar Lashista");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_titulo.setText("Insertar Datos");
        jPanel1.add(txt_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        txt_nombre.setText("Nombre:");
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        txf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txf_nombreActionPerformed(evt);
            }
        });
        jPanel1.add(txf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 300, -1));

        txt_appaterno.setText("Apellido:");
        jPanel1.add(txt_appaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));
        jPanel1.add(txf_appaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 300, -1));

        txt_servicio.setText("Servicio:");
        jPanel1.add(txt_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jPanel1.add(cb_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 300, -1));

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
        jPanel1.add(cb_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 80, -1));

        txt_id.setText("ID:");
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 20, -1));

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_cancelarMousePressed(evt);
            }
        });
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMousePressed
        obm.ob_l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelarMousePressed

    private void btn_guardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMousePressed
        try {
             
            String nombre = txf_nombre.getText();
            String ap_paterno = txf_appaterno.getText();
            int id_lashista = Integer.parseInt(cb_id.getSelectedItem().toString());
            Connection con = ConexionDB.getConexion();
            Statement leer = con.createStatement();
            ResultSet result = leer.executeQuery("select distinct id_servicio from servicios where nombre = '"+cb_servicio.getSelectedItem().toString()+"'");
            int[] x = new int[1];
            while (result.next()) {
                x[0] = result.getInt(1);
            }
            int id_servicio = x[0];
            PreparedStatement ps = con.prepareStatement("UPDATE LASHISTAS SET ID_SERVICIO = ?, NOMBRE = ?, AP_PATERNO = ? WHERE ID_LASHISTA = ?");
            
            ps.setInt(1, id_servicio);
            ps.setString(2, nombre);
            ps.setString(3, ap_paterno);
            ps.setInt(4,id_lashista);

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

    private void cb_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_idItemStateChanged
        try {
            llenarComboBoxServ();
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
            cb_servicio.setSelectedItem(datos[2]);

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.toString(), "", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_cb_idItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarComboBoxID();
    }//GEN-LAST:event_formWindowOpened

    private void txf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txf_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txf_nombreActionPerformed

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
            java.util.logging.Logger.getLogger(editar_lashista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editar_lashista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editar_lashista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editar_lashista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editar_lashista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cb_id;
    private javax.swing.JComboBox<String> cb_servicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txf_appaterno;
    private javax.swing.JTextField txf_nombre;
    private javax.swing.JLabel txt_appaterno;
    private javax.swing.JLabel txt_id;
    private javax.swing.JLabel txt_nombre;
    private javax.swing.JLabel txt_servicio;
    private javax.swing.JLabel txt_titulo;
    // End of variables declaration//GEN-END:variables
}
