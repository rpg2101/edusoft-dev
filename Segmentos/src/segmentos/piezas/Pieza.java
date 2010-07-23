/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package segmentos.piezas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import segmentos.Lienzo;

/**
 *
 * @author Hector Rattis
 */
public abstract class Pieza implements MouseInputListener{
    private int x, y, last_x, last_y;
    private int tamelipse, anginicial, angfinal;
    private Color color;
    private BasicStroke ancholinea;
    private Lienzo lienzo;
    private boolean pressout;
    
    public Pieza(int x0, int y0, int elipse, int aini, Lienzo l){
        pressout = true;
        x = x0;
        y = y0;
        tamelipse = elipse;
        anginicial = aini;
        lienzo = l;
        ancholinea = new BasicStroke(2.0f,BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER);
    }


    /*
     * Metodo implementado por cada pieza para pintarse
     */
    public abstract void pintarse(Graphics g);
    protected abstract Rectangle rect();


    public void mouseEntered(MouseEvent me) {}
    public void mouseExited(MouseEvent me) {}
    public void mouseClicked(MouseEvent me) {}

    public void mousePressed(MouseEvent me) {

    }

    public void mouseReleased(MouseEvent me) {

    }

    public void mouseDragged(MouseEvent me) {

    }

    public void mouseMoved(MouseEvent me) {

    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the tamelipse
     */
    public int getTamelipse() {
        return tamelipse;
    }

    /**
     * @return the anginicial
     */
    public int getAnginicial() {
        return anginicial;
    }

    /**
     * @return the angfinal
     */
    public int getAngfinal() {
        return angfinal;
    }

    /**
     * @return the ancholinea
     */
    public BasicStroke getAncholinea() {
        return ancholinea;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param angfinal the angfinal to set
     */
    public void setAngfinal(int angfinal) {
        this.angfinal = angfinal;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

}
