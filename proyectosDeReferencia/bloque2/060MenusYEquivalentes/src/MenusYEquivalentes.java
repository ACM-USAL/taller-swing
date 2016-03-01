import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import com.coti.guitools.*;

public class MenusYEquivalentes implements ActionListener{
	private JLabel jl;
	MenusYEquivalentes() {
		// Preparamos una etiqueta
		jl = new JLabel("No se ha seleccionado ninguna acción");
		jl.setPreferredSize(new Dimension(300,200));
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setBorder(new LineBorder(Color.red));
		jl.setForeground(Color.black);
		jl.setBackground(Color.pink);
		jl.setOpaque(true);
		// Preparamos un marco
		JFrameAI marco = new JFrameAI(	"Menús y equivalentes de teclado",
																		JFrameAI.PLATFORM,
																		0.3);
		// Le añadimos la etiqueta		
		marco.getContentPane().add(jl);
		// Preparamos un menú y sus opciones
		String[] nombres_de_opciones =	{
																			"Alfa", "Beta",
																			"Gamma", "Delta",
																			"Salir"
																		};
		JMenuItem[] jmil = new JMenuItem[nombres_de_opciones.length];
		JMenu archivo = new JMenu("Archivo");
		// Tecla de activación del menú
		archivo.setMnemonic(KeyEvent.VK_A);
		// Configuración de la opciones de menú
		for(int i=0;i<nombres_de_opciones.length;i++)
			{
				jmil[i] = new JMenuItem(nombres_de_opciones[i]);
				//jmil[i].setActionCommand(i+"");
				jmil[i].setActionCommand(nombres_de_opciones[i]);
				jmil[i].addActionListener(this);
				jmil[i].setAccelerator(	KeyStroke.getKeyStroke(
																		nombres_de_opciones[i].charAt(0),
																		Event.CTRL_MASK
																											)
															);
				archivo.add(jmil[i]);
			}
		// Añadimos las opciones a una barra de menús
		JMenuBar jmb = new JMenuBar();
		jmb.add(archivo);
		// Añadimos la barra al marco y lo hacemos visible
		marco.setJMenuBar(jmb);
		marco.pack();
		marco.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		
		// Mostramos la acción seleccionada poniendo su nombre en el rótulo
		jl.setText(accion);
		
		if(accion.equals("Salir"))
			System.exit(0);
	}
	public static void main(String[] args) {
			new MenusYEquivalentes();
	}
}