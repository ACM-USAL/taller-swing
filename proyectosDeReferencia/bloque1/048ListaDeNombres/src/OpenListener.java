import com.coti.textfiletools.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class OpenListener implements ActionListener {
	private ListaDeNombres estado           = null;
	private AuxText at                      = null; 
	public OpenListener(ListaDeNombres estado)
	{
		this.estado = estado;
		at = new AuxText(estado.getMarco());
		estado.getJta().setText("No hay datos");
	}
	public void actionPerformed(ActionEvent ae)
	{
		String directorioDelUsuario = System.getProperty("user.dir");
		JFileChooser jf = new JFileChooser(directorioDelUsuario);
		int resultado = jf.showOpenDialog(estado.getMarco());
		if (JFileChooser.APPROVE_OPTION == resultado)
			estado.getJta().setText(at.readString(jf.getSelectedFile()));
	}
}
