import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import com.coti.guitools.*;
import java.net.URL;

public class UsoDeAcciones2{
		JLabel jl;
		public UsoDeAcciones2() {
		// Preparamos una etiqueta
		jl = new JLabel("No se ha seleccionado ninguna acción");
		jl.setPreferredSize(new Dimension(300,200));
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setBorder(new LineBorder(Color.red));
		jl.setForeground(Color.black);
		jl.setBackground(Color.pink);
		jl.setOpaque(true);
		// Preparamos un JFrame		
		JFrameAI jf = new JFrameAI("Menús y equivalentes de teclado",
																JFrameAI.PLATFORM,0.0);
		// Le añadimos la etiqueta		
		jf.getContentPane().add(jl);
		// Creamos una barra de menús con un menú (archivo)
		JMenuBar jmb = new JMenuBar();
		JMenu archivo = new JMenu("Archivo");
		// El archivo se activa mediante Alt+R; Alt+A activa el botón
		archivo.setMnemonic(KeyEvent.VK_R);
		jmb.add(archivo);
		jf.setJMenuBar(jmb);

		// Preparamos los nombres de las opciones de menu
		// y de los botones
		String[] nombres_de_opciones = {
																			"Alfa", "Beta",
																			"Gamma", "Delta",
																			"Salir"
																		};
		String[] rutas							 = {
																			"img/alfa.jpg", "img/beta.jpg",
																			"img/gamma.jpg", "img/delta.jpg",
																			"img/exit.gif"
																		};
		int numero = nombres_de_opciones.length;
		// Creamos los botones y menús
		JMenuItem jmi 				= null;
		JButton jb 						= null;
		JPanel panel_botones 	= new JPanel(new GridLayout(1,numero));
		AbstractAction accion = null;
		Icon icono 						= null;
		for(int i=0;i<numero;i++)
			{
				URL imgURL = ClassLoader.getSystemResource(rutas[i]);
				if (imgURL != null)
					icono = new ImageIcon(imgURL);
				else
					jf.errMess(	null,
											"No se encontró "+rutas[i],
											"Fallo al cargar iconos");
				accion = new Accion2(nombres_de_opciones[i], this,icono);
				jmi = new JMenuItem(accion);
				jmi.setAccelerator(
																KeyStroke.getKeyStroke(
																	nombres_de_opciones[i].charAt(0),
																	Event.CTRL_MASK
																											)
													);
				archivo.add(jmi);
				jb = new JButton(accion);
				jb.setMnemonic(nombres_de_opciones[i].charAt(0));
				panel_botones.add(jb);
			}

		// Añadimos el panel de botones a la zona norte del contenedor
		jf.getContentPane().add(BorderLayout.NORTH, panel_botones);

		jf.pack();
		jf.setVisible(true);
	}
	public JLabel getJl() { return jl; }
	
	public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
									UsoDeAcciones2 u = new UsoDeAcciones2();
                }
            });    
	}
}
