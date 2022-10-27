
/**
 * Draw 3D Polygon
 *
 * Omario
 * 0.01v
 */
import java.awt.Color;

public class DPolygon
{
    Color c;
    double[] x, y, z;
    int Poly = 0;
    
    public DPolygon(double[] x, double[] y, double[] z, Color c){
        Screen.NumberOf3DPolygons++;
        this.x = x;
        this.y = y;
        this.z = z;
        this.c = c;
        createPolygon();
    }
    
    void createPolygon(){
        double[] newX = new double[x.length];
        double[] newY = new double[x.length];
        
        for (int i = 0; i < x.length; i++){
             newX[i] = 500 + 50 * Calculator.CalculatePositionX(Screen.ViewFrom, Screen.ViewTo, x[i], y[i], z[i]);
             newY[i] = 500 + 50 * Calculator.CalculatePositionY(Screen.ViewFrom, Screen.ViewTo, x[i], y[i], z[i]);
             getDistance();
        }
        Poly = Screen.NumberOfPolygons;
        Screen.DrawablePolygons[Screen.NumberOfPolygons] = new PolygonObject(newX,newY,c);
        Screen.DrawablePolygons[Poly].AvgDist = getDistance();
    }
    
    void updatePolygon(){
        double[] newX = new double[x.length];
        double[] newY = new double[x.length];
        
        for (int i = 0; i < x.length; i++){
             newX[i] = 500 + 50 * Calculator.CalculatePositionX(Screen.ViewFrom, Screen.ViewTo, x[i], y[i], z[i]);
             newY[i] = 500 + 50 * Calculator.CalculatePositionY(Screen.ViewFrom, Screen.ViewTo, x[i], y[i], z[i]);
        }
        Screen.DrawablePolygons[Poly] = new PolygonObject(newX,newY,c);
        Screen.DrawablePolygons[Poly].AvgDist = getDistance();
        Screen.NumberOfPolygons --;
    }
    
    double getDistance(){
        double total = 0;
        for (int i = 0; i <x.length; i++){
            total += getDistanceToP(i);
        }
        return total /x.length;
    }
    
    double getDistanceToP(int i){
        
        return Math.sqrt((Screen.ViewFrom[0]-x[i]) * (Screen.ViewFrom[0]-x[i]) +
                        (Screen.ViewFrom[1]-y[i]) * (Screen.ViewFrom[1]-y[i])+
                        (Screen.ViewFrom[2]-z[i]) * (Screen.ViewFrom[2]-z[i]));
    }
}
