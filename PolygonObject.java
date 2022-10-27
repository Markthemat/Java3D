
/**
 * Write a description of class PolygonObject here.
 *
 * Omario
 * 0.01v
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;


public class PolygonObject
{
    Polygon p;
    Color c;
    double AvgDist = 0;
    
    //Create Polygons
    public PolygonObject(double[] x, double[] y, Color c){
        Screen.NumberOfPolygons++;
        p = new Polygon();
        for(int i = 0; i<x.length; i++)
                p.addPoint((int)x[i], (int)y[i]);
        this.c = c;
    }
    
    void drawPolygon(Graphics g){
        g.setColor(c);
        g.drawPolygon(p);
        g.fillPolygon(p);
    }
}
