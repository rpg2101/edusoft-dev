/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segmsincolor;

import segmsincolor.piezas.*;
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author Hector Rattis
 */
public class Lienzo extends Canvas implements MouseInputListener {

    private Vector<Trofeo> trofeos;
    private Vector<Pieza> mesa;
    private boolean sobrePieza;
    private boolean[] premios;
    private Image imag;
    private Graphics gBuffer;
    private JFrame frame;

    public Lienzo() {
        // Defino dimiensiones y color de fondo
        // Genero el marco
        frame = new JFrame();
        frame.setBounds(0, 0, 800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Fracciones");
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
        premios = new boolean[3];
        premios[0] = false;
        premios[1] = false;
        premios[2] = false;

        //Genero las Piezas
        generarPiezas();
        frame.add(this);
        frame.setVisible(true);
        this.mouseClicked(null);
    }

    public Vector<Pieza> getMesa() {
        return mesa;
    }

    @Override
    public void update(Graphics g) {
        if (getGB() == null) {
            imag = createImage(getWidth(), getHeight());
            setGB(imag.getGraphics());
        }
        getGB().setColor(getBackground());
        getGB().fillRect(0, 0, getWidth(), getHeight());
        //Llamamos a paint
        paint(getGB());
        g.drawImage(imag, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //Dibujo los elementos
        g2.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER));
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));
        g2.setColor(Color.BLACK);
        // Titulo y Cartel de trofeos
        g2.setFont(new Font("Serif", Font.BOLD, 25));
        g2.drawString("Completar el entero usando piezas del mismo color",
                40, 35);
        g2.setFont(new Font("Serif", Font.BOLD, 20));
        g2.drawString("Combinaciones obtenidas:", 20, this.getHeight() - 210);

        //Dibujo el recuadro mas grande
        g2.drawRect(getWidth() - 190, 60, 165, 480);

        // Rutina que dibuja los trofeos
        Iterator tr = trofeos.iterator();
        while (tr.hasNext()) {
            Trofeo tmp = (Trofeo) tr.next();
            tmp.pintarse(g2, this);
        }

        // Rutina que dibuja las piezas
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
                break;
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
        VentanaAnuncio anuncio = new VentanaAnuncio();
        Vector<Pieza> alineados = new Vector();
        Iterator mesaitr = mesa.iterator();
        while (mesaitr.hasNext()) {
            Pieza tmp = (Pieza) mesaitr.next();
            if (tmp.segArrastre().contains(me.getX(), me.getY()) && sobrePieza) {
                tmp.actulizaPosicion(me);
                //Alinea piezas al medio patron de juego
                this.alinearPatron(tmp);
                alineados.add(tmp);
                sobrePieza = false;
            } else {
                tmp.setPressOut(false);
                sobrePieza = true;
            }
        }
        try {
            //Verifico que forme un entero y anuncio el resultado
            String enteroschk = chkEnteros();
            if (enteroschk.equals("Doceavo") || enteroschk.equals("Cuarto") || enteroschk.equals("Octavo")) {
                if (enteroschk.equals("Doceavo")) {
                    //Llama a la ventana de pregunta
                    trofeos.add(new Trofeo(30, this.getHeight() - 170, 150, "trofeo_medio.png"));
                    premios[0] = true;
                } else if (enteroschk.equals("Cuarto")) {
                    anuncio.pregunta(this);
                    trofeos.add(new Trofeo(200, this.getHeight() - 170, 150, "trofeo_cuarto.png"));
                    premios[1] = true;
                } else if (enteroschk.equals("Octavo")) {
                    trofeos.add(new Trofeo(370, this.getHeight() - 170, 150, "trofeo_octavo.png"));
                    premios[2] = true;
                }
                //anuncio.anuncioEntero("¡Muy Bien! ¡Asi se hace!", this);
            } else if (enteroschk.equals("distintoColor")) {
                anuncio.anuncioEntero("Prueba de nuevo", this);
            }

        } catch (Exception e) {
        }
    }

    private void generarPiezas() {
        int x_pos = getWidth() - 190;
        int y_pos = 70;
        //Medio Patron
        mesa.add(new Medio(80, 100, 90, this));

        int ainicial = 90;
        //Medios
        for (int i = 0; i < 12; i++) {
            mesa.add(new Doceavo(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 30;
        }
        //Cuartos
        ainicial = 90;
        y_pos = y_pos + 155;
        for (int i = 0; i < 4; i++) {
            mesa.add(new Cuarto(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 90;
        }
        //Octavos
        ainicial = 90;
        y_pos = y_pos + 155;
        for (int i = 0; i < 8; i++) {
            mesa.add(new Octavo(x_pos, y_pos, ainicial, this));
            ainicial = ainicial + 45;
        }

        // Asigno las piezas patron
        mesa.get(0).setPatron(true);
        mesa.get(1).setPatron(true);
        mesa.get(2).setPatron(true);
        mesa.get(3).setPatron(true);
        mesa.get(4).setPatron(true);
        mesa.get(5).setPatron(true);
        mesa.get(6).setPatron(true);
        mesa.get(13).setPatron(true);
        mesa.get(14).setPatron(true);
        mesa.get(17).setPatron(true);
        mesa.get(18).setPatron(true);
        mesa.get(19).setPatron(true);
        mesa.get(20).setPatron(true);
    }

    public void resetPiezas() {
        Iterator it = mesa.iterator();
        while (it.hasNext()) {
            ((Pieza) it.next()).resetPosicion();
        }
        repaint();
    }

    // Area de accion del click del mouse
    private Rectangle areaMouse(MouseEvent me) {
        return new Rectangle(me.getX() - 2, me.getY() - 2, 4, 4);
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
                sumaAngulos = sumaAngulos + p.getAngfinal();
                alineados.add(p);
                patron = p;
            }
        }
        //Verifico que las piezas sean todas iguales
        Color tmpColor = Color.white;
        tmpColor = alineados.firstElement().getColor();

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
        String tmp = "nulo";
        if (sumaAngulos == 360) {
            if (congruentes) {
                tmp = alineados.firstElement().getClass().getSimpleName();
            } else {
                tmp = "distintoColor";
            }
        }
        return tmp;
    }

    private Graphics getGB() {
        return gBuffer;
    }

    private void setGB(Graphics graphics) {
        gBuffer = graphics;
    }

    public boolean getPremio(int i) {
        return premios[i];
    }
}