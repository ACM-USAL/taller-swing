
import com.coti.guitools.*;
import javax.swing.*;
import java.awt.*;

public class JTabbedPaneColores {

    public static void main(String[] args) {
        JFrameAI marco = new JFrameAI("JTabbedPane con colores",
                JFrameAI.PLATFORM,
                0.4);
        JTabbedPane jtp = new JTabbedPane();
        JPanel jp;
        Color[] color = {
            Color.red, Color.orange, Color.yellow,
            Color.green, Color.cyan, Color.blue,
            Color.magenta
        };
        String[] name = {
            "ROJO", "ANARANJADO", "AMARILLO",
            "VERDE", "AZUL", "AÑIL",
            "VIOLETA"
        };
        int j = 0;
        for (int i = 0; i < color.length; i++) {
            if (i < color.length - 1) {
                j++;
            } else {
                j = 0;
            }
            jp = new JPanel();
            jp.setBackground(color[i]);
            jtp.addTab(name[i], jp);
            jtp.setForegroundAt(i, color[i]);
            jtp.setBackgroundAt(i, color[j]);
        }
        marco.add(jtp);
        marco.setVisible(true);
    }
}