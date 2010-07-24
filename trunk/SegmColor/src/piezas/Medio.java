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
public class Medio extends Pieza {

    public Medio(int x0, int y0, int elipse,int ainicial, Lienzo l){
        super(x0,y0,elipse,ainicial,l);
        setAngfinal(180);
        setColor(Color.YELLOW);
    }

    @Override
    public Rectangle rect() {
        return new Rectangle(getX(),getY(),getTamelipse(),getTamelipse());
    }

}
