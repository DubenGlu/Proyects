/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautymarshely;

import static beautymarshely.ConexionDB.getConexion;
import static beautymarshely.Direcciones.instanciado_como;
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
public class insertar_sucursal extends javax.swing.JFrame {

    /**
     * Creates new form insertar_sucursal
     */
    static int contadordatos = 0; 
    static int contadordatos_dir = 0; 
    
    public insertar_sucursal() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("src/imagenes/BeautyMarshe_Ly.png");
        this.setIconImage(img.getImage());
    }

     public void llenarComboBox() {
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select count(*) from direccion");
                    
                    int[] datos = new int[1];
                    
                    while (result.next()) {
                        datos[0] = result.getInt(1);
                    }
                    
                    contadordatos_dir = datos[0];
                    
                    
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el count de direccion: "+e);
                }
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select id_direccion||' - '||calle||' #'||numero||', colonia '||colonia||', '||ciudad||', '||estado from direccion");
                    
                    String[] datos = new String[contadordatos_dir];
                    int i=0;
                    cb_direccion.addItem(null);
                    while (result.next()) {
                        datos[i] = result.getString(i+1);
                        cb_direccion.addItem(datos[i]);
                    }
                    
 
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el llenado del combo box: "+e);
                }
    }
     
     public void contarID(){
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select count(*) from sucursales");
                    
                    int[] datos = new int[1];
                    
                    while (result.next()) {
                        datos[0] = result.getInt(1);
                    }
                    
                    contadordatos = datos[0]+1;
                    
                    txt_contadorID.setText(""+contadordatos);
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el count: "+e);
                }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_titulo = new javax.swing.JLabel();
        txt_ID = new javax.swing.JLabel();
        txt_contadorID = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        txt_telefono = new javax.swing.JLabel();
        txf_telefono = new javax.swing.JTextField();
        cb_direccion = new javax.swing.JComboBox<>();
        txt_direccion = new javax.swing.JLabel();
        btn_indir = new javax.swing.JButton();
        btn_elidir = new javax.swing.JButton();
        btn_editdir = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txt_titulo.setText("Insertar Sucursal");

        txt_ID.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_ID.setText("ID:");

        txt_contadorID.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_contadorID.setText("0");

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        txt_telefono.setText("Telefono:");

        txt_direccion.setText("Direccion:");

        btn_indir.setText("Ingresar nueva direccion");
        btn_indir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_indirActionPerformed(evt);
            }
        });

        btn_elidir.setText("Eliminar Direccion");
        btn_elidir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elidirActionPerformed(evt);
            }
        });

        btn_editdir.setText("Editar Direccion");
        btn_editdir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editdirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(txt_telefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_ID)
                        .addGap(46, 46, 46)
                        .addComponent(txt_contadorID))
                    .addComponent(txt_titulo))
                .addGap(258, 258, 258))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_direccion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_editdir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                .addComponent(btn_indir, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btn_elidir, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cb_direccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_cancelar)
                                .addGap(178, 178, 178)
                                .addComponent(btn_limpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_guardar)))
                        .addGap(35, 35, 35))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_titulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ID)
                    .addComponent(txt_contadorID))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_telefono)
                    .addComponent(txf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(txt_direccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editdir)
                    .addComponent(btn_indir)
                    .addComponent(btn_elidir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_limpiar)
                    .addComponent(btn_guardar))
                .addContainerGap())
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

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        // TODO add your handling code here:
       txf_telefono.setText("");
       cb_direccion.setSelectedItem(null);
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        try {
             ConexionDB.getConexion();
            int id_sucursal = contadordatos;
            long telefono = Long.parseLong(txf_telefono.getText());
            String dir = cb_direccion.getSelectedItem().toString();
            char[] id_dir = dir.toCharArray();
            int id_direccion = Character.getNumericValue(id_dir[0]);
           
           
            Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO  SUCURSALES (ID_SUCURSAL, ID_DIRECCION, TELEFONO) VALUES(?,?,?)");
   
            ps.setInt(1, id_sucursal);
            ps.setInt(2, id_direccion);
            ps.setLong(3, telefono);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sucursal insertada correctamente");
            btn_limpiarActionPerformed(evt);
//            ConexionDB.cargarTabla(tabla_lashistas, "lashistas");

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error en el insert: "+sql, "Error en SQL", JOptionPane.ERROR_MESSAGE);

        }
        
        btn_cancelarActionPerformed(evt);
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_indirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_indirActionPerformed
        insertar_direccion ob = new insertar_direccion();
        instanciado_como = 1;
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_indirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarComboBox();
        contarID();
    }//GEN-LAST:event_formWindowOpened

    private void btn_elidirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elidirActionPerformed
        eliminar_direccion ob = new eliminar_direccion();
        instanciado_como = 1;
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_elidirActionPerformed

    private void btn_editdirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editdirActionPerformed
        editar_direccion ob = new editar_direccion();
        instanciado_como = 1;
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_editdirActionPerformed

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
            java.util.logging.Logger.getLogger(insertar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insertar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insertar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insertar_sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new insertar_sucursal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editdir;
    private javax.swing.JButton btn_elidir;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_indir;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox<String> cb_direccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txf_telefono;
    private javax.swing.JLabel txt_ID;
    private javax.swing.JLabel txt_contadorID;
    private javax.swing.JLabel txt_direccion;
    private javax.swing.JLabel txt_telefono;
    private javax.swing.JLabel txt_titulo;
    // End of variables declaration//GEN-END:variables
}
