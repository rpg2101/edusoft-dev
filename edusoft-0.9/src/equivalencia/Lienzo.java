/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package equivalencia;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import equivalencia.piezas.*;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 *
 * @author Hector Rattis
 */
public class Lienzo extends Canvas implements MouseInputListener {

    private Vector<Trofeo> trofeos;
    private Vector<Pieza> mesa;
    private boolean[] premios;
    private boolean sobrePieza;
    private Image imag;
    private Graphics gBuffer;
    private JFrame frame;
    protected JTextArea numerador, denominador;
    private JButton comprobar;

    public Lienzo() {
        premios = new boolean[4];
        premios[0] = false;
        premios[1] = false;
        premios[2] = false;
        premios[3] = false;
        frame = new JFrame();
        frame.setBounds(0, 0, 800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Fracciones");
        comprobar = new JButton("Comprobar");
        comprobar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String check = new String(chk());
                if (check.equals("Cuarto") && (numerador.getText().equals("2")) && (denominador.getText().equals("4"))) {
                    generarTrofeo(check);
                    premios[0] = true;
                    numerador.setText(null);
                    denominador.setText(null);
                    ventana("¡Muy Bien! ¡Asi se hace!");
                } else if (check.equals("Sexto")&& (numerador.getText().equals("3")) && (denominador.getText().equals("6"))) {
                    generarTrofeo(check);
                    premios[1] = true;
                    ventana("¡Muy Bien! ¡Asi se hace!");
                } else if (check.equals("Octavo")&& (numerador.getText().equals("4")) && (denominador.getText().equals("8"))) {
                    generarTrofeo(check);
                    premios[2] = true;
                    ventana("¡Muy Bien! ¡Asi se hace!");
                } else if (check.equals("Doceavo")&& (numerador.getText().equals("6")) && (denominador.getText().equals("12"))) {
                    generarTrofeo(check);
                    premios[3] = true;
                    ventana("¡Muy Bien! ¡Asi se hace!");
                } else if (check.equals("distintoColor")) {
                    ventana("Las piezas no son del mismo color");
                } else {
                    ventana("Intentalo de nuevo");
                }


            }
        });
        comprobar.setBounds(320, 110, 150, 30);
        numerador = new JTextArea();
        denominador = new JTextArea();
        numerador.setFont(new Font("Serif", Font.BOLD, 50));
        denominador.setFont(new Font("Serif", Font.BOLD, 50));
        numerador.setBackground(Color.LIGHT_GRAY);
        denominador.setBackground(Color.LIGHT_GRAY);
        numerador.setBounds(680, 70, 70, 50);
        denominador.setBounds(680, 140, 70, 50);
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

        frame.add(numerador);
        frame.add(denominador);
        frame.add(comprobar);
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
        //Preparo el graphics
        Graphics2D g2 = (Graphics2D) g;

        //Dibujo los elementos
        g2.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER));
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));
        g2.setColor(Color.BLACK);

        // Titulo y Cartel de trofeos
        g2.setFont(new Font("Serif", Font.BOLD, 21));
        g2.drawString("¿Cuantas piezas de un color necesito para formar otro medio?",
                25, 35);
        // Fraccion fija
        g2.setFont(new Font("Serif", Font.BOLD, 50));
        g2.drawString("1", 60, 120);
        g2.drawString("__", 55, 120);
        g2.drawString("2", 60, 180);

        //Fraccion Variable
        g2.drawString("__", 690, 120);

        if (this.premios[0]) {
            g2.drawString("2", 125, this.getHeight() - 110);
            g2.drawString("__", 120, this.getHeight() - 105);
            g2.drawString("4", 125, this.getHeight() - 50);
        }
        if (this.premios[1]) {
            g2.drawString("3", 125 + 190, this.getHeight() - 110);
            g2.drawString("__", 120 + 190, this.getHeight() - 105);
            g2.drawString("6", 125 + 190, this.getHeight() - 50);
        }
        if (this.premios[2]) {
            g2.drawString("4", 125 + 190 * 2, this.getHeight() - 110);
            g2.drawString("__", 120 + 190 * 2, this.getHeight() - 105);
            g2.drawString("8", 125 + 190 * 2, this.getHeight() - 50);
        }
        if (this.premios[3]) {
            g2.drawString("6", 140 + 190 * 3, this.getHeight() - 110);
            g2.drawString("__", 130 + 190 * 3, this.getHeight() - 105);
            g2.drawString("12", 120 + 190 * 3, this.getHeight() - 50);
        }
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

    }

    public void resetPiezas() {
        Iterator it = mesa.iterator();
        while (it.hasNext()) {
            ((Pieza) it.next()).resetPosicion();
        }
        repaint();
    }

    public void ventana(String mensaje) {
        final JFrame f = new JFrame("Fracciones");
        f.setBounds(getWidth() / 2 - 100, getHeight() / 2 - 100, 290, 100);
        f.setResizable(false);
        JPanel p = new JPanel();
        p.setLayout(null);
        JLabel l = new JLabel();
        l.setBounds(25, 3, 230, 50);
        if (premios[0] && premios[1] && premios[2]) {
            mensaje = "¡Muy bien!¡Armaste 3 Enteros!";
        }
        l.setText(mensaje);
        JButton b = new JButton("Continuar");
        b.setBounds(55, 45, 150, 25);
        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                resetPiezas();
                f.dispose();

            }
        });
        p.add(b);
        p.add(l);
        f.add(p);
        f.setVisible(true);
    }

    public void generarTrofeo(String mensaje) {
        int ainicial = 90;
        if (mensaje.equals("Cuarto")) {
            for (int i = 0; i < 2; i++) {
                mesa.add(new Cuarto(35, this.getHeight() - 175, ainicial, this));
                ainicial = ainicial + 90;

            }
        } else if (mensaje.equals("Sexto")) {
            for (int i = 0; i < 3; i++) {
                mesa.add(new Sexto(35 + 190, this.getHeight() - 175, ainicial, this));
                ainicial = ainicial + 60;

            }
        } else if (mensaje.equals("Octavo")) {
            for (int i = 0; i < 4; i++) {
                mesa.add(new Octavo(35 + 190 + 190, this.getHeight() - 175, ainicial, this));
                ainicial = ainicial + 45;
            }
        } else if (mensaje.equals("Doceavo")) {
            for (int i = 0; i < 6; i++) {
                mesa.add(new Doceavo(35 + 190 + 190 + 190, this.getHeight() - 175, ainicial, this));
                ainicial = ainicial + 30;

            }
        }
    }

    private void generarPiezas() {
        int x_pos = getX() + 35;
        int y_pos = 230;
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
            p.setPosicion((int) patron.getX() + 5, (int) patron.getY() + 5);
        } else {
            p.resetPosicion();
        }
    }

    private Graphics getGB() {
        return gBuffer;
    }

    private void setGB(Graphics gr) {
        gBuffer = gr;
    }

    private String chk() {
        boolean congruentes = false;
        Vector<Pieza> alineados = new Vector();
        //Sumo los angulos de las piezas
        Iterator it = mesa.iterator();
        Pieza patron = mesa.firstElement();
        int sumaAngulos = 0;
        //Remuevo la pieza patron de la lista de chequeo
        it.next();
        while (it.hasNext()) {
            Pieza p = (Pieza) it.next();
            //Seleccione solo las piezas alineadas a la pieza patron
            if (p.getX() == 495) {
                // Chequeo que la pieza
                if (patron.ckInnerAng(p.getAnginicial())) {
                    sumaAngulos = sumaAngulos + p.getAngfinal();
                    alineados.add(p);
                    patron = p;
                }
            }
        }
        System.out.println(sumaAngulos);
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
        if (sumaAngulos == 180 && congruentes) {
            tmp = alineados.firstElement().getClass().getSimpleName();
        }
        System.out.println(tmp);
        return tmp;
    }
}
