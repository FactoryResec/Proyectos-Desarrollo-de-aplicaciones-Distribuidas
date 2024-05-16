/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syntech2;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.ejb.Stateless;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
@Stateless
public class BDConnect {

   Connection con=null;
       
 public static Connection serverConnect()
    {
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/calcubd?","root","");
            System.out.println("Conexión exitosa a la base de datos WebTest");
       
         
        } catch (Exception e) {
            System.out.println("inter.DBConnect.connect()");
            JOptionPane.showConfirmDialog(null,e);
        }
       return con;
    }
}
