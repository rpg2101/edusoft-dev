/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edusoft.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author rpg
 */
public class Fracc1 {
        
    public Fracc1 (){
        final JFrame frame = new JFrame("Proyecto Educativo - Fracciones");
        frame.setLayout(null);
        frame.setBounds(0, 0, 800, 600);
        frame.setResizable(false);
        Lienzo panel = new Lienzo(frame);
        frame.setLayout(null);
        panel.setBounds(20, 20, frame.getWidth()-50, frame.getHeight()-70);
        JButton sig = new JButton ("Salir");
        sig.setBounds(panel.getWidth()-120, panel.getHeight()-50, 100, 30);
        sig.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
