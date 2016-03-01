
import javax.swing.*;
import com.coti.guitools.*;
import java.awt.event.*;
import java.awt.*;

public class EditorDeListas {

    private JFrameAI marco;
    private JTextArea jta;

    public EditorDeListas() {
        marco = new JFrameAI("Editor de listas", JFrameAI.PLATFORM);
        jta = new JTextArea(25, 80); // r x c
        jta.setMargin(new Insets(16, 16, 16, 16));

        String[] opcionesDeMenu = {"Abrir...", "Guardar como...", "Salir"};
        ActionListener[] acciones = {
            new OpenListener(this),
            new SaveListener(this),
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
                EditorDeListas ndc = new EditorDeListas();
            }
        });
    }
}
