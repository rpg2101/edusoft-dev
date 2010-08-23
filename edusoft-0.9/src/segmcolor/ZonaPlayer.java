package segmcolor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import segmcolor.piezas.Pieza;

/**
 *
 * @author Hector Rattis
 */
public class ZonaPlayer extends Rectangle {

    private int cant_enteros;
    private Set<Pieza> entero;
    private String nombre;

    public ZonaPlayer(int x0, int y0, int ancho, int alto) {
        super(x0, y0, ancho, alto);
        cant_enteros = 0;
        entero = new HashSet<Pieza>();
        nombre = "Jugador";
    }

    public int getCantEnteros() {
        return cant_enteros;
    }

    public Set getEntero(){
        return entero;
    }

    public void resetSetEnteros(){
        entero.removeAll(entero);
    }

    public void setID(String name) {
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

    public boolean addSegmento(Pieza p) {
        boolean rt = false;
        try {
            rt = entero.add(p);
        } catch (Exception e) {
        }
        return rt;
    }

    public boolean removeSegmento(Pieza p) {
        boolean rt = false;
        try {
            rt = entero.remove(p);
        } catch (Exception e) {
        }
        return rt;
    }

    public boolean chkEnteros() {
        //Sumo los angulos de las piezas
        int sumaAngulos = 0;
        java.awt.Color tmp_color = getColor();
        Iterator<Pieza> it = entero.iterator();
        while (it.hasNext()) {
            Pieza p = it.next();
            //Seleccione solo las piezas alineadas a la pieza patron
            // Chequeo que la pieza
            if (!tmp_color.equals(p.getColor())) {
                return false;
            }
            sumaAngulos = sumaAngulos + p.getAngfinal();
        }
        //Preparo la respuesta de la funcion
        if (sumaAngulos == 360) {
            cant_enteros++;
            return true;
        }
        return false;
    }

    private Color getColor() {
        Iterator<Pieza> it = entero.iterator();
        return it.next().getColor();
    }
    
    public String getClase() {
        Iterator<Pieza> it = entero.iterator();
        return it.next().getClass().getSimpleName();
    }

}
