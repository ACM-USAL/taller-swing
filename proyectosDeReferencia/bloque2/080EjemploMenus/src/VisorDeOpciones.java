import javax.swing.*;
import java.awt.Dimension;

public class VisorDeOpciones extends JPanel {
	JLabel jl = null;
	VisorDeOpciones() {
		jl = new JLabel("No se ha seleccionado ninguna opción");
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setPreferredSize(new Dimension(300,200));
		add(jl);
	}
}
