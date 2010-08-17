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

    public void pregunta(final Lienzo lz) {
        setBounds(lz.getWidth() / 2 - 100, lz.getHeight() / 2 - 100, 280, 200);
        JPanel p = new JPanel();
        p.setLayout(null);
        String str = "<html>" + "Cuantas piezas de mismo color" + "<br>"
                + "necesitaste para armar un entero:" + "<br>" + "</html>";
        JLabel mensaje = new JLabel(str);
        mensaje.setBounds(27, 3, 230, 50);
        p.add(mensaje);
        //Checkbox
        JLabel lb_cua = new JLabel("<html>" + "1" + "<br>" + "4" + "</html>");
        lb_cua.setBounds(40, 50, 40, 40);
        p.add(lb_cua);
        final JCheckBox chkcuarto = new JCheckBox();
        chkcuarto.setBounds(55, 55, 20, 20);
        p.add(chkcuarto);
        JLabel lb_oct = new JLabel("<html>" + "1" + "<br>" + "8" + "</html>");
        lb_oct.setBounds(110, 50, 40, 40);
        p.add(lb_oct);
        final JCheckBox chkoctavo = new JCheckBox();
        chkoctavo.setBounds(125, 55, 20, 20);
        p.add(chkoctavo);
        JLabel lb_doc = new JLabel("<html>" + "  1" + "<br>" + "12" + "</html>");
        lb_doc.setBounds(170, 50, 40, 40);
        p.add(lb_doc);
        final JCheckBox chkdoceavo = new JCheckBox();
        chkdoceavo.setBounds(185, 55, 20, 20);
        p.add(chkdoceavo);
        //Boton
        JButton b = new JButton("Comprobar");
        b.setBounds(55, getHeight() - 60, 150, 25);
        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                System.out.println(chkcuarto.isSelected() + " " + chkoctavo.isSelected()
                        + " " + chkdoceavo.isSelected());
                lz.resetPiezas();
                dispose();
            }
        });
        p.add(b);
        //Añado el panel al frame
        add(p);
        setVisible(true);
    }
}
