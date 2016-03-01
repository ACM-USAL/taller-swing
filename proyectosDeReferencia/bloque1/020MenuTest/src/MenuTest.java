
import javax.swing.*;

public class MenuTest {

    public MenuTest() {

        JFrame applicationWindow = new JFrame();
        applicationWindow.setSize(400, 400);
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
