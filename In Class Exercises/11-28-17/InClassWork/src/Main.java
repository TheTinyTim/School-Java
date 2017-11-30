import java.util.ArrayList;

public class Main {
    
    public static void main (String[] args)
    {
        ArrayList<Animal> animals = new ArrayList<Animal> ();
        animals.add (new Fish ("Jeff"));
        animals.add (new Horse ("Wellington III"));
        animals.add (new Bird ("Tweety"));
        
        for (Animal animal : animals) {
            System.out.println (animal.toString ());
        }
    }
    
}
