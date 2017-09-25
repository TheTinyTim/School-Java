import java.util.Scanner;

public class CountMovieSpaces {
    
    public static void main (String[] args)
    {
        //Initialize the Scanner
        Scanner input = new Scanner (System.in);
        
        //Prompt the user to enter in a quote
        System.out.println ("Please enter in a movie quote and I will tell you the amount of spaces it has!");
        String userQuote = input.nextLine ();
        
        //Set up some variables tat will need to be accessed outside the loop
        int numSpaces = 0;
        //Now create a for loop to go through all the characters in the users quote
        for (int i = 0; i < userQuote.length (); i++) {
            //Get the char at the current index (i)
            char quoteChar = userQuote.charAt (i);
            
            //Check to see if the quote is a space or not and if it is add one to the number of spaces
            if (quoteChar == ' ')
                numSpaces++;
        }
        
        //Now display how many spaces there were in the users quote
        System.out.printf ("There was %d space(s) in your quote.", numSpaces);
    }
}
