import java.util.Scanner;

public class InClassPractice {

    public static void main (String[] args)
    {
        Scanner input = new Scanner (System.in);
//
//        System.out.println ("Enter a phrase");
//        String userPhrase = input.next ();
//        System.out.println ("The phrase is: " + userPhrase);
//
//        //Convert the input string using String methods
//        userPhrase = userPhrase.toUpperCase ();
//        System.out.println ("The phrase is: " + userPhrase);
//
//        //Comparing Strings
//        String myString = "MYSTRING";
//        boolean isMatch = myString == userPhrase;
//        System.out.println (isMatch);
//        isMatch = myString.equals (userPhrase);
//        System.out.println (isMatch);
        
//        //Print out the char value of A
//        char letter = 'A';
//        System.out.println ("Character value is: " + letter);
//        //Print out the equivalent decimal value of A
//        int decLetter = (int)'A';
//        System.out.println ("Decimal value is: " + decLetter);
        
        //Lets convert that letter to its opposite case
        String userPhrase = "MY dOg SInGs";
    
//        String switchedPhrase = "";
        
        //While loop version
//        int i = 0;
//        int phraseLength = userPhrase.length ();
//
//        while (i < phraseLength) {
//            char firstLetter = userPhrase.charAt (i);
//            //System.out.println ("The first letter is: " + firstLetter);
//
//            int charLetter = (int) firstLetter;
//            //System.out.println ("The decimal value of " + firstLetter + " is: " + charLetter);
//
//            int toggleCharacter;
//            if (charLetter == 32)
//                switchedPhrase += (char) 32;
//            else if (charLetter >= 65 && charLetter <= 90)
//                switchedPhrase += (char) (charLetter + 32);
//            else
//                switchedPhrase += (char) (charLetter - 32);
//
//            i++;
//        }
        
        //For loop version
//        for (int i = 0; i < userPhrase.length (); i++) {
//            char firstLetter = userPhrase.charAt (i);
//            //System.out.println ("The first letter is: " + firstLetter);
//
//            int charLetter = (int) firstLetter;
//            //System.out.println ("The decimal value of " + firstLetter + " is: " + charLetter);
//
//            int toggleCharacter;
//            if (charLetter == 32) {
//                switchedPhrase += (char) 32;
//            } else if (charLetter >= 65 && charLetter <= 90) {
//                toggleCharacter = charLetter + 32;
//                switchedPhrase += (char) toggleCharacter;
//            } else {
//                toggleCharacter = charLetter - 32;
//                switchedPhrase += (char) toggleCharacter;
//            }
//        }
//
//        System.out.println (switchedPhrase);
    
//        System.out.printf ("String: %s, Char: %c, Int: %d\n", userPhrase, letter, toggleCharacter);
//        System.out.printf ("String with 4 spaces: %4s right aligned\n", userPhrase);
//        System.out.printf ("Int with 4 spaces: %-4d left aligned\n", toggleCharacter);
//
//        double tipPercent = 2.295d;
//        System.out.printf ("Double with 10 spaces and 2 decimal positions: %10.2f\n", tipPercent);
        
        int age;
        System.out.println ("Enter your age");
        age = input.nextInt ();
        System.out.println (age);
        System.out.println ("Enter in your name");
        input.nextLine ();
        String name = input.nextLine ();
        System.out.println (name);
    }
}
