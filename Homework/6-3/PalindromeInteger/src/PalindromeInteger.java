import java.util.Scanner;

public class PalindromeInteger {
    
    public static void main (String[] args)
    {
        //Initialize the Scanner
        Scanner input = new Scanner (System.in);
        
        //Prompt the user to enter a number
        System.out.println ("Please enter in a number and I'll tell you if it's a palindrome or not!");
        int number = input.nextInt ();
    
        if (isPalindrome (number))
            System.out.printf ("%d is a palindrome!", number);
        else
            System.out.printf ("%d is not a palindrome!", number);
    }
    
    public static int reverse (int number)
    {
        String numString = Integer.toString (number);
        String reversed = "";
        
        for (int i = numString.length ()-1; i >= 0; i--) {
            reversed += numString.charAt (i);
        }
        
        return Integer.parseInt (reversed);
    }
    
    public static boolean isPalindrome (int number)
    {
        if (number == reverse (number))
            return true;
        else
            return false;
    }
}
