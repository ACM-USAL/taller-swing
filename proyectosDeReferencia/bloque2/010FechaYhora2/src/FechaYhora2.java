
import java.util.*;
import java.text.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import com.coti.guitools.*;

public class FechaYhora2 {

    /*
    Interfaz de usuario 
     */
    private JFrameAI marco = null;
    JMenuBar jmb = null;
    JMenu archivo = null;
    JMenuItem opcionActualizar = null;
    JMenuItem opcionSalir = null;
    /*
    Proceso
     */
    private Date ahora = null;
    private SimpleDateFormat traductor = null;
    private String fecha = null;
    private JLabel jl = null;

    /*
    Constructor
     */
    public FechaYhora2() {
        /*
      Adición del rótulo al marco.
         */
        jl = new JLabel("Visualización de fecha y hora");
        jl.setSize(200, 30);
        marco = new JFrameAI("Visualización de fecha y hora",
                JFrameAI.PLATFORM);
        jl.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));//TLBR
        marco.add(jl, BorderLayout.CENTER);
        /*
      Creación de elementos de proceso
         */
        traductor = new SimpleDateFormat("dd MMMM yyyy @ hh:mm:ss");
        ahora = new Date();
        fecha = traductor.format(ahora);
        jl.setText(fecha);
        /*
      Creación del menú
         */
        opcionActualizar = new JMenuItem("Actualizar");
        opcionActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ahora = new Date();
                fecha = traductor.format(ahora);
                jl.setText(fecha);
            }
        });
        opcionActualizar.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_U,
                        ActionEvent.ALT_MASK));
        opcionSalir = new JMenuItem("Salir");
        opcionSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        archivo = new JMenu("Archivo");
        archivo.add(opcionActualizar);
        archivo.add(opcionSalir);
        jmb = new JMenuBar();
        jmb.add(archivo);
        marco.setJMenuBar(jmb);
        marco.pack();
        marco.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            FechaYhora2 fyh = new FechaYhora2();
        });
    }
}
