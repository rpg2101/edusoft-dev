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
 * @author Hector Rattis
 */
public class Tercio extends Pieza {

    public Tercio(int x0, int y0, int ainicial, Lienzo l) {
        super(x0, y0, ainicial, l);
        setAngfinal(120);
        setColor(Color.ORANGE);
    }

    @Override
    public Rectangle segArrastre() {
        Rectangle tmp = null;
        int tam_W = getTamelipse() * 1 / 4;
        int tam_H = getTamelipse() * 1 / 3;
        switch (this.getAnginicial()) {
            case 90:
                tmp = new Rectangle(getX() + 15, getY() + 30, tam_W + 20,
                        tam_H);
                break;
            case 210:
                tmp = new Rectangle(getX() + 35, getY() + 100, tam_H + 30,
                        tam_W);
                break;
            case 330:
                tmp = new Rectangle(getX() + 78, getY() + 30, tam_W + 20,
                        tam_H);
                break;
        }
        return tmp;
    }
}
