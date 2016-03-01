
import com.coti.guitools.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SeveralFrames {

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        ArrayList<JFrameAI> lista = new ArrayList<>();
        int numeroDeMarcos = 10;
        if (args.length == 1) {
            try {
                numeroDeMarcos = Integer.parseInt(args[0]);
            } catch (Exception e) {
                System.err.println("Error al leer el número de marcos");
            }
        }
        JLabel rotulo;
        JFrameAI marco;

        for (int i = 0; i < numeroDeMarcos; i++) {
            rotulo = new JLabel("Marco numero: " + i, SwingConstants.CENTER);
            marco = new JFrameAI("Autolocated Frame", JFrameAI.PLATFORM, 0.5);
            marco.add(rotulo);
            lista.add(marco);
            marco.setLocationByPlatformFix(lista);
            marco.setVisible(true);
        }
    }
}
