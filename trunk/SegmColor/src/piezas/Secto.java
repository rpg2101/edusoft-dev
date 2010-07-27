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
public class Secto extends Pieza {

    public Secto(int x0, int y0, int elipse, int aini, Lienzo l) {
        super(x0, y0, elipse, aini, l);
        setAngfinal(60);
        setColor(Color.BLUE);
    }

    @Override
    public Rectangle rect() {
        Rectangle tmp = null;
        int tam_W = getTamelipse() * 1 / 3;
        int tam_H = getTamelipse() * 1 / 3;
        switch (this.getAnginicial()) {
            case 90:
                tmp = new Rectangle(getX() + 35, getY() + 5, tam_W - 15,
                        tam_H - 5);
                break;
            case 150:
                tmp = new Rectangle(getX(), getY() + 50, tam_W - 15, tam_H - 5);
                break;
            case 210:
                tmp = new Rectangle(getX() + 35, getY() + 100, tam_W - 15,
                        tam_H - 5);
                break;
            case 270:
                tmp = new Rectangle(getX() + 80, getY() + 100, tam_W - 15,
                        tam_H - 5);
                break;
            case 330:
                tmp = new Rectangle(getX() + 115, getY() + 50, tam_W - 15,
                        tam_H - 5);
                break;
            case 390:
                tmp = new Rectangle(getX() + 80, getY() + 5, tam_W - 15,
                        tam_H - 5);
                break;
        }
        return tmp;
    }
}
