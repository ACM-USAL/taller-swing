/*
 * Main.java
 *
 * Created on May 10, 2007, 6:21 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import com.coti.guitools.*;
import java.awt.BorderLayout;
/**
 *
 * @author coti
 */
public class Main {
    JFrameAI marco = null;

    public Main() {
        marco = new JFrameAI("Reloj Digital",JFrameAI.PLATFORM,0.1f);
        RelojDigital r = new RelojDigital();
        marco.add(r,BorderLayout.CENTER);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.marco.setVisible(true);
    }
    
}
