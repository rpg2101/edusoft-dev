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
public class Octavo extends Pieza {

    public Octavo(int x0, int y0, int elipse, int ainicial,Lienzo l){
        super(x0,y0,elipse,ainicial,l);
        setColor(Color.CYAN);
        setAngfinal(45);
    }


    @Override
    public Rectangle rect() {
        return new Rectangle(getX(),getY(),getTamelipse(),getTamelipse());
    }


}
