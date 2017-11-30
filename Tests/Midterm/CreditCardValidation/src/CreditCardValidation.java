import java.util.Scanner;

public class CreditCardValidation {
    
    public static void main (String[] args)
    {
        Scanner input = new Scanner (System.in);
        
        //Get the user to enter a credit card number
        System.out.println ("Please enter in a credit card number and I'll tell you if it's valid!");
        long creditCardNumber = input.nextLong ();
        
        //Now check if it's valid
        if (isValid (creditCardNumber)) {
            System.out.println ("The credit card number you entered is valid!");
        } else {
            System.out.println ("The credit card number you entered is invalid.");
        }
    }
    
    /** Return true if the card number is valid */
    public static boolean isValid(long number)
    {
        //First check the length of the credit card number and make sure it's between 12-17
        if (getSize (number) > 12 && getSize (number) < 17) {
            //The length of the credit card is correct so now make sure that it begins with one of the
            //4 starting numbers (4 - Visa, 5 - Master, 37 - American Express, 6 - Discover)
            long prefixOne = getPrefix (number, 1);
            long prefixTwo = getPrefix (number, 2);
            
            if (prefixMatched (prefixOne, 4) || prefixMatched (prefixOne, 5) || prefixMatched (prefixTwo, 37) || prefixMatched (prefixOne, 6)) {
                //Now that we know the number has the correct prefix let's now make sure the number passes the MOD 10 check
                int evenSum = sumOfDoubleEvenPlace (number);
                int oddSum = sumOfOddPlace (number);
                //Now add the sums together
                int sum = evenSum + oddSum;
                //And make sure it's divisible by 10
                if ((sum % 10) == 0) {
                    //This credit card is valid!
                    return true;
                }
            }
        }
        //This credit card is not valid
        return false;
    }
    
    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number)
    {
        //Get the string array of the number to easily loop through the numbers
        String[] numbers = Long.toString (number).split ("");
        
        //Now loop through all the even spots of the number from right to left and
        //double the number, make sure it isn't 2 digits, and add them to the sum of the even numbers
        int evenSum = 0;
        for (int i = numbers.length - 2; i >= 0; i -= 2) {
            //First turn the string into an integer
            int currNum = Integer.parseInt (numbers[i]);
            //Now double the number
            currNum *= 2;
            //Now make sure if it's 2 digits to add them together then add it to the total sum of the even numbers
            evenSum += getDigit (currNum);
        }
        //Now return the sum of all the even numbers
        return evenSum;
    }
    
    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int number)
    {
        //First find out if it's larger than 9
        if (number > 9) {
            //Because it's larger than 9 we have to add the 2 digits together
            //So start off by turning it into a string and split it
            String[] numbers = Integer.toString (number).split ("");
            //Now add the numbers together and return it
            return Integer.parseInt (numbers[0]) + Integer.parseInt (numbers[1]);
        } else {
            //Because it's less than 9 just return the number
            return number;
        }
    }
    
    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number)
    {
        //First turn the number into a string array
        String[] numbers = Long.toString (number).split ("");
    
        //Now loop through all the odd spots of the number from right to left and add it to the overall sum
        int oddSum = 0;
        for (int i = numbers.length - 1; i >= 0; i -= 2) {
            //First turn the string into an integer
            int currNum = Integer.parseInt (numbers[i]);
            //Now add that number to the overall sum
            oddSum += currNum;
        }
        //Now return the overall sum of the odd numbers
        return oddSum;
    }
    
    /** Return true if the digit d is a prefix for number */
    public static boolean prefixMatched(long number, int d)
    {
        //Check to see if the int is equal to the long and if so return true
        if (number == d)
            return true;
        else
            return false;
    }
    
    /** Return the number of digits in d */
    public static int getSize(long l)
    {
        //Turn the long into a string so we can get the length of it
        String longString = Long.toString (l);
        return longString.length ();
    }
    
    /** Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k)
    {
        //Turn the number into a string
        String numberString = Long.toString (number);
        
        //Now first make sure k isn't as long as the number itself
        if (numberString.length () > k) {
            //Get the substring of the number based on k
            numberString = numberString.substring (0, k);
            //Now parse the number string into a long and return that
            return Long.parseLong (numberString);
        } else {
            //Because the number is smaller then the amount trying to get from it just return the number
            return number;
        }
    }
}
