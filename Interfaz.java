import javax.swing.*;
public class Interfaz {
    public static void main (String [] args) {
        JFrame inicio = new JFrame();
        inicio.setContentPane(new Inicio_sesion().Pantalla_inicio);
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setSize(800,640);
        inicio.setVisible(true);
        inicio.pack();
    }
}
