package juego;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author pzx64
 */
public class Fantasma extends Thread {

    int x, y;
    int Ancho_fantasma;
    int Alto_fantasma;
    JPanel miJP;
    Graphics g;
    ProyectoJuego FeidG;

    public Fantasma(JPanel miJ, int xi, int yi, ProyectoJuego FJ) {
        this.g = miJ.getGraphics();
        this.miJP = miJ;
        this.x = xi;
        this.y = yi;
        this.FeidG = FJ;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            while (i < miJP.getWidth() - 30) {
                try {
                    i = i + 10;
                    this.x = i;
                    this.FeidG.Dibuja_feid(g, this.FeidG.x, this.FeidG.y, this.FeidG.Dir);
                    ImageIcon MImagen = new ImageIcon("C:\\Users\\EQUIPO\\Documents\\NetBeansProjects\\Graficacion\\src\\ProyectoJuego\\fantasmas.png");
                    this.g.drawImage(MImagen.getImage(), this.x, this.y, this.miJP);
                    Alto_fantasma = MImagen.getIconHeight();
                    Ancho_fantasma = MImagen.getIconWidth();
                    Fantasma.sleep(50);
                    this.miJP.update(g);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Fantasma.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            while (i > 0) {
                try {
                    i = i - 10;
                    this.FeidG.Dibuja_feid(g, this.FeidG.x, this.FeidG.y, this.FeidG.Dir);
                    ImageIcon MImagen = new ImageIcon("C:\\Users\\EQUIPO\\Documents\\NetBeansProjects\\Graficacion\\src\\ProyectoJuego\\fantasmaL.png");
                    this.g.drawImage(MImagen.getImage(), i, this.y, this.miJP);
                    Fantasma.sleep(50);
                    this.miJP.update(g);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Fantasma.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }
}
