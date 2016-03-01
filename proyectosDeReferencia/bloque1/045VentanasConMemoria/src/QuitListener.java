
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import com.coti.guitools.*;
import java.io.*;

public class QuitListener implements ActionListener {

    private VentanasConMemoria estado = null;

    public QuitListener(VentanasConMemoria estado) {
        this.estado = estado;
    }

    public void guardarLasPosicionesDeLasVentanas() {
        Properties p = new Properties();
        ArrayList<JFrameAI> listaDeVentanas = estado.obtenerListaDeVentanas();
        p.setProperty("numeroDeVentanas", listaDeVentanas.size() + "");
        for (int i = 0; i < listaDeVentanas.size(); i++) {
            JFrameAI j = listaDeVentanas.get(i);
            int anchuraDelMarco = j.getSize().width;
            int alturaDelMarco = j.getSize().height;
            int posXdelMarco = j.getLocationOnScreen().x;
            int posYdelMarco = j.getLocationOnScreen().y;
            String claveAnchura = "w" + i;
            String claveAltura = "h" + i;
            String clavePosX = "x" + i;
            String clavePosY = "y" + i;
            p.setProperty(claveAnchura, anchuraDelMarco + "");
            p.setProperty(claveAltura, alturaDelMarco + "");
            p.setProperty(clavePosX, posXdelMarco + "");
            p.setProperty(clavePosY, posYdelMarco + "");
        }
        try {
            File f = new File("VentanasConMemoria.plist");
            FileOutputStream fos = new FileOutputStream(f);
            p.storeToXML(fos, "Posiciones de las ventanas", "UTF-8");
            fos.close();
        } catch (Exception e) {
            JFrameAI.errMess(estado.getPpal(),
                    e.getMessage(),
                    "No fue posible guardar las posiciones");
        }
    }

    public void actionPerformed(ActionEvent ae) {
        String mensaje = "¿Desea realmente salir del programa?";
        String titulo = "Saliendo...";
        Component propietario = estado.getPpal();
        int respuesta = JOptionPane.showConfirmDialog(propietario,
                mensaje,
                titulo,
                JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == respuesta) {
            guardarLasPosicionesDeLasVentanas();
            System.exit(0);
        }
    }
}
