
import com.coti.guitools.*;
import javax.swing.*;
import java.awt.*;

public class PoliticaJTabbedPane {

    public static void main(String[] args) {
        JTabbedPane jtpWRAP = new JTabbedPane(JTabbedPane.TOP,
                JTabbedPane.WRAP_TAB_LAYOUT);
        JTabbedPane jtpSCROLL = new JTabbedPane(JTabbedPane.TOP,
                JTabbedPane.SCROLL_TAB_LAYOUT);
        JFrameAI marco = new JFrameAI("Visualización de solapas",
                JFrameAI.PLATFORM,
                0.3);
        marco.setLayout(new GridLayout(1, 0));
        for (int i = 0; i < 10; i++) {
            jtpWRAP.add("W: " + i, new JPanel());
            jtpSCROLL.add("S: " + i, new JPanel());
        }
        marco.add(jtpWRAP);
        marco.add(jtpSCROLL);
        marco.setVisible(true);
    }
}
