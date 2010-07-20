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
import segmentos.piezas.*;


/**
 *
 * @author curio
 */
public class Lienzo extends Canvas{
    
    private Vector<Pieza> piezas;

    public Lienzo(){
        piezas = new Vector();
        /*
         *Genero las 35 Piezas 
         */
        int ainicial = 90;
        /*for(int i=0;i<2;i++){
            piezas.add(new Medio(100,50,150,ainicial,this));
            ainicial=ainicial+180;
        }
        for(int i=0;i<3;i++){
            piezas.add(new Tercio(300,50,150,ainicial,this));
            ainicial=ainicial+120;
        }
        for(int i=0;i<4;i++){
            piezas.add(new Cuarto(500,50,150,ainicial,this));
            ainicial=ainicial+90;
        }
        for(int i=0;i<6;i++){
            piezas.add(new Secto(100,200,150,ainicial,this));
            ainicial=ainicial+60;
        }
        for(int i=0;i<8;i++){
            piezas.add(new Octavo(300,200,150,ainicial,this));
            ainicial=ainicial+45;
        }*/
        for(int i=0;i<12;i++){
            piezas.add(new Doceavo(200,100,200,ainicial,this));
            ainicial=ainicial+30;
        }
        
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1000, 700);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.LIGHT_GRAY);
        this.setBounds(0, 0, 1000, 700);
        this.setBackground(Color.LIGHT_GRAY);
        frame.setTitle("Fracciones");
        frame.add(this);
        frame.setVisible(true);  
    }

    public Vector<Pieza> getPiezas(){
        return piezas;
    }

    @Override
    public void paint (Graphics g){
        g.drawRect(20, 50, 950, 280);

        g.drawRect(20,350,227,300);
        g.drawRect(262,350,227,300);
        g.drawRect(503,350,227,300);
        g.drawRect(745,350,227,300);

        Iterator p = piezas.iterator();
        while(p.hasNext()){
            Pieza segmento= (Pieza)p.next();
            segmento.pintarse(g);
        }

    }

}
