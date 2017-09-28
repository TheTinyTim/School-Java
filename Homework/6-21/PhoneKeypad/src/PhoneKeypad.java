import java.util.Scanner;

public class PhoneKeypad {
    
    public static void main (String[] args)
    {
        //Initialize the Scanner
        Scanner input = new Scanner (System.in);
        
        //Prompt the user to enter in a phone number and it can contain letters
        System.out.println ("Enter in a phone number that contains letters and I'll convert the letters the appropriate numbers!");
        String userNumber = input.next ();
        
        //Now loop through the users number and for each letter send it to the getNumber method to find out the number
        //that letter is associated with
        String newNumber = "";
        for (int i = 0; i < userNumber.length (); i++) {
            //Get the current character at the index
            String currentChar = userNumber.substring (i, i+1).toUpperCase ();
            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains (currentChar))
                newNumber += getNumber (currentChar.charAt (0));
            else
                newNumber += currentChar;
        }
        
        //Now display the new number
        System.out.println (newNumber);
    }
    
    private static int getNumber (char uppercaseLetter)
    {
        int letterNum = 0;
        
        //Find out what number is associated with this letter
        if (uppercaseLetter == 'A' || uppercaseLetter == 'B' || uppercaseLetter == 'C')
            letterNum = 2;
        else if (uppercaseLetter == 'D' || uppercaseLetter == 'E' || uppercaseLetter == 'F')
            letterNum = 3;
        else if (uppercaseLetter == 'G' || uppercaseLetter == 'H' || uppercaseLetter == 'I')
            letterNum = 4;
        else if (uppercaseLetter == 'J' || uppercaseLetter == 'K' || uppercaseLetter == 'L')
            letterNum = 5;
        else if (uppercaseLetter == 'M' || uppercaseLetter == 'N' || uppercaseLetter == 'O')
            letterNum = 6;
        else if (uppercaseLetter == 'P' || uppercaseLetter == 'Q' || uppercaseLetter == 'R' || uppercaseLetter == 'S')
            letterNum = 7;
        else if (uppercaseLetter == 'T' || uppercaseLetter == 'U' || uppercaseLetter == 'V')
            letterNum = 8;
        else if (uppercaseLetter == 'W' || uppercaseLetter == 'X' || uppercaseLetter == 'Y' || uppercaseLetter == 'Z')
            letterNum = 9;
        
        return letterNum;
    }
}
