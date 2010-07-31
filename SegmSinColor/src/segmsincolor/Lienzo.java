/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segmsincolor;

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
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import piezas.*;

/**
 *
 * @author Hector Rattis
 */
public class Lienzo extends Canvas implements MouseInputListener {

    private Vector<Trofeo> trofeos;
    private Vector<Pieza> mesa;

    public Lienzo() {
        // Defino dimiensiones y color de fondo
        this.setBounds(0, 0, 1000, 700);
        this.setBackground(Color.WHITE);

        // Agrego los MouseListener
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        //Inicializo variables
        //piezas = new Vector();
        mesa = new Vector();
        trofeos = new Vector();

        //Genero las Piezas
        generarPiezas();

        // Genero el marco
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1008, 725);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Fracciones");
        frame.add(this);
        frame.setVisible(true);
        this.mouseClicked(null);
    }

    public Vector<Pieza> getMesa() {
        return mesa;
    }

//    @Override
//    public void update(Graphics g){
//        paint(g);
//    }
    @Override
    public void paint(Graphics g) {
        //Preparo el graphics
        //BufferedImage imagen = (BufferedImage)createImage(WIDTH,HEIGHT);
        Graphics2D g2 = (Graphics2D) g;

        //Dibujo los elementos
        g2.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER));
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));

        // Titulo y Cartel de trofeos
        g2.setFont(new Font("Serif", Font.BOLD, 30));
        g2.drawString("Completar el entero usando piezas del mismo color",
                100, 35);
        g2.setFont(new Font("Serif", Font.BOLD, 25));
        g2.drawString("Combinaciones obtenidas:", 50, this.getHeight() - 210);
        //Dibujo el recuadro mas grande
        g2.drawRect(getWidth() - 230, 60, 220, 620);

        // Rutina que dibuja los trofeos
        Iterator tr = trofeos.iterator();
        while (tr.hasNext()) {
            Trofeo tmp = (Trofeo) tr.next();
            tmp.pintarse(g);
        }

        // Rutina que dibuja las piezas
        Iterator p = mesa.iterator();
        while (p.hasNext()) {
            Pieza segmento = (Pieza) p.next();
            segmento.pintarse(g2);
        }
        //g2.drawImage(imagen, this, 0, 0);

    }

    //Metodos que adiciona los trofeos a la imagen
    private void trofeoMedio() {
        trofeos.add(new Trofeo(30, this.getHeight() - 190, 150, "Medio"));
    }

    private void trofeoCuarto() {
        trofeos.add(new Trofeo(260, this.getHeight() - 190, 150, "Cuarto"));
    }

    private void trofeoOctavo() {
        trofeos.add(new Trofeo(490, this.getHeight() - 190, 150, "Octavo"));
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
            if (!tmp.getPressOut() && !tmp.getPatron()) {
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
                break;
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
            tmp.setLastPosicion((tmp.getX()) - me.getX(), (tmp.getY()) - me.getY());
            if (tmp.segArrastre().contains(me.getX(), me.getY())) {
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
                //Alinea piezas al medio patron de juego
                this.alinearPatron(tmp);

            } else {
                tmp.setPressOut(false);
            }
        }
        //Verifico que forme un entero y anuncio el resultado
        try {
            if (chkEnteros().equals("Medio")) {
                trofeoMedio();
            }
            if (chkEnteros().equals("Cuarto")) {
                trofeoCuarto();
            }
            if (chkEnteros().equals("Octavo")) {
                trofeoOctavo();
            }
            //Ventana de anuncio
            JFrame f = new JFrame();
            f.setBounds(getWidth() / 2 - 100, getHeight() / 2 - 100, 200, 200);
            f.setResizable(false);
            JPanel p = new JPanel();
            JButton b = new JButton("Siguente");
            b.setAlignmentX(JButton.CENTER_ALIGNMENT);
            b.setAlignmentY(JButton.BOTTOM);
            p.add(b);
            f.add(p);
            f.setVisible(true);
        } catch (Exception e) {
        }
    }

    private void generarPiezas() {
        int x_pos = getWidth() - 220;
        int y_pos = 65;
        //Medio 
        mesa.add(new Medio(130, 150, 90, this));

        int ainicial = 90;
        //Medios
        for (int i = 0; i < 2; i++) {
            mesa.add(new Medio(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 180;
        }
        //Cuartos
        ainicial = 90;
        y_pos = y_pos + 205;
        for (int i = 0; i < 4; i++) {
            mesa.add(new Cuarto(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 90;
        }
        //Octavos
        ainicial = 90;
        y_pos = y_pos + 205;
        for (int i = 0; i < 8; i++) {
            mesa.add(new Octavo(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 45;
        }

        // Asigno las piezas patron
        mesa.get(0).setPatron(true);
        mesa.get(1).setPatron(true);
        mesa.get(3).setPatron(true);
        mesa.get(4).setPatron(true);
        mesa.get(7).setPatron(true);
        mesa.get(8).setPatron(true);
        mesa.get(9).setPatron(true);
        mesa.get(10).setPatron(true);
    }

    // Area de accion del click del mouse
    private Rectangle areaMouse(MouseEvent me) {
        return new Rectangle(me.getX() - 10, me.getY() - 10, 20, 20);
    }

    private void alinearPatron(Pieza p) {
        Rectangle patron = new Rectangle(mesa.firstElement().getX() - 50,
                mesa.firstElement().getY() - 50, 300, 300);
        if (patron.contains(p.segArrastre())) {
            p.setPosicion(mesa.firstElement().getX(), mesa.firstElement().getY());
        } else {
            p.resetPosicion();
        }
    }

    private String chkEnteros() {
        boolean congruentes = false;
        Vector<Pieza> alineados = new Vector();
        //Sumo los angulos de las piezas
        Iterator it = mesa.iterator();
        Pieza patron = mesa.firstElement();
        int sumaAngulos = patron.getAngfinal();
        //Remuevo la pieza patron de la lista de chequeo
        it.next();
        while (it.hasNext()) {
            Pieza p = (Pieza) it.next();
            //Seleccione solo las piezas alineadas a la pieza patron
            if (p.getX() == patron.getX() && p.getY() == patron.getY()) {
                // Chequeo que la pieza
                if (patron.ckInnerAng(p.getAnginicial())) {
                    sumaAngulos = sumaAngulos + p.getAngfinal();
                    alineados.add(p);
                    patron = p;
                }
            }
        }
        //Verifico que las piezas sean todas iguales
        Color tmpColor = null;
        try {
            tmpColor = alineados.firstElement().getColor();
        } catch (Exception e) {
        }
        Iterator al = alineados.iterator();
        while (al.hasNext()) {
            Pieza tmp = (Pieza) al.next();
            if (tmp.getColor().equals(tmpColor)) {
                congruentes = true;
            } else {
                congruentes = false;
            }
        }
        //Preparo la respuesta de la funcion
        String tmp = null;
        if (sumaAngulos == 360 && congruentes) {
            tmp = alineados.firstElement().getClass().getSimpleName();
        }
        return tmp;
    }
}
