
import com.coti.guitools.*;
import java.awt.*;

public class PruebaVisorDeTexto {

    public PruebaVisorDeTexto() {
        JFrameAI marco = new JFrameAI("Prueba de VisorDeTexto",
                JFrameAI.PLATFORM, 0.0);
        VisorDeTexto vdt = new VisorDeTexto(marco);
        marco.add(vdt, BorderLayout.CENTER);
        marco.pack();
        marco.setVisible(true);
    }

    public static void main(String[] args) {
        PruebaVisorDeTexto pvdt = new PruebaVisorDeTexto();
    }
}
