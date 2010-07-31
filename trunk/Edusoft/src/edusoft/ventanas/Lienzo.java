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
    private Image pliegue, solapa, basepapel0, basepapel1, basepapel2, basepapel3, puntapapel;
    private boolean modificaranchod, modificaraltoup;
    private boolean modificaranchoi, modificaraltodown;
    private boolean outi, outup, outdown, outd;
    private Rectangle rectangulo;
    private Image imag;
    private Graphics gBuffer;
    private int margenx = 20;
    private int margeny = 100;
    private int ancho = 650;
    private int alto = 250;

    @Override
    public boolean mouseMove(Event evt, int x, int y) {
        if (modificaranchod) {
            this.getElem().elementAt(0).set(3, x);
            this.getElem().elementAt(1).set(3, (ancho - x) / 2);
            this.getElem().elementAt(1).set(1, x);
            this.getElem().elementAt(3).set(3, (ancho - x) / 2);
            this.getElem().elementAt(3).set(1, x);
            this.getElem().elementAt(2).set(1, (x + (ancho - x) / 2));

            if (x >= margenx && x <= margenx + ancho) {
                this.outd = false;
                this.repaint();
            } else {
                if (x < margenx) {
                    this.outd = true;
                    this.getElem().elementAt(0).set(3, 5);
                    this.getElem().elementAt(1).set(3, (ancho - margenx + 30) / 2);
                    this.getElem().elementAt(1).set(1, margenx);
                    this.getElem().elementAt(3).set(3, ((ancho - margenx + 30) / 2)-10);
                    this.getElem().elementAt(3).set(1, margenx);
                    this.getElem().elementAt(2).set(1, (margenx + (ancho - margenx) / 2));
                    this.repaint();
                }
                if (x > margenx + ancho) {
                    this.outd = true;
                    this.getElem().elementAt(0).set(3, ancho);
                    this.getElem().elementAt(1).set(3, 0);
                    this.getElem().elementAt(1).set(1, 0);
                    this.getElem().elementAt(3).set(3, 0);
                    this.getElem().elementAt(3).set(1, 0);
                    this.getElem().elementAt(2).set(1, margenx+ancho);
                    this.repaint();
                }
            }
        }
//        if (modificaranchoi) {
//            this.getElem().elementAt(2).set(1, x);
//            this.getElem().elementAt(2).set(3, 450 - x);
//            this.getElem().elementAt(3).set(1, x);
//            this.getElem().elementAt(3).set(3, 450 - x);
//            if (x >= 100 && x <= 800) {
//                this.outi = false;
//                this.repaint();
//            } else {
//                if (x < 100) {
//                    this.outi = true;
//                    this.getElem().elementAt(2).set(3, 350);
//                    this.getElem().elementAt(2).set(1, 100);
//                    this.getElem().elementAt(3).set(3, 350);
//                    this.getElem().elementAt(3).set(1, 100);
//                    this.repaint();
//                }
//                if (x > 800) {
//                    this.outi = true;
//                    this.getElem().elementAt(2).set(1, 450);
//                    this.getElem().elementAt(2).set(3, 350);
//                    this.getElem().elementAt(3).set(1, 450);
//                    this.getElem().elementAt(3).set(3, 350);
//                    this.repaint();
//                }
//            }
//        }
//        if (modificaraltodown) {
//            this.getElem().elementAt(1).set(4, y - 275);
//            this.getElem().elementAt(2).set(4, y - 275);
//            if (y >= 150 && y <= 400) {
//                this.outdown = false;
//                this.repaint();
//            } else {
//                if (y < 150) {
//                    this.outdown = true;
//                    this.getElem().elementAt(1).set(4, -125);
//                    this.getElem().elementAt(2).set(4, -125);
//                    this.repaint();
//                }
//                if (y > 400) {
//                    this.outdown = true;
//                    this.getElem().elementAt(1).set(4, 125);
//                    this.getElem().elementAt(2).set(4, 125);
//                    this.repaint();
//                }
//            }
//        }
//        if (modificaraltoup) {
//            this.getElem().elementAt(0).set(2, y);
//            this.getElem().elementAt(0).set(4, 275 - y);
//            this.getElem().elementAt(3).set(2, y);
//            this.getElem().elementAt(3).set(4, 275 - y);
//            if (y >= 150 && y <= 400) {
//                this.outup = false;
//                this.repaint();
//            } else {
//                if (y < 150) {
//                    this.outup = true;
//                    this.getElem().elementAt(0).set(4, 125);
//                    this.getElem().elementAt(0).set(2, 150);
//                    this.getElem().elementAt(3).set(4, 125);
//                    this.getElem().elementAt(3).set(2, 150);
//                    this.repaint();
//                }
//                if (y > 400) {
//                    this.outup = true;
//                    this.getElem().elementAt(0).set(4, 125);
//                    this.getElem().elementAt(0).set(2, 275);
//                    this.getElem().elementAt(3).set(4, 125);
//                    this.getElem().elementAt(3).set(2, 275);
//                    this.repaint();
//                }
//            }
//        }
        return true;
    }

    public Vector<Vector> getElem() {
        return elemento;
    }

    public Lienzo() {
        setBackground(Color.BLACK);
        basepapel0 = new ImageIcon(getClass().getResource("basepapel0.png")).getImage();
        basepapel1 = new ImageIcon(getClass().getResource("basepapel1.png")).getImage();
        basepapel2 = new ImageIcon(getClass().getResource("basepapel2.png")).getImage();
        basepapel3 = new ImageIcon(getClass().getResource("basepapel3.png")).getImage();
        solapa = new ImageIcon(getClass().getResource("solapa.png")).getImage();
        pliegue = new ImageIcon(getClass().getResource("pliegue.png")).getImage();
        elemento = new Vector<Vector>();

        Vector<Integer> aux1 = new Vector<Integer>();
        aux1.add(0);
        aux1.add(margenx);
        aux1.add(margeny);
        aux1.add(ancho);
        aux1.add(alto);
        elemento.add(aux1);

//Rectangulo auxiliar para interseccion
        rectangulo = new Rectangle(margenx, margeny, ancho, alto);

// Rectangulo inferior del solape
        Vector<Integer> rectdoblez1 = new Vector<Integer>();
        rectdoblez1.add(1);
        rectdoblez1.add(margenx + ancho);
        rectdoblez1.add(margeny);
        rectdoblez1.add(0);
        rectdoblez1.add(alto);
// Rectangulo Superior del solape
        Vector<Integer> rectdoblez2 = new Vector<Integer>();
        rectdoblez2.add(2);
        rectdoblez2.add(margenx + ancho);
        rectdoblez2.add(margeny + 27);
        rectdoblez2.add(0);
        rectdoblez2.add(alto);
// Pligue
        Vector<Integer> rectdoblez3 = new Vector<Integer>();
        rectdoblez3.add(3);
        rectdoblez3.add(margenx + ancho);
        rectdoblez3.add(margeny);
        rectdoblez3.add(30);
        rectdoblez3.add(alto + 25);

// Primero el inferior , despues el pliegue , y por ultimo el superior
        elemento.add(rectdoblez1);
        elemento.add(rectdoblez3);
        elemento.add(rectdoblez2);

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
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        if (getGB() == null) {
            imag = createImage(800, 600);
            setGB(imag.getGraphics());
        }
        getGB().setColor(Color.WHITE);
        getGB().fillRect(0, 0, getWidth(), getHeight());
        getGB().setColor(Color.BLACK);
        getGB().setFont(new Font("Serif", Font.BOLD, 30));
        getGB().drawString("Doblar el papel en partes iguales", 90, 50);

        for (int i0 = 0; i0 < getElem().size(); i0++) {
            if ((Integer) getElem().elementAt(i0).get(0) == 0) {
                getGB().drawImage(solapa, (Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4), this);
            }
            if ((Integer) getElem().elementAt(i0).get(0) == 1) {
                getGB().drawImage(basepapel0, (Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4), this);
            }
            if ((Integer) getElem().elementAt(i0).get(0) == 2) {
                getGB().drawImage(solapa, (Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4), this);

            }
            if ((Integer) getElem().elementAt(i0).get(0) == 3) {
                getGB().drawImage(pliegue, (Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4), this);
            }
        }
        getGB().setColor(Color.RED);
        getGB().drawRect(rectangulo.x, rectangulo.y, rectangulo.width, rectangulo.height);
        g.drawImage(imag, 0, 0, null);

    }

    @Override
    public boolean mouseDown(Event evt, int x, int y) {
        if (modificaranchod) {
            this.modificaranchod = false;
            if (outd && x < margenx) {
                this.rectangulo.width = 5;
                x = margenx;
            }
            if (outd && x > margenx + ancho) {
                this.rectangulo.width = ancho;
                x = margenx + ancho;
            } else {
                this.rectangulo.width = x - margenx;
            }
            this.repaint();
            return true;
        } //        if (modificaranchoi) {
        //            this.modificaranchoi = false;
        //            if (outi && x < 100) {
        //                this.rectangulo.width = 700;
        //                x = 100;
        //            }
        //            if (outi && x > 800) {
        //                this.rectangulo.width = 350;
        //                this.rectangulo.x = 450;
        //                x = 800;
        //            } else {
        //                this.rectangulo.width = 800 - x;
        //                this.rectangulo.x = x;
        //            }
        //            this.repaint();
        //            return true;
        //        }
        //        if (modificaraltodown) {
        //            this.modificaraltodown = false;
        //            if (outdown && y < 150) {
        //                this.rectangulo.height = 125;
        //                y = 150;
        //            }
        //            if (outdown && y > 400) {
        //                this.rectangulo.height = 250;
        //                y = 400;
        //            } else {
        //                this.rectangulo.height = y - 150;
        //            }
        //            this.repaint();
        //            return true;
        //        }
        //        if (modificaraltoup) {
        //            this.modificaraltoup = false;
        //            if (outup && y < 150) {
        //                this.rectangulo.height = 250;
        //                y = 150;
        //            }
        //            if (outup && y > 400) {
        //                this.rectangulo.height = 125;
        //                this.rectangulo.y = 275;
        //                y = 400;
        //            } else {
        //                this.rectangulo.height = 400 - y;
        //                this.rectangulo.y = y;
        //            }
        //            this.repaint();
        //            return true;
        //        }
        else {
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

