import java.util.Scanner;

public class CountLetters {
    
    public static void main (String[] args)
    {
        //Initialize the Scanner
        Scanner input = new Scanner (System.in);
        
        //Prompt the user to give a string
        System.out.println ("Give me a string and I'll tell you how many letters there are!");
        String userString = input.nextLine ();
        
        //Now display how many letters there are in the users string
        System.out.printf ("There is %d Letter(s) in your string!", countLetters (userString));
    }
    
    public static int countLetters (String s)
    {
        s = s.replaceAll (" ", "");
        return s.length ();
    }
}
