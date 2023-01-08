package juego;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 *
 * @author pzx64
 */
public class Feid {

    int x;
    int y;
    JPanel miJP;
    String Dir;
    int Ancho;
    int Alto;

    public Feid(JPanel JP) {
        this.x = 275;
        this.y = 280;
        this.miJP = JP;
        this.Ancho = 0;
        this.Alto = 0;
    }

    public void Dibuja_feid(Graphics g, int x, int y, String Direccion) {
        this.x = x;
        this.y = y;
        this.miJP.update(g);
        this.Dir = Direccion;
        ImageIcon MImagen = new ImageIcon(Direccion);
        g.drawImage(MImagen.getImage(), x, y, miJP);
        Alto = MImagen.getIconHeight();
        Ancho = MImagen.getIconWidth();
    }

    public int CordX() {
        return this.x;
    }

    public int CordY() {
        return this.y;
    }

    public String Direction() {
        return this.Dir;
    }
}
