package segmcolor;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Vector;
import segmcolor.piezas.Pieza;

/**
 *
 * @author Hector Rattis
 */
public class ZonaPlayer extends Rectangle {

    private int cant_enteros;
    private Vector<Pieza> entero;
    private String nombre;

    public ZonaPlayer(int x0, int y0, int ancho, int alto) {
        super(x0, y0, ancho, alto);
        cant_enteros = 0;
        entero = new Vector();
        nombre = "Jugador";
    }

    public int getCantEnteros() {
        return cant_enteros;
    }

    public void sumaEntero() {
        cant_enteros++;
    }

    public void setID(String name){
        nombre = name;
    }

    public void pintarse(Graphics2D g) {
        // Dibuja los carteles
        g.setFont(new Font("Times", Font.TRUETYPE_FONT, 20));
        g.drawString("Enteros: " + String.valueOf(cant_enteros),
                (int) getX() + 40, (int) getMaxY() - 5);
        g.drawString(nombre, (int) getX() + 40, (int) getMaxY() + 25);
        g.draw(this);
    }

    public void addSegmento(Pieza p) {
        if (!entero.isEmpty()) {
            Iterator it = entero.iterator();
            try {
                while (it.hasNext()) {
                    Pieza tmp = (Pieza) it.next();
                    if (!tmp.equals(p)) {
                        System.out.println("Añadido " + p + " numero de piezas " + entero.size());
                        entero.add(p);
                    }
                }
            } catch (Exception e) {
            }
        } else {
            System.out.println("Añadido " + p + " numero de piezas " + entero.size());
            entero.add(p);
        }
    }

    public void removeSegmento(Pieza p) {
        Iterator itr = entero.iterator();
        while (itr.hasNext()) {
            Pieza tmp = (Pieza) itr.next();
            if (tmp.equals(p)) {
                entero.removeElement(p);
            }
        }
    }

    public Vector getEntero() {
        return entero;
    }

    private boolean chkEnteros() {
        //Sumo los angulos de las piezas
        int sumaAngulos = 0;
        Iterator it = entero.iterator();
        while (it.hasNext()) {
            Pieza p = (Pieza) it.next();
            //Seleccione solo las piezas alineadas a la pieza patron
            // Chequeo que la pieza
            sumaAngulos = sumaAngulos + p.getAngfinal();
        }

        //Preparo la respuesta de la funcion
        boolean tmp = false;
        if (sumaAngulos == 360) {
            tmp = true;
        }

        // Devuelvo el resultado
        return tmp;
    }
}
