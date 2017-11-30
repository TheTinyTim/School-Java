/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclasswork;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ni0784722
 */
public class InClassWork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch ();
        stopWatch.start();
        //Now go through and create a list with 100,000 randomly generated numbers
        Random rand = new Random ();
        List <int> nums = new List <int> ();
        for (int i = 0; i < 100000; i++) {
            
        }
        
        
//        Account account = new Account (1122, 20000);
//        account.setAnnualInterestRate(4.5);
//        account.withdraw(2500);
//        account.deposit(3000);
//        System.out.printf("Account status:\n"
//                + "\tBalance: %1.2f\n"
//                + "\tMonthly Intrest: %1.2f\n"
//                + "\tDate Created: %s\n",
//                account.getBalance(), account.getMonthlyIntrest(), account.getDateCreated());
    }
    
}
