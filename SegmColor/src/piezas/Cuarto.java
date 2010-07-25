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
public class Cuarto extends Pieza {

    public Cuarto(int x0, int y0, int elipse, int ainicial, Lienzo l) {
        super(x0, y0, elipse, ainicial, l);
        setColor(Color.RED);
        setAngfinal(90);
    }

    @Override
    public Rectangle rect() {
        Rectangle tmp=null;
        switch (this.getAnginicial()){
            case 90: tmp = new Rectangle(getX(),getY(),getTamelipse()/2,
                    getTamelipse()/2);break;
            case 180: tmp = new Rectangle(getX(),getY()+getTamelipse()/2,
                    getTamelipse()/2,getTamelipse()/2);break;
            case 270: tmp = new Rectangle(getX()+getTamelipse()/2,
                    getY()+getTamelipse()/2,getTamelipse()/2,getTamelipse()/2);
                    break;
            case 360: tmp = new Rectangle(getX()+getTamelipse()/2,getY(),
                    getTamelipse()/2,getTamelipse()/2);break;
        }
        return tmp;
    }
}
