/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package segmentos.piezas;

import java.awt.BasicStroke;
import java.awt.Graphics;
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
    private BasicStroke ancholinea;
    private Lienzo lienzo;
    
    public Pieza(int x0, int y0, int elipse, int aini, int afinal,
            Lienzo l){
        x = x0;
        y = y0;
        tamelipse = elipse;
        anginicial = aini;
        angfinal = afinal;
        lienzo = l;
        ancholinea = new BasicStroke(2.0f,BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER);
        
    }

    protected void moverse(int posx, int posy){
        x = posx; y = posy;
        lienzo.repaint();
    }

    protected void rotar(int rotacion){
        /*anginicial = getAnginicial()+rotacion;
        angfinal = getAngfinal()+rotacion;
        lienzo.repaint();*/
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

    /*
     * Metodo implementado por cada pieza para pintarse
     */
    public abstract void pintarse(Graphics g);
    

}
