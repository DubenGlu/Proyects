/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautymarshely;

import static beautymarshely.ConexionDB.getConexion;
import com.toedter.calendar.JDateChooser;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;


public class insertar_cita extends javax.swing.JFrame {

    int contadordatos;
    int contador_clientes;
    int contador_servicios;
    int contador_lashistas;
    int contador_tipopago;
    int contador_sucursal;
    
    public insertar_cita() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("src/imagenes/BeautyMarshe_Ly.png");
        this.setIconImage(img.getImage());
    }
    
    public void llenarComboBox(int contador, JComboBox cb, String tabla, String campo) {
        
        try {
                    
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select count(*) from "+tabla);
                    
                    int[] datos = new int[1];
                    
                    while (result.next()) {
                        datos[0] = result.getInt(1);
                    }
                    
                    contador = datos[0];
                    
                    
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el count de : "+tabla+e);
                }
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select "+campo+" from "+tabla);
                    
                    String[] datos = new String[contador];
                    int i=0;
                    cb.addItem(null);
                    while (result.next()) {
                        datos[i] = result.getString(i+1);
                        cb.addItem(datos[i]);
                    }
                    
 
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el llenado del combo box: "+e);
                }
    }
    
    public void llenarComboBoxLashistas(String nombre) {
        int contador_lash = 0;
        try {
                    
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select count(*) from lashistas l join servicios s on l.id_servicio = s.id_servicio where s.nombre = '"+nombre+"'");
                    
                    int[] datos = new int[1];
                    
                    while (result.next()) {
                        datos[0] = result.getInt(1);
                    }
                    
                    contador_lash = datos[0];
                    
                    
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el count de : lashistas"+e);
                }
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select l.nombre from lashistas l join servicios s on l.id_servicio = s.id_servicio where s.nombre = '"+nombre+"'");
                    
                    String[] datos = new String[contador_lash];
                    int i=0;
                    cb_lashista.addItem(null);
                    while (result.next()) {
                        datos[i] = result.getString(i+1);
                        cb_lashista.addItem(datos[i]);
                    }
                    
 
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el llenado del combo box: "+e);
                }
    }

    public String generar_fecha(JDateChooser dc){
        Date date = dc.getDate();
        String mes;
        String dia;
        int day = date.getDate();
        int month = date.getMonth()+1;
        int año = date.getYear()+1900;
        if (day<10) {
            dia = "0"+day;
        }else{
            dia = day+"";
        }
        if (month<10) {
            mes = "0"+month;
        }else{
            mes = month+"";
        }
        String fecha = dia+"/"+mes+"/"+año;
        
        return fecha;
    }
    
    public void contarID(){
        try {
                    Connection conect = getConexion();
                    Statement leer = conect.createStatement();
                    ResultSet result = leer.executeQuery("select count(*) from citas");
                    
                    int[] datos = new int[1];
                    
                    while (result.next()) {
                        datos[0] = result.getInt(1);
                    }
                    
                    contadordatos = datos[0]+1;
                    
                    txt_contID.setText(""+contadordatos);
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en el count: "+e);
                }
    }
    
    public String hora(JSpinner s_h, JSpinner s_m){
        String horas;
                String minutos;
                int h = Integer.parseInt(s_h.getValue().toString());
                int m = Integer.parseInt(s_m.getValue().toString());
                if (h<10) {
                    horas = "0"+h;
                }else{
                    horas = h+"";
                }
                if (m<10) {
                    minutos = "0"+m;
                }else{
                    minutos = m+"";
                }
                String hora = horas+":"+minutos;
                return hora;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        txt_nombrecliente = new javax.swing.JLabel();
        txt_id = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        txt_titulo = new javax.swing.JLabel();
        txt_contID = new javax.swing.JLabel();
        txt_hora = new javax.swing.JLabel();
        spin_hora = new javax.swing.JSpinner();
        spin_minuto = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dc_fecha = new com.toedter.calendar.JDateChooser();
        txt_servicio = new javax.swing.JLabel();
        cb_servicio = new javax.swing.JComboBox<>();
        txt_lashista = new javax.swing.JLabel();
        cb_lashista = new javax.swing.JComboBox<>();
        txt_tipopago = new javax.swing.JLabel();
        cb_cliente = new javax.swing.JComboBox<>();
        cb_tipopago = new javax.swing.JComboBox<>();
        txt_sucursal = new javax.swing.JLabel();
        cb_sucursal = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txt_totalapagar = new javax.swing.JLabel();
        txt_precio = new javax.swing.JLabel();
        fondo_pago = new javax.swing.JLabel();
        fondo_citas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Generar cita");
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

        txt_id.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_id.setForeground(new java.awt.Color(100, 70, 35));
        txt_id.setText("ID:");
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

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
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, -1, -1));

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, -1, -1));

        txt_titulo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_titulo.setForeground(new java.awt.Color(100, 70, 35));
        txt_titulo.setText("Generar cita");
        jPanel1.add(txt_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        txt_contID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_contID.setForeground(new java.awt.Color(100, 70, 35));
        txt_contID.setText("0");
        jPanel1.add(txt_contID, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 45, -1));

        txt_hora.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_hora.setForeground(new java.awt.Color(100, 70, 35));
        txt_hora.setText("Hora:");
        jPanel1.add(txt_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 323, -1, -1));

        spin_hora.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));
        jPanel1.add(spin_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 320, 60, -1));

        spin_minuto.setModel(new javax.swing.SpinnerNumberModel(0, 0, 60, 1));
        jPanel1.add(spin_minuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 60, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(100, 70, 35));
        jLabel1.setText(":");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 323, 5, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(100, 70, 35));
        jLabel2.setText("Min");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 323, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(100, 70, 35));
        jLabel3.setText("Hrs");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 323, -1, -1));

        dc_fecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(dc_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 160, 30));

        txt_servicio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_servicio.setForeground(new java.awt.Color(100, 70, 35));
        txt_servicio.setText("Servicio:");
        jPanel1.add(txt_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        cb_servicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_servicioItemStateChanged(evt);
            }
        });
        jPanel1.add(cb_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 240, -1));

        txt_lashista.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_lashista.setForeground(new java.awt.Color(100, 70, 35));
        txt_lashista.setText("Lashista:");
        jPanel1.add(txt_lashista, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        jPanel1.add(cb_lashista, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 240, -1));

        txt_tipopago.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_tipopago.setForeground(new java.awt.Color(100, 70, 35));
        txt_tipopago.setText("Tipo de pago:");
        jPanel1.add(txt_tipopago, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        jPanel1.add(cb_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 240, -1));

        jPanel1.add(cb_tipopago, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 240, -1));

        txt_sucursal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_sucursal.setForeground(new java.awt.Color(100, 70, 35));
        txt_sucursal.setText("Sucursal:");
        jPanel1.add(txt_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        jPanel1.add(cb_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 240, -1));

        jPanel3.setBackground(new java.awt.Color(241, 216, 160));
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 22, 710, 50));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_totalapagar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        txt_totalapagar.setForeground(new java.awt.Color(235, 58, 150));
        txt_totalapagar.setText("TOTAL A PAGAR");
        jPanel2.add(txt_totalapagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 150, 20));

        txt_precio.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        txt_precio.setForeground(new java.awt.Color(235, 58, 150));
        txt_precio.setText("$0");
        jPanel2.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        fondo_pago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pago.png"))); // NOI18N
        jPanel2.add(fondo_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 80));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 240, 80));

        fondo_citas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo_citas.png"))); // NOI18N
        jPanel1.add(fondo_citas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        try {
            ConexionDB.getConexion();
            int id_cita = contadordatos;
            String cliente = cb_cliente.getSelectedItem().toString();
            String fecha = generar_fecha(dc_fecha);
            String hora = hora(spin_hora,spin_minuto);
            String servicio = cb_servicio.getSelectedItem().toString();
            String lashista = cb_lashista.getSelectedItem().toString();
            String tipo_pago = cb_tipopago.getSelectedItem().toString();
            String sucursal = cb_sucursal.getSelectedItem().toString();
            
            Connection con = ConexionDB.getConexion();
            CallableStatement ps = con.prepareCall("{CALL HACER_CITA (?,?,?,?,?,?,?,?)}");
            Statement leer = con.createStatement();
            ResultSet result = leer.executeQuery("select distinct id_cliente from clientes where nombre = '"+cliente+"'");
            int[] x = new int[1];
            while (result.next()) {
                x[0] = result.getInt(1);
            }
            int id_cliente = x[0];           
            ResultSet result2 = leer.executeQuery("select distinct id_servicio,precio from servicios where nombre = '"+servicio+"'");
            int[] x2 = new int[2];
            while (result2.next()) {
                x2[0] = result2.getInt(1);
                x2[1] = result2.getInt(2);
            }
            int id_servicio = x2[0];
            ResultSet result3 = leer.executeQuery("select distinct id_lashista from lashistas where nombre = '"+lashista+"'");
            int[] x3 = new int[1];
            while (result3.next()) {
                x3[0] = result3.getInt(1);
            }
            int id_lashista = x3[0];
            ResultSet result4 = leer.executeQuery("select distinct id_pago from tipo_pago where tipo = '"+tipo_pago+"'");
            int[] x4 = new int[1];
            while (result4.next()) {
                x4[0] = result4.getInt(1);
            }
            int id_pago = x4[0];
            ResultSet result5 = leer.executeQuery("select distinct id_sucursal from sucursales natural join direccion where ciudad = '"+sucursal+"'");
            int[] x5 = new int[1];
            while (result5.next()) {
                x5[0] = result5.getInt(1);
            }
            int id_sucursal = x5[0];
            ps.setInt(1,id_cita);
            ps.setInt(2,id_cliente);
            ps.setString(3,fecha);
            ps.setString(4,hora);
            ps.setInt(5,id_servicio);
            ps.setInt(6,id_lashista);
            ps.setInt(7,id_pago);
            ps.setInt(8,id_sucursal);
            
            ps.registerOutParameter(1, java.sql.Types.INTEGER);
            ps.registerOutParameter(2, java.sql.Types.INTEGER);
            ps.registerOutParameter(3, java.sql.Types.VARCHAR);
            ps.registerOutParameter(4, java.sql.Types.VARCHAR);
            ps.registerOutParameter(5, java.sql.Types.INTEGER);
            ps.registerOutParameter(6, java.sql.Types.INTEGER);
            ps.registerOutParameter(7, java.sql.Types.INTEGER);
            ps.registerOutParameter(8, java.sql.Types.INTEGER);
            
            ps.executeUpdate();
            
            ResultSet rs6 = leer.executeQuery("SELECT * FROM DISPONIBILIDAD");
            String[] x6 = new String[3];
            while (rs6.next()) {
                x6[0] = rs6.getString(1);
                x6[1] = rs6.getString(2);
                x6[2] = rs6.getString(3);
            }
            
            char[] vector_fecha = fecha.toCharArray();
            char[] fecha_rev = new char[vector_fecha.length+9]; 
            fecha_rev[0] = vector_fecha[6];
            fecha_rev[1] = vector_fecha[7];
            fecha_rev[2] = vector_fecha[8];
            fecha_rev[3] = vector_fecha[9];
            fecha_rev[4] = '-';
            fecha_rev[5] = vector_fecha[3];
            fecha_rev[6] = vector_fecha[4];
            fecha_rev[7] = '-';
            fecha_rev[8] = vector_fecha[0];
            fecha_rev[9] = vector_fecha[1];
            fecha_rev[10] = ' ';
            fecha_rev[11] = '0';
            fecha_rev[12] = '0';
            fecha_rev[13] = ':';
            fecha_rev[14] = '0';
            fecha_rev[15] = '0';
            fecha_rev[16] = ':';
            fecha_rev[17] = '0';
            fecha_rev[18] = '0';
            
            System.out.println("variables");
            System.out.println(""+id_lashista);
            for (int i = 0; i < fecha_rev.length; i++) {
                System.out.print(fecha_rev[i]);
            }
            System.out.println("");
            System.out.println(hora);
            System.out.println("disponibilidad");
            System.out.println(x6[0]);
            System.out.println(x6[1]);
            System.out.println(x6[2]);
            
            String fecha_buena = String.valueOf(fecha_rev);
            if ((x6[0].equals(id_lashista+""))&&(x6[1].equals(fecha_buena))&&(x6[2].equals(hora))) {
                JOptionPane.showMessageDialog(null, "La lashista"+lashista+"no esta disponible ese dia en ese horario, elige otra lashista u otro horario", "Error en la disponibilidad", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Cita creada correctamente"); 
                btn_cancelarActionPerformed(evt);
            }
            
         
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.toString(), "", JOptionPane.ERROR_MESSAGE);

        }
                
                
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        Citas ob = new Citas();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarComboBox(contador_clientes, cb_cliente, "clientes", "nombre");
        llenarComboBox(contador_servicios, cb_servicio, "servicios", "nombre");
        llenarComboBox(contador_sucursal, cb_sucursal, "direccion", "ciudad");
        llenarComboBox(contador_tipopago, cb_tipopago, "tipo_pago", "tipo");
        contarID();
    }//GEN-LAST:event_formWindowOpened

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        cb_cliente.setSelectedItem(null);
        cb_lashista.setSelectedItem(null);
        cb_servicio.setSelectedItem(null);
        cb_sucursal.setSelectedItem(null);
        cb_tipopago.setSelectedItem(null);
        dc_fecha.removeAll();
        spin_hora.setValue(0);
        spin_minuto.setValue(0);
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void cb_servicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_servicioItemStateChanged
            cb_lashista.removeAllItems();
        try {
            String nombre_servicio = cb_servicio.getSelectedItem().toString();
            llenarComboBoxLashistas(nombre_servicio);
             Connection con = ConexionDB.getConexion();
             Statement leer = con.createStatement();
            ResultSet result = leer.executeQuery("SELECT PRECIO FROM SERVICIOS WHERE NOMBRE = '"+nombre_servicio+"'");
            String datos[] = new String[1];
            while (result.next()) {
                datos[0] = result.getString(1);
            }
            txt_precio.setText("$"+datos[0]);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cb_servicioItemStateChanged

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
            java.util.logging.Logger.getLogger(insertar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insertar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insertar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insertar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new insertar_cita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox<String> cb_cliente;
    private javax.swing.JComboBox<String> cb_lashista;
    private javax.swing.JComboBox<String> cb_servicio;
    private javax.swing.JComboBox<String> cb_sucursal;
    private javax.swing.JComboBox<String> cb_tipopago;
    private com.toedter.calendar.JDateChooser dc_fecha;
    private javax.swing.JLabel fondo_citas;
    private javax.swing.JLabel fondo_pago;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JCalendar jCalendar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner spin_hora;
    private javax.swing.JSpinner spin_minuto;
    private javax.swing.JLabel txt_contID;
    private javax.swing.JLabel txt_fecha;
    private javax.swing.JLabel txt_hora;
    private javax.swing.JLabel txt_id;
    private javax.swing.JLabel txt_lashista;
    private javax.swing.JLabel txt_nombrecliente;
    private javax.swing.JLabel txt_precio;
    private javax.swing.JLabel txt_servicio;
    private javax.swing.JLabel txt_sucursal;
    private javax.swing.JLabel txt_tipopago;
    private javax.swing.JLabel txt_titulo;
    private javax.swing.JLabel txt_totalapagar;
    // End of variables declaration//GEN-END:variables
}
