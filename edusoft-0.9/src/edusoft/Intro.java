/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edusoft;


import edusoft.ventanas.Panelconfondo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author rpg
 */
public class Intro {
    public Intro() {
        final JFrame frame = new JFrame("Proyecto Educativo");
        frame.setLayout(null);
        frame.setBounds(0, 0, 800, 600);
        frame.setResizable(false);
        Panelconfondo panel = new Panelconfondo("inicio.jpg");
        panel.setLayout(null);
        panel.setBounds(20, 20, frame.getWidth()-50, frame.getHeight()-70);
        panel.setBackground(Color.LIGHT_GRAY);
        JButton sig = new JButton ("Iniciar");
        sig.setBounds((panel.getWidth()/2)-60, panel.getHeight()-50, 100, 30);
        sig.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                MenuEdu m = new MenuEdu();
                frame.dispose();
            }
        });
        panel.add(sig);
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