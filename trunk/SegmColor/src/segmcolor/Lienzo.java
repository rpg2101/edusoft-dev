/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segmcolor;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

        //Genero las 35 Piezas
        generarPiezas();

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
    public void Repartir() {
        Random gene = new Random();
        for (int i = mesa.size(); i < 3; i++) {
            Pieza tmp = piezas.remove(gene.nextInt(piezas.size()));
            tmp.setX(150 + (250 * i));
            tmp.setY(this.getHeight() / 6);
            mesa.add(tmp);
        }
    }

//   @Override
//    public void update(Graphics g) {
//        paint(g);
//    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.drawRect(20, 50, 950, 280);

        g2.drawRect(20, 350, 227, 300);
        g2.drawRect(262, 350, 227, 300);
        g2.drawRect(503, 350, 227, 300);
        g2.drawRect(745, 350, 227, 300);

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
        while(itr.hasNext()){
            Pieza tmp = (Pieza)itr.next();
            if(!tmp.getPressOut()){
                tmp.actulizaPosicion(me);
            }
        }
    }

    public void mouseMoved(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
        /**
         * Aqui inspeccionamos todas las piezas en la mesa buscando la que
         * tenga el area que coincida con el x e y del mouse.
         */
        Iterator mesaitr = mesa.iterator();
        while (mesaitr.hasNext()) {
            Pieza tmp = (Pieza) mesaitr.next();
            tmp.setLastPosicion((tmp.getX()) - me.getX(),(tmp.getY()) - me.getY());
            if (tmp.rect().contains(me.getX(), me.getY())) {
                tmp.actulizaPosicion(me);
            } else {
                tmp.setLastPosicion(((int) tmp.rect().getX()) + me.getX(),
                        ((int) tmp.rect().getY()) + me.getY());
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
            if (tmp.rect().contains(me.getX(), me.getY())) {
                tmp.actulizaPosicion(me);
            } else {
                tmp.setPressOut(false);
            }
        }
    }

    private void generarPiezas() {
        //Medios
        int ainicial = 90;
        for (int i = 0; i < 2; i++) {
            piezas.add(new Medio(100, 50, 150, ainicial, this));
            ainicial = ainicial + 180;
        }
        //Tercios
        ainicial = 90;
        for (int i = 0; i < 3; i++) {
            piezas.add(new Tercio(300, 50, 150, ainicial, this));
            ainicial = ainicial + 120;
        }
        //Cuartos
        ainicial = 90;
        for (int i = 0; i < 4; i++) {
            piezas.add(new Cuarto(500, 50, 150, ainicial, this));
            ainicial = ainicial + 90;
        }
        //Sectos
        ainicial = 90;
        for (int i = 0; i < 6; i++) {
            piezas.add(new Secto(100, 200, 150, ainicial, this));
            ainicial = ainicial + 60;
        }
        //Octavos
        ainicial = 90;
        for (int i = 0; i < 8; i++) {
            piezas.add(new Octavo(300, 200, 150, ainicial, this));
            ainicial = ainicial + 45;
        }
        //Doceavos
        ainicial = 90;
        for (int i = 0; i < 12; i++) {
            piezas.add(new Doceavo(200, 100, 200, ainicial, this));
            ainicial = ainicial + 30;
        }
    }
}
