/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautymarshely;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rey_r
 */
public class lashistas_despedidas extends javax.swing.JFrame {

    /**
     * Creates new form lashistas_despedidas
     */
    public lashistas_despedidas() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("src/imagenes/BeautyMarshe_Ly.png");
        this.setIconImage(img.getImage());
    }

    public static void cargarTabla() {
        
                DefaultTableModel tabla = new DefaultTableModel();
                

                tabla.addColumn("Nombre");
                tabla.addColumn("Apellido");
                tabla.addColumn("Fecha de despedida");
                
                String [] datos_lash = new String[3];
                
                try {
                    ConexionDB con = new ConexionDB();
                    Connection conect = con.getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("SELECT NOMBRE, AP_PATERNO, DECHA FROM LASH_DESP ORDER BY DECHA");
                    
                    while (result.next()) {
                        datos_lash[0] = result.getString(1);
                        datos_lash[1] = result.getString(2);
                        datos_lash[2] = result.getString(3);
                        tabla.addRow(datos_lash);
                    }
                    
                    Tabla.setModel(tabla);
                    if (datos_lash[0] == null) {
                        JOptionPane.showMessageDialog(null, "No se ha insertado ninguna lashista");
                    }else{
                        JOptionPane.showMessageDialog(null, "La tabla ha cargado correctamente" );
                    }
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en la consulta: "+e);
                }
        
    }
    
    public static void limpiarTabla(){
        
        DefaultTableModel tb = (DefaultTableModel) Tabla.getModel();
        int a = Tabla.getRowCount()-1;
        int b = Tabla.getColumnCount()-1;
        for (int i = a; i >= 0; i--) {          
        tb.removeRow(tb.getRowCount()-1);
        
        }
        tb.setColumnCount(0);
        
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_anterior = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Anterior.png"))); // NOI18N
        btn_anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_anteriorMousePressed(evt);
            }
        });
        jPanel1.add(btn_anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 30));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 490, 500));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Plantilla.jpg"))); // NOI18N
        fondo.setText("jLabel1");
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_anteriorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_anteriorMousePressed
        Lashistas obm = new Lashistas();
        obm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_anteriorMousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        limpiarTabla();
        cargarTabla();
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
            java.util.logging.Logger.getLogger(lashistas_despedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lashistas_despedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lashistas_despedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lashistas_despedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lashistas_despedidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable Tabla;
    private javax.swing.JLabel btn_anterior;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
