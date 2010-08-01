package segmcolor;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Vector;
import piezas.Pieza;

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

    public void pintarse(Graphics2D g) {
        // Dibuja los carteles
        g.setFont(new Font("Times", Font.TRUETYPE_FONT, 20));
        g.drawString("Enteros: " + String.valueOf(cant_enteros),
                (int) getX() + 40, (int) getMaxY() - 5);
        g.drawString(nombre, (int) getX() + 40, (int) getMaxY() + 25);
        g.draw(this);
    }

    public void addSegmento(Pieza p) {
        entero.add(p);
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
}
