package segmcolor;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author curio
 */
public class SegMain {
    private static Lienzo lienzo;

    public SegMain() {
        //Creo el tablero de juego
        lienzo = new Lienzo();
        VentanaJugadores v = new VentanaJugadores(lienzo);

    }

    private static Lienzo getLienzo(){
        return lienzo;
    }
}
