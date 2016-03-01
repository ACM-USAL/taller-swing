import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Accion2 extends AbstractAction {
	UsoDeAcciones2 mv;
	public Accion2(String nombre, UsoDeAcciones2 mv, Icon icono) {
		super(nombre,icono);
		this.putValue(Action.ACTION_COMMAND_KEY,nombre);
		this.mv = mv;
	}
	public void actionPerformed(ActionEvent ae) {
		mv.getJl().setText(ae.getActionCommand());
		if(ae.getActionCommand().equals("Salir"))
			System.exit(0);
	}
}
