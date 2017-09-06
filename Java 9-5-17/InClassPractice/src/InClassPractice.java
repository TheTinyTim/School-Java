import java.util.Scanner;

public class InClassPractice {
    
    /*
     * Notes:
     *      Press Ctrl+/ to comment in/out everything that is selected
     *      http://docs.oracle.com/javase/8/docs/api/index.html
     */
    
    public static void main (String[] args)
    {
        int dayOfWeek = 5;
        
        switch (dayOfWeek) {
            
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println ("Weekday");
                break;
            case 6:
            case 7:
                System.out.println ("Weekend");
                break;
            default:
                System.out.println ("Oops!");
            
        }
        int randNumber = 1 + (int)Math.random () * 10;
        int aNum = 5;
        if (aNum == 5)
            System.out.println ("5 is the number");
        else
            System.out.println ("The number is not 5");

        //Ternary operator
        // variable = (condition) ? true : false;
        String ans = aNum == 5 ? "5" : "not";
        System.out.println (ans);

        boolean isFive = aNum == 5 ? true : false;
        System.out.println (isFive);

        //if /else block
        int aNewNum = 4;

        if (aNewNum == 35)
            System.out.println ("35 is the magic number");
        else if (aNewNum > 35)
            System.out.println ("Greater than 35");
        else
            System.out.println ("Less than 35");

        //Logical operators
        int nextNumber = 6;
        if (nextNumber == 35)
            System.out.println ("35 is the magic number");
        else if (nextNumber >= 5 && nextNumber <= 10)
            System.out.println ("Between 5 and 10");
        else if (nextNumber >= 25 || nextNumber <= 5)
            System.out.println ("Greater than 25 or less than 5");
        else
            System.out.println ("Between 6 and 24");
        
        // 1. Generate two random single-digit integers
        int number1 = (int)(Math.random () * 10);
        int number2 = (int)(Math.random () * 10);

        // 2. If number1 < number2, swap number1 with number2
        if (number1 < number2) {
            int temp = number1;
            number1 = number2;
            number2 = temp;
        }

        // 3. Prompt the student to answer "What is number1 - number2?"
        System.out.println ("What is " + number1 + " - " + number2 + "? ");
        Scanner input = new Scanner (System.in);
        int answer = input.nextInt ();

        // 4. Grade the answer and display the result
        if (number1 - number2 == answer) {
            System.out.println ("You are correct!");
        } else {
            System.out.println ("Your answer is wrong.");
            System.out.println (number1 + " - " + number2 + " should be " + (number1 - number2));
        }
    }
}
