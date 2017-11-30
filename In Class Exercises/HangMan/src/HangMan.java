import java.util.Random;
import java.util.Scanner;

public class HangMan {
    
    //All the words that can be used in the hangman game
    private static String[] words = new String[] {"Akward", "Bagpipes", "Banjo", "Dwarves", "Fishhook", "Haphazard", "Memento", "Numbskull", "Zig-Zag"};
    private static int wordNum;     //The number corresponding to the current word being used for hangman
    
    private static String[] lettersCorrect;  //This will store all the letters the player has guessed correctly
    private static String[] lettersWrong = new String[6];    //And this will store the words they've guessed incorrectly
    
    private static String output;
    
    public static void main (String[] args)
    {
        Random random = new Random ();
        //Get the number of the word that will be used for this game
        wordNum = random.nextInt (words.length);
        
        //Set up the length of the letters correct array
        lettersCorrect = new String[words[wordNum].length ()];
        
        //Set up some variables for the main game loop
        boolean gameFinished = false;
        
        //Keep looping until the game is finished
        while (!gameFinished) {
            //Draw the hangman
            drawHangMan ();
    
            //Display the hidden word
            output = drawHiddenWord ();
            System.out.println (output);
            
            //Display the words the user has already guessed and gotten wrong
            System.out.printf ("\nIncorrect letters: %s\n", getWrongLetterString ());
            
            //Find out if the game is completed or not
            if (!output.contains ("_")) {
                //The user has guessed all the letters and won!
                System.out.println ("Congratulations You've won!!!");
                //Tell the program the game is done
                gameFinished = true;
            } else if (wrongLettersLength () >= 6) {
                //The user has gotten too many incorrect letters and lost.
                System.out.println ("I'm sorry you've lost...");
                //Display what the word was
                System.out.println ("The word was: " + words[wordNum]);
                //Tell the program the game is done
                gameFinished = true;
            } else {
                //Because the user hasn't won or lost yet get their input
                getUsersInput ();
            }
        }
    }
    
    //This will draw the hangman based on how many incorrect guesses there is
    private static void drawHangMan ()
    {
        System.out.printf ("%5s\n", "┌──┐");
        System.out.printf ("%5s\n", "│  │");
        
        //Draw the head if the player has missed more then once
        if (wrongLettersLength () > 0)
            System.out.printf ("%5s\n", "O  │");
        else
            System.out.printf ("%5s\n", "   │");
        
        //Now draw the torso (2 wrong) and both arms (3 wrong for one and 4 wrong for both)
        if (wrongLettersLength () > 3)
            System.out.printf ("%4s\n", "/│\\ │");
        else if (wrongLettersLength () > 2)
            System.out.printf ("%4s\n", "/│  │");
        else if (wrongLettersLength () > 1)
            System.out.printf ("%5s\n", "│  │");
        else
            System.out.printf ("%5s\n", "   │");
        
        //Now draw the legs (5 wrong for one and 6 wrong for both)
        if (wrongLettersLength () > 5)
            System.out.printf ("%4s\n", "/ \\ │");
        else if (wrongLettersLength () > 4)
            System.out.printf ("%4s\n", "/   │");
        else
            System.out.printf ("%5s\n", "   │");
        
        System.out.printf ("%4s\n", "────┴─");
    }
    
    //This method will go through the current word and find out which letters have/haven't been guessed and
    //either place the letter or an _ respectfully
    private static String drawHiddenWord ()
    {
        //Get the current word being used for the game
        String currentWord = words[wordNum];
        //Set up the variable that will hold the output of the hidden word
        String output = "";
        //Now go through each letter of the word and put _ that haven't been guessed and the actual letter for
        //the ones that have been guessed. And for spaces and special characters like: ' , . ! etc... go ahead
        //and display those from the beginning
        for (int i = 0; i < currentWord.length (); i++) {
            //Get the current character based on the index (i) and make it uppercase if it isn't
            String currentCharacter = currentWord.substring (i, i + 1).toUpperCase ();
            //Now find out if the current character is a letter or a special character based on the decimal value
            if (currentCharacter.charAt (0) >= 65 && currentCharacter.charAt (0) <= 90) {
                //The current character is an uppercase letter so find out if it's been already
                //guessed by the player
                if (lettersCorrectContains (currentCharacter)) {
                    //This letter has already been guessed by the player so display it
                    output += currentCharacter;
                } else {
                    //This letter hasn't been guessed so just add an underscore
                    output += "_";
                }
            } else {
                //This is a special character so just go ahead and display it
                output += currentCharacter;
            }
        }
        
        //Now return the output
        return output;
    }
    
    //This method will capture the players input and check to see if it's correct or incorrect
    private static void getUsersInput ()
    {
        Scanner input = new Scanner (System.in);
        //Prompt the user to guess a letter
        System.out.printf ("Guess a letter > ");
        //Capture the letter the player is guessing
        String userInput = input.nextLine ();
        
        //Make sure the user didn't enter nothing
        if (!userInput.isEmpty ()) {
            userInput = userInput.toUpperCase ().substring (0,1);
            //First make sure what they entered was actually a letter
            if (userInput.charAt (0) >= 65 && userInput.charAt (0) <= 90 && !userInput.equals ("")) {
                //It is a letter so first make sure this isn't a letter the player has already guessed
                if (!lettersWrongContains (userInput) && !lettersCorrectContains (userInput)) {
                    //This letter hasn't already been guessed so find out if it's wrong or right
                    if (words[wordNum].toUpperCase ().contains (userInput)) {
                        //The letter is correct so add it to the correct letter array
                        addToCorrectLetters (userInput);
                    } else {
                        //The letter is incorrect
                        addToWrongLetters (userInput);
                    }
                }
            }
        }
    }
    
    //Check if the letters correct array has a letter
    private static boolean lettersCorrectContains (String letter)
    {
        //Loop through all the letters in the array and find out if the passed letter is in it
        for (int i = 0; i < lettersCorrect.length; i++) {
            if (lettersCorrect[i] != null) {
                if (lettersCorrect[i].equals (letter))
                    return true;
            }
        }
        return false;
    }
    
    //Add the passed letter to the letters correct array at the end
    private static void addToCorrectLetters (String letter)
    {
        //Go through all the spots in the letters correct array and add the letter in a blank spot
        for (int i = 0; i < lettersCorrect.length; i++) {
            if (lettersCorrect[i] == null) {
                lettersCorrect[i] = letter;
                break;
            }
        }
    }
    
    //Check if the letters wrong array has a letter
    private static boolean lettersWrongContains (String letter)
    {
        //Loop through all the letters in the array and find out if the passed letter is in it
        for (int i = 0; i < lettersWrong.length; i++) {
            if (lettersWrong[i] != null) {
                if (lettersWrong[i].equals (letter))
                    return true;
            }
        }
        return false;
    }
    
    //Add the passed letter to the letters wrong array at the end
    private static void addToWrongLetters (String letter)
    {
        //Go through all the spots in the letters correct array and add the letter in a blank spot
        for (int i = 0; i < lettersWrong.length; i++) {
            if (lettersWrong[i] == null) {
                lettersWrong[i] = letter;
                break;
            }
        }
    }
    
    //Get how many letters there are in the wrong letter array
    private static int wrongLettersLength ()
    {
        int length = 0;
        
        //Loop through all the items in the wrong letters array and what isn't null add onto the length
        for (int i = 0; i < lettersWrong.length; i++) {
            if (lettersWrong[i] != null)
                length++;
        }
        
        return length;
    }
    
    //Get a string of all the wrong letters
    private static String getWrongLetterString ()
    {
        String output = "";
        
        for (int i = 0; i < lettersWrong.length; i++) {
            if (lettersWrong[i] != null)
                output += lettersWrong[i] + " ";
        }
        
        return output;
    }
}
