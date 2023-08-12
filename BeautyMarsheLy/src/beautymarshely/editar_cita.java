/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beautymarshely;

import static beautymarshely.ConexionDB.getConexion;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
/**
 *
 * @author rey_r
 */
public class editar_cita extends javax.swing.JFrame {

    /**
     * Creates new form editar_cita
     */
    static Menu obm = new Menu();
    int contadordatos;
    int contador_clientes;
    int contador_servicios;
    int contador_lashistas;
    int contador_tipopago;
    int contador_sucursal;
    public editar_cita() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("src/imagenes/BeautyMarshe_Ly.png");
        this.setIconImage(img.getImage());
    }

    
    public void llenarComboBoxID() {
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
    
    public void llenarComboBox(int contador, JComboBox cb, String tabla, String campo) {
        cb.removeAllItems();
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

        jPanel1 = new javax.swing.JPanel();
        txt_nombrecliente = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        txt_titulo = new javax.swing.JLabel();
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
        cb_id = new javax.swing.JComboBox<>();
        txt_id = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_totalapagar = new javax.swing.JLabel();
        txt_precio = new javax.swing.JLabel();
        fondo_pago = new javax.swing.JLabel();
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
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_id.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_idItemStateChanged(evt);
            }
        });
        jPanel3.add(cb_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 70, -1));

        txt_id.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_id.setForeground(new java.awt.Color(100, 70, 35));
        txt_id.setText("ID:");
        jPanel3.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 35, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 22, 710, 60));

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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarComboBoxID();
        
    }//GEN-LAST:event_formWindowOpened

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        Citas ob = new Citas();
        ob.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        cb_cliente.setSelectedItem(null);
        cb_lashista.setSelectedItem(null);
        cb_servicio.setSelectedItem(null);
        cb_sucursal.setSelectedItem(null);
        cb_tipopago.setSelectedItem(null);
        spin_hora.setValue(0);
        spin_minuto.setValue(0);
    }//GEN-LAST:event_btn_limpiarActionPerformed

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
            PreparedStatement ps = con.prepareStatement("UPDATE CITAS SET ID_CITA = ?, ID_CLIENTE = ?, FECHA = ?, HORA = ? WHERE ID_CITA = ?");
            Statement leer = con.createStatement();
            ResultSet result = leer.executeQuery("select distinct id_cliente from clientes where nombre = '"+cliente+"'");
            int[] x = new int[1];
            while (result.next()) {
                x[0] = result.getInt(1);
            }
            int id_cliente = x[0];
            ps.setInt(1, id_cita);
            ps.setInt(2, id_cliente);
            ps.setString(3, fecha);
            ps.setString(4, hora);
            ps.setInt(5, id_cita);
            ps.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement("UPDATE CITA_DETA SET ID_SERVICIO = ?, ID_CITA = ?, ID_LASHISTA = ?, TOTAL_PAGO = ?, ID_PAGO = ?, ID_SUCURSAL = ? WHERE ID_CITA =?");
            ResultSet result2 = leer.executeQuery("select distinct id_servicio,precio from servicios where nombre = '"+servicio+"'");
            int[] x2 = new int[2];
            while (result2.next()) {
                x2[0] = result2.getInt(1);
                x2[1] = result2.getInt(2);
            }
            int id_servicio = x2[0];
            int total_pago = x2[1];
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
            ps2.setInt(1,id_servicio);
            ps2.setInt(2,id_cita);
            ps2.setInt(3,id_lashista);
            ps2.setInt(4,total_pago);
            ps2.setInt(5,id_pago);
            ps2.setInt(6,id_sucursal);
            ps2.setInt(7,id_cita);
            ps2.executeUpdate();

            JOptionPane.showMessageDialog(null, "cita insertada correctamente");
            btn_limpiarActionPerformed(evt);
            btn_cancelarActionPerformed(evt);

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, sql.toString(), "", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btn_guardarActionPerformed

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

    private void cb_idItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_idItemStateChanged
            llenarComboBox(contador_clientes, cb_cliente, "clientes", "nombre");
            llenarComboBox(contador_servicios, cb_servicio, "servicios", "nombre");
            llenarComboBox(contador_sucursal, cb_sucursal, "direccion", "ciudad");
            llenarComboBox(contador_tipopago, cb_tipopago, "tipo_pago", "tipo");
        try {
            String id = cb_id.getSelectedItem().toString();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
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
            cb_cliente.setSelectedItem(datos[0]);
            
            cb_servicio.setSelectedItem(datos[3]);
            cb_lashista.setSelectedItem(datos[4]);
            cb_tipopago.setSelectedItem(datos[5]);
            cb_sucursal.setSelectedItem(datos[6]);

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
            java.util.logging.Logger.getLogger(editar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editar_cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editar_cita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox<String> cb_cliente;
    private javax.swing.JComboBox<String> cb_id;
    private javax.swing.JComboBox<String> cb_lashista;
    private javax.swing.JComboBox<String> cb_servicio;
    private javax.swing.JComboBox<String> cb_sucursal;
    private javax.swing.JComboBox<String> cb_tipopago;
    private com.toedter.calendar.JDateChooser dc_fecha;
    private javax.swing.JLabel fondo_citas;
    private javax.swing.JLabel fondo_pago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner spin_hora;
    private javax.swing.JSpinner spin_minuto;
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
