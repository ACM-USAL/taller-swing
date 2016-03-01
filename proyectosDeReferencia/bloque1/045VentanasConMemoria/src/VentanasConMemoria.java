
import com.coti.guitools.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;

public class VentanasConMemoria {

    private ArrayList<JFrameAI> jai = null;
    private JFrame ppal = null;
    private Properties p = null;
    ActionListener nwl = null;
    ActionListener ql = null;

    public boolean cargarPosiciones() {
        boolean seHanCargado = true;
        try {
            File f = new File("VentanasConMemoria.plist");
            FileInputStream fis = new FileInputStream(f);
            p = new Properties();
            p.loadFromXML(fis);
            fis.close();
            p.list(System.out);
        } catch (Exception e) {
            seHanCargado = false;
        }
        return seHanCargado;
    }

    public boolean reconstruirLasPosicionesDeLasVentanas() {
        if (cargarPosiciones()) {
            int numeroDeVentanas = Integer.parseInt(p.getProperty("numeroDeVentanas"));
            for (int i = 0; i < numeroDeVentanas; i++) {
                JFrameAI j = new JFrameAI("Marco num.: " + i,
                        JFrameAI.NONE,
                        0.2);
                int anchuraDelMarco = Integer.parseInt(p.getProperty("w" + i));
                int alturaDelMarco = Integer.parseInt(p.getProperty("h" + i));
                int posXdelMarco = Integer.parseInt(p.getProperty("x" + i));
                int posYdelMarco = Integer.parseInt(p.getProperty("y" + i));
                j.setSize(anchuraDelMarco, alturaDelMarco);
                j.setLocation(posXdelMarco, posYdelMarco);
                j.setJMenuBar(crearBarraDeMenus());
                jai.add(j);
                j.setVisible(true);
            }
        }
        return true;
    }

    public ArrayList<JFrameAI> obtenerListaDeVentanas() {
        return jai;
    }

    public JFrame getPpal() {
        return ppal;
    }

    public JMenuBar crearBarraDeMenus() {
        JMenu archivo = new JMenu("Archivo");
        JMenuItem nuevaVentana = new JMenuItem("Crear una ventana nueva");
        nuevaVentana.addActionListener(nwl);
        nuevaVentana.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                ActionEvent.META_MASK));
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(ql);

        archivo.add(nuevaVentana);
        archivo.add(salir);

        JMenuBar jmb = new JMenuBar();
        jmb.add(archivo);
        return jmb;
    }

    public VentanasConMemoria() {
        jai = new ArrayList<JFrameAI>();
        p = new Properties();
        /*
        Se construye un marco principal para disponer de un men�.
        Esta ventana no forma parte del sistema de reubicaci�n; siempre
        aparecer� en la misma posici�n.
         */
        nwl = new NewWindowListener(this);
        ql = new QuitListener(this);
        ppal = new JFrameAI("Ventana principal", JFrameAI.PLATFORM);
        ppal.setJMenuBar(crearBarraDeMenus());
        ppal.setVisible(true);
        if (!reconstruirLasPosicionesDeLasVentanas()) {
            JFrameAI.errMess(null,
                    "No se pudieron reconstruir las posiciones de las ventanas",
                    "Error en el posicionamiento de ventanas");
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                VentanasConMemoria ndc = new VentanasConMemoria();
            }
        });
    }
}
