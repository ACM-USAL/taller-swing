import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.coti.guitools.*;

public class PruebaPopup implements ActionListener {
	private JFrameAI marco;
	private JPanel visor;
	private Color[] lista;
	private String[] nombres;
	private JPopupMenu jpm;
	PruebaPopup() {
		marco = new JFrameAI(	"Prueba JPopupMenu",JFrameAI.PLATFORM,0.3);
		visor = new JPanel();
		marco.getContentPane().add(visor);
		
		jpm = new JPopupMenu();
		Color[] lista2 = {
			Color.BLUE, Color.CYAN, Color.DARK_GRAY,  Color.GRAY,
			Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
			Color.ORANGE, Color.PINK, Color.RED, Color.WHITE,	Color.YELLOW
		};
		lista = lista2;
		String[] nombres2 = {
			"BLUE", "CYAN", "DARK_GRAY", "GRAY", "GREEN", "LIGHT_GRAY",
			"MAGENTA", "ORANGE", "PINK", "RED", "WHITE",  "YELLOW"
		 };
		nombres = nombres2;
		for(int i=0; i<lista.length;i++)
			{
				JMenuItem jmi = new JMenuItem(nombres[i]);
				jmi.setActionCommand(i+"");
				jmi.addActionListener(this);
				jpm.add(jmi);
			}
		MouseListener oyenteRaton = new OyentePopupMenu(this);
		visor.addMouseListener(oyenteRaton);
		marco.setVisible(true);
	}
	public Color[] getLista() { return lista; };
	public JPopupMenu getJpm() { return jpm; };
	public void actionPerformed(ActionEvent ae) {
		int numeroDeColor = Integer.parseInt(ae.getActionCommand());
		visor.setBackground(lista[numeroDeColor]);
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					PruebaPopup pp = new PruebaPopup();
				}
		});
	}
}
