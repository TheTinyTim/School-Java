public class Animal {
    
    private String name;
    
    public String toString () {
        return "My name is " + name + " and I move " + move ();
        
        //System.out.printf ("My name is %s and I move %s", name, move ());
    }
    
    public Animal (String name) { this.name = name; }
    
    public String move ()
    {
        return "one of many different ways";
    }
    
}
