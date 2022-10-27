
/**
 * Calculate posiotn for 3D
 *
 * Omario
 * 0.01v
 */
public class Calculator
{
    static double DrawX = 0, DrawY = 0;
    static double CalculatePositionX(double[] ViewFrom,double[] ViewTo, double x, double y, double z){
        setStuff(ViewFrom, ViewTo, x, y, z);
        return DrawX;
    }
    
    static double CalculatePositionY(double[] ViewFrom,double[] ViewTo, double x, double y, double z){
        setStuff(ViewFrom, ViewTo, x, y, z);
        return DrawY;
    }
    
    static void setStuff(double [] ViewFrom, double[] ViewTo, double x, double y, double z){
      Vector viewVector = new Vector(ViewTo[0] - ViewFrom[0],ViewTo[1] - ViewFrom[1], ViewTo[2] - ViewFrom[2]); 
      Vector DirectionVector = new Vector(1,1,1); //Position Vector
      //Plane Vectors
      Vector PlaneVector1 = viewVector.CrossProject(DirectionVector);
      Vector PlaneVector2 = viewVector.CrossProject(PlaneVector1);
      
      //Create ViewPoint Vector
      Vector ViewToPoint = new Vector(x - ViewFrom[0], y - ViewFrom[1], z - ViewFrom[2]);
      
      //Transfrom
      double t = (viewVector.x * ViewTo[0] + viewVector.y * ViewTo[1] + viewVector.z * ViewTo[2]
               - (viewVector.x * ViewFrom[0] + viewVector.y * ViewFrom[1] + viewVector.z * ViewFrom[2]))
               / (viewVector.x * ViewToPoint.x + viewVector.y * ViewToPoint.y + viewVector.z * ViewToPoint.z);
               
      x = ViewFrom[0] + ViewToPoint.x * t;
      y = ViewFrom[1] + ViewToPoint.y * t;
      z = ViewFrom[2] + ViewToPoint.z * t;
      
      if (t >= 0){
          DrawX = PlaneVector2.x * x + PlaneVector2.y * y + PlaneVector2.z * z;
          DrawY = PlaneVector1.x * x + PlaneVector1.y * y + PlaneVector1.z * z;
      }
    }
    
}
