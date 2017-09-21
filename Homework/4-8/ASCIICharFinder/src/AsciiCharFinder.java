import java.util.Scanner;

public class AsciiCharFinder {
    
    public static void main (String[] args)
    {
        //Import the scanner
        Scanner input = new Scanner (System.in);
    
        //Have the user give a int between 0-127
        System.out.println ("Please enter in a number (0-127) and I'll tell you what ASCII character that is!");
        int charCode = input.nextInt ();
        
        //Make sure the user only entered in an int between 0-127
        if (charCode >= 0 && charCode <= 127)
            System.out.printf ("The character for ASCII code %d is %c", charCode, (char)charCode);
        else
            System.out.println ("You entered in a number that wasn't between 0-127.");
    }
}
