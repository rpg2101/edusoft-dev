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

    public Octavo(int x0, int y0, int ainicial, Lienzo l) {
        super(x0, y0, ainicial, l);
        setColor(Color.CYAN);
        setAngfinal(45);
    }

    @Override
    public Rectangle rect() {
        Rectangle tmp = null;
        int tam_W = getTamelipse() * 1 / 5;
        int tam_H = getTamelipse() * 1 / 5;
        switch (this.getAnginicial()) {
            case 90:
                tmp = new Rectangle(getX() + 55, getY() + 12, tam_W + 2, tam_H);
                break;
            case 135:
                tmp = new Rectangle(getX() + 12, getY() + 57, tam_W + 3, tam_H);
                break;

            case 180:
                tmp = new Rectangle(getX() + 12, getY() + 103, tam_W + 3, tam_H);
                break;

            case 225:
                tmp = new Rectangle(getX() + 55, getY() + 147, tam_W + 2, tam_H);
                break;

            case 270:
                tmp = new Rectangle(getX() + 103, getY() + 147, tam_W + 2, tam_H);
                break;

            case 315:
                tmp = new Rectangle(getX() + 145, getY() + 103, tam_W + 3, tam_H);
                break;

            case 360:
                tmp = new Rectangle(getX() + 145, getY() + 57, tam_W + 3, tam_H);
                break;
            case 405:
                tmp = new Rectangle(getX() + 103, getY() + 12, tam_W + 2, tam_H);
                break;
        }
        return tmp;
    }
}
