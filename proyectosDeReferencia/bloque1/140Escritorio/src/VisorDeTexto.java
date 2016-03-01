
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import com.coti.textfiletools.*;

public class VisorDeTexto extends JPanel implements ActionListener {

    private JTextArea jta;
    private JButton abrir;
    private JButton guardar;
    private File archivo;
    private String cadenaAbrir, cadenaGuardar;
    private AuxText at;

    public VisorDeTexto(Component propietario) {
        cadenaAbrir = "Abrir...";
        cadenaGuardar = "Guardar"; // Otro constructor lo haría de otro modo
        jta = new JTextArea(25, 80);
        jta.setFont(new Font("sansserif", Font.ITALIC, 10));
        JScrollPane jsp = new JScrollPane(jta);
        abrir = new JButton(cadenaAbrir);
        abrir.addActionListener(this);
        guardar = new JButton(cadenaGuardar);
        guardar.addActionListener(this);
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.setSize(200, 16);
        panelBotones.add(abrir);
        panelBotones.add(guardar);
        this.setLayout(new BorderLayout());
        this.add(panelBotones, BorderLayout.NORTH);
        this.add(jsp, BorderLayout.CENTER);
        at = new AuxText(this);
        guardar.setEnabled(false);
    }

    public void actionPerformed(ActionEvent ae) {
        JButton origen = (JButton) ae.getSource();
        JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
        int resultado;
        String contenidoDelArchivo;
        if (origen == abrir) {
            resultado = jfc.showOpenDialog(this);
            if (JFileChooser.APPROVE_OPTION == resultado) {
                archivo = jfc.getSelectedFile();
                contenidoDelArchivo = at.readString(archivo);
                jta.setText(contenidoDelArchivo);
                guardar.setEnabled(true);
            }
        } else if (origen == guardar) {
            resultado = jfc.showSaveDialog(this);
            if (JFileChooser.APPROVE_OPTION == resultado) {
                archivo = jfc.getSelectedFile();
                at.writeString(jta.getText(), archivo);
            }
        }

    }
}
