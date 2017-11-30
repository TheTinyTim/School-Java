/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclasswork;

import java.util.Date;

/**
 *
 * @author ni0784722
 */
public class Account {
    
    private int id;    
    public int getId () { return id; }
    public void setId (int i) { id = i; }
    
    private double balance;    
    public double getBalance () { return balance; }
    public void setBalance (double b) { balance = b; }
    
    private double annualInterestRate;
    public double getAnnualInterestRate () { return annualInterestRate; }
    public void setAnnualInterestRate (double rate) { annualInterestRate = rate; }
    
    private Date dateCreated;
    public String getDateCreated () { return dateCreated.toString(); }
    
    public Account ()
    {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
    }
    
    public Account (int id, double balance)
    {
        this.id = id;
        this.balance = balance;
        annualInterestRate = 0;
        dateCreated = new Date ();
    }
    
    private double getMonthlyIntrestRate () { return (annualInterestRate / 100) / 12; }
    public double getMonthlyIntrest () { return balance * getMonthlyIntrestRate(); }
    
    public void withdraw (int amount) { balance -= amount; }    
    public void deposit (int amount) { balance += amount; }
    
}
