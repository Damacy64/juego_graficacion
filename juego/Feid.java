package juego;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

/**
 *
 * @author pzx64
 */
public class Feid {
    public static int x=10, y=10;
    
    public void paint(Graphics g){
        ImageIcon disco = new ImageIcon(getClass().getResource("../imagenes/disco.png"));
        g.drawImage(disco.getImage(), 500, 500, 150, 150, null);
        
        ImageIcon personaje = new ImageIcon(getClass().getResource("../imagenes/feidD.png"));
        g.drawImage(personaje.getImage(), x, y, 100, 100, null);
    }
    
    public void KeyPressed(KeyEvent e){
        if(e.getKeyCode() == 37){
            if(x>0){
                x=x-20;
            }
        }
        
        if(e.getKeyCode() == 39){
            if(x<580){
                x=x+20;
            }
        }
        
        if(e.getKeyCode() == 38){
            if(y>0){
                y=y-20;
            }
        }
        if(e.getKeyCode() == 40){
            if(y<580){
                y=y+20;
            }
        }
    }
    
    public Ellipse2D getBoundsPersonaje(){
        return new Ellipse2D.Double(x+10,y+30,80,50);
    }
    
    public boolean llegaDisco(){
        Rectangle cuadrado = new Rectangle(520,520,110,110);
        Area cuadradoArea = new Area(cuadrado);
        return cuadradoArea.contains(getBoundsPersonaje().getBounds());
    }
}
