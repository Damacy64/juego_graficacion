package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author pzx64
 */
public class Juego extends JPanel{

    public static boolean haColisionado = false;
    Fantasmas fantasma = new Fantasmas(this);
    Feid feid = new Feid();

    public Juego(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                feid.KeyPressed(ke);
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });
        
        setFocusable(true);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        ImageIcon fondo = new ImageIcon(getClass().getResource("../imagenes/fondo.png"));
        g.drawImage(fondo.getImage(), 0, 0, getWidth(),getHeight(),this);
        
        Font score = new Font("Arial", Font.BOLD, 25);
        g.setFont(score);
        g.setColor(Color.BLUE);
        g.drawString("Puntaje: " + fantasma.obtenerPuntos(), 520, 50);
        
        feid.paint(g);
        
        fantasma.paint(g);
        fantasma.mover();
        
        g.dispose();
    }
    
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Mi juego");
        Juego juego = new Juego();
        ventana.add(juego);
        ventana.setSize(700, 700);
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true){
            if(haColisionado | Fantasmas.nivel == 5){
                if(Fantasmas.nivel == 5){JOptionPane.showMessageDialog(null, "Ganaste");}
                    int reiniciaJuego = JOptionPane.showConfirmDialog(null, "Haz perdido, "
                    + "¿Quieres reiniciar el juego?", "Perdiste", JOptionPane.YES_NO_OPTION);
                    if(reiniciaJuego == 0){
                        reiniciaValores();
                    } else if(reiniciaJuego == 1){
                        System.exit(0);
                    }
            }
            
            try{
                Thread.sleep(10);
            } catch(InterruptedException ex){
                System.out.println(ex.toString());
            }
            
            juego.repaint();
        }
    }
    
    public static void reiniciaValores(){
        Fantasmas.xFantasma1 = 600;
        Fantasmas.yFantasma1 = 700;
        Fantasmas.xFantasma2 = 700;
        Fantasmas.yFantasma2 = 100;
        Fantasmas.xFantasma3 = -20;
        Fantasmas.yFantasma3 = 600;
        Fantasmas.xFantasma4 = 300;
        Fantasmas.yFantasma4 = -20;
        Feid.x = 10;
        Feid.y = 10;
        Fantasmas.nivel = 1;
        haColisionado = false;
        Fantasmas.puntos = 0;
    }

    
}
