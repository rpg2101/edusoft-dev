/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package equivalencia.piezas;

import java.awt.Color;
import java.awt.Rectangle;
import equivalencia.Lienzo;

/**
 *
 * @author curio
 */
public class Octavo extends Pieza {

    public Octavo(int x0, int y0, int ainicial, Lienzo l) {
        super(x0, y0, ainicial, l);
        setColor(Color.CYAN);
        setAngfinal(45);
    }

    @Override
    public Rectangle segArrastre() {
        Rectangle tmp = null;
        int tam_W = getTamelipse() * 1 / 5;
        int tam_H = getTamelipse() * 1 / 5;
        switch (this.getAnginicial()) {
            case 90:
                tmp = new Rectangle(getX() + 40, getY() + 10, tam_W + 2, tam_H);
                break;
            case 135:
                tmp = new Rectangle(getX() + 10, getY() + 42, tam_W + 3, tam_H);
                break;

            case 180:
                tmp = new Rectangle(getX() + 10, getY() + 78, tam_W + 3, tam_H);
                break;

            case 225:
                tmp = new Rectangle(getX() + 40, getY() + 110, tam_W + 2, tam_H);
                break;

            case 270:
                tmp = new Rectangle(getX() + 78, getY() + 110, tam_W + 2, tam_H);
                break;

            case 315:
                tmp = new Rectangle(getX() + 110, getY() + 78, tam_W + 3, tam_H);
                break;

            case 360:
                tmp = new Rectangle(getX() + 110, getY() + 42, tam_W + 3, tam_H);
                break;
            case 405:
                tmp = new Rectangle(getX() + 78, getY() + 10, tam_W + 2, tam_H);
                break;
        }
        return tmp;
    }
}
