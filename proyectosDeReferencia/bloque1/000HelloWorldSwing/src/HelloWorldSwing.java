
import javax.swing.*;

public class HelloWorldSwing {

    /**
     * Se crea la interfaz gráfica de usuario desde el hilo de procesamiento de
     * eventos.
     */
    private static void createAndShowGUI() {
        // Se utiliza el aspecto y sensación local
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Creamos una ventana con el título "Hola, Mundo - desde Swing!"
        JFrame marco = new JFrame("Hola Mundo - desde Swing!");
        // Hacemos que la aplicación concluya cuando se cierra esa ventana
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Le damos un tamaño razonable
        marco.setSize(300, 200);

        // Se crea el rótulo "Hola, Mundo!", haciendo que quede centrado
        // el texto en el rótulo
        JLabel rotulo = new JLabel("Hola, Mundo!", SwingConstants.CENTER);
        // Se añade el rótulo a la ventana
        marco.getContentPane().add(rotulo);

        //Se hace que la ventana se centre en la pantalla
        marco.setLocationRelativeTo(null);
        // Por último, se hace visible la ventana
        marco.setVisible(true);
    }

    public static void main(String[] args) {
        // Se crea oportunamente la ventana.
        javax.swing.SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
}
