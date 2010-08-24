/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segmcolor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author curio
 */
public class VentanaAnuncio extends JFrame {

    VentanaAnuncio() {
        this.setTitle("Fracciones");
        setBounds(800 / 2 - 100, 600 / 2 - 100, 270, 100);
        setResizable(false);
    }

    public void anuncioEntero(String mensaje) {
        JPanel p = new JPanel();
        p.setLayout(null);
        JLabel l = new JLabel();
        l.setBounds(25, 3, 230, 50);
        l.setText(mensaje);
        JButton b = new JButton("Continuar");
        b.setBounds(55, 45, 150, 25);
        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
        p.add(b);
        p.add(l);
        add(p);
        setVisible(true);

    }

}
