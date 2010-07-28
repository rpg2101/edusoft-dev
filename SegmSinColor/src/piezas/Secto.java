/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package piezas;

import java.awt.Color;
import java.awt.Rectangle;
import segmsincolor.Lienzo;

/**
 *
 * @author curio
 */
public class Secto extends Pieza {

    public Secto(int x0, int y0, int aini, Lienzo l) {
        super(x0, y0, aini, l);
        setAngfinal(60);
        setColor(Color.BLUE);
    }

    @Override
    public Rectangle segArrastre() {
        Rectangle tmp = null;
        int tam_W = getTamelipse() * 1 / 4;
        int tam_H = getTamelipse() * 1 / 4;
        switch (this.getAnginicial()) {
            case 90:
                tmp = new Rectangle(getX() + 47, getY() + 17, tam_W, tam_H);
                break;
            case 150:
                tmp = new Rectangle(getX() + 5, getY() + 75, tam_W, tam_H);
                break;
            case 210:
                tmp = new Rectangle(getX() + 47, getY() + 133, tam_W, tam_H);
                break;
            case 270:
                tmp = new Rectangle(getX() + 103, getY() + 133, tam_W, tam_H);
                break;
            case 330:
                tmp = new Rectangle(getX() + 145, getY() + 75, tam_W, tam_H);
                break;
            case 390:
                tmp = new Rectangle(getX() + 103, getY() + 17, tam_W, tam_H);
                break;
        }
        return tmp;
    }
}
