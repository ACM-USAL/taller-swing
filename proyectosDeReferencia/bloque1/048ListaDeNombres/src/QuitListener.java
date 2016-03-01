
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class QuitListener implements ActionListener {

    private ListaDeNombres estado = null;

    public QuitListener(ListaDeNombres estado) {
        this.estado = estado;
    }

    public void actionPerformed(ActionEvent ae) {
        String mensaje = "¿Desea realmente salir del programa?";
        String titulo = "Saliendo...";
        Component propietario = null;
        //propietario = estado.getMarco();
        int respuesta = JOptionPane.showConfirmDialog(propietario,
                mensaje,
                titulo,
                JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == respuesta) {
            System.exit(0);
        }
    }
}
