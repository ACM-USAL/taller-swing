import com.coti.textfiletools.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SaveListener implements ActionListener {
	private EditorDeListas estado            = null;
  private AuxText at                      = null; 
	public SaveListener(EditorDeListas estado)
	{
		this.estado = estado;
		at = new AuxText(estado.getMarco());
	}
	public void actionPerformed(ActionEvent ae)
	{
		String directorioDelUsuario = System.getProperty("user.dir");
		JFileChooser jf = new JFileChooser(directorioDelUsuario);
		int resultado = jf.showSaveDialog(estado.getMarco());
		if (JFileChooser.APPROVE_OPTION == resultado)
			at.writeString(estado.getJta().getText(),jf.getSelectedFile());
	}
}
