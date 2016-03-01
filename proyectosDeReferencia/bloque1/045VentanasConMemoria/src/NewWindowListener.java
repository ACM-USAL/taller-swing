
import com.coti.guitools.*;
import java.util.*;
import java.awt.event.*;

public class NewWindowListener implements ActionListener {

    private ArrayList<JFrameAI> jai = null;
    VentanasConMemoria estado = null;

    public NewWindowListener(VentanasConMemoria estado) {
        this.estado = estado;
        this.jai = estado.obtenerListaDeVentanas();
    }

    public void actionPerformed(ActionEvent ae) {
        JFrameAI nuevoMarco = new JFrameAI("Marco num.: " + jai.size(),
                JFrameAI.PLATFORM,
                0.2);
        nuevoMarco.setJMenuBar(estado.crearBarraDeMenus());
        jai.add(nuevoMarco);
        nuevoMarco.setVisible(true);
    }
}
