import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import com.coti.guitools.*;

public class FechaYhora3 {
  /*
    Interfaz de usuario 
  */
  private JFrameAI marco                  = null;
  JMenuBar jmb                            = null;
  JMenu archivo                           = null;
  JMenuItem opcionActualizar              = null;
  JMenuItem opcionSalir                   = null;
  /*
    Proceso
  */
  private JLabel rotulo                       = null;
  public JLabel getRotulo() { return rotulo; };
  public JFrameAI getMarco() { return marco; };
  /*
    Constructor
  */
  public FechaYhora3() {
    /*
      Creación del rótulo y el marco.
      Adición del rótulo al marco.
    */
    rotulo = new JLabel("Visualización de fecha y hora");
    rotulo.setSize(200,30);
    marco = new JFrameAI( "Visualización de fecha y hora",
                          JFrameAI.PLATFORM);
    rotulo.setBorder(BorderFactory.createEmptyBorder(40,   // Arriba
    																								40,   // Izquierda
    																								40,   // Abajo
    																								40)); // Derecha
    /*
    	Se crean dos clases independientes, una para cada
    	oyente. De este modo, sería muy fácil construir el
    	programa en paralelo, asignando una clase a cada equipo.
    */
    UpdateListener ul = new UpdateListener(this);
    QuitListener   ql = new QuitListener(this);
    marco.add(rotulo,BorderLayout.CENTER);
    /*
      Se construye una barra de menús sencilla
    */
    opcionActualizar = new JMenuItem("Actualizar");
    opcionActualizar.addActionListener(ul);
    opcionActualizar.setAccelerator(
          KeyStroke.getKeyStroke( KeyEvent.VK_U,
                                  ActionEvent.ALT_MASK));
    opcionSalir = new JMenuItem("Salir");
    opcionSalir.addActionListener(ql);
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
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    FechaYhora3 fyh = new FechaYhora3();
                }
            });    
  }
}
