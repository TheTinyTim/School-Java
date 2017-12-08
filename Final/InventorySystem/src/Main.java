import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    private static ArrayList<InventoryItem> inventoryItems = new ArrayList<> ();
    public static void addToInventory (InventoryItem item) { inventoryItems.add (item); }
    
    private static Scanner input;
    
    private static boolean mainLoop = true;
    
    private static String userQuery = "";
    
    public static void main (String[] args)
    {
        inventoryItems = FileManagement.loadFile ();
    
//        InventoryItem item1 = new InventoryItem ("Toothbrush", "M01", 4.99);
//        Food food1 = new Food ("Banana", "F01", 2.99, "Fruit", 5);
//        Food food2 = new Food ("Bagels", "F02", 2.99, "Bread", 5);
//        Clothing clothing1 = new Clothing ("Bootcut Jeans", "C01", 39.99, "Light Blue", "28x32");
//        Clothing clothing2 = new Clothing ("Long Sleeved Shirt", "C02", 14.99, "Black", "Medium");
//
//        inventoryItems.add (item1);
//        inventoryItems.add (food1);
//        inventoryItems.add (food2);
//        inventoryItems.add (clothing1);
//        inventoryItems.add (clothing2);
        
        //Lets set up the input object
        input = new Scanner (System.in);
    
        drawInventoryMenu ();
        drawFunctionMenu ();
    }
    
    //This method handles drawing the inventory menu of the program and with a search query so if the user
    //ever try's to use the search feature it will only show stuff with their query
    private static void drawInventoryMenu ()
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
                //Lets find out what type of class this item is made from and assign it to the correct list while also only adding items that are in the bounds of the users search query
                if (item.getClass () == Food.class) {
                    Food fItem = (Food)item;
                    if (fItem.toString ().toLowerCase ().contains (userQuery) || userQuery == "")
                        foodItems.add (fItem);
                } else if (item.getClass () == Clothing.class) {
                    Clothing cItem = (Clothing)item;
                    if (cItem.toString ().toLowerCase ().contains (userQuery) || userQuery == "")
                        clothingItems.add (cItem);
                } else if (item.toString ().toLowerCase ().contains (userQuery) || userQuery == "") {
                    miscItems.add (item);
                }
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
    private static void drawFunctionMenu ()
    {
        //Set up some variables that will later be used in this method
        boolean menuError = false;
        String menuErrorMessage = "";
        
        //Fist let's draw the header of the menu
        System.out.println ("\n");
        
        //Display the current users search query
        if (!userQuery.isEmpty ())
            System.out.println ("\t\t\t\t\tSearch Query: " + userQuery);
        else
            System.out.println ("\t\t\t\t\tSearch Query: None");
        
        System.out.println ("\t\tFunction Menu (Press One Of The Keys Listed)");
    
        System.out.println ("\t a: Add Item\td: Delete Item\ts: Search\tq: Quit");
        
        //Let's keep looping until we get an input from the user that actually does something
        while (mainLoop) {
            //Capture the users input and if it's one of the commands do the correct thing
            System.out.print ("\nWhat would you like to do >> ");
            String userInput = input.next ();
            input.nextLine ();
            
            //Now check to see if the user inputted an actual function
            if (userInput.equals ("a")) {
                //The user is trying to add an item find out what kind of item they're trying to create
                ItemCreation.itemCreationMenu (input);
                //After the user has successfully gone out of the item creation menu break
                //out of the main menu loop to refresh the inventory menu
                break;
            } else if (userInput.equals ("d")) {
                //The user is trying to delete an item
                System.out.print ("Enter in the item ID you wish to delete >> ");
                userInput = input.nextLine ().toUpperCase ();
                removeItem (userInput);
                break;
            } else if (userInput.equals ("s")) {
                //The user is trying to search for an item
                //Ask the user what they want to search for
                if (userQuery.isEmpty ())
                    System.out.print ("\nWhat would you like to search >> ");
                else
                    System.out.print ("\nWhat would you like to search (Enter nothing to end current search) >> ");
                
                userQuery = input.nextLine ().toLowerCase ();
                break;
            } else if (userInput.equals ("q")) {
                //The user is trying to quit the program
                System.out.println ("Saving inventory file do not close the program\n" +
                        "or edit the save file outside of this program.");
                
                FileManagement.saveData (inventoryItems);
                mainLoop = false;
            } else {
                //This is not a correct function so prompt the user and display the information again
                System.out.println ("\n\n\n\n");
                menuErrorMessage = "\nYou didn't enter in a correct menu function!";
                menuError = true;
                break;
            }
        }
        
        //Check to see if the program just broke out of the loop instead of it actually ending
        if (mainLoop) {
            //If it did just break the loop this means the user didn't enter in the correct command so display the menu again and tell them what went wrong
            drawInventoryMenu ();
            
            //Display a error message if something went wrong in this menu
            if (menuError)
                System.out.println (menuErrorMessage);
            
            drawFunctionMenu ();
        }
    }
    
    //This method will make sure the user want's to actually delete the item and that that item actually exists
    private static void removeItem (String itemID)
    {
        //First check to make sure that item exists
        if (InventoryItem.checkIfProductIDExists (itemID)) {
            //The item exists so continue with item deletion
            //Make sure the user wants to delete this item
            if (yesNoQuestion ("Are you sure you want to delete " + getItemName (itemID) + "?")) {
                deleteItem (itemID);
            }
        } else {
            //The item doesn't exist so tell the user and go back to the menu
            System.out.printf ("The item ID %s doesn't exist.\n\n", itemID);
        }
    }
    
    //This method will delete an item based on the id passed
    private static void deleteItem (String id)
    {
        int index = 0;
        for (index = 0; index < inventoryItems.size (); index++) {
            if (inventoryItems.get (index).getProductID ().equals (id))
                break;
        }
        
        //Now remove the item from the list
        inventoryItems.remove (index);
    }
    
    //This method will get an items name based on the id passed
    private static String getItemName (String id)
    {
        for (InventoryItem item : inventoryItems) {
            if (item.getProductID ().equals (id))
                return item.name;
        }
        
        return "";
    }
    
    //This will have the program ask the user a yes or no question based on the message sent and return
    //a boolean based on the users response
    private static boolean yesNoQuestion (String message)
    {
        System.out.println (message + " Y/N");
        String userInput = input.next ().toUpperCase ();
        //Now fire a nextLine() so it consumes what next() didn't and the program wont skip the
        //next nextLine()
        input.nextLine ();
        
        if (userInput.equals ("Y"))
            return true;
        else
            return false;
    }
    
}