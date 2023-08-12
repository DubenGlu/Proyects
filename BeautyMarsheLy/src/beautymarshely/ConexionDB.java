
package beautymarshely;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class ConexionDB {
    
   
    static Statement st;
    static ResultSet rs;
    
    
    
    
   
    
    public static Connection getConexion()
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/RubenDB", "SalonBell", "SalonBell12");
            return con;
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Error en la coneccion: " + e.toString());
            return null;
        }
    }
    
    
}
