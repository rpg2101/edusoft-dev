package segmcolor;

import piezas.*;

/**
 *
 * @author curio
 */
public class SegMain {

    public static void main(String[] args){
        Lienzo l = new Lienzo();
        //l.Repartir();
        //test
        int ainicial = 90;
        for (int i = 0; i < 3; i++) {
            l.getMesa().add(new Tercio(300, 50, 150, ainicial, l));
            ainicial = ainicial + 120;
        }
    }

}
