/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package piezas;

import java.awt.Color;
import java.awt.Rectangle;
import segmcolor.Lienzo;

/**
 *
 * @author curio
 */
public class Cuarto extends Pieza {

    public Cuarto(int x0, int y0, int elipse, int ainicial, Lienzo l) {
        super(x0, y0, elipse, ainicial, l);
        setColor(Color.RED);
        setAngfinal(90);
    }

    @Override
    public Rectangle rect() {
        return new Rectangle(getX(),getY(),getTamelipse(),getTamelipse());
    }
}
