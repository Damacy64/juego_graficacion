package juego;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author pzx64
 */
public class Fantasma {

    int x, y;
    JPanel miJP;
    Graphics g;
    String Direccion;

    public Fantasma(JPanel miJP) {
        super();
        this.miJP = miJP;
        this.g = miJP.getGraphics();
    }

    public void dibuja_fantasma(Graphics g, int x, int y, String Direccion) {
        this.x = x;
        this.y = y;
        this.miJP.update(g);
        this.Direccion = Direccion;
        ImageIcon MImagen = new ImageIcon(Direccion);
        g.drawImage(MImagen.getImage(), x, y, miJP);
    }

    public int CordX() {
        return this.x;
    }

    public int CordY() {
        return this.y;
    }

    public String Direction() {
        return this.Direccion;
    }

}
