import java.util.Scanner;

public class ReverseString {
    
    public static void main (String[] args)
    {
        //Initialize the Scanner
        Scanner input = new Scanner (System.in);
        
        //Prompt the user to input a string they want to be reversed
        System.out.println ("Please enter in anything and I'll reverse it for you!");
        String userString = input.nextLine ();
        
        //Create a new String variable to store the backwards text
        String backwardsString = "";
        //Go through everything BACKWARDS and add it to the new string
        for (int i = userString.length () - 1; i >= 0; i--) {
            backwardsString += userString.charAt (i);
        }
        
        //Now display the backwards string to the user
        System.out.printf ("\nYour phrase backwards: \n%s", backwardsString);
    }
}
