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
public class Medio extends Pieza {

    public Medio(int x0, int y0, int elipse, int ainicial, Lienzo l) {
        super(x0, y0, elipse, ainicial, l);
        setAngfinal(180);
        setColor(Color.YELLOW);
    }

    @Override
    public Rectangle rect() {
        Rectangle tmp = null;
        int tam_W = getTamelipse() / 2;
        int tam_H = getTamelipse() / 2;
        switch (this.getAnginicial()) {
            case 90:
                tmp = new Rectangle(getX() + 10, getY() + 50, tam_W - 15,
                        tam_H);
                break;
            case 270:
                tmp = new Rectangle(getX() + tam_W + 5, getY() + 50, tam_W - 15,
                        tam_H);
                break;
        }
        return tmp;
    }
}
