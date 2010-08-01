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

    public Cuarto(int x0, int y0, int ainicial, Lienzo l) {
        super(x0, y0, ainicial, l);
        setColor(Color.RED);
        setAngfinal(90);
    }

    @Override
    public Rectangle segArrastre() {
        Rectangle tmp = null;
        int tam_W = getTamelipse() * 1 / 3;
        int tam_H = getTamelipse() * 1 / 3;
        switch (this.getAnginicial()) {
            case 90:
                tmp = new Rectangle(getX() + 20, getY() + 20, tam_W, tam_H);
                break;
            case 180:
                tmp = new Rectangle(getX() + 20, getY() + 80, tam_W, tam_H);
                break;
            case 270:
                tmp = new Rectangle(getX() + 80, getY() + 80, tam_W, tam_H);
                break;
            case 360:
                tmp = new Rectangle(getX() + 80, getY() + 20, tam_W, tam_H);
                break;
        }
        return tmp;
    }
}
