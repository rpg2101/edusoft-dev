/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segmsincolor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author curio
 */
public class VentanaAnuncio extends JFrame {

    public VentanaAnuncio() {
        this.setTitle("Fracciones");
        setBounds(800 / 2 - 100, 600 / 2 - 100, 270, 100);
        setResizable(false);
    }

    public void anuncioEntero(String mensaje, final Lienzo lz) {
        JPanel p = new JPanel();
        p.setLayout(null);
        JLabel l = new JLabel();
        l.setBounds(25, 3, 230, 50);
        if (lz.getPremio(0) && lz.getPremio(1) && lz.getPremio(2)) {
            mensaje = "¡Muy bien!¡Armaste 3 Enteros!";
        }
        l.setText(mensaje);
        JButton b = new JButton("Continuar");
        b.setBounds(55, 45, 150, 25);
        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                lz.resetPiezas();
                dispose();
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
