import java.util.Scanner;

public class AreaOfPentagon {
    
    public static void main (String[] args)
    {
        //Initialize the Scanner
        Scanner input = new Scanner (System.in);
        
        //Create the constants used for tis program
        final double PI = 3.14d;
        
        //Prompt the user to enter in the length of te radius of the pentagon
        System.out.printf ("Enter the length between the center and a vertex: ");
        double pentagonRadius = input.nextDouble ();
        
        //Make sure if the user entered in a negative number to make it positive
        pentagonRadius = Math.abs (pentagonRadius);
        
        //Get the length of a side on the pentagon based on the radius given
        double sideLength = 2 * pentagonRadius * Math.sin (PI / 5.0d);
        
        //Now get the numerator and denominator for the equation
        double numerator = 5.0d * Math.pow (sideLength, 2.0d);
        double denominator = 4.0d * Math.tan (PI / 5.0d);
        
        //Now take the numerator and denominator and find the area of the pentagon
        double pentagonArea = numerator / denominator;
        //Display the result to the user
        System.out.printf ("\nThe area of the pentagon is: %1.2f\n", pentagonArea);
    }
}
