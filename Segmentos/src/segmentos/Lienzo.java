/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package segmentos;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import java.util.Vector;
import javax.swing.JFrame;
import segmentos.piezas.Medio;
import segmentos.piezas.Pieza;

/**
 *
 * @author curio
 */
public class Lienzo extends Canvas{
    
    private Vector<Pieza> piezas;

    public Lienzo(){
        piezas = new Vector();
        piezas.add(new Medio(50,50,100,270,180,this));
        piezas.add(new Medio(50,50,100,90,180,this));
        piezas.add(new Medio(50,150,100,90,270,this));
        piezas.add(new Medio(400,51,100,270,360,this));
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1000, 1000);
        frame.setResizable(false);
        frame.setBackground(Color.GRAY);
        this.setBounds(50, 50, 00, 1400);
        this.setBackground(Color.LIGHT_GRAY);
        frame.setTitle("Prueba");
        frame.add(this);
        frame.setVisible(true);
        
    }

    public Vector<Pieza> getPiezas(){
        return piezas;
    }

    @Override
    public void paint (Graphics g){
        Iterator p = piezas.iterator();
        while(p.hasNext()){
            System.out.println("Pintando");
            Pieza segmento= (Pieza)p.next();
            segmento.pintarse(g);
        }

    }

}
