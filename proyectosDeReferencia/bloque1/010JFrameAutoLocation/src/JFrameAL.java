
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class JFrameAL extends JFrame {

    public static final int CENTER = 0;
    public static final int PLATFORM = 1;

    public JFrameAL(String title, int placement) {
        super(title);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        float scaleFactor = 1.0f / 2.0f;
        int desiredWindowWidth = (int) (screenDimensions.width * scaleFactor);
        int desiredWindowHeight = (int) (screenDimensions.height * scaleFactor);
        Dimension windowDimensions = new Dimension(desiredWindowWidth, desiredWindowHeight);
        super.setSize(windowDimensions);

        if (CENTER == placement) {
            super.setLocationRelativeTo(null);
        } else if (PLATFORM == placement) {
            super.setLocationByPlatform(true);
        }

    }
}
