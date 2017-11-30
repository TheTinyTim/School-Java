public class Rectangle {

    double width = 1;
    double height = 1;
    
    public Rectangle ()
    {
    
    }
    
    public Rectangle (double width, double height)
    {
        this.width = width;
        this.height = height;
    }
    
    public double getArea ()
    {
        return width * height;
    }
    
    public double getPerimeter ()
    {
        return (width * 2) + (height * 2);
    }
}
