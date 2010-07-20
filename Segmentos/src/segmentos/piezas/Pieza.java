/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package segmentos.piezas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;
import segmentos.Lienzo;

/**
 *
 * @author Hector Rattis
 */
public abstract class Pieza {
    private int x;
    private int y;
    private int tamelipse;
    private int anginicial;
    private int angfinal;
    private Color color;
    private BasicStroke ancholinea;
    private Lienzo lienzo;
    
    public Pieza(int x0, int y0, int elipse, int aini, Lienzo l){
        x = x0;
        y = y0;
        tamelipse = elipse;
        anginicial = aini;
        lienzo = l;
        ancholinea = new BasicStroke(2.0f,BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER);
    }

    public Pieza(int x0, int y0, int elipse, Lienzo l){
        x = x0;
        y = y0;
        tamelipse = elipse;
        anginicial = 90;
        lienzo = l;
        ancholinea = new BasicStroke(2.0f,BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER);
    }

    /*
     * Metodo implementado por cada pieza para pintarse
     */
    public abstract void pintarse(Graphics g);
    
    /*
     * Metodo que cambia la posicion de una pieza
     */
    protected void moverse(int posx, int posy){
        x = posx; y = posy;
        lienzo.repaint();
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

}
