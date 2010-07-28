/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segmcolor;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;
import piezas.*;

/**
 *
 * @author Hector Rattis
 */
public class Lienzo extends Canvas implements MouseInputListener {

    private Vector<Pieza> piezas;
    private Vector<Pieza> mesa;
    private Vector<ZonaPlayer> zonas;
    private int piezasEnjuego;

    public Lienzo() {
        // Defino dimiensiones y color de fondo
        this.setBounds(0, 0, 1008, 725);
        this.setBackground(Color.WHITE);

        // Agrego los MouseListener
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        //Inicializo variables
        piezas = new Vector();
        mesa = new Vector();
        zonas = new Vector();
        piezasEnjuego = 0;
        //Genero las 35 Piezas
        generarPiezas();

        //Genero las zonas de juegos
        zonas.add(new ZonaPlayer(20, 350, 227, 300));
        zonas.add(new ZonaPlayer(262, 350, 227, 300));
        zonas.add(new ZonaPlayer(503, 350, 227, 300));
        zonas.add(new ZonaPlayer(745, 350, 227, 300));

        // Genero el marco
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1008, 725);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Fracciones");
        frame.add(this);
        frame.setVisible(true);
    }

    public Vector<Pieza> getPiezas() {
        return piezas;
    }

    public Vector<Pieza> getMesa() {
        return mesa;
    }

    /**
     *  Este metodo sustrae 3 piezas aleatorias para ser puestas sobre la
     * mesa de juego
     */
    public void repartir() {
        Random gene = new Random();
        for (int i = mesa.size(); i < 3; i++) {
            Pieza tmp = piezas.remove(gene.nextInt(piezas.size()));
            tmp.setPosicion(150 + (250 * i), getHeight() / 6);
            mesa.add(tmp);
            piezasEnjuego++;
        }
    }

//   @Override
//    public void update(Graphics g) {
//        paint(g);
//    }
    @Override
    public void paint(Graphics g) {
        //Preparo el graphics
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER));
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));

        // Titulo
        g.setFont(new Font("Serif", Font.BOLD, 30));
        g.drawString("Armar enteros usando las piezas", getX() + 220, getY() + 35);

        //Dibujo el recuadro mas grande
        g2.drawRect(20, 50, 950, 280);

        //Dibujo las zonas de juego
        for (int i = 0; i < 4; i++) {
            zonas.get(i).pintarse(g2);
        }

        Iterator p = mesa.iterator();
        while (p.hasNext()) {
            Pieza segmento = (Pieza) p.next();
            segmento.pintarse(g2);
        }
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mouseDragged(MouseEvent me) {
        /**
         * Metodo que va dibujando la pieza mientras la arrastramos por el
         * area de juego.
         */
        Iterator itr = mesa.iterator();
        while (itr.hasNext()) {
            Pieza tmp = (Pieza) itr.next();
            if (!tmp.getPressOut()) {
                tmp.actulizaPosicion(me);
            }
        }
    }

    public void mouseMoved(MouseEvent me) {
        Iterator itr = mesa.iterator();
        while (itr.hasNext()) {
            Pieza tmp = (Pieza) itr.next();
            if (tmp.segArrastre().contains(this.areaMouse(me))) {
                this.setCursor(new Cursor(Cursor.HAND_CURSOR));
            } else {
                this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

        }
    }

    public void mousePressed(MouseEvent me) {
        /**
         * Aqui inspeccionamos todas las piezas en la mesa buscando la que
         * tenga el area que coincida con el x e y del mouse.
         */
        Iterator mesaitr = mesa.iterator();
        while (mesaitr.hasNext()) {
            Pieza tmp = (Pieza) mesaitr.next();
            tmp.setLastPosicion((tmp.getX()) - me.getX(),
                    (tmp.getY()) - me.getY());
            if (tmp.segArrastre().contains(this.areaMouse(me))) {
                tmp.actulizaPosicion(me);
            } else {
                tmp.setPressOut(true);
            }
        }
    }

    public void mouseReleased(MouseEvent me) {
        /**
         * Aqui inspeccionamos todas las piezas en la mesa buscando la que
         * tenga el area que coincida con el x e y del mouse.
         */
        Iterator mesaitr = mesa.iterator();
        while (mesaitr.hasNext()) {
            Pieza tmp = (Pieza) mesaitr.next();
            if (tmp.segArrastre().contains(me.getX(), me.getY())) {
                tmp.actulizaPosicion(me);
            } else {
                tmp.setPressOut(false);
            }
            //Alinea piezas a las zonas de juego
            for (int i = 0; i < 4; i++) {
                if (zonas.get(i).contains(tmp.segArrastre())) {
                    alinearSegmZonas(zonas.get(i), tmp);
                    zonas.get(i).addSegmento(tmp);
                }
            }
        }
        System.out.println(" Release juego " + piezasEnjuego);
    }

    private void generarPiezas() {
        int x_pos = 200;
        int y_pos = 200;
        //Medios
        int ainicial = 90;
        for (int i = 0; i < 2; i++) {
            piezas.add(new Medio(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 180;
        }
        //Tercios
        ainicial = 90;
        for (int i = 0; i < 3; i++) {
            piezas.add(new Tercio(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 120;
        }
        //Cuartos
        ainicial = 90;
        for (int i = 0; i < 4; i++) {
            piezas.add(new Cuarto(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 90;
        }
        //Sectos
        ainicial = 90;
        for (int i = 0; i < 6; i++) {
            piezas.add(new Secto(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 60;
        }
        //Octavos
        ainicial = 90;
        for (int i = 0; i < 8; i++) {
            piezas.add(new Octavo(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 45;
        }
        //Doceavos
        ainicial = 90;
        for (int i = 0; i < 12; i++) {
            piezas.add(new Doceavo(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 30;
        }
    }

    // Area de accion del click del mouse
    private Rectangle areaMouse(MouseEvent me) {
        return new Rectangle(me.getX() - 10, me.getY() - 10, 20, 20);
    }

    /** Metodo que alinea los segmentos en las distinas zonas del juego
     * verifica si el segmento coincide el color
     * @param zona zona de juego
     * @param seg  segmento a alinear
     */
    private void alinearSegmZonas(Rectangle zona, Pieza seg) {
        seg.setPosicion((int) zona.getX() + 14, (int) zona.getY() + 20);
    }
}
