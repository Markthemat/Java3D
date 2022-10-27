
/**
 * Write a description of class Screen here.
 *
 * Omario
 * 0.01v
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Screen extends JPanel implements KeyListener
{
    double sleepTime = 1000/30, LastRefresh = 0; //Time that loop runs
    
    //Pretty much just a camera :D
    static double[] ViewFrom = new double[]{10,10,10};
    static double[] ViewTo = new double[]{5,0,0};
    
    static int NumberOfPolygons = 0;
    static int NumberOf3DPolygons = 0;
    int[] NewOrder;
    
    static PolygonObject[] DrawablePolygons = new PolygonObject[100];
    
    static DPolygon[] DrawableDPolygons = new DPolygon[100];
    
    public Screen(){
        addKeyListener(this);
        setFocusable(true);
        
        DrawableDPolygons[NumberOfPolygons] = new DPolygon(new double[]{0, 2, 2, 0}, new double[]{0, 0, 2, 2},  new double[]{0, 0, 0, 0}, Color.black);
        DrawableDPolygons[NumberOfPolygons] = new DPolygon(new double[]{0, 2, 2, 0}, new double[]{0, 0, 2, 2},  new double[]{3, 3, 3, 3}, Color.red);
        DrawableDPolygons[NumberOfPolygons] = new DPolygon(new double[]{0, 2, 2, 0}, new double[]{0, 0, 0, 0},  new double[]{0, 0, 3, 3}, Color.blue);
        DrawableDPolygons[NumberOfPolygons] = new DPolygon(new double[]{0, 2, 2, 0}, new double[]{2, 2, 2, 2},  new double[]{0, 0, 3, 3}, Color.yellow);
        DrawableDPolygons[NumberOfPolygons] = new DPolygon(new double[]{0, 0, 0, 0}, new double[]{0, 2, 2, 0},  new double[]{0, 0, 3, 3}, Color.green);
        DrawableDPolygons[NumberOfPolygons] = new DPolygon(new double[]{0, 2, 2, 0}, new double[]{0, 2, 2, 0},  new double[]{0, 0, 3, 3}, Color.pink);
    }
    
    public void paintComponent(Graphics g){
        g.clearRect(0, 0, 2000, 1200); //Clear screen

        for(int i = 0; i < NumberOf3DPolygons; i++)
		DrawableDPolygons[i].updatePolygon();
	setOrder(); //Depth buffer	
        for (int i = 0; i <NumberOfPolygons; i++)
             DrawablePolygons[NewOrder[i]].drawPolygon(g);

             
        SleepAndRefresh();
    }
    
    void setOrder(){
        double [] k = new double[NumberOfPolygons];
        NewOrder = new int[NumberOfPolygons];
        
        for (int i=0; i <NumberOfPolygons; i++){
            k[i] = DrawablePolygons[i].AvgDist;
            NewOrder[i] = i;
        }
        
        double temp;
        int tempr;
        //Do the sourting
        for (int a = 0; a <k.length-1; a++)
            for (int b = 0; b < k.length-1; b++)
                if (k[b] < k[b + 1]){
                    temp = k[b];
                    tempr = NewOrder[b];
                    NewOrder[b] = NewOrder[b+1];
                    k[b] = k[b+1];
                    NewOrder[b+1] = tempr;
                    k[b+1] = tempr;
                }
    }

    void SleepAndRefresh(){
        //Game loop
        while (true){
            if((System.currentTimeMillis() - LastRefresh) > sleepTime){
                LastRefresh = System.currentTimeMillis();
                repaint();
                break;
            }else {
                try{
                    Thread.sleep((long)(sleepTime - (System.currentTimeMillis() - LastRefresh)));
                }
                catch(Exception e){
                    
                }
            }
        }

    }
    
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            ViewFrom[0] --;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            ViewFrom[0] ++;
        if (e.getKeyCode() == KeyEvent.VK_UP)
            ViewFrom[1] --;
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            ViewFrom[1] ++;
    }
    
    public void keyReleased(KeyEvent e){
        
    }
    
    public void keyTyped(KeyEvent e){
        
    }
}
