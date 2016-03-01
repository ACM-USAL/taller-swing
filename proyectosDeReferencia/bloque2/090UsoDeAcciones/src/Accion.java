import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Accion extends AbstractAction {
	UsoDeAcciones mv;
	public Accion(String nombre, UsoDeAcciones mv) {
		this.putValue(Action.NAME,nombre);
		this.putValue(Action.ACTION_COMMAND_KEY,nombre);
		this.mv = mv;
	}
	public void actionPerformed(ActionEvent ae) {
		mv.getJl().setText(ae.getActionCommand());
		if(ae.getActionCommand().equals("Salir"))
			System.exit(0);
	}
}
