import java.util.Scanner;

public class ValidatePassword {
    
    public static void main (String[] args)
    {
        //Initialize the Scanner
        Scanner input = new Scanner (System.in);
        
        //Set up some variables that will be used in the program
        boolean passedChecks = true;        //This will store if the user passed all the checks for their password.
                                            //This will only ever be set to false.
        boolean correctPassword = false;    //This will store if the user has created a correct password and will
                                            //break out of the loop if they did
        
        while (!correctPassword) {
            //Make sure to set passed checks to true at the beginning of every loop
            passedChecks = true;
            
            //Prompt the user to enter in a password that NEEDS to have at least 2 uppercase letters and 2 numbers in it
            System.out.println ("Please enter in a password that has at least 2 uppercase letters and 2 numbers in it.");
            String userPassword = input.nextLine ();
    
            //Now check if all the requirements are met with the password
    
            //First check: Make sure there is no spaces in the users password
            if (userPassword.contains (" ")) {
                System.out.println ("You can not have any spaces in your password!");
                passedChecks = false;
            }
    
            //Second Check: Make sure the password has:
            //  2 or more uppercase letters
            //  2 or more numbers
            //This will be checked by going through every character in the password and compare it to its ASCII decimal value
            //  A char that is >= 65 && <= 90 is an uppercase
            //  A char that is >= 48 && <= 57 is a number
    
            //Set up variables that will store how many numbers and how many letters there are to be accessed outside the loop
            int numOfUpper = 0;
            int numOfNums = 0;
    
            //Now actually go through all the characters in the password
            for (int i = 0; i < userPassword.length (); i++) {
                //Get the characters ASCII decimal value at the current index (i)
                int passwordChar = (int) userPassword.charAt (i);
        
                //Now check whether the char is an uppercase or a number based off its ASCII decimal value
                if (passwordChar >= 65 && passwordChar <= 90) {
                    //This character is an uppercase letter
                    numOfUpper++;
                } else if (passwordChar >= 48 && passwordChar <= 57) {
                    //This character is a number
                    numOfNums++;
                }
            }
    
            //Now check to make sure the had 2 or more uppercase letters and numbers in their password
            if (numOfUpper < 2) {
                System.out.println ("You did not have enough uppercase letters in your password!");
                passedChecks = false;
            }
    
            if (numOfNums < 2) {
                System.out.println ("You did not have enough numbers in your password!");
                passedChecks = false;
            }
    
            //Now check to see if the user passed all the checks and if so tell them they did
            if (passedChecks) {
                System.out.println ("You entered a password with all the correct requirements!");
                correctPassword = true;
            } else {
                System.out.println ("You did not enter in a correct password. Please try again\n");
            }
        }
    }
}
