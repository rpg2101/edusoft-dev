/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segmsincolor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author curio
 */
public class VentanaAnuncio extends JFrame {

    VentanaAnuncio ventana;
    Lienzo  lienzo;

    public VentanaAnuncio(Lienzo lz) {
        this.setTitle("Fracciones");
        setBounds(800 / 2 - 100, 600 / 2 - 100, 270, 100);
        setResizable(false);
        lienzo = lz;
        ventana = this;
    }

    public void anuncioEntero(String mensaje, final Lienzo lz) {
        JPanel p = new JPanel();
        p.setLayout(null);
        JLabel l = new JLabel();
        l.setBounds(25, 3, 230, 50);
        l.setText(mensaje);
        JButton b = new JButton("Continuar");
        b.setBounds(55, 45, 150, 25);
        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                lz.resetPiezas();
                dispose();
                if (lz.getPremios()[0]&&lz.getPremios()[1]&&lz.getPremios()[2]
             && lz.getPremios()[3] && lz.getPremios()[4] && lz.getPremios()[5]) {

                    final JFrame exit = new JFrame();
                    exit.setTitle("Fracciones");
                    exit.setBounds(800 / 2 - 100, 600 / 2 - 100, 370, 100);
                    exit.setResizable(false);
                    JButton salida = new JButton("Continuar");
                    salida.setBounds(75, 45, 150, 25);
                    salida.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            exit.dispose();
                            ventana.dispose();
                            lienzo.getFrame().dispose();
                        }
                    });
                    JLabel lab = new JLabel();
                    lab.setBounds(35, 3, 330, 50);
                    lab.setText("¡Excelente! ¡Lograste formar todos los enteros!");
                    exit.add(salida);
                    exit.add(lab);
                    exit.setVisible(true);
                }
            }
        });
        p.add(b);
        p.add(l);
        add(p);
        setVisible(true);

    }

    public void pregunta(Lienzo lz) {
        new WinPregunta(lz);
    }
}
