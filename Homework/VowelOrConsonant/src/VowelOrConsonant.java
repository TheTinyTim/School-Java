import java.util.Scanner;

public class VowelOrConsonant {
    
    public static void main (String[] args)
    {
        //Initialize the scanner
        Scanner input = new Scanner (System.in);
        
        //Create constants that hold all the vowels and consonants
        final String VOWELS = "aeiouAEIOU";
        final String CONSONANTS = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        
        //Prompt the user to enter in a letter
        System.out.println ("Enter a letter: ");
        String userLetter = input.next ().substring (0);
        
        //Check to see if what the user inputted is a vowel, consonant, or an invalid input
        if (VOWELS.contains (userLetter))
            System.out.printf ("%s is a vowel", userLetter);
        else if (CONSONANTS.contains (userLetter))
            System.out.printf ("%s is a consonant", userLetter);
        else
            System.out.printf ("%s is an invalid input", userLetter);
    }
}
