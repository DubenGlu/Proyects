/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautymarshely;

import static beautymarshely.ConexionDB.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class insertar_lashista extends javax.swing.JFrame {

     int contadordatos = 0; 
     int contadordatos_serv = 0; 
    static Menu obm = new Menu();
    
    
    
    public insertar_lashista() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("src/imagenes/BeautyMarshe_Ly.png");
        this.setIconImage(img.getImage());
    }
    
    public void llenarComboBox() {
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select count(*) from servicios");
                    
                    int[] datos = new int[1];
                    
                    while (result.next()) {
                        datos[0] = result.getInt(1);
                    }
                    
                    contadordatos_serv = datos[0];
                    
                    
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el count de servicios: "+e);
                }
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select nombre from servicios");
                    
                    String[] datos = new String[contadordatos_serv];
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
    
    public void contarID(){
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select count(*) from lashistas");
                    
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        txf_nombre = new javax.swing.JTextField();
        txt_titulo = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_id = new javax.swing.JLabel();
        txt_contadorID = new javax.swing.JLabel();
        txt_appaterno = new javax.swing.JLabel();
        txf_appaterno = new javax.swing.JTextField();
        txt_servicio = new javax.swing.JLabel();
        cb_servicio = new javax.swing.JComboBox<>();
        btn_guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agregar Lashista");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 300, -1));

        txt_titulo.setText("Insertar Datos");
        getContentPane().add(txt_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        txt_nombre.setText("Nombre:");
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_cancelarMousePressed(evt);
            }
        });
        getContentPane().add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        btn_limpiar.setText("Limpiar");
        btn_limpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_limpiarMousePressed(evt);
            }
        });
        getContentPane().add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_id.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_id.setText("ID:");
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 30, 40));

        txt_contadorID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txt_contadorID.setText("0");
        jPanel1.add(txt_contadorID, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, 20));

        txt_appaterno.setText("Apellido:");
        jPanel1.add(txt_appaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));
        jPanel1.add(txf_appaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 300, -1));

        txt_servicio.setText("Servicio:");
        jPanel1.add(txt_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        cb_servicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        pack();
    }// </editor-fold>                        

    private void btn_cancelarMousePressed(java.awt.event.MouseEvent evt) {                                          
        Lashistas ob_l = new Lashistas();
        ob_l.setVisible(true);
        this.dispose();
    }                                         

    private void btn_guardarMousePressed(java.awt.event.MouseEvent evt) {                                         
        try {
             ConexionDB.getConexion();
            int id_lashista = contadordatos;
            String nombre = txf_nombre.getText();
            String ap_paterno = txf_appaterno.getText();

            Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO  LASHISTAS (ID_LASHISTA, ID_SERVICIO, NOMBRE, AP_PATERNO) VALUES(?,?,?,?)");
            Statement leer = con.createStatement();
            ResultSet result = leer.executeQuery("select distinct id_servicio from servicios where nombre = '"+cb_servicio.getSelectedItem()+"'");
            int[] x = new int[1];
            while (result.next()) {
                x[0] = result.getInt(1);
            }
            int id_servicio = x[0];
            ps.setInt(1, id_lashista);
            ps.setInt(2, id_servicio);
            ps.setString(3, nombre);
            ps.setString(4, ap_paterno);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Lashista insertada correctamente");
            btn_limpiarMousePressed(evt);
//            ConexionDB.cargarTabla(tabla_lashistas, "lashistas");

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error en el insert: "+sql, "Error en SQL", JOptionPane.ERROR_MESSAGE);

        }
        
        btn_cancelarMousePressed(evt);
        
    }                                        

    private void btn_limpiarMousePressed(java.awt.event.MouseEvent evt) {                                         
        txf_nombre.setText("");
        txf_appaterno.setText("");
        cb_servicio.setSelectedItem(null);
    }                                        

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        cb_servicio.removeAllItems();
        llenarComboBox();
        contarID();
        
    }                                 

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

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
            java.util.logging.Logger.getLogger(insertar_lashista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insertar_lashista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insertar_lashista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insertar_lashista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new insertar_lashista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox<String> cb_servicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txf_appaterno;
    private javax.swing.JTextField txf_nombre;
    private javax.swing.JLabel txt_appaterno;
    private javax.swing.JLabel txt_contadorID;
    private javax.swing.JLabel txt_id;
    private javax.swing.JLabel txt_nombre;
    private javax.swing.JLabel txt_servicio;
    private javax.swing.JLabel txt_titulo;
    // End of variables declaration                   
}
