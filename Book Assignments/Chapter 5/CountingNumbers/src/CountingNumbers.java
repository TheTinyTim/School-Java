import java.util.Scanner;

public class CountingNumbers {
    
    public static void main (String[] args)
    {
        //Initialize the Scanner
        Scanner input = new Scanner (System.in);
        
        //Prompt the user to enter a string of numbers separated by spaces
        System.out.println ("Please enter numbers separated by spaces that ends with a 0");
        String userNumbers = input.nextLine ();
        
        //Just in case add a 0 at the end of the string so if the user didn't the loop will be able to stop
        userNumbers += " 0";
        
        //Create the variables needed for the loop
        boolean continueLoop = true;
        int loopIndex = 0;
        int numOfPos = 0;
        int numOfNeg = 0;
        int numOfInvalid = 0;
        //Split the string by spaces
        String[] userNumArray = userNumbers.split (" ");
        
        //Create a while loop to go through all the numbers until a 0 shows up
        while (continueLoop) {
            try {
                int parsedNum = Integer.parseInt (userNumArray [loopIndex]);
            } catch (NumberFormatException e) {
                System.out.printf ("%s is invalid!", userNumArray [loopIndex]);
            }
            
            loopIndex++;
        }
    }
}
