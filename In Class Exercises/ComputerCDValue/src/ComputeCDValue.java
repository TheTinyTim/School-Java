import java.util.Scanner;

public class ComputeCDValue {
    
    public static void main (String[] args)
    {
        //Initialize the Scanner
        Scanner input = new Scanner (System.in);
        
        //Prompt the user to input all the needed information
        System.out.println ("How much is in the CD?");
        double cdAmount = input.nextDouble ();
    
        System.out.println ("What is the annual interest rate?");
        double cdInterest = input.nextDouble ();
    
        System.out.println ("How many months do you want to test for?");
        int lengthMonths = input.nextInt ();
        
        //Start going through each month and calculate the interest in the CD
        for (int i = 1; i <= lengthMonths; i++) {
            //Do the math to find out the amount gained this month
            double newCDAmount = cdAmount + (cdAmount * (cdInterest / 1200));
            
            //Get if month should be plural or not
            String monthType = i + " Month";
            if (i != 1)
                monthType = i + " Months";
            
            //Now display to the user what they earned in interest
            System.out.printf ("After %s, the CD is worth:\n" +
                    "\t%1.2f + (%1.2f * (%1.2f / 1200)) = %1.2f\n\n",
                    monthType, cdAmount, cdAmount, cdInterest, newCDAmount);
            
            //Make sure to set the cdAmount to the new amount to keep adding on to it
            cdAmount = newCDAmount;
        }
    }
}
