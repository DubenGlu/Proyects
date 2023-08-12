/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautymarshely;

import static beautymarshely.ConexionDB.getConexion;
import static beautymarshely.eliminar_direccion.cb_iddir;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class eliminar_cita extends javax.swing.JFrame {

    
   
    int contadordatos;
    public eliminar_cita() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("src/imagenes/BeautyMarshe_Ly.png");
        this.setIconImage(img.getImage());
    }

    
    public void llenarComboBox() {
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select count(*) from citas");
                    
                    int[] datos = new int[1];
                    
                    while (result.next()) {
                        datos[0] = result.getInt(1);
                    }
                    
                    contadordatos = datos[0];
                    
                    
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el count de citas: "+e);
                }
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select id_cita from citas");
                    
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

        jPanel1 = new javax.swing.JPanel();
        txt_nombrecliente = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        txt_hora = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_servicio = new javax.swing.JLabel();
        txt_lashista = new javax.swing.JLabel();
        txt_tipopago = new javax.swing.JLabel();
        txf_hora = new javax.swing.JTextField();
        txf_fecha = new javax.swing.JTextField();
        txf_sucursal = new javax.swing.JTextField();
        txf_tipopago = new javax.swing.JTextField();
        txf_lashista = new javax.swing.JTextField();
        txf_servicio = new javax.swing.JTextField();
        txf_cliente = new javax.swing.JTextField();
        txt_sucursal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txt_id = new javax.swing.JLabel();
        cb_id = new javax.swing.JComboBox<>();
        txt_titulo = new javax.swing.JLabel();
        fondo_citas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombrecliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_nombrecliente.setForeground(new java.awt.Color(100, 70, 35));
        txt_nombrecliente.setText("Nombre del cliente:");
        jPanel1.add(txt_nombrecliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 101, -1, -1));

        txt_fecha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_fecha.setForeground(new java.awt.Color(100, 70, 35));
        txt_fecha.setText("Fecha:");
        jPanel1.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, -1, -1));

        txt_hora.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_hora.setForeground(new java.awt.Color(100, 70, 35));
        txt_hora.setText("Hora:");
        jPanel1.add(txt_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(100, 70, 35));
        jLabel1.setText(":");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 323, 5, -1));

        txt_servicio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_servicio.setForeground(new java.awt.Color(100, 70, 35));
        txt_servicio.setText("Servicio:");
        jPanel1.add(txt_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        txt_lashista.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_lashista.setForeground(new java.awt.Color(100, 70, 35));
        txt_lashista.setText("Lashista:");
        jPanel1.add(txt_lashista, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        txt_tipopago.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_tipopago.setForeground(new java.awt.Color(100, 70, 35));
        txt_tipopago.setText("Tipo de pago:");
        jPanel1.add(txt_tipopago, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        txf_hora.setEditable(false);
        jPanel1.add(txf_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 120, -1));

        txf_fecha.setEditable(false);
        jPanel1.add(txf_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 120, -1));

        txf_sucursal.setEditable(false);
        jPanel1.add(txf_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 240, -1));

        txf_tipopago.setEditable(false);
        jPanel1.add(txf_tipopago, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 240, -1));

        txf_lashista.setEditable(false);
        jPanel1.add(txf_lashista, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 240, -1));

        txf_servicio.setEditable(false);
        jPanel1.add(txf_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 240, -1));

        txf_cliente.setEditable(false);
        jPanel1.add(txf_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 240, -1));

        txt_sucursal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_sucursal.setForeground(new java.awt.Color(100, 70, 35));
        txt_sucursal.setText("Sucursal:");
        jPanel1.add(txt_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        jPanel3.setBackground(new java.awt.Color(241, 216, 160));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_id.setForeground(new java.awt.Color(100, 70, 35));
        txt_id.setText("ID:");
        jPanel3.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        cb_id.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_idItemStateChanged(evt);
            }
        });
        jPanel3.add(cb_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 26, 70, -1));

        txt_titulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_titulo.setForeground(new java.awt.Color(100, 70, 35));
        txt_titulo.setText("Eliminar Cita");
        jPanel3.add(txt_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 6, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 22, 690, 60));

        fondo_citas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_citas.png"))); // NOI18N
        jPanel1.add(fondo_citas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 420));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        Citas ob = new Citas();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        try {
            String id = cb_id.getSelectedItem().toString();
            Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM CITA_DETA WHERE ID_CITA = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            
            PreparedStatement ps2 = con.prepareStatement("DELETE FROM CITAS WHERE ID_CITA = ?");
            ps2.setString(1, id);
            ps2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null,"", "", JOptionPane.ERROR_MESSAGE);
        } 

        btn_cancelarActionPerformed(evt);

    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       llenarComboBox();
    }//GEN-LAST:event_formWindowOpened

    private void cb_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_idItemStateChanged
        try {
            String id = cb_id.getSelectedItem().toString();
            Connection con = ConexionDB.getConexion();
            Statement leer = con.createStatement();
            ResultSet res = leer.executeQuery("SELECT CL.NOMBRE, CI.FECHA, CI.HORA, SE.NOMBRE, L.NOMBRE, TP.TIPO, D.CIUDAD "
                    + "FROM CITAS CI "
                    + "JOIN CLIENTES CL ON CI.ID_CLIENTE = CL.ID_CLIENTE "
                    + "JOIN CITA_DETA CD ON CI.ID_CITA = CD.ID_CITA "
                    + "JOIN SERVICIOS SE ON CD.ID_SERVICIO = SE.ID_SERVICIO "
                    + "JOIN LASHISTAS L ON CD.ID_LASHISTA = L.ID_LASHISTA "
                    + "JOIN TIPO_PAGO TP ON CD.ID_PAGO = TP.ID_PAGO "
                    + "JOIN SUCURSALES SU ON CD.ID_SUCURSAL = SU.ID_SUCURSAL "
                    + "JOIN DIRECCION D ON SU.ID_DIRECCION = D.ID_DIRECCION "
                    + "WHERE CI.ID_CITA = "+id);
            String[] datos = new String[7];
            while (res.next()) {
                datos[0]=res.getString(1);
                datos[1]=res.getString(2);
                datos[2]=res.getString(3);
                datos[3]=res.getString(4);
                datos[4]=res.getString(5);
                datos[5]=res.getString(6);
                datos[6]=res.getString(7);
            }
            txf_cliente.setText(datos[0]);
            txf_fecha.setText(datos[1]);
            txf_hora.setText(datos[2]);
            txf_servicio.setText(datos[3]);
            txf_lashista.setText(datos[4]);
            txf_tipopago.setText(datos[5]);
            txf_sucursal.setText(datos[6]);

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
            java.util.logging.Logger.getLogger(eliminar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(eliminar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(eliminar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(eliminar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new eliminar_cita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JComboBox<String> cb_id;
    private javax.swing.JLabel fondo_citas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txf_cliente;
    private javax.swing.JTextField txf_fecha;
    private javax.swing.JTextField txf_hora;
    private javax.swing.JTextField txf_lashista;
    private javax.swing.JTextField txf_servicio;
    private javax.swing.JTextField txf_sucursal;
    private javax.swing.JTextField txf_tipopago;
    private javax.swing.JLabel txt_fecha;
    private javax.swing.JLabel txt_hora;
    private javax.swing.JLabel txt_id;
    private javax.swing.JLabel txt_lashista;
    private javax.swing.JLabel txt_nombrecliente;
    private javax.swing.JLabel txt_servicio;
    private javax.swing.JLabel txt_sucursal;
    private javax.swing.JLabel txt_tipopago;
    private javax.swing.JLabel txt_titulo;
    // End of variables declaration//GEN-END:variables
}
