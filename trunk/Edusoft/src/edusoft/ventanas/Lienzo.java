/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edusoft.ventanas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Event;
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
    private Image texto1;
    private Image basepapel, puntapapel;
    private boolean modificaranchod, modificaraltoup;
    private boolean modificaranchoi, modificaraltodown;
    private boolean outi, outup, outdown, outd;
    private Rectangle rectangulo;
    private Image imag;
    private Graphics gBuffer;

    @Override
    public boolean mouseMove(Event evt, int x, int y) {
        if (modificaranchod) {

            this.getElem().elementAt(0).set(3, x - 450);
            this.getElem().elementAt(1).set(3, x - 450);
            this.getElem().elementAt(4).set(3, ((800 - x) / 2) + 10);
            this.getElem().elementAt(4).set(1, x);
            this.getElem().elementAt(6).set(3, (800 - x) / 2);
            this.getElem().elementAt(6).set(1, x + 10);
            this.getElem().elementAt(5).set(1, (x + (800 - x) / 2));

            if (x >= 100 && x <= 800) {
                this.outd = false;
                this.repaint();
            } else {
                if (x < 100) {
                    this.outd = true;
                    this.getElem().elementAt(0).set(3, -350);
                    this.getElem().elementAt(1).set(3, -350);
                    this.repaint();
                }
                if (x > 800) {
                    this.outd = true;
                    this.getElem().elementAt(0).set(3, 350);
                    this.getElem().elementAt(1).set(3, 350);
                    this.repaint();
                }
            }
        }
        if (modificaranchoi) {
            this.getElem().elementAt(2).set(1, x);
            this.getElem().elementAt(2).set(3, 450 - x);
            this.getElem().elementAt(3).set(1, x);
            this.getElem().elementAt(3).set(3, 450 - x);
            if (x >= 100 && x <= 800) {
                this.outi = false;
                this.repaint();
            } else {
                if (x < 100) {
                    this.outi = true;
                    this.getElem().elementAt(2).set(3, 350);
                    this.getElem().elementAt(2).set(1, 100);
                    this.getElem().elementAt(3).set(3, 350);
                    this.getElem().elementAt(3).set(1, 100);
                    this.repaint();
                }
                if (x > 800) {
                    this.outi = true;
                    this.getElem().elementAt(2).set(1, 450);
                    this.getElem().elementAt(2).set(3, 350);
                    this.getElem().elementAt(3).set(1, 450);
                    this.getElem().elementAt(3).set(3, 350);
                    this.repaint();
                }
            }
        }
        if (modificaraltodown) {
            this.getElem().elementAt(1).set(4, y - 275);
            this.getElem().elementAt(2).set(4, y - 275);
            if (y >= 150 && y <= 400) {
                this.outdown = false;
                this.repaint();
            } else {
                if (y < 150) {
                    this.outdown = true;
                    this.getElem().elementAt(1).set(4, -125);
                    this.getElem().elementAt(2).set(4, -125);
                    this.repaint();
                }
                if (y > 400) {
                    this.outdown = true;
                    this.getElem().elementAt(1).set(4, 125);
                    this.getElem().elementAt(2).set(4, 125);
                    this.repaint();
                }
            }
        }
        if (modificaraltoup) {
            this.getElem().elementAt(0).set(2, y);
            this.getElem().elementAt(0).set(4, 275 - y);
            this.getElem().elementAt(3).set(2, y);
            this.getElem().elementAt(3).set(4, 275 - y);
            if (y >= 150 && y <= 400) {
                this.outup = false;
                this.repaint();
            } else {
                if (y < 150) {
                    this.outup = true;
                    this.getElem().elementAt(0).set(4, 125);
                    this.getElem().elementAt(0).set(2, 150);
                    this.getElem().elementAt(3).set(4, 125);
                    this.getElem().elementAt(3).set(2, 150);
                    this.repaint();
                }
                if (y > 400) {
                    this.outup = true;
                    this.getElem().elementAt(0).set(4, 125);
                    this.getElem().elementAt(0).set(2, 275);
                    this.getElem().elementAt(3).set(4, 125);
                    this.getElem().elementAt(3).set(2, 275);
                    this.repaint();
                }
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
        basepapel = new ImageIcon(getClass().getResource("basepapel.png")).getImage();
        puntapapel = new ImageIcon(getClass().getResource("puntapapel.png")).getImage();
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

        Vector<Integer> rectdoblez1 = new Vector<Integer>();
        rectdoblez1.add(1);
        rectdoblez1.add(800);
        rectdoblez1.add(150);
        rectdoblez1.add(0);
        rectdoblez1.add(250);
        elemento.add(rectdoblez1);
        Vector<Integer> rectdoblez2 = new Vector<Integer>();
        rectdoblez2.add(2);
        rectdoblez2.add(800);
        rectdoblez2.add(170);
        rectdoblez2.add(0);
        rectdoblez2.add(250);

        Vector<Integer> rectdoblez3 = new Vector<Integer>();
        rectdoblez3.add(3);
        rectdoblez3.add(780);
        rectdoblez3.add(150);
        rectdoblez3.add(20);
        rectdoblez3.add(20);
        elemento.add(rectdoblez3);
        elemento.add(rectdoblez2);
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
    public synchronized void update(Graphics g) {
        if (getGB() == null) {
            imag = createImage(1000, 700);
            setGB(imag.getGraphics());
        }
        getGB().setColor(Color.WHITE);
        getGB().fillRect(0, 0, getWidth(), getHeight());
        getGB().drawImage(texto1, 50, 40, 850, 100, this);

        for (int i0 = 0; i0 < getElem().size(); i0++) {
            if ((Integer) getElem().elementAt(i0).get(0) == 0) {
//                g.drawImage(basepapel, (Integer) getElem().elementAt(i0).get(1),
//                        (Integer) getElem().elementAt(i0).get(2),
//                        (Integer) getElem().elementAt(i0).get(3),
//                        (Integer) getElem().elementAt(i0).get(4), this);

                getGB().setColor(Color.LIGHT_GRAY);
                getGB().fillRect((Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4));

            }
            if ((Integer) getElem().elementAt(i0).get(0) == 1) {
                getGB().setColor(Color.LIGHT_GRAY);
                getGB().fillRect((Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4));
            }
            if ((Integer) getElem().elementAt(i0).get(0) == 2) {
                getGB().setColor(Color.GRAY);
                getGB().fillRect((Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4));
            }
            if ((Integer) getElem().elementAt(i0).get(0) == 3) {
                getGB().setColor(Color.LIGHT_GRAY);
                getGB().fillArc((Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4), -90, 180);
                getGB().setColor(Color.BLACK);
                getGB().drawArc((Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4), -90, 180);
            }
        }


        getGB().setColor(Color.BLUE);
        getGB().setColor(Color.GREEN);
        g.drawImage(imag, 0, 0, null);
    }
    
    public synchronized void paint(Graphics g){
    getGB().setColor(Color.WHITE);
        getGB().fillRect(0, 0, getWidth(), getHeight());
        getGB().drawImage(texto1, 50, 40, 850, 100, this);

        for (int i0 = 0; i0 < getElem().size(); i0++) {
            if ((Integer) getElem().elementAt(i0).get(0) == 0) {
//                g.drawImage(basepapel, (Integer) getElem().elementAt(i0).get(1),
//                        (Integer) getElem().elementAt(i0).get(2),
//                        (Integer) getElem().elementAt(i0).get(3),
//                        (Integer) getElem().elementAt(i0).get(4), this);

                getGB().setColor(Color.LIGHT_GRAY);
                getGB().fillRect((Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4));

            }
            if ((Integer) getElem().elementAt(i0).get(0) == 1) {
                getGB().setColor(Color.LIGHT_GRAY);
                getGB().fillRect((Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4));
            }
            if ((Integer) getElem().elementAt(i0).get(0) == 2) {
                getGB().setColor(Color.GRAY);
                getGB().fillRect((Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4));
            }
            if ((Integer) getElem().elementAt(i0).get(0) == 3) {
                getGB().setColor(Color.LIGHT_GRAY);
                getGB().fillArc((Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4), -90, 180);
                getGB().setColor(Color.BLACK);
                getGB().drawArc((Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4), -90, 180);
            }
        }


        getGB().setColor(Color.BLUE);
        getGB().setColor(Color.GREEN);
        g.drawImage(imag, 0, 0, null);
}

    @Override
    public boolean mouseDown(Event evt, int x, int y) {
        if (modificaranchod) {
            this.modificaranchod = false;
            if (outd && x < 100) {
                this.rectangulo.width = 350;
                x = 100;
            }
            if (outd && x > 800) {
                this.rectangulo.width = 700;
                x = 800;
            } else {
                this.rectangulo.width = x - 100;
            }
            this.repaint();
            return true;
        }
        if (modificaranchoi) {
            this.modificaranchoi = false;
            if (outi && x < 100) {
                this.rectangulo.width = 700;
                x = 100;
            }
            if (outi && x > 800) {
                this.rectangulo.width = 350;
                this.rectangulo.x = 450;
                x = 800;
            } else {
                this.rectangulo.width = 800 - x;
                this.rectangulo.x = x;
            }
            this.repaint();
            return true;
        }
        if (modificaraltodown) {
            this.modificaraltodown = false;
            if (outdown && y < 150) {
                this.rectangulo.height = 125;
                y = 150;
            }
            if (outdown && y > 400) {
                this.rectangulo.height = 250;
                y = 400;
            } else {
                this.rectangulo.height = y - 150;
            }
            this.repaint();
            return true;
        }
        if (modificaraltoup) {
            this.modificaraltoup = false;
            if (outup && y < 150) {
                this.rectangulo.height = 250;
                y = 150;
            }
            if (outup && y > 400) {
                this.rectangulo.height = 125;
                this.rectangulo.y = 275;
                y = 400;
            } else {
                this.rectangulo.height = 400 - y;
                this.rectangulo.y = y;
            }
            this.repaint();
            return true;
        } else {
            if (Boolean.valueOf(this.rect(x, y).intersects(rectangulo))) {
                if ((rectangulo.getMaxX() - 10 < x) && (x < rectangulo.getMaxX() + 10)) {
                    this.modificaranchod = true;
                }
            }
            if (Boolean.valueOf(this.rect(x, y).intersects(rectangulo))) {
                if ((rectangulo.getX() - 10 < x) && (x < rectangulo.getX() + 10)) {
                    this.modificaranchoi = true;
                }
            }
            if (Boolean.valueOf(this.rect(x, y).intersects(rectangulo))) {
                if ((rectangulo.getMaxY() - 10 < y) && (y < rectangulo.getMaxY() + 10)) {
                    this.modificaraltodown = true;
                }
            }
            if (Boolean.valueOf(this.rect(x, y).intersects(rectangulo))) {
                if ((rectangulo.getY() - 10 < y) && (y < rectangulo.getY() + 10)) {
                    this.modificaraltoup = true;
                }
            }
            return true;
        }
    }

    private Graphics getGB() {
        return gBuffer;
    }

    private void setGB(Graphics gb) {
        gBuffer = gb;
    }

    public Rectangle rect(int x, int y) {
        Rectangle r = new Rectangle(x - 10, y - 10, 20, 20);
        return r;
    }
}

