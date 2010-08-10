/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edusoft;

import edusoft.ventanas.Fracc1;
import edusoft.ventanas.Panelconfondo;
import equivalencia.Equivalencia;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import segmsincolor.SegSC;

/**
 *
 * @author rpg
 */
class MenuEdu {

    public MenuEdu() {
        final JFrame frame = new JFrame("Proyecto Educativo");
        frame.setLayout(null);
        frame.setBounds(0, 0, 800, 600);
        frame.setResizable(false);
        Panelconfondo panel = new Panelconfondo("inicio.jpg");
        panel.setLayout(null);
        panel.setBounds(20, 20, frame.getWidth() - 50, frame.getHeight() - 150);
        panel.setBackground(Color.LIGHT_GRAY);
        JPanel p = new JPanel();
        p.setBounds(20, frame.getHeight()-120 , frame.getWidth()-50 ,70 );

        JButton b1 = new JButton("Rectangulo");
        JButton b2 = new JButton("Circulos 1");
        JButton b3 = new JButton("Circulos 2");
        JButton b4 = new JButton("Equivalencias");
        JButton salir = new JButton("Salir");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Fracc1 f = new Fracc1();
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SegSC ssc = new SegSC ();
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuEdu m = new MenuEdu();
            }
        });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Equivalencia eq = new Equivalencia();
            }
        });
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        p.setLayout(new GridLayout (3,1));
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(salir);
        frame.add(panel);
        frame.add(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}
