import java.awt.event.*;
import java.awt.*;

public class ListenerForQuitMenuItem implements ActionListener {
	public void actionPerformed(ActionEvent ae) {
		System.exit(0);
	}
}
