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

    public Secto(int x0, int y0, int elipse, int aini, Lienzo l){
        super(x0,y0,elipse,aini,l);
        setAngfinal(60);
        setColor(Color.BLUE);
    }

    @Override
    public Rectangle rect() {
        return new Rectangle(getX(),getY(),getTamelipse(),getTamelipse());
    }


}
