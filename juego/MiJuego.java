/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author pzx64
 */
public class MiJuego extends javax.swing.JFrame {

    ProyectoJuego feid;
    FondoPanel fondo = new FondoPanel();

    /**
     * Creates new form MiJuego
     */
    public MiJuego() {
        this.setContentPane(fondo);
        initComponents();
        feid = new ProyectoJuego(jPanel1);
        feid.Dir = "C:\\Users\\EQUIPO\\Documents\\NetBeansProjects\\Graficacion\\src\\ProyectoJuego\\feidD.png";
        //Fantasma MFantasma = new Fantasma(jPanel1, 0, 200, Feid);
        //MFantasma.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        int x, y;
        x = feid.CordX();
        y = feid.CordY();
        String Direc = "";
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                x = x - 10;
                Direc = "C:\\Users\\pzx64\\OneDrive\\Documentos\\NetBeansProjects\\ProyectoJuego\\src\\imagenes\\feidL.png";
                feid.x = x;
                feid.Dir = Direc;
                break;

            case KeyEvent.VK_RIGHT:
                x = x + 10;
                Direc = "C:\\Users\\pzx64\\OneDrive\\Documentos\\NetBeansProjects\\ProyectoJuego\\src\\imagenes\\feidD.png";
                feid.x = x;
                feid.Dir = Direc;
                break;

            case KeyEvent.VK_UP:
                y = y - 10;
                Direc = "C:\\Users\\pzx64\\OneDrive\\Documentos\\NetBeansProjects\\ProyectoJuego\\src\\imagenes\\feidA.png";
                feid.y = y;
                feid.Dir = Direc;
                break;

            case KeyEvent.VK_DOWN:
                y = y + 10;
                Direc = "C:\\Users\\pzx64\\OneDrive\\Documentos\\NetBeansProjects\\ProyectoJuego\\src\\imagenes\\feidA.png";
                feid.y = y;
                feid.Dir = Direc;
                break;

            case KeyEvent.VK_S:
                Salto MiSalto = new Salto(jPanel1, x, y, feid);
                MiSalto.start();
                break;
            case KeyEvent.VK_W:
                break;
        }
        feid.Dibuja_feid(jPanel1.getGraphics(), x, y, Direc);
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MiJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MiJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/fondoR.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
