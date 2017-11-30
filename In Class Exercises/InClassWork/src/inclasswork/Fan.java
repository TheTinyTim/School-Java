package inclasswork;

public class Fan {

    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    
    private int speed = 1;
    public int getSpeed () { return speed; }
    public void setSpeed (int speed) {
        if (speed == 1 || speed == 2 || speed == 3)
            this.speed = speed;
        else
            System.out.println ("The fan only has the speed 1, 2, or 3.");
    }
    
    private boolean on = false;
    public boolean isOn () { return on; }
    public void setOn (boolean state) { on = state; }
    
    private double radius = 5;
    public double getRadius () { return radius; }
    public void setRadius (double amount) { radius = amount; }
    
    private String color = "blue";
    public String getColor () { return color; }
    public void setColor (String color) { this.color = color; };
    
    public Fan () {}
    
    public String toString ()
    {
        if (on) {
            String fanDescription = "The " + color + " fan is currently ON and is on the ";
            
            if (speed == SLOW)
                fanDescription += "slow setting. ";
            else if (speed == MEDIUM)
                fanDescription += "medium setting. ";
            else if (speed == FAST)
                fanDescription += "fast setting. ";
            
            fanDescription += "Its radius is " + radius;
            
            return fanDescription;
        } else {
            return "The fan is currently off.";
        }
    }
    
}
