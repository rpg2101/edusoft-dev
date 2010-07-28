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
                tmp = new Rectangle(getX() + 65, getY() + 7, tam_W, tam_H);
                break;
            case 120:
                tmp = new Rectangle(getX() + 30, getY() + 30, tam_W, tam_H);
                break;
            case 150:
                tmp = new Rectangle(getX() + 7, getY() + 65, tam_W, tam_H);
                break;
            case 180:
                tmp = new Rectangle(getX() + 7, getY() + 102, tam_W, tam_H);
                break;
            case 210:
                tmp = new Rectangle(getX() + 30, getY() + 137, tam_W, tam_H);
                break;
            case 240:
                tmp = new Rectangle(getX() + 65, getY() + 160, tam_W, tam_H);
                break;
            case 270:
                tmp = new Rectangle(getX() + 102, getY() + 160, tam_W, tam_H);
                break;
            case 300:
                tmp = new Rectangle(getX() + 138, getY() + 137, tam_W, tam_H);
                break;
            case 330:
                tmp = new Rectangle(getX() + 160, getY() + 102, tam_W, tam_H);
                break;
            case 360:
                tmp = new Rectangle(getX() + 160, getY() + 65, tam_W, tam_H);
                break;
            case 390:
                tmp = new Rectangle(getX() + 138, getY() + 30, tam_W, tam_H);
                break;
            case 420:
                tmp = new Rectangle(getX() + 102, getY() + 7, tam_W, tam_H);
                break;
        }
        return tmp;
    }
}
