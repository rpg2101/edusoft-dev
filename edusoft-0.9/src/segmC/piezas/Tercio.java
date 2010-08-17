/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segmC.piezas;

import java.awt.Color;
import java.awt.Rectangle;
import segmcolor.Lienzo;

/**
 *
 * @author curio
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
                tmp = new Rectangle(getX() + 20, getY() + 40, tam_W + 25,
                        tam_H + 5);
                break;
            case 210:
                tmp = new Rectangle(getX() + 55, getY() + 130, tam_H + 25,
                        tam_W + 5);
                break;
            case 330:
                tmp = new Rectangle(getX() + 105, getY() + 40, tam_W + 25,
                        tam_H + 5);
                break;
        }
        return tmp;
    }
}
