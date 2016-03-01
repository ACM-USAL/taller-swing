
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class AutoUbicacion {

    public static void main(String[] args) {
        JFrame jf = new JFrame("Un marco que se sitúa por si mismo");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tampPant = Toolkit.getDefaultToolkit().getScreenSize();
        double escala = 1.0 / 5.0;
        double nuevaAnchura = tampPant.getWidth() * escala;
        double nuevaAltura = tampPant.getHeight() * escala;
        Dimension nuevaDimension = new Dimension();
        nuevaDimension.setSize(nuevaAnchura, nuevaAltura);
        jf.setSize(nuevaDimension);
        jf.setLocationRelativeTo(null);
        //jf.setLocationByPlatform(true);
        jf.setVisible(true);
    }
}
