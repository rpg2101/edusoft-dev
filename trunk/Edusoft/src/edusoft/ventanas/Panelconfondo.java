/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edusoft.ventanas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panelconfondo extends JPanel {
    private Image imagen;
    public Panelconfondo(String nombreImagen) {
        if (nombreImagen != null) {
            imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
            
        }
    }
    public void paint(Graphics g) {
           g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
           setOpaque(false);
	   super.paint(g);
    }
}

