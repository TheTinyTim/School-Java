import java.util.Scanner;

public class CharToUnicode {
    
    public static void main (String[] args)
    {
        //Initialize the scanner
        Scanner input = new Scanner (System.in);
        
        //Prompt the user to enter a character and grab the first character in the string they send just in case it's more then one letter
        System.out.println ("Enter a character: ");
        char userChar = input.next ().charAt (0);
    
        System.out.printf ("The Unicode for the character %c is %d", userChar, (int)userChar);
    }
}
