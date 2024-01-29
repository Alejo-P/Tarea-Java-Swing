import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    private JLabel Titulo;
    private JLabel Info;
    private JTextArea area_texto;
    private JButton salir;
    JPanel pantalla2;

    private int id_usr;

    List<Object[]> arreglo = new ArrayList<>();

    public Principal (int ID) {
        String URL="jdbc:mysql://localhost:3306/poo_usuarios";
        String bd_user="root";
        String bd_pass=""; //No se puede compartir la contraseña de un servidor local
        this.id_usr=ID;
        java.sql.Connection conexion= null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, bd_user, bd_pass);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT * FROM detalles");
            int id, usr;
            String descripcion;
            while (resultado.next())
            {
                id=resultado.getInt("id");
                usr=resultado.getInt("usuario");
                descripcion=resultado.getString("descripcion");
                Object[] fila = {id, usr, descripcion};
                arreglo.add(fila);
            }
            resultado.close();
            statement.close();
            conexion.close();
            for (Object[] fila : arreglo) {
                int usuario_desc = (int) fila[1];
                String desc = (String) fila[2];
                if (usuario_desc == this.id_usr) {
                    area_texto.setText(desc);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(pantalla2);
                frame.dispose();
            }
        });
    }
}
