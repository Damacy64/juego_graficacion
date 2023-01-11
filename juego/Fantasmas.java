package juego;

import java.awt.Graphics;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

/**
 *
 * @author pzx64
 */
public class Fantasmas {
    public static int xFantasma1 = 600, yFantasma1 = 700;
    public static int xFantasma2 = 700, yFantasma2 = 100;
    public static int xFantasma3 = -20, yFantasma3 = 600;
    public static int xFantasma4 = 300, yFantasma4 = -20;
    
    public static int puntos = 0;
    public Juego j;
    public static int nivel = 1;
    int incremento = 2;
    
    Area f1, f2, f3, f4, fantasmaArea;
    
    int inicioY = 0;
    int inicioX = 0;
    int finX = 700;
    int finY = 700;
    
    public Fantasmas(Juego j){
        this.j = j;
    }
    
    public void paint(Graphics g){
        ImageIcon fantasma = new ImageIcon(getClass().getResource("../imagenes/fantasma.png"));
        
        if(nivel >= 1){
            g.drawImage(fantasma.getImage(), xFantasma1, yFantasma1, 48, 48, null);
        }
        
        if(nivel >= 2){
            g.drawImage(fantasma.getImage(), xFantasma2, yFantasma2, 48, 48, null);
        }
        
        if(nivel >= 3){
            g.drawImage(fantasma.getImage(), xFantasma3, yFantasma3, 48, 48, null);
        }
        
        if(nivel >= 4){
            g.drawImage(fantasma.getImage(), xFantasma4, yFantasma4, 48, 48, null);
        }
    }
    
    public boolean colision(){
        Area areaPersonaje = new Area(j.feid.getBoundsPersonaje());
        areaPersonaje.intersect(getBoundsFantasma());
        return !areaPersonaje.isEmpty();
    }
    
    public void mover(){
        
        if(colision()){
            j.haColisionado = true;
        }
        
        if(j.feid.llegaDisco()){
            nivel++;
            Feid.x = 10;
            Feid.y = 10;
        }
        
        if(nivel >= 1){
            if(yFantasma1 == -20){
                yFantasma1 = 700;
                xFantasma1 = (int) (Math.random()*(finX-inicioX)+inicioX);
                puntos++;
            }else{
                yFantasma1 = yFantasma1-incremento;
            }
        }
        
        if(nivel >= 2){
            if(xFantasma2 == -20){
                xFantasma2 = 700;
                yFantasma2 = (int) (Math.random()*(finY-inicioY)+inicioY);
                puntos++;
            }else{
                xFantasma2 = xFantasma2-incremento;
            }
        }
        
        if(nivel >= 3){
            if(xFantasma3 == 700){
                xFantasma3 = -20;
                yFantasma3 = (int) (Math.random()*(finY-inicioY)+inicioY);
                puntos++;
            }else{
                xFantasma3 = xFantasma3+incremento;
            }
        }
        
        if(nivel >= 4){
            if(xFantasma4 == 700){
                yFantasma4 = -20;
                xFantasma4 = (int) (Math.random()*(finX-inicioX)+inicioX);
                puntos++;
            }else{
                yFantasma4 = yFantasma4+incremento;
            }
        }
    }
    
    public int obtenerPuntos(){
        return puntos;
    }
    
    public Area getBoundsFantasma(){
        Ellipse2D fantasma1, fantasma2, fantasma3, fantasma4;
        
        fantasma4 = new Ellipse2D.Double(xFantasma1,yFantasma1,48,48);
        f4 = new Area(fantasma4);
        fantasmaArea = f4;
        
        if(nivel >= 1){
            fantasma1 = new Ellipse2D.Double(xFantasma1,yFantasma1,48,48);
            f1 = new Area(fantasma1);
            fantasmaArea.add(f1);
        }
        
        if(nivel >= 2){
            fantasma2 = new Ellipse2D.Double(xFantasma2,yFantasma2,48,48);
            f2 = new Area(fantasma2);
            fantasmaArea.add(f2);
        }
        
        if(nivel >= 3){
            fantasma3 = new Ellipse2D.Double(xFantasma3,yFantasma3,48,48);
            f3 = new Area(fantasma3);
            fantasmaArea.add(f3);
        }
        
        if(nivel >= 4){
            fantasma4 = new Ellipse2D.Double(xFantasma4,yFantasma4,48,48);
            f4 = new Area(fantasma4);
            fantasmaArea.add(f4);
        }
        
        return fantasmaArea;
    }
}
