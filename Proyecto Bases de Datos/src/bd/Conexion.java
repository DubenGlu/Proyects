/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 

/**
 *
 * @author DMF
 */
public class Conexion
{

 

    public static Connection getConexion()
    {
        try
        {

 

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "proyecto", "proyecto");
            return con;

 

        } catch (SQLException e)
        {
            System.out.println("Error" + e.toString());
            return null;
        }
    }

 

}
 