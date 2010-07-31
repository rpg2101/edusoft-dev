/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segmsincolor;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

/**
 *
 * @author curio
 */
class Trofeo {

    private String name;
    private int x, y, tam;
    private Image img;

    public Trofeo(int x0, int y0, int t, String i) {
        x = x0;
        y = y0;
        tam = t;
        img = new ImageIcon(getClass().getResource(i)).getImage();
    }

    public void pintarse(Graphics g, Lienzo l) {
        g.drawImage(img, x, y, tam, tam,l);
    }
}
