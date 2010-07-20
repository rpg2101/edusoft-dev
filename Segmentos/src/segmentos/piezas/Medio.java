/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package segmentos.piezas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import segmentos.Lienzo;


/**
 *
 * @author curio
 */
public class Medio extends Pieza {

    public Medio(int x0, int y0, int elipse, int aini, int afinal, Lienzo l){
        super(x0,y0,elipse,aini,afinal,l);
    }

    @Override
    public void pintarse(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.yellow);
        g2.fill(new Arc2D.Float(getX(), getY(), getTamelipse(), getTamelipse(),
                getAnginicial(), getAngfinal(), Arc2D.PIE));
        g2.setColor(Color.black);
        g2.setStroke(this.getAncholinea());
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                     RenderingHints.VALUE_ANTIALIAS_ON));
        g2.draw(new Arc2D.Float(getX(), getY(), getTamelipse(), getTamelipse(),
                getAnginicial(), getAngfinal(), Arc2D.PIE));
        
        //g2.drawRect(getX(), getY(), getTamelipse(), getTamelipse());
    }


}
