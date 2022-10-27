
/**
 * Vectors
 *
 * Omario
 * 0.01v
 */
public class Vector
{
    double x = 0, y = 0, z = 0;
    public Vector(double x, double y, double z){
        double Length = Math.sqrt(x*x + y*y + z*z);
        if(Length >0){
        this.x = x/Length;
        this.y = y/Length;
        this.z = z/Length;
        }
    }
    
    Vector CrossProject(Vector v){
        Vector CrossVector = new Vector(
            y * v.z - z * v.y,
            z * v.x - x * v.z,
            x * v.y - y * v.x);
        return CrossVector;
    }
}
