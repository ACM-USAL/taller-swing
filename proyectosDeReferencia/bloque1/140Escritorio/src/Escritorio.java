
import javax.swing.*;
import com.coti.guitools.*;
import java.awt.event.*;

public class Escritorio implements ActionListener {

    private JFrameAI marco;
    private JDesktopPane jdp;
    private JMenuItem otroReloj, otroArchivo, salir;
    private JMenu archivo;
    private JMenuBar jmb;
    private int numFrames;

    public Escritorio() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("%nCould not set default LAF%n");
        }
        marco = new JFrameAI("Escritorio", JFrameAI.PLATFORM, 0.5);
        jdp = new JDesktopPane();
        numFrames = 0;
        marco.getContentPane().add(jdp);
        archivo = new JMenu("Archivo");
        otroReloj = new JMenuItem("Otro reloj");
        otroReloj.addActionListener(this);
        otroReloj.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
                ActionEvent.CTRL_MASK));
        otroArchivo = new JMenuItem("Otro archivo");
        otroArchivo.addActionListener(this);
        otroArchivo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                ActionEvent.CTRL_MASK));
        salir = new JMenuItem("Salir");
        salir.addActionListener(this);
        salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                ActionEvent.CTRL_MASK));
        archivo.add(otroReloj);
        archivo.add(otroArchivo);
        archivo.add(salir);
        jmb = new JMenuBar();
        jmb.add(archivo);
        marco.setJMenuBar(jmb);
    }

    public void actionPerformed(ActionEvent ae) {
        JMenuItem origen = (JMenuItem) ae.getSource();
        JInternalFrame jif;
        int desp_x = 30;
        int desp_y = 40;
        int posx = (int) Math.abs(Math.random() * jdp.getBounds().width - 200);
        int posy = (int) Math.abs(Math.random() * jdp.getBounds().height - 200);
        if (origen == otroReloj) {
            numFrames++;
            jif = new JInternalFrame(numFrames + " (Reloj)", true, true, true, true);
            jif.add(new RelojDigital());
            jif.setSize(200, 200);
            jif.setLocation(posx, posy);
            jdp.add(jif);
            jif.setVisible(true);
        } else if (origen == otroArchivo) {
            numFrames++;
            jif = new JInternalFrame(numFrames + " (Archivo)", true, true, true, true);
            jif.add(new VisorDeTexto(marco));
            jif.setSize(200, 200);
            jif.setLocation(posx, posy);
            jdp.add(jif);
            jif.setVisible(true);
        } else if (origen == salir) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                Escritorio scr = new Escritorio();
                scr.marco.setVisible(true);
            }
        });
    }
}
