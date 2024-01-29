import javax.swing.*;

public class Principal {
    private JLabel Titulo;
    private JLabel Info;
    private JTextArea area_texto;
    private JButton salir;
    JPanel pantalla2;

    public Principal () {
        String URL="jdbc:mysql://localhost:3306/poo_usuarios";
        String bd_user="root";
        String bd_pass="AP_@l3j0_2004";
        java.sql.Connection conexion= null;
    }
}
