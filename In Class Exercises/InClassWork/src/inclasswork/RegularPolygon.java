package inclasswork;

public class RegularPolygon {
    
    private int n = 3;
    public int getN ()
    {
        return n;
    }
    public void setN (int n)
    {
        this.n = n;
    }
    
    private double side = 1;
    public double getSide ()
    {
        return side;
    }
    public void setSide (double side)
    {
        this.side = side;
    }
    
    private double x = 0;
    public double getX ()
    {
        return x;
    }
    public void setX (double x)
    {
        this.x = x;
    }
    
    private double y = 0;
    public double getY ()
    {
        return y;
    }
    public void setY (double y)
    {
        this.y = y;
    }
    
    public RegularPolygon () {}
    
    public RegularPolygon (int numSides, double sideLength)
    {
        n = numSides;
        side = sideLength;
    }
    
    public RegularPolygon (int numSides, double sideLength, double x, double y)
    {
        n = numSides;
        side = sideLength;
        this.x = x;
        this.y = y;
    }
    
    public double getPerimeter ()
    {
        return n * side;
    }
    
    public double getArea ()
    {
        return (n * Math.pow (side, 2)) / (4 * Math.tan (Math.PI / n));
    }
    
}
