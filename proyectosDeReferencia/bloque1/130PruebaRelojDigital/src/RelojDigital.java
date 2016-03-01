/*
 * RelojDigital.java
 *
 * Created on May 10, 2007, 6:22 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author coti
 */
public class RelojDigital extends JPanel implements ActionListener {

    private SimpleDateFormat sdf;
    private Calendar cal;
    private TimeZone husoHorario;
    private final String FORMATO = "HH:mm:ss";
    private int tamFuente = 9;
    private Font f = null;
    private FontMetrics fm = null;
    private String hora = null;
    private int anchoCadenaHora = 0;
    private int altoCadenaHora = 0;
    private int anchuraPanel = 0;
    private int alturaPanel = 0;

    public RelojDigital() {
        husoHorario = TimeZone.getDefault();
        sdf = new SimpleDateFormat(FORMATO);
        sdf.setTimeZone(husoHorario);
        cal = Calendar.getInstance(husoHorario);
        f = new Font("monospaced", Font.PLAIN, tamFuente);
        Timer t = new Timer(1000, this);
        t.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        hora = sdf.format(cal.getTime());
        g.setFont(f);
        fm = g.getFontMetrics(f);
        anchoCadenaHora = fm.stringWidth(hora);
        altoCadenaHora = fm.getAscent();
        anchuraPanel = this.getBounds().width;
        alturaPanel = this.getBounds().height;
        if (Math.abs(anchoCadenaHora - anchuraPanel) > 15) {
            if (anchoCadenaHora < anchuraPanel) {
                tamFuente++;
            } else {
                tamFuente--;
            }
            f = new Font("monospaced", Font.PLAIN, tamFuente);
            g.setFont(f);
            fm = g.getFontMetrics(f);
        }
        g.drawString(hora,
                (anchuraPanel - anchoCadenaHora) / 2,
                alturaPanel / 2 + altoCadenaHora / 2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        cal = Calendar.getInstance(husoHorario);
        this.repaint();
    }
}
