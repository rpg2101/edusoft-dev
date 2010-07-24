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
public class Doceavo extends Pieza {

    public Doceavo(int x0, int y0, int elipse, int aini, Lienzo l){
        super(x0,y0,elipse,aini,l);
        setColor(Color.GREEN);
        setAngfinal(30);
    }

    @Override
    public Rectangle rect() {
        return new Rectangle(getX(),getY(),getTamelipse(),getTamelipse());
    }


}
