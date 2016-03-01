import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class OyentePopupMenu extends MouseAdapter {
	private PruebaPopup p;
	private Color[] lista;
	JPopupMenu jpm;
	public OyentePopupMenu(PruebaPopup p) {
		this.p = p;
		this.lista = p.getLista();
		this.jpm = p.getJpm();
	}

	public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger()) {
					jpm.show(e.getComponent(),
										 e.getX(), e.getY());
			}
	}
	public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger()) {
					jpm.show(e.getComponent(),
										 e.getX(), e.getY());
			}
	}
}
