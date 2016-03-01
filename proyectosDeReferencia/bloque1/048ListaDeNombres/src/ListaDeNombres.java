
import javax.swing.*;
import com.coti.guitools.*;
import java.awt.event.*;
import java.awt.*;
/*
 * Nota:
 *
 * Los signos diacríticos del archivo de entrada solo se mostrarán
 * correctamente si la codificación de la terminal coincide con la
 * codificación del archivo leído. En este caso, se suministra una
 * archivo de codificación UTF8 (No BOM), que deberia mostrarse
 * correctamente.
 */
public class ListaDeNombres {

    private JFrameAI marco;
    private JTextArea jta;

    public ListaDeNombres() {
        marco = new JFrameAI("Lista de Nombres", JFrameAI.PLATFORM);
        String[] opcionesDeMenu = {"Abrir...", "Salir"};
        jta = new JTextArea(25, 80); // f x c
        jta.setMargin(new Insets(16, 16, 16, 16));
        ActionListener[] acciones = {
            new OpenListener(this),
            new QuitListener(this)
        };
        JMenu archivo = new JMenu("Archivo");
        for (int i = 0; i < opcionesDeMenu.length; i++) {
            JMenuItem jb = new JMenuItem(opcionesDeMenu[i]);
            jb.addActionListener(acciones[i]);
            archivo.add(jb);
        }
        JMenuBar jmb = new JMenuBar();
        jmb.add(archivo);
        marco.setJMenuBar(jmb);
        marco.add(jta, BorderLayout.CENTER);
        marco.setVisible(true);
    }

    public JTextArea getJta() {
        return jta;
    }

    ;

    public JFrame getMarco() {
        return marco;
    }

    ;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                ListaDeNombres ndc = new ListaDeNombres();
            }
        });
    }
}
