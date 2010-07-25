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
        Rectangle tmp=null;
        switch (this.getAnginicial()){
            case 90: tmp = new Rectangle(getX(),getY(),getTamelipse()/2,
                    getTamelipse());break; 
            case 270: tmp = new Rectangle(getX()+getTamelipse()/2,getY(),
                    getTamelipse()/2,getTamelipse());break;
        }
        return tmp;
    }

}
