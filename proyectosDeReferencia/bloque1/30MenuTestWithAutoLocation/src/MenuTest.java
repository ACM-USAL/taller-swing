/*
 * Salamanca - ACM Workshop on Java Swing 2016
 * Permission is granted for non-commercial use
 * Dr. J.R. García-Bermejo Giner - coti@usal.es
 */
// Funny
//
// proxima:C_01_programas bruegel$ edit */src/*.java
//
// This program is equivalent to 20MenuTest (q.v.) making use of JFrameAL
//
// One could of course include a library
//
import biblioteca.JFrameAL;
import javax.swing.*;

public class MenuTest {

    public MenuTest() {

        JFrameAL applicationWindow = new JFrameAL("MenuTest",JFrameAL.CENTER);

        JMenuBar applicationMenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenuItem quitMenuItem = new JMenuItem("Salir");

        fileMenu.add(quitMenuItem);
        applicationMenuBar.add(fileMenu);

        ListenerForQuitMenuItem listenerForMenuItem = new ListenerForQuitMenuItem();
        quitMenuItem.addActionListener(listenerForMenuItem);

        applicationWindow.setJMenuBar(applicationMenuBar);
        applicationWindow.setLocationRelativeTo(null);
        applicationWindow.setVisible(true);
    }

    public static void main(String[] argumentos) {
        MenuTest pm = new MenuTest();
    }
}
