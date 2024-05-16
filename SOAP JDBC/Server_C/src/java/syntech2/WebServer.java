/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syntech2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author cesar
 */
@WebService(serviceName = "WebServer")
public class WebServer {
Connection con = BDConnect.serverConnect();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public void operation(@WebParam(name = "num1") int num1, @WebParam(name = "operador") String operador, @WebParam(name = "num2") int num2, @WebParam(name = "resultado") int resultado) {
        try {
           String sq="INSERT INTO `operaciones`(`num1`,`operador`,`num2`,`resultado`) VALUES ('"+num1+"','"+operador+"','"+num2+"','"+resultado+"')";
             PreparedStatement pst=con.prepareStatement(sq);
           pst.execute();
        //   update();
        } catch (Exception e) {
          // JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
      
   @WebMethod(operationName = "actualizar")
    public List<String> actualizar() {
        List<String> operaciones = new ArrayList<>();
        try {
            String sql = "SELECT * FROM operaciones";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int num1 = rs.getInt("num1");
                String operador = rs.getString("operador");
                int num2 = rs.getInt("num2");
                int resultado = rs.getInt("resultado");
                operaciones.add("\nOperación: " + num1 + " " + operador + " " + num2 + " = " + resultado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operaciones;
    }
    
    
}
