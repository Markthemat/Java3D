
/**
 * Write a description of class DDDT here.
 *
 * Omario
 * 0.01v
 */
import java.awt.Toolkit;
import javax.swing.JFrame;

public class DDDT extends JFrame
{
    static JFrame F = new DDDT();
    /**
     * Create new Screen
     */
    Screen ScreenObject = new Screen();
    
    public DDDT(){
        add(ScreenObject);
        setUndecorated(true);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setVisible(true);
    }
    
    public static void main(String[] args){
        
    }
}
