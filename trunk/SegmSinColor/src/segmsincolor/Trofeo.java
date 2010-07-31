/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package segmsincolor;


import java.awt.Graphics;

/**
 *
 * @author curio
 */
class Trofeo {
    public String name;
    public int x,y,tam;

    public Trofeo(int x0, int y0, int t, String n){
        x=x0;
        y = y0;
        tam = t;
        name = n;
    }

    public void pintarse (Graphics g){
        g.drawRect(x, y, tam, tam);
        g.drawString(name, x+50, y+50);
    }

}
