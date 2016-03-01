import java.util.*;
import java.text.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class UpdateListener implements ActionListener {
	private FechaYhora3 estado              = null;
  private Date ahora                      = null;
  private SimpleDateFormat traductor      = null;
  private String fecha                    = null; 
	public UpdateListener(FechaYhora3 estado)
	{
		this.estado = estado;
		ahora = new Date();
		traductor = new SimpleDateFormat("dd MMMM yy @ hh:mm:ss");
		fecha = traductor.format(ahora);
		estado.getRotulo().setText(fecha);
	}
	public void actionPerformed(ActionEvent ae)
	{
		ahora = new Date();
		fecha = traductor.format(ahora);
		estado.getRotulo().setText(fecha);
	}
}