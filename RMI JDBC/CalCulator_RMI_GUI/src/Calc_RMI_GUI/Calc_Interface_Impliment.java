/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calc_RMI_GUI;

import com.mysql.jdbc.Connection;
import java.lang.invoke.MethodHandles;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bedo
 */
public class Calc_Interface_Impliment extends
        UnicastRemoteObject implements
        Calculator_Interface {

    public Calc_Interface_Impliment() throws RemoteException {
        super();
    }

    public int Calculator(int a, int b, int choice) throws Exception {
        Connection cn = null;
        int result = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/calcu", "root", "rancher15");
            System.out.println("Conexión exitosa a la base de datos Calculadora");

            switch (choice) {
                case 0:
                    result = a + b;
                    break;
                case 1:
                    result = a * b;
                    break;
                case 2:
                    result = a - b;
                    break;
                case 3:
                    result = a / b;
                    break;
                default:
                    System.out.println("Please Select Valid Number 1-4");
            }

            // Insertar los datos en la tabla Operaciones
            String sql = "INSERT INTO Operaciones (numero1, numero2, operador, resultado) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setInt(1, a);
            stmt.setInt(2, b);
            stmt.setString(3, obtenerOperador(choice)); // Obtener el operador como texto
            stmt.setInt(4, result);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos MySQL: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

// Método para obtener el operador como texto
    private String obtenerOperador(int choice) {
        switch (choice) {
            case 0:
                return "+";
            case 1:
                return "*";
            case 2:
                return "-";
            case 3:
                return "/";
            default:
                return "Invalido";
        }
    }
    
     @Override
    public List<String> getOperacionesRealizadas() throws RemoteException {
        List<String> operaciones = new ArrayList<>();
        try {
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/calcu", "root", "rancher15");
            String sql = "SELECT * FROM Operaciones";
            PreparedStatement stmt = cn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int numero1 = rs.getInt("numero1");
                int numero2 = rs.getInt("numero2");
                String operador = rs.getString("operador");
                int resultado = rs.getInt("resultado");
                
                operaciones.add(numero1 + " " + operador + " " + numero2 + " = " + resultado);
            }
            
            rs.close();
            stmt.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operaciones;
    }

}
