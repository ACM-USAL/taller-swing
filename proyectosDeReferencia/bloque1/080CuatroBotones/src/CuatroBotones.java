import javax.swing.*;
import java.awt.*; /* Para GridLayout */
import java.awt.event.*;

public class CuatroBotones{
  public CuatroBotones() {
		/*
			Componentes - cuatro botones.
		*/
    String[] nombres = {"Uno", "Dos", "Tres", "Cuatro"};
    JButton  b = null;
		/*
			Contenedor - una ventana
		*/
    JFrame jf = new JFrame("Una ventana con cuatro botones");
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
			Disposición - una cuadrícula con 20 píxeles de separación
			horizontal y vertical entre componentes.
		*/
		jf.setLayout(new GridLayout(2,2,20,20));
		/*
			Se añaden los componentes al contenedor
		*/
    for(String s : nombres)
    	jf.add(new JButton(s));
    /*
    	Se prepara el contenedor para su visualización
    */
		jf.pack();
		jf.setLocationRelativeTo(null);
		/*
			Finalmente, se hace visible el contenedor.
			Por omisión, todos los componentes de Java se crean
			si visibilidad.
		*/
		jf.setVisible(true);
	}
	public static void main(String[] args) {
			CuatroBotones c = new CuatroBotones();
	}
}
