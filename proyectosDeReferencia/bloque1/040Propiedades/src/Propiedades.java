
import java.util.Properties;
import java.io.*;

public class Propiedades {

    private Properties props = null;

    public Propiedades() {
        Properties porDefecto = new Properties();
        porDefecto.setProperty("numfilas", "10");
        porDefecto.setProperty("numcolumnas", "3");
        props = new Properties(porDefecto);
    }

    public Properties getProps() {
        return props;
    }

    public static void main(String[] args) {
        Propiedades x = new Propiedades();
        FileOutputStream fos = null;
        FileInputStream fis = null;
        File ruta = new File("props.xml");
        Properties acceso = x.getProps();
        System.out.println("\nValores predeterminados:\n");
        acceso.list(System.out);
        acceso.setProperty("numfilas", "44");
        acceso.setProperty("numcolumnas", "55");
        System.out.println("\nPrimer conjunto de propiedades\n");
        acceso.list(System.out);
        System.out.println("\nLas propiedades se han guardado en disco\n");
        try {
            fos = new FileOutputStream(ruta);
            acceso.storeToXML(fos, "Listado de Propiedades");
            fos.close();
        } catch (Exception e) {
            System.out.println("Error al guardar las propiedades.");
        }
        acceso.setProperty("numfilas", "-327");
        acceso.setProperty("numcolumnas", "-428");
        System.out.println("Segundo conjunto de propiedades\n");
        acceso.list(System.out);
        System.out.printf("\nSe vuelve a leer el primer conjunto\n");

        //acceso.clear();
        try {
            fis = new FileInputStream(ruta);
            acceso.loadFromXML(fis);
            fis.close();
        } catch (Exception e) {
            System.out.println("Error al cargar las propiedades");
        }
        System.out.println("\nListado de propiedades en XML\n");
        acceso.list(System.out);
    }
}
