import java.util.Scanner;

public class ISBNChecker {
    
    public static void main (String[] args)
    {
        //Initialize the Scanner
        Scanner input = new Scanner (System.in);
        
        //Prompt the user to enter the first 12 digits of an ISBN-13 number
        System.out.println ("Please enter in the first 12 digits of a ISBN-13 with no spaces:");
        String userISBN = input.next ();
        
        //Now do some fail safe checks to make sure what the user put in will work
        boolean failedCheck = false;
        //First check to make sure the length is 12
        if (userISBN.length () != 12) {
            System.out.printf ("%s is invalid! It is no the correct length (12)", userISBN);
            failedCheck = true;
        }
        
        //Make sure it only contains numbers
        try {
            Long.parseLong (userISBN);
        } catch (NumberFormatException e) {
            System.out.printf ("%s is invalid! It can only contain numbers!", userISBN);
            failedCheck = true;
        }
        
        //Only do the rest of the program if it passed the fail check
        if (!failedCheck) {
            //Create a variable that will hold the last digit of the ISBN
            long lastISBN = 0;
            //Now go through all the numbers and add them up
            for (int i = 0; i < userISBN.length (); i++) {
                //Get the number at the current index
                int currentNum = Integer.parseInt (userISBN.substring (i,i+1));
                //Add that number to the total
                lastISBN += currentNum;
            }
    
            //Now do the math to get the last ISBN number
            lastISBN = 10 - lastISBN % 10;
    
            //Now check if the number is over 10. If so make it a 0
            if (lastISBN == 10)
                lastISBN = 0;
    
            //Now display the ISBN-13
            System.out.printf ("The ISBN-13 number is: %s%d", userISBN, lastISBN);
        }
    }
}
