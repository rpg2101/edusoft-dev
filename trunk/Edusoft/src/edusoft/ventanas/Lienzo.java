/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edusoft.ventanas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Vector;
import javax.swing.ImageIcon;

/**
 *
 * @author rpg
 */
public class Lienzo extends Canvas {

    private Vector<Vector> elemento;
    private static Font monoFont = new Font("Monospaced", Font.BOLD | Font.ITALIC, 36);
    private static Font sanSerifFont = new Font("SanSerif", Font.PLAIN, 12);
    private static Font serifFont = new Font("Serif", Font.BOLD, 24);
    private Image texto1;
    private Image puntapapel;
    private Image basepapel;
    private boolean modificaranchod, modificaraltoup ;
    private boolean modificaranchoi, modificaraltodown;
    private boolean outi, outup, outdown, outd;
    private Rectangle rectangulo;

    @Override
    public boolean mouseMove(Event evt, int x, int y) {
        if (modificaranchod) {
            this.getElem().elementAt(0).set(3, x - 450);
            this.getElem().elementAt(1).set(3, x - 450);
            if (x > 100 && x < 800) {
                this.outd = false;
                this.repaint();
            } else {
                System.out.println("Estas ajuera derecha");
                this.outd = true;
                this.getElem().elementAt(0).set(3, 350);
                this.getElem().elementAt(1).set(3, 350);
                this.repaint();
            }
        }
        if (modificaranchoi) {
            this.getElem().elementAt(2).set(1, x);
            this.getElem().elementAt(2).set(3, 450 - x);
            this.getElem().elementAt(3).set(1, x);
            this.getElem().elementAt(3).set(3, 450 - x);
            if (x > 100 && x < 800) {
                this.outi = false;
                this.repaint();
            } else {
                System.out.println("Seguis Afuera izquierda");
                this.outi = true;
                this.getElem().elementAt(2).set(1, 100);
                this.getElem().elementAt(2).set(3, 350);
                this.getElem().elementAt(3).set(1, 100);
                this.getElem().elementAt(3).set(3, 350);
                this.repaint();
            }
        }
        return true;
    }

    public Vector<Vector> getElem() {
        return elemento;
    }

    public Lienzo() {
        setBackground(Color.BLACK);
        texto1 = new ImageIcon(getClass().getResource("1.png")).getImage();
        puntapapel = new ImageIcon(getClass().getResource("puntapapel.png")).getImage();
        basepapel = new ImageIcon(getClass().getResource("basepapel.png")).getImage();
        elemento = new Vector<Vector>();
        // Primer Cuadrante
        Vector<Integer> aux1 = new Vector<Integer>();
        aux1.add(0);
        aux1.add(450);
        aux1.add(150);
        aux1.add(350);
        aux1.add(125);
        elemento.add(aux1);
        // Segundo Cuadrante
        Vector<Integer> aux2 = new Vector<Integer>();
        aux2.add(0);
        aux2.add(450);
        aux2.add(275);
        aux2.add(350);
        aux2.add(125);
        elemento.add(aux2);
        // Tercer Cuadrante
        Vector<Integer> aux3 = new Vector<Integer>();
        aux3.add(0);
        aux3.add(100);
        aux3.add(275);
        aux3.add(350);
        aux3.add(125);
        elemento.add(aux3);
        // Cuarto Cuadrante
        Vector<Integer> aux4 = new Vector<Integer>();
        aux4.add(0);
        aux4.add(100);
        aux4.add(150);
        aux4.add(350);
        aux4.add(125);
        elemento.add(aux4);
        //Rectangulo auxiliar para interseccion
        rectangulo = new Rectangle(100, 150, 700, 250);

        this.setBackground(Color.LIGHT_GRAY);
        this.modificaranchod = false;
        this.modificaranchoi = false;
        this.modificaraltoup = false;
        this.modificaraltodown = false;
        this.outd = false;
        this.outi = false;
        this.outup = false;
        this.outdown = false;
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(texto1, 50, 40, 850, 100, this);

        for (int i0 = 0; i0 < getElem().size(); i0++) {
            if ((Integer) getElem().elementAt(i0).get(0) == 0) {
                if (i0 == 0) {
                    g.drawImage(puntapapel,
                            (Integer) getElem().elementAt(i0).get(1),
                            (Integer) getElem().elementAt(i0).get(2),
                            (Integer) getElem().elementAt(i0).get(3),
                            (Integer) getElem().elementAt(i0).get(4), this);
                } else {
                    g.setColor(Color.WHITE);
                    g.drawImage(basepapel, (Integer) getElem().elementAt(i0).get(1),
                            (Integer) getElem().elementAt(i0).get(2),
                            (Integer) getElem().elementAt(i0).get(3),
                            (Integer) getElem().elementAt(i0).get(4), this);
                }
            }
            if ((Integer) getElem().elementAt(i0).get(0) == 1) {
                g.setColor(Color.RED);

                g.fillRect((Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4));
            }
        }


        g.setColor(Color.BLUE);
        g.setFont(monoFont);
//        FontMetrics fm = g.getFontMetrics();
//        g.drawString("Dividir el rectángulo en partes iguales", 50, 40);

    }

    @Override
    public boolean mouseDown(Event evt, int x, int y) {
        if (modificaranchod) {
            this.modificaranchod = false;
            if (outd) {
                this.rectangulo.width = 700;
                x = 800;
            } else {
                this.rectangulo.width = x - 100;
            }
            Vector<Integer> aux = new Vector<Integer>();
            aux.add(1);
            aux.add(x);
            aux.add(150);
            aux.add(5);
            aux.add(250);
            elemento.add(aux);
            this.repaint();
            return true;
        }
        if (modificaranchoi) {
            this.modificaranchoi = false;
            //this.rectangulo.x = x;
            if (outi) {
                this.rectangulo.width = 700;
                x = 100;
            } else {
                this.rectangulo.width = x - 100;
            }
            Vector<Integer> aux = new Vector<Integer>();
            aux.add(1);
            aux.add(x);
            aux.add(150);
            aux.add(5);
            aux.add(250);
            elemento.add(aux);
            this.repaint();
            return true;
        } else {
            if (Boolean.valueOf(this.rect(x, y).intersects(rectangulo))) {
                if ((rectangulo.getMaxX() - 5 < x) && (x < rectangulo.getMaxX() + 5)) {
                    this.modificaranchod = true;
                }
            }
            if (Boolean.valueOf(this.rect(x, y).intersects(rectangulo))) {
                if ((rectangulo.getX() - 5 < x) && (x < rectangulo.getX() + 5)) {
                    this.modificaranchoi = true;
                }
            }
            if (Boolean.valueOf(this.rect(x, y).intersects(rectangulo))) {
                if ((rectangulo.getMaxY() - 5 < y) && (y < rectangulo.getMaxY() + 5)) {
                    this.modificaraltoup = true;
                }
            }
            if (Boolean.valueOf(this.rect(x, y).intersects(rectangulo))) {
                if ((rectangulo.getY() - 5 < y) && (y < rectangulo.getY() + 5)) {
                    this.modificaraltodown = true;
                }
            }
            return true;
        }
    }

    public Rectangle rect(int x, int y) {
        Rectangle r = new Rectangle(x - 5, y - 5, 10, 10);
        return r;
    }
}

