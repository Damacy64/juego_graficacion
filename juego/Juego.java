package juego;

import java.awt.Color;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pzx64
 */
public class Juego extends JFrame implements KeyListener{

    JPanel panel;
    JLabel feid;
    JLabel fantasma;

    public Juego() {
        setSize(800, 500);
        setTitle("Mi juego");
        setLocationRelativeTo(null);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Juego ventana = new Juego();
        ventana.setVisible(true);
    }

    private void iniciarComponentes() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(112, 240, 68));
        this.getContentPane().add(panel);
        feid = new JLabel(new ImageIcon("feidD.png"));
        feid.setBounds(0, 350, 100, 112);
        panel.add(feid);
        addKeyListener(this);
        setFocusable(true);
        fantasma = new JLabel(new ImageIcon("fantasma.png"));
        fantasma.setBounds(10, 10, 63, 70);
        panel.add(fantasma);
        //add(feid);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                feid.setLocation(feid.getX() - 10, feid.getY());
                break;
            case KeyEvent.VK_RIGHT:
                feid.setLocation(feid.getX() + 10, feid.getY());
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
