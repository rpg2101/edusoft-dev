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
public class Doceavo extends Pieza {

    public Doceavo(int x0, int y0, int aini, Lienzo l) {
        super(x0, y0, aini, l);
        setColor(Color.GREEN);
        setAngfinal(30);
    }

    @Override
    public Rectangle segArrastre() {
        Rectangle tmp = null;
        int tam_W = getTamelipse() * 1 / 6;
        int tam_H = getTamelipse() * 1 / 6;
        switch (this.getAnginicial()) {
            case 90:
                tmp = new Rectangle(getX() + 48, getY() + 5, tam_W, tam_H);
                break;
            case 120:
                tmp = new Rectangle(getX() + 22, getY() + 22, tam_W, tam_H);
                break;
            case 150:
                tmp = new Rectangle(getX() + 5, getY() + 47, tam_W, tam_H);
                break;
            case 180:
                tmp = new Rectangle(getX() + 5, getY() + 78, tam_W, tam_H);
                break;
            case 210:
                tmp = new Rectangle(getX() + 22, getY() + 102, tam_W, tam_H);
                break;
            case 240:
                tmp = new Rectangle(getX() + 48, getY() + 120, tam_W, tam_H);
                break;
            case 270:
                tmp = new Rectangle(getX() + 77, getY() + 120, tam_W, tam_H);
                break;
            case 300:
                tmp = new Rectangle(getX() + 102, getY() + 102, tam_W, tam_H);
                break;
            case 330:
                tmp = new Rectangle(getX() + 120, getY() + 78, tam_W, tam_H);
                break;
            case 360:
                tmp = new Rectangle(getX() + 120, getY() + 47, tam_W, tam_H);
                break;
            case 390:
                tmp = new Rectangle(getX() + 102, getY() + 22, tam_W, tam_H);
                break;
            case 420:
                tmp = new Rectangle(getX() + 77, getY() + 5, tam_W, tam_H);
                break;
        }
        return tmp;
    }
}
