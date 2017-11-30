/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclasswork;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ni0784722
 */
public class InClassWork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //stopWatchTest ();
        
        //accountTest ();
        
        //fanTest ();
        
        polygonTest ();
    }
    
    public static void stopWatchTest ()
    {
        System.out.println ("I'm going to create and sort 100,000 random numbers and tell you how long it takes.");
        StopWatch stopWatch = new StopWatch ();
        stopWatch.start();
        //Now go through and create a list with 100,000 randomly generated numbers
        Random rand = new Random ();
        ArrayList<Integer> nums = new ArrayList <Integer> ();
        for (int i = 0; i < 100000; i++) {
            nums.add (rand.nextInt ());
        }
        //Now go through all the numbers and sort them
        ArrayList <Integer> sortedNums = new ArrayList <Integer> ();
        for (int i = 0; i < nums.size (); i++) {
            int indexSpot = 0;
            if (sortedNums.size () != 0) {
                for (int index = 0; index < sortedNums.size (); index++) {
                    if (sortedNums.get (index) > nums.get (i)) {
                        indexSpot = index;
                        break;
                    } else {
                        indexSpot = index;
                    }
                }
            }
            if (sortedNums.size () == indexSpot) {
                sortedNums.add (nums.get (i));
            } else {
                sortedNums.add (indexSpot, nums.get (i));
            }
        }
        stopWatch.stop ();
        System.out.printf ("It took %1.02f seconds to sort 100,000 random numbers\n", stopWatch.getElapsedTime ());
    }
    
    public static void accountTest ()
    {
        Account account = new Account (1122, 20000);
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.printf("Account status:\n"
                + "\tBalance: %1.2f\n"
                + "\tMonthly Intrest: %1.2f\n"
                + "\tDate Created: %s\n",
                account.getBalance(), account.getMonthlyIntrest(), account.getDateCreated());
    }
    
    public static void fanTest ()
    {
        Fan yellowFan = new Fan ();
        yellowFan.setColor ("Yellow");
        yellowFan.setSpeed (3);
        yellowFan.setRadius (10);
        yellowFan.setOn (true);
        
        Fan blueFan = new Fan ();
        blueFan.setSpeed (2);
        blueFan.setRadius (5);
    
        System.out.println (yellowFan.toString ());
        System.out.println (blueFan.toString ());
    }
    
    public static void polygonTest ()
    {
        RegularPolygon firstPolygon = new RegularPolygon ();
        RegularPolygon secondPolygon = new RegularPolygon (6, 4);
        RegularPolygon thirdPolygon = new RegularPolygon (10, 4, 5.6, 7.8);
    
        System.out.println ("First Polygon");
        System.out.println ("    Perimeter: " + firstPolygon.getPerimeter ());
        System.out.println ("    Area: " + firstPolygon.getArea ());
    
        System.out.println ("Second Polygon");
        System.out.println ("    Perimeter: " + secondPolygon.getPerimeter ());
        System.out.println ("    Area: " + secondPolygon.getArea ());
    
        System.out.println ("Third Polygon");
        System.out.println ("    Perimeter: " + thirdPolygon.getPerimeter ());
        System.out.println ("    Area: " + thirdPolygon.getArea ());
    }
    
}
