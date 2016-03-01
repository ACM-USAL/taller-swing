import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class QuitListener implements ActionListener {
  private EditorDeListas estado               = null;
  public QuitListener(EditorDeListas estado)
  {
    this.estado = estado;
  }
  public void actionPerformed(ActionEvent ae)
  {
    String mensaje = "¿Desea realmente salir del programa?";
    String titulo = "Saliendo...";
    Component propietario = estado.getMarco();
    int response =     JOptionPane.showConfirmDialog( propietario,
                                   mensaje,
                                   titulo,
                                   JOptionPane.YES_NO_OPTION);
    if (JOptionPane.YES_OPTION == response)
    	System.exit(0);
  }
}
