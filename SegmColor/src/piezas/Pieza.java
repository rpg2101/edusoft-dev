/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package piezas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import segmcolor.Lienzo;

/**
 *
 * @author Hector Rattis
 */
public abstract class Pieza {

    private int x, y, last_x, last_y;
    private int tamelipse, anginicial, angfinal;
    private Color color;
    private BasicStroke ancholinea;
    private Lienzo lienzo;
    private boolean pressOut;

    public Pieza(int x0, int y0, int elipse, int aini, Lienzo l) {
        pressOut = true;
        x = x0;
        y = y0;
        tamelipse = elipse;
        anginicial = aini;
        lienzo = l;
        ancholinea = new BasicStroke(2.0f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER);
    }

    /*
     * Metodo implementado por cada pieza para pintarse
     */
    public abstract Rectangle rect();

    public void pintarse(Graphics2D g2) {
        g2.setColor(this.color);
        g2.fill(new Arc2D.Float(x, y, tamelipse, tamelipse, anginicial,
                angfinal, Arc2D.PIE));
        g2.setColor(Color.black);
        g2.setStroke(this.getAncholinea());
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));
        g2.draw(new Arc2D.Float(x, y, tamelipse, tamelipse, anginicial,
                angfinal, Arc2D.PIE));
        g2.draw(this.rect());
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

    public int getAngfinal() {
    return angfinal;
    }*/
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

    public void setPressOut(boolean flag) {
        pressOut = flag;
    }

    public boolean getPressOut() {
        return pressOut;
    }

    public void setLastPosicion(int x0, int y0) {
        last_x = x0;
        last_y = y0;
    }

    public void setPosicion(int x0, int y0) {
        x = x0;
        y = y0;
    }

    public void actulizaPosicion(MouseEvent me) {
        this.setPosicion(last_x + me.getX(), last_y + me.getY());
        checkArea();
        lienzo.repaint();
    }

    /**
     * Este metodo verifica que la figura no abandone el area de la ventana
     * aunque el mouse si lo haga.
     */
    private void checkArea() {
        Rectangle area = new Rectangle(lienzo.getSize());
        int new_x = this.x;
        int new_y = this.y;
        if ((x + tamelipse) > area.getWidth()) {
            new_x = (int) area.getWidth() - tamelipse - 1;
        }
        if (x < 0) {
            new_x = -1;
        }
        if ((y + tamelipse) > area.getHeight()) {
            new_y = (int) area.getHeight() - tamelipse - 1;
        }
        if (y < 0) {
            new_y = -1;
        }
        this.setPosicion(new_x, new_y);
    }
}
