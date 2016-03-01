import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

public class MenusBotonesYEquivalentes implements ActionListener{
		JLabel jl;
		public MenusBotonesYEquivalentes() {
		// Preparamos una etiqueta
		jl = new JLabel("No se ha seleccionado ninguna acción");
		jl.setPreferredSize(new Dimension(300,200));
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setBorder(new LineBorder(Color.red));
		jl.setForeground(Color.black);
		jl.setBackground(Color.pink);
		jl.setOpaque(true);
		// Preparamos un JFrame		
		JFrame jf = new JFrame("Menús y equivalentes de teclado");
		jf.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) {
					System.exit(0);
				}
		});
		// Le añadimos la etiqueta		
		jf.getContentPane().add(jl);
		// Preparamos un menú y sus opciones
		String[] nombres_de_opciones = {"Alfa", "Beta", "Gamma", "Delta", "Salir"};
		int numero = nombres_de_opciones.length;
		JMenuItem[] jmil = new JMenuItem[numero];
		JMenu archivo = new JMenu("Archivo");
		// El archivo se activa mediante Alt+R; Alt+A activa el botón
		archivo.setMnemonic(KeyEvent.VK_R);
		for(int i=0;i<numero;i++)
			{
				jmil[i] = new JMenuItem(nombres_de_opciones[i]);
				jmil[i].setActionCommand(nombres_de_opciones[i]);
				jmil[i].addActionListener(this);
				jmil[i].setAccelerator(KeyStroke.getKeyStroke(nombres_de_opciones[i].charAt(0),java.awt.Event.CTRL_MASK));
				archivo.add(jmil[i]);
			}
		// Los añadimos a una barra de menús
		JMenuBar jmb = new JMenuBar();
		jmb.add(archivo);
		// Preparamos botones equivalentes
		JButton[] jbl = new JButton[numero];
		JPanel panel_botones = new JPanel(new GridLayout(1,numero));
		for(int i=0;i<numero;i++)
			{
				jbl[i] = new JButton(nombres_de_opciones[i]);
				jbl[i].setActionCommand(nombres_de_opciones[i]);
				jbl[i].addActionListener(this);
				jbl[i].setMnemonic(nombres_de_opciones[i].charAt(0));
				panel_botones.add(jbl[i]);
			}
		jf.getContentPane().add(BorderLayout.NORTH, panel_botones);
		// Añadimos la barra al JFrame y lo hacemos visible
		jf.setJMenuBar(jmb);
		jf.pack();
		jf.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		jl.setText(accion);
		if(accion.equals("Salir"))
			System.exit(0);
	}
	public static void main(String[] args) {
			new MenusBotonesYEquivalentes();
	}
}
