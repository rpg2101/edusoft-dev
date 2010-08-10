/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edusoft.ventanas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
/**
 *
 * @author rpg
 */
public class Lienzo extends Canvas {

    private Vector<Vector> elemento;
    private Image pliegue, solapa, basepapel0, linea;
    private boolean modificaranchod, modificaraltoup, modificaranchoi, modificaraltodown;
    private boolean outi, outup, outdown, outd, desplegar, comoson;
    private boolean letrai, letrag, letrau, letraa, letral, letrae, letras;
    private Rectangle rectangulo;
    private Image imag;
    private Graphics gBuffer;
    private int margenx = 20;
    private int margeny = 100;
    private static int anchopatron = 650;
    private int ancho = 650;
    private int alto = 250;
    private int filos = 7;
    private int ndoblez;
    private int fraccion;
    private String titulo;

    public Lienzo getLienzo() {
        return this;
    }

    @Override
    public boolean keyDown(Event evt, int key) {
        if (comoson) {
            if (key == 105 || key == 73) {
                letrai = true;
                this.repaint();
            }
            if (key == 103 || key == 71) {
                letrag = true;
                this.repaint();
            }
            if (key == 117 || key == 85) {
                letrau = true;
                this.repaint();
            }
            if (key == 97 || key == 65) {
                letraa = true;
                this.repaint();
            }
            if (key == 108 || key == 76) {
                letral = true;
                this.repaint();
            }
            if (key == 101 || key == 69) {
                letrae = true;
                this.repaint();
            }
            if (key == 115 || key == 83) {
                letras = true;
                this.repaint();
            }
        }
        if (letrai && letrag && letrau && letraa && letral && letrae && letras) {
            final JDialog f = new JDialog();
            f.setBounds(270, 250, 200, 200);
            f.setVisible(true);
            f.setAlwaysOnTop(true);
            f.setLayout(null);
            JButton b = new JButton("Continuar");
            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    f.setVisible(false);
                    getLienzo().armarRect(elemento, 1);
                    repaint();
                }
            });
            b.setBounds(13, 110, 165, 50);
            f.add(b);
            this.fraccion++;
            this.comoson = false;
            this.letrai = false;
            this.letrag = false;
            this.letrau = false;
            this.letraa = false;
            this.letral = false;
            this.letrae = false;
            this.letras = false;
            this.ndoblez = 0;

        }
        return true;
    }

    @Override
    public boolean mouseMove(Event evt, int x, int y) {
        if (this.checkpuntero(x, y) == true) {
            this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if (modificaranchod) {
            this.setCursor(new Cursor(Cursor.MOVE_CURSOR));
            this.getElem().elementAt(0).set(3, x);
            this.getElem().elementAt(1).set(3, (ancho - x) / 2);
            this.getElem().elementAt(1).set(1, x);
            this.getElem().elementAt(3).set(3, (ancho - x) / 2);
            this.getElem().elementAt(3).set(1, x);
            this.getElem().elementAt(2).set(1, (x + (ancho - x) / 2));

            if (x >= margenx + 7 && x <= margenx + ancho) {
                this.outd = false;
                this.repaint();
            } else {
                if (x < margenx) {
                    this.outd = true;
                    this.getElem().elementAt(0).set(3, 5);
                    this.getElem().elementAt(1).set(3, (ancho - margenx + 30) / 2);
                    this.getElem().elementAt(1).set(1, margenx);
                    this.getElem().elementAt(3).set(3, ((ancho - margenx + 30) / 2) - 15);
                    this.getElem().elementAt(3).set(1, margenx);
                    this.getElem().elementAt(2).set(1, (margenx + (ancho - margenx) / 2));
                    this.repaint();
                } else if (x > margenx + ancho) {
                    this.outd = true;
                    this.getElem().elementAt(0).set(3, ancho);
                    this.getElem().elementAt(1).set(3, 0);
                    this.getElem().elementAt(1).set(1, margenx + ancho);
                    this.getElem().elementAt(3).set(3, 0);
                    this.getElem().elementAt(3).set(1, margenx + ancho);
                    this.getElem().elementAt(2).set(1, margenx + ancho);
                    this.repaint();
                }
            }

        } else {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
        return true;
    }

    public Vector<Vector> getElem() {
        return elemento;
    }

    public void armarRect(Vector<Vector> elemento, int coef) {
        ancho = anchopatron / coef;
        filos = 7;
        elemento.removeAllElements();
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
    }

    public Lienzo() {
        setBackground(Color.BLACK);
        this.titulo = "Doblar el papel en partes iguales";
        basepapel0 = new ImageIcon(getClass().getResource("basepapel0.png")).getImage();
        solapa = new ImageIcon(getClass().getResource("solapa.png")).getImage();
        pliegue = new ImageIcon(getClass().getResource("pliegue.png")).getImage();
        linea = new ImageIcon(getClass().getResource("linea.png")).getImage();
        elemento = new Vector<Vector>();
        this.armarRect(elemento, 1);
        this.modificaranchod = false;
        this.modificaranchoi = false;
        this.modificaraltoup = false;
        this.modificaraltodown = false;
        this.outd = false;
        this.outi = false;
        this.outup = false;
        this.outdown = false;
        this.desplegar = false;
        this.comoson = false;
        this.letrai = false;
        this.letrag = false;
        this.letrau = false;
        this.letraa = false;
        this.letral = false;
        this.letrae = false;
        this.letras = false;
        this.ndoblez = 0;
        this.fraccion = 0;
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
        getGB().drawString(titulo, margenx, 50);

        for (int i0 = 0; i0 < getElem().size(); i0++) {
            if ((Integer) getElem().elementAt(i0).get(0) == 0) {
                getGB().drawImage(solapa, (Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4), this);
                getGB().drawImage(linea, (Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        7,
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
// Linea filo del papel (para mantener la relacion de aspecto)
                getGB().drawImage(linea, (Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        filos,
                        (Integer) getElem().elementAt(i0).get(4), this);

            }
            if ((Integer) getElem().elementAt(i0).get(0) == 3) {
                getGB().drawImage(pliegue, (Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4), this);
            }
            if ((Integer) getElem().elementAt(i0).get(0) == 4) {
                getGB().drawImage(linea, (Integer) getElem().elementAt(i0).get(1),
                        (Integer) getElem().elementAt(i0).get(2),
                        (Integer) getElem().elementAt(i0).get(3),
                        (Integer) getElem().elementAt(i0).get(4), this);

            }
            getGB().setColor(Color.GRAY);
            if (desplegar) {
                getGB().setFont(new Font("Serif", Font.BOLD, 30));
                getGB().drawString(" Despliega el rectángulo ", 50, 420);
            }
            if (comoson) {
                getGB().setFont(new Font("Serif", Font.BOLD, 30));
                getGB().drawString("¿ Como son las partes ? ", 50, 420);
                getGB().setFont(new Font("Serif", Font.BOLD, 50));
                getGB().drawString("   _  _  _  _  _    ", 180, 500);
                if (letrai) {
                    getGB().drawString("I", 180, 500);
                }
                if (letrag) {
                    getGB().drawString("G", 222, 500);
                }
                if (letrau) {
                    getGB().drawString("U", 282, 500);
                }
                if (letraa) {
                    getGB().drawString("A", 345, 500);
                }
                if (letral) {
                    getGB().drawString("L", 402, 500);
                }
                if (letrae) {
                    getGB().drawString("E", 460, 500);
                }
                if (letras) {
                    getGB().drawString("S", 526, 500);
                }

            }

        }
        g.drawImage(imag, 0, 0, null);


    }

    @Override
    public boolean mouseDown(Event evt, int x, int y) {
        if (modificaranchod) {
            if (outd && x < margenx) {
                if (ndoblez == 0) {
                    if (fraccion == 0) {
                        Vector<Integer> aux1 = new Vector<Integer>();
                        aux1.add(4);
                        aux1.add(ancho / 2 + margenx + 13);
                        aux1.add(margeny);
                        aux1.add(5);
                        aux1.add(alto);
                        elemento.add(aux1);
                        desplegar = true;
                        repaint();
                    } else {
                        this.armarRect(elemento, 2);
                        modificaranchod = false;
                        ndoblez++;
                        repaint();
                    }

                } else if (ndoblez == 1) {
                    if (fraccion == 1) {
                        this.armarRect(elemento, 1);
                        modificaranchod = false;
                        desplegar = false;
                        comoson = true;
                        letrai = true;
                        letras = true;
                        filos = 0;
                        this.rectangulo.width = anchopatron;
                        x = margenx + ancho;
                        this.getElem().elementAt(2).set(3, 0);
                        this.getElem().elementAt(3).set(3, 13);
                        this.getElem().elementAt(3).set(2, margeny);
                        modificaranchod = false;
                        Vector<Integer> aux1 = new Vector<Integer>();
                        aux1.add(4);
                        aux1.add(anchopatron / 2 + margenx + 6);
                        aux1.add(margeny);
                        aux1.add(5);
                        aux1.add(alto);
                        Vector<Integer> aux2 = new Vector<Integer>();
                        aux2.add(4);
                        aux2.add(anchopatron / 4 + margenx + 6);
                        aux2.add(margeny);
                        aux2.add(5);
                        aux2.add(alto);
                        Vector<Integer> aux3 = new Vector<Integer>();
                        aux3.add(4);
                        aux3.add((anchopatron / 2) + (anchopatron / 4) + margenx + 13);
                        aux3.add(margeny);
                        aux3.add(5);
                        aux3.add(alto);
                        Vector<Integer> aux4 = new Vector<Integer>();
                        aux4.add(4);
                        aux4.add(anchopatron + margenx + 13);
                        aux4.add(margeny);
                        aux4.add(5);
                        aux4.add(alto);

                        elemento.add(aux1);
                        elemento.add(aux2);
                        elemento.add(aux3);
                        elemento.add(aux4);
                        repaint();
                    } else if (fraccion == 2) {
                        this.armarRect(elemento, 4);
                        modificaranchod = false;
                        ndoblez++;
                        repaint();
                    }
                } else if (ndoblez == 2) {
                    this.armarRect(elemento, 1);
                    modificaranchod = false;
                    desplegar = false;
                    comoson = true;
                    letrai = true;
                    letras = true;
                    filos = 0;
                    this.rectangulo.width = anchopatron;
                    x = margenx + ancho;
                    this.getElem().elementAt(2).set(3, 0);
                    this.getElem().elementAt(3).set(3, 13);
                    this.getElem().elementAt(3).set(2, margeny);
                    modificaranchod = false;
                    Vector<Integer> aux1 = new Vector<Integer>();
                    aux1.add(4);
                    aux1.add(anchopatron / 2 + margenx + 6);
                    aux1.add(margeny);
                    aux1.add(5);
                    aux1.add(alto);
                    Vector<Integer> aux2 = new Vector<Integer>();
                    aux2.add(4);
                    aux2.add(anchopatron / 4 + margenx + 6);
                    aux2.add(margeny);
                    aux2.add(5);
                    aux2.add(alto);
                    Vector<Integer> aux3 = new Vector<Integer>();
                    aux3.add(4);
                    aux3.add((anchopatron / 2) + (anchopatron / 4) + margenx + 13);
                    aux3.add(margeny);
                    aux3.add(5);
                    aux3.add(alto);
                    Vector<Integer> aux4 = new Vector<Integer>();
                    aux4.add(4);
                    aux4.add(anchopatron + margenx + 13);
                    aux4.add(margeny);
                    aux4.add(5);
                    aux4.add(alto);
                    Vector<Integer> aux5 = new Vector<Integer>();
                    aux5.add(4);
                    aux5.add(anchopatron/8 + margenx + 6);
                    aux5.add(margeny);
                    aux5.add(5);
                    aux5.add(alto);
                    Vector<Integer> aux6 = new Vector<Integer>();
                    aux6.add(4);
                    aux6.add((anchopatron/8)+(anchopatron / 4) + margenx + 6);
                    aux6.add(margeny);
                    aux6.add(5);
                    aux6.add(alto);
                    Vector<Integer> aux7 = new Vector<Integer>();
                    aux7.add(4);
                    aux7.add((anchopatron/8)+(anchopatron / 2) + margenx + 6 );
                    aux7.add(margeny);
                    aux7.add(5);
                    aux7.add(alto);
                    Vector<Integer> aux8 = new Vector<Integer>();
                    aux8.add(4);
                    aux8.add((anchopatron/8)+ (anchopatron / 2) + (anchopatron / 4)  + margenx + 13 );
                    aux8.add(margeny);
                    aux8.add(5);
                    aux8.add(alto);
                    elemento.add(aux1);
                    elemento.add(aux2);
                    elemento.add(aux3);
                    elemento.add(aux4);
                    elemento.add(aux5);
                    elemento.add(aux6);
                    elemento.add(aux7);
                    elemento.add(aux8);

                    repaint();
                }

            } else if (outd && (x > margenx + ancho) && desplegar) {
                if (fraccion == 0) {
                    modificaranchod = false;
                    desplegar = false;
                    comoson = true;
                    letrai = true;
                    letras = true;
                    this.rectangulo.width = ancho;
                    x = margenx + ancho;
                    this.getElem().elementAt(2).set(3, 0);
                    this.getElem().elementAt(3).set(3, 13);
                    this.getElem().elementAt(3).set(2, margeny);
                    filos = 0;
                    Vector<Integer> aux2 = new Vector<Integer>();
                    aux2.add(4);
                    aux2.add(ancho + margenx + 13);
                    aux2.add(margeny);
                    aux2.add(5);
                    aux2.add(alto);
                    elemento.add(aux2);
                    this.repaint();
                }

            } else {
                this.rectangulo.width = x - margenx;
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

    private boolean checkpuntero(int x, int y) {
        if (Boolean.valueOf(this.rect(x, y).intersects(rectangulo))) {
            if ((rectangulo.getMaxX() - 10 < x) && (x < rectangulo.getMaxX() + 10)) {
                return true;
            }
        }

        return false;
    }
}


