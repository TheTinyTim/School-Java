import java.util.Scanner;

public class DecimalToHex {
    
    public static void main (String[] args)
    {
        //Initialize the Scanner
        Scanner input = new Scanner (System.in);
        
        //Prompt the user to enter in a decimal to be converted to hex
        System.out.printf ("Enter a decimal value (0 to 15): ");
        int userDecimal = input.nextInt ();
        
        if (userDecimal >= 0 && userDecimal <= 15) {
            //Now convert the decimal to hex
            String converted = Integer.toHexString (userDecimal);
    
            //And display it to the user
            System.out.printf ("The hexadecimal value of %d is: %s", userDecimal, converted);
        } else {
            System.out.printf ("%d is an invalid input!", userDecimal);
        }
    }
}
