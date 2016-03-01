import javax.swing.*;
import java.awt.*;

public class CuatroImagenes {
	private JFrame jf;

	public CuatroImagenes() {
		/*
		 * Container
		 */
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		JFrame.setDefaultLookAndFeelDecorated(true);
		jf = new JFrame("Visor de imágenes");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new GridLayout(2, 2, 5, 5));
		JMenuBar jmb = new JMenuBar();
		JMenu file = new JMenu("Archivo");
		JMenuItem quit = new JMenuItem("Salir");
		file.add(quit);
		jmb.add(file);
		jf.setJMenuBar(jmb);
		/*
		 * Componentes
		 */
		JLabel[] listOfLabels = new JLabel[4];
		ImageIcon[] listOfImages = new ImageIcon[4];
		for (int i = 0; i < listOfLabels.length; i++) {
			String pathToImage = "img/0" + i + ".jpg";
			try {
				listOfImages[i] = new ImageIcon(ClassLoader
						.getSystemResource(pathToImage));
				JLabel jl = new JLabel(listOfImages[i]);
				jf.getContentPane().add(jl);
			} catch (Exception e) {
				errMess(pathToImage, "No fue posible cargar este archivo:");
			}
		}
		jf.pack();
		jf.setVisible(true);
	}

	private void errMess(String message, String title) {
		JOptionPane.showMessageDialog(jf, message, title,
				JOptionPane.ERROR_MESSAGE);
	}

	public static void main(String[] args) {
		CuatroImagenes ci = new CuatroImagenes();
	}
}
