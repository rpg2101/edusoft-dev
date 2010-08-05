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

    public static void main(String[] args) {
        //Creo el tablero de juego
        lienzo = new Lienzo();
        
        //Recolecto los nombres de los jugadores
        final TextField txbx1, txbx2, txbx3, txbx4;
        final JFrame fr = new JFrame("Jugadores");
        fr.setBounds(50, 50, 350, 230);
        fr.setLayout(null);
        JLabel jl1 = new JLabel("Ingrese los nombres de cada jugador y presione Ok");
        jl1.setBounds(10, 5, 340, 20);
        fr.add(jl1);
        JLabel jl2 = new JLabel("Nombre del Jugador:");
        jl2.setBounds(40, 50, 150, 20);
        fr.add(jl2);
        JLabel jl3 = new JLabel("Nombre del Jugador:");
        jl3.setBounds(40, 80, 150, 20);
        fr.add(jl3);
        JLabel jl4 = new JLabel("Nombre del Jugador:");
        jl4.setBounds(40, 110, 150, 20);
        fr.add(jl4);
        JLabel jl5 = new JLabel("Nombre del Jugador:");
        jl5.setBounds(40, 140, 150, 20);
        fr.add(jl5);
        txbx1 = new TextField("Jugador");
        txbx2 = new TextField("Jugador");
        txbx3 = new TextField("Jugador");
        txbx4 = new TextField("Jugador");
        txbx1.setBounds(175, 50, 100, 20);
        txbx2.setBounds(175, 80, 100, 20);
        txbx3.setBounds(175, 110, 100, 20);
        txbx4.setBounds(175, 140, 100, 20);
        fr.add(txbx1);
        fr.add(txbx2);
        fr.add(txbx3);
        fr.add(txbx4);
        JButton b = new JButton("Ok");
        b.setBounds(135, 180, 60, 20);
        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                lienzo.getZonas().get(0).setID(txbx1.getText());
                lienzo.getZonas().get(1).setID(txbx2.getText());
                lienzo.getZonas().get(2).setID(txbx3.getText());
                lienzo.getZonas().get(3).setID(txbx4.getText());
                lienzo.repartir();
                fr.setVisible(false);
                lienzo.setVisibilidad(true);
            }
        });
        fr.add(b);
        fr.setVisible(true);

    }

    private static Lienzo getLienzo(){
        return lienzo;
    }
}
