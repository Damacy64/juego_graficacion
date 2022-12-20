package juego;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author pzx64
 */
public class Salto extends Thread {

    int x, y;
    Feid Feid;
    JPanel miJP;
    Graphics g;
    String direc;

    public Salto(JPanel miJ, int xi, int yi, Feid FJ) {
        super();
        this.g = miJ.getGraphics();
        this.miJP = miJ;
        this.x = xi;
        this.y = yi;
        this.Feid = FJ;
        this.direc = FJ.Direction();

    }

    @Override
    public void run() {
        int i = 0;
        int z;
        z = this.y;
        while (true) {
            while (i <= 8) {

                try {

                    this.y = z + 3 * i * i - 24 * i;
                    this.miJP.update(g);
                    Feid.Dibuja_feid(g, this.x, this.y, this.direc);

                    Salto.sleep(50);
                    i = i + 1;

                } catch (InterruptedException ex) {
                    Logger.getLogger(Salto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
