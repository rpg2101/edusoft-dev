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
        for (int i = 0; i < 12; i++) {
            l.getMesa().add(new Doceavo(300, 300, 200, ainicial, l));
            ainicial = ainicial + 30;
        }

        ainicial = 90;
        for (int i = 0; i < 3; i++) {
            l.getMesa().add(new Tercio(100, 100, 200, ainicial, l));
            ainicial = ainicial + 120;
        }
    }

}
