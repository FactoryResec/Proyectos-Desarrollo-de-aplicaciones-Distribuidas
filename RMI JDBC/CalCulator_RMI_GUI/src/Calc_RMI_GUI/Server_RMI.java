package Calc_RMI_GUI;

import javax.swing.JFrame;

public class Server_RMI {
    public static void main(String[] args) {
        // Crear una instancia de tu formulario
        ServerFrom s = new ServerFrom();
        
        // Configurar la operación al cerrar la ventana
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Hacer visible el formulario
        s.setVisible(true);
    }
}



