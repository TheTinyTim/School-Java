import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends JFrame implements KeyListener{
    
    private static ArrayList<InventoryItem> inventoryItems = new ArrayList<> ();
    
    private static Scanner input;
    
    private boolean loop = true;
    
    public static void main (String[] args)
    {
        //Create and start the program
        new Main ();
    }
    
    public Main ()
    {
        InventoryItem item1 = new InventoryItem ("Toothbrush", "M01", 4.99);
        Food food1 = new Food ("Banana", "F01", 2.99, "Fruit", 5);
        Food food2 = new Food ("Bagels", "F02", 2.99, "Bread", 5);
        Clothing clothing1 = new Clothing ("Bootcut Jeans", "C01", 39.99, "Light Blue", "28x32");
        Clothing clothing2 = new Clothing ("Long Sleeved Shirt", "C02", 14.99, "Black", "Medium");
    
        inventoryItems.add (item1);
        inventoryItems.add (food1);
        inventoryItems.add (food2);
        inventoryItems.add (clothing1);
        inventoryItems.add (clothing2);
    
        //Let's set up the variable that will handle the users input
        input = new Scanner (System.in);
    
        //Add the key listener
        addKeyListener (this);
    
        drawInventoryMenu ();
        drawFunctionMenu ();
    }
    
    //This method handles drawing the inventory menu of the program
    private void drawInventoryMenu ()
    {
        
        //First let's draw the header of the menu
        System.out.println ("\t\t\t\t\tInventory Manager");
        System.out.println ("\t\t\t\t   By: Nicholas Ingram");
        
        //Now let's check if there's any items in the inventory at the moment
        if (inventoryItems.size () > 0) {
            //Now that we know there are items in the list let's loop through all of them and assign them to more specific lists based on the type of item they are
            ArrayList<InventoryItem> miscItems = new ArrayList<> ();
            ArrayList<Food> foodItems = new ArrayList<> ();
            ArrayList<Clothing> clothingItems = new ArrayList<> ();
            
            for (InventoryItem item : inventoryItems) {
                //Lets find out what type of class this item is made from and assign it to the correct list
                if (item.getClass () == Food.class)
                    foodItems.add ((Food)item);
                else if (item.getClass () == Clothing.class)
                    clothingItems.add ((Clothing)item);
                else
                    miscItems.add (item);
            }
            
            //Now that we have all the items categorized based on the base class it was created from let's go ahead and loop
            //through all the items and display them on the screen
            
            //First we go through the food items but only if there are some that's been created
            if (foodItems.size () > 0) {
                //Draw the sub menu header
                System.out.println ("\nFood:\t\tID\tName\tType\tShelf Life (days)\tPrice");
                
                //Now let's loop through all the items and draw them onto the screen one by one
                for (Food foodItem : foodItems) {
                    System.out.println ("\t\t\t" + foodItem.toString ());
                }
            }
            
            //Now do the same for clothing items
            if (clothingItems.size () > 0) {
                //Draw the sub menu header
                System.out.println ("\nClothing:\tID\tSize\tColor\tName\tPrice");
                
                //Loop through all the items and add them to the menu
                for (Clothing clothingItem : clothingItems) {
                    System.out.println ("\t\t\t" + clothingItem.toString ());
                }
            }
            
            //Finally do the same for misc items
            if (miscItems.size () > 0) {
                //Draw the sub menu header
                System.out.println ("\nMisc:\t\tID\tName\tPrice");
                
                //Loop through all the items and add them to the menu
                for (InventoryItem miscItem : miscItems) {
                    System.out.println ("\t\t\t" + miscItem.toString ());
                }
            }
        }
    }
    
    //This method will handle drawing the function menu as well as interpreting the users key presses and if they correlate to any specific program functionality
    private void drawFunctionMenu ()
    {
        //Fist let's draw the header of the menu
        System.out.println ("\n");
        System.out.println ("\t\tFunction Menu (Press One Of The Keys Listed)");
    
        System.out.println ("\t a: Add Item\td: Delete Item\ts: Search\tq: Quit");
        
        //Let's keep looping until we get an input from the user that actually does something
        while (loop) {
        
        }
    }
    
    //Set up all the variables needed to implement the KeyListener
    public void keyPressed (KeyEvent event)
    {
        /*
            KeyCodes (http://monkeyfighter.com/images/games/keycodes.gif):
                a - 65
                d - 68
                s - 83
                q - 81
         */
        
        //Check if any of the menu keys pressed
        if (event.getKeyCode () == 65)
            System.out.println ("A pressed");
        else if (event.getKeyCode () == 81)
            loop = false;
    }
    
    public void keyReleased (KeyEvent event)
    {
    
    }
    
    public void keyTyped (KeyEvent event)
    {
    
    }
    
}