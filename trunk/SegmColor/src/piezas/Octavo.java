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
public class Octavo extends Pieza {

    public Octavo(int x0, int y0, int elipse, int ainicial, Lienzo l) {
        super(x0, y0, elipse, ainicial, l);
        setColor(Color.CYAN);
        setAngfinal(45);
    }

    @Override
    public Rectangle rect() {
        Rectangle tmp = null;
        int tam_W = getTamelipse() * 1 / 4;
        int tam_H = getTamelipse() * 1 / 3;
        switch (this.getAnginicial()) {
            case 90:
                tmp = new Rectangle(getX() + 40, getY() + 10, tam_W - 5,
                        tam_H - 20);
                break;
            case 135:
                tmp = new Rectangle(getX() + 7, getY() + 40, tam_W - 5,
                        tam_H - 18);
                break;

            case 180:
                tmp = new Rectangle(getX() + 7, getY() + 78, tam_W - 5,
                        tam_H - 18);
                break;

            case 225:
                tmp = new Rectangle(getX() + 40, getY() + 110, tam_W - 5,
                        tam_H - 20);
                break;

            case 270:
                tmp = new Rectangle(getX() + 78, getY() + 110, tam_W - 5,
                        tam_H - 20);
                break;

            case 315:
                tmp = new Rectangle(getX() + 110, getY() + 78, tam_W - 5,
                        tam_H - 18);
                break;

            case 360:
                tmp = new Rectangle(getX() + 110, getY() + 40, tam_W - 5,
                        tam_H - 18);
                break;
            case 405:
                tmp = new Rectangle(getX() + 78, getY() + 10, tam_W - 5,
                        tam_H - 20);
                break;
        }
        return tmp;
    }
}
