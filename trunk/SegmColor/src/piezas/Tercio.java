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
public class Tercio extends Pieza {

    public Tercio(int x0, int y0, int elipse, int ainicial, Lienzo l) {
        super(x0, y0, elipse, ainicial, l);
        setAngfinal(120);
        setColor(Color.ORANGE);
    }

    @Override
    public Rectangle rect() {
        Rectangle tmp = null;
        int tam_W = getTamelipse() * 1 / 4 + 15;
        int tam_H = getTamelipse() * 1 / 3 + 5;
        switch (this.getAnginicial()) {
            case 90:
                tmp = new Rectangle(getX() + 20, getY() + 20, tam_W, tam_H);
                break;
            case 210:
                tmp = new Rectangle(getX() + 35, getY() + 100, tam_H + 25,
                        tam_W - 10);
                break;
            case 330:
                tmp = new Rectangle(getX() + 75, getY() + 20, tam_W, tam_H);
                break;
        }
        return tmp;
    }
}
