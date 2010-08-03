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
import segmsincolor.Lienzo;

/**
 *
 * @author Hector Rattis
 */
public abstract class Pieza {

    private int x, y, x_ini, y_ini, last_x, last_y;
    final private int tamelipse;
    private int anginicial, angfinal;
    private Color color;
    private Lienzo lienzo;
    private boolean pressOut, isPatron;

    public Pieza(int x0, int y0, int aini, Lienzo l) {
        pressOut = true;
        isPatron = false;
        x = x_ini = x0;
        y = y_ini = y0;
        tamelipse = 150;
        anginicial = aini;
        lienzo = l;
    }

    /*
     * Metodo implementado por cada pieza para pintarse
     */
    public void pintarse(Graphics2D g2) {
        g2.setColor(this.color);
        g2.fill(new Arc2D.Float(x, y, tamelipse, tamelipse, anginicial,
                angfinal, Arc2D.PIE));
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER));
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));
        g2.draw(new Arc2D.Float(x, y, tamelipse, tamelipse, anginicial,
                angfinal, Arc2D.PIE));
        g2.draw(segArrastre());
    }

    /**
     * Este metodo retornará las zonas de arrastre de cada segmento
     * @return
     */
    public abstract Rectangle segArrastre();

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
     * @return the angfinal
     */
    public void setAngfinal(int afinal) {
        angfinal = afinal;
    }

    public boolean ckInnerAng(int ang) {
        Integer integer = Integer.valueOf(ang);
        return integer.equals(anginicial + angfinal);
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
     * Seteo la bandera de PressOut
     * @param flag
     */
    public void setPressOut(boolean flag) {
        pressOut = flag;
    }

    public boolean getPressOut() {
        return pressOut;
    }

    public void setPatron(boolean flag) {
        isPatron = flag;
    }

    public boolean getPatron() {
        return isPatron;
    }

    public void setLastPosicion(int x0, int y0) {
        last_x = x0;
        last_y = y0;
    }

    public void setPosicion(int x0, int y0) {
        x = x0;
        y = y0;
    }

    public void resetPosicion() {
        setPosicion(x_ini, y_ini);
    }

    public void actulizaPosicion(MouseEvent m) {
        this.setPosicion(last_x + m.getX(), last_y + m.getY());
        this.actulizaPosicion();
    }

    public void actulizaPosicion() {
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
