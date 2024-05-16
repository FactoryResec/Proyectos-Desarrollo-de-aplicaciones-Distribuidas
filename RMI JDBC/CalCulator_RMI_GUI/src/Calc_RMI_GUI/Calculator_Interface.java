/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calc_RMI_GUI;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Calculator_Interface extends Remote {
    int Calculator(int num1, int num2, int operator) throws Exception;
    List<String> getOperacionesRealizadas() throws RemoteException;
}
