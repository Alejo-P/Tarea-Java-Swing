import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Inicio_sesion {
    private JLabel Titulo_pagina;
    private JLabel userlbl;
    private JTextField usr_entry;
    private JLabel passwdlbl;
    private JPasswordField pass_entry;
    private JButton iniciarbtn;
    JPanel Pantalla_inicio;

    public Inicio_sesion() {
        iniciarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Object[]> arreglo = new ArrayList<>();
                String URL="jdbc:mysql://localhost:3306/poo_usuarios";
                String bd_user="root";
                String bd_pass="AP_@l3j0_2004";
                java.sql.Connection conexion= null;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conexion = DriverManager.getConnection(URL, bd_user, bd_pass);
                    Statement statement = conexion.createStatement();
                    ResultSet resultado = statement.executeQuery("SELECT * FROM registros");
                    int id;
                    String Nombre, Contras;
                    while (resultado.next())
                    {
                        id=resultado.getInt("id");
                        Nombre=resultado.getString("Usuario");
                        Contras=resultado.getString("Contrasena");
                        Object[] fila = {id, Nombre, Contras};
                        arreglo.add(fila);
                    }
                    for (Object[] fila : arreglo) {
                        int ID = (int) fila[0];
                        String nombre = (String) fila[1];
                        String contrasena = (String) fila[2];

                        System.out.println("ID: " + ID + ", Nombre: " + nombre + ", Contraseña: " + contrasena);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return;
                }
            }
        });
    }
}
