import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inicio_sesion {
    private JLabel Titulo_pagina;
    private JLabel userlbl;
    private JTextField usr_entry;
    private JLabel passwdlbl;
    private JPasswordField pass_entry;
    private JButton iniciarbtn;
    JPanel Pantalla_inicio;

    List<Object[]> arreglo = new ArrayList<>();

    public Inicio_sesion() {
        iniciarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arreglo.clear();

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
                    boolean encontrado = false;
                    for (Object[] fila : arreglo) {
                        String nombre = (String) fila[1];
                        String contrasena = (String) fila[2];
                        if (nombre.equals(usr_entry.getText()) && contrasena.equals(new String(pass_entry.getPassword()))) {
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        JOptionPane.showMessageDialog(Pantalla_inicio, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        JFrame inicio = new JFrame();
                        inicio.setContentPane(new Principal().pantalla2);
                        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        inicio.setSize(800,640);
                        inicio.setVisible(true);
                        inicio.pack();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return;
                }
            }
        });
    }
}
