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

    public ZonaPlayer(int x0, int y0, int ancho, int alto) {
        super(x0, y0, ancho, alto);
        cant_enteros = 0;
        entero = new Vector();
    }

    public int getCantEnteros() {
        return cant_enteros;
    }

    public void sumaEntero() {
        cant_enteros++;
    }

    public void pintarse(Graphics2D g) {
        Iterator itr = entero.iterator();
        while(itr.hasNext()){
            Pieza p = (Pieza)itr.next();
            p.pintarse(g);
        }
        g.setFont(new Font("Times", Font.TRUETYPE_FONT, 24));
        g.drawString("Enteros: " + String.valueOf(cant_enteros),
                (int) this.getX() + 55, (int) this.getMaxY() - 10);
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

    public Vector getEntero(){
        return entero;
    }
}
