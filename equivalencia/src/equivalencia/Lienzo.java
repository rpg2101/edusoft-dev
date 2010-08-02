/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package equivalencia;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import equivalencia.piezas.*;

/**
 *
 * @author Hector Rattis
 */
public class Lienzo extends Canvas implements MouseInputListener {

    private Vector<Trofeo> trofeos;
    private Vector<Pieza> mesa;
    private boolean sobrePieza;

    public Lienzo() {
        // Defino dimiensiones y color de fondo
        this.setBounds(0, 0, 800, 600);
        this.setBackground(Color.WHITE);

        // Agrego los MouseListener
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        //Inicializo variables
        //piezas = new Vector();
        mesa = new Vector();
        trofeos = new Vector();
        sobrePieza = false;

        //Genero las Piezas
        generarPiezas();

        // Genero el marco
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 800, 600);
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
        g2.setFont(new Font("Serif", Font.BOLD, 20));
        g2.drawString("¿Cuantas piezas de un color necesito para formar una pieza de otro color ?",
                20, 35);

        g2.setColor(Color.BLACK);
        // Rectangulo derecha
        g2.drawRect(this.getX() + 140, this.getY() + 55, 160, 160);
        // Rectangulo izquierda
        g2.drawRect(this.getX() + 490, this.getY() + 55, 160, 160);
        // Rectangulo abajo
        g2.drawRect(this.getX() + 20, this.getHeight() - 180, 750, 160);
        // Rectangulo arriba
        g2.drawRect(this.getX() + 20, this.getHeight() - 345, 750, 160);
        // Rutina que dibuja los trofeos
        Iterator tr = trofeos.iterator();
        while (tr.hasNext()) {
            Trofeo tmp = (Trofeo) tr.next();
            tmp.pintarse(g, this);
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
        trofeos.add(new Trofeo(30, this.getHeight() - 170, 150, "trofeo_medio.png"));
    }

    private void trofeoCuarto() {
        trofeos.add(new Trofeo(200, this.getHeight() - 170, 150, "trofeo_cuarto.png"));
    }

    private void trofeoOctavo() {
        trofeos.add(new Trofeo(370, this.getHeight() - 170, 150, "trofeo_octavo.png"));
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
                sobrePieza = true;
            } else {
                tmp.setPressOut(true);
                sobrePieza = false;
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
            if (tmp.segArrastre().contains(me.getX(), me.getY()) && sobrePieza) {
                tmp.actulizaPosicion(me);
                //Alinea piezas al medio patron de juego
                this.alinearPatron(tmp);
                sobrePieza = false;
            } else {
                tmp.setPressOut(false);
                sobrePieza = true;
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
            ventanaEntero();
        } catch (Exception e) {
        }
    }

    private void ventanaEntero() {
        JFrame f = new JFrame("Fracciones");
        f.setBounds(getWidth() / 2 - 100, getHeight() / 2 - 100, 200, 100);
        f.setResizable(false);
        JPanel p = new JPanel();
        JLabel l = new JLabel();
        l.setText("!Muy Bien¡\n" + "\n!Así se hace!");
        JButton b = new JButton("Continuar");
        p.add(b);
        p.add(l);
        f.add(p);
        f.setVisible(true);
    }

    private void generarPiezas() {
        int x_pos = getX() + 35;
        int y_pos = 235;
        //Medio Patron
        mesa.add(new Medio(170, 60, 90, this));
        mesa.firstElement().setPatron(true);
        int ainicial = 90;
        //Cuartos
        for (int i = 0; i < 4; i++) {
            mesa.add(new Cuarto(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 90;
        }
        //Sectos
        ainicial = 90;
        x_pos = x_pos + 190;
        for (int i = 0; i < 6; i++) {
            mesa.add(new Sexto(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 60;
        }
        //Octavos
        ainicial = 90;
        x_pos = x_pos + 190;
        for (int i = 0; i < 8; i++) {
            mesa.add(new Octavo(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 45;
        }
        //Doceavos
        ainicial = 90;
        x_pos = x_pos + 190;
        for (int i = 0; i < 12; i++) {
            mesa.add(new Doceavo(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 30;
        }

    }

    // Area de accion del click del mouse
    private Rectangle areaMouse(MouseEvent me) {
        return new Rectangle(me.getX() - 10, me.getY() - 10, 20, 20);
    }

    private void alinearPatron(Pieza p) {
        Rectangle patron = new Rectangle(this.getX() + 490, this.getY() + 55, 160, 160);
        if (patron.contains(p.segArrastre())) {
            p.setPosicion((int)patron.getX()+5,(int)patron.getY()+5);
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
