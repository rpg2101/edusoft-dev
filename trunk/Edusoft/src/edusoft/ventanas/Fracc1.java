/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edusoft.ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author rpg
 */
class Fracc1 {
        
    public Fracc1 (){
        final JFrame frame = new JFrame("Proyecto Educativo - Fracciones");
        frame.setLayout(null);
        frame.setBounds(0, 0, 1008, 725);
        frame.setResizable(false);
        Lienzo panel = new Lienzo();
        frame.setLayout(null);
        panel.setBounds(20, 20, frame.getWidth()-40, frame.getHeight()-70);
        JButton sig = new JButton ("Salir");
        sig.setBounds(panel.getWidth()-120, panel.getHeight()-50, 100, 30);
        sig.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
           public void windowClosing(WindowEvent e){
             System.exit(0);
           }
        }
        );
        frame.setVisible(true);
    }
}
