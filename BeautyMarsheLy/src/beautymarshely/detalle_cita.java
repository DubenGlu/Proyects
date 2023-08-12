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
public class detalle_cita extends javax.swing.JFrame {

    /**
     * Creates new form detalle_cita
     */
    public detalle_cita() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("src/imagenes/BeautyMarshe_Ly.png");
        this.setIconImage(img.getImage());
    }

    public static void cargarTabla() {
                DefaultTableModel tabla = new DefaultTableModel();
        
                tabla.addColumn("ID");
                tabla.addColumn("Cliente");
                tabla.addColumn("Fecha");
                tabla.addColumn("Hora");
                tabla.addColumn("Servicio");
                tabla.addColumn("Lashista");
                tabla.addColumn("Precio");
                tabla.addColumn("Sucursal");
                tabla.addColumn("Metodo de pago");
                
                
                String [] datos = new String[9];
                
                try {
                    ConexionDB con = new ConexionDB();
                    Connection conect = con.getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("SELECT CI.ID_CITA, CL.NOMBRE||' '||CL.AP_PATERNO, CI.FECHA, CI.HORA, SE.NOMBRE, L.NOMBRE, SE.PRECIO, D.CIUDAD, TP.TIPO \n" +
"FROM CITAS CI\n" +
"JOIN CLIENTES CL ON CI.ID_CLIENTE = CL.ID_CLIENTE\n" +
"JOIN CITA_DETA CD ON CI.ID_CITA = CD.ID_CITA\n" +
"JOIN SERVICIOS SE ON CD.ID_SERVICIO = SE.ID_SERVICIO\n" +
"JOIN LASHISTAS L ON CD.ID_LASHISTA = L.ID_LASHISTA \n" +
"JOIN TIPO_PAGO TP ON CD.ID_PAGO = TP.ID_PAGO\n" +
"JOIN SUCURSALES SU ON CD.ID_SUCURSAL = SU.ID_SUCURSAL\n" +
"JOIN DIRECCION D ON SU.ID_DIRECCION = D.ID_DIRECCION\n");
                    
                    while (result.next()) {
                        datos[0] = result.getString(1);
                        datos[1] = result.getString(2);
                        datos[2] = result.getString(3);
                        datos[3] = result.getString(4);
                        datos[4] = result.getString(5);
                        datos[5] = result.getString(6);
                        datos[6] = result.getString(7);
                        datos[7] = result.getString(8);
                        datos[7] = result.getString(9);
                        tabla.addRow(datos);
                    }
                    
                    Tabla.setModel(tabla);
                    if (datos[0] == null) {
                        JOptionPane.showMessageDialog(null, "No se ha insertado ninguna cita");
                    }else{
//                        JOptionPane.showMessageDialog(null, "La tabla ha cargado correctamente" );
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(detalle_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detalle_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detalle_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detalle_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new detalle_cita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable Tabla;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
