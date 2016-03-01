import javax.swing.*;
import java.awt.event.*;
import com.coti.guitools.JFrameAI;


/*
 * http://wiki.netbeans.org/FaqI18nProjectEncoding
 */
public class EjemploMenus implements ActionListener {

    VisorDeOpciones vdo = null;
    JCheckBoxMenuItem[] cbmil;
    JRadioButtonMenuItem[] rbmil;
    JFrameAI marco;
    JMenuBar jmb;
    JMenu archivo;
    JMenuItem salir;

    EjemploMenus() {
        marco = new JFrameAI("Ejemplos de menús", JFrameAI.PLATFORM, 0.3);

        preparar_menus();

        vdo = new VisorDeOpciones();
        marco.getContentPane().add(vdo);

        marco.pack();
        marco.setVisible(true);
    }

    public void preparar_menus() {
        // Primero construimos un menú para poder salir
        jmb = new JMenuBar();
        archivo = new JMenu("Archivo");
        salir = new JMenuItem("Salir...");
        salir.addActionListener(new QuitListener(this));
        archivo.add(salir);
        jmb.add(archivo);
        // Ahora construimos tres menús
        String[] nombre_opcion = {"Alfa", "Beta", "Delta", "Gamma"};
        String[] nombre_opcion_submenu = {"Uno", "Dos", "Tres", "Cuatro", "Cinco"};
        JMenu ej_submenu, ej_casillas, ej_radio;
        ej_submenu = new JMenu("Submenú");
        ej_casillas = new JMenu("Casillas de verificación");
        ej_radio = new JMenu("Botones de radio");
        //
        // Un menú con un submenú
        //
        JMenuItem[] opc_1 = new JMenuItem[nombre_opcion.length];
        for (int i = 0; i < nombre_opcion.length; i++) {
            opc_1[i] = new JMenuItem(nombre_opcion[i]);
            opc_1[i].addActionListener(this);
            opc_1[i].setActionCommand(1 + "*" + i);
            ej_submenu.add(opc_1[i]);
        }
        ej_submenu.addSeparator();
        JMenu submenu = new JMenu("Submenú");
        JMenuItem[] opciones_submenu = new JMenuItem[nombre_opcion_submenu.length];
        for (int i = 0; i < nombre_opcion_submenu.length; i++) {
            opciones_submenu[i] = new JMenuItem(nombre_opcion_submenu[i]);
            opciones_submenu[i].addActionListener(this);
            opciones_submenu[i].setActionCommand(2 + "*" + i);
            submenu.add(opciones_submenu[i]);
        }
        ej_submenu.add(submenu);
        //
        // Construcción de un menú con casillas de verificación
        //
        cbmil = new JCheckBoxMenuItem[nombre_opcion.length];
        for (int i = 0; i < nombre_opcion.length; i++) {
            cbmil[i] = new JCheckBoxMenuItem(nombre_opcion[i], false);
            cbmil[i].addActionListener(this);
            cbmil[i].setActionCommand(3 + "*" + i);
            ej_casillas.add(cbmil[i]);
        }
        //
        // Construcción de un menú con botones de radio
        //
        ButtonGroup bg = new ButtonGroup();
        rbmil = new JRadioButtonMenuItem[nombre_opcion.length];
        for (int i = 0; i < nombre_opcion.length; i++) {
            rbmil[i] = new JRadioButtonMenuItem(nombre_opcion[i], false);
            rbmil[i].addActionListener(this);
            rbmil[i].setActionCommand(4 + "*" + i);
            ej_radio.add(rbmil[i]);
            bg.add(rbmil[i]);
        }
        rbmil[0].setSelected(true);// Queda seleccionada la primera opción
        // Se añaden los menús a la barra
        jmb.add(ej_submenu);
        jmb.add(ej_casillas);
        jmb.add(ej_radio);
        marco.setJMenuBar(jmb);
    }

    public void actionPerformed(ActionEvent e) {
        String[] s = e.getActionCommand().split("\\*");
        int menu = Integer.parseInt(s[0]);
        int opcion = Integer.parseInt(s[1]);
        String resultado = null;
        boolean estado;
        switch (menu) {
            case 1:
            case 2:
                resultado = "Menu: " + menu + " Opción: " + opcion;
                break;
            case 3:
                estado = cbmil[opcion].getState();
                resultado = "Menu: " + menu + " Opción: " +
                        opcion + (estado ? ", Marcada" : " ,Sin marcar");
                break;
            case 4:
                estado = rbmil[opcion].isSelected();
                resultado = "Menu: " + menu + " Opción: " +
                        opcion + (estado ? ", Marcada" : " ,Sin marcar");
                break;
        }
        vdo.jl.setText(resultado);
    }

    public static void main(String[] args) {
        new EjemploMenus();
    }
}
