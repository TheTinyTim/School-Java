import java.util.Scanner;

public class ItemCreation {
    
    //This method will ask the user what kind of item they want to create or if they want to back out of this menu
    public static void itemCreationMenu (Scanner input)
    {
        //Keep looping through asking the user what they want to do until they enter in a correct command
        //Commands:
        //  f - create a food item
        //  c - create a clothing item
        //  o - create a misc item
        //  b - back out of the loop and back to the main menu
        while (true) {
            System.out.println ("\nWhat kind of item would you like to make?\n" +
                    "f: Food c: Clothing o: Other b: Back");
            String userInput = input.next ();
            //Now fire a nextLine() so it consumes what next() didn't and the program wont skip the
            //next nextLine()
            input.nextLine ();
        
            if (userInput.equals ("f")) {
                //Create a food item
                createItem ("food", input);
                break;
            } else if (userInput.equals ("c")) {
                //Create a clothing item
                createItem ("clothing", input);
                break;
            } else if (userInput.equals ("o")) {
                //Create a misc item
                createItem ("misc", input);
                break;
            } else if (userInput.equals ("b")) {
                //Back out of this menu
                break;
            } else {
                System.out.println ("That command doesn't exist.");
            }
        }
    }
    
    //This method will handle everything needed to create items to the inventory manager
    private static void createItem (String itemType, Scanner input)
    {
        //First let's get the base information that will be in every item
        System.out.print ("Item Name >> ");
        String itemName = input.nextLine ();
        
        //Keep looping through until the user enters in a product ID that doesn't exist
        String itemID = "";
        while (true) {
            System.out.print ("Unique Item ID >> ");
            itemID = input.nextLine ();
            if (!InventoryItem.checkIfProductIDExists (itemID))
                break;
            else
                System.out.printf ("That product ID: %s already exists! Please enter a different one.\n", itemID);
        }
        
        double itemPrice = onlyNumberEntry ("Item Price", input);
        input.nextLine ();
        
        //Now let's get the specifics of the item being created
        if (itemType == "food") {
            
            System.out.print ("Type Of Food >> ");
            String foodType = input.nextLine ();
            
            int shelfLife =  (int)onlyNumberEntry ("Shelf Life", input);
            input.nextLine ();
            
            System.out.printf ("ID: %s | Name: %s | Food Type: %s | Shelf Life: %d | Price: $%1.2f\n",
                    itemID, itemName, foodType, shelfLife, itemPrice);
            //Check to see if the user wants to re-enter the data
            if (yesNoQuestion ("Would you like to keep this data?", input)) {
                Main.addToInventory (new Food (itemName, itemID, itemPrice, foodType, shelfLife));
            }
            
        } else if (itemType == "clothing") {
            
            System.out.print ("Clothing Color >> ");
            String color = input.nextLine ();
            
            System.out.print ("Clothing Size >> ");
            String size = input.nextLine ();
            
            System.out.printf ("ID: %s | Name: %s | Clothing Color: %s | Clothing Size: %s | Price: $%1.2f\n",
                    itemID, itemName, color, size, itemPrice);
            //Check to see if the user wants to re-enter the data
            if (yesNoQuestion ("Would you like to keep this data?", input)) {
                Main.addToInventory (new Clothing (itemName, itemID, itemPrice, color, size));
            }
            
        } else if (itemType == "misc") {
            
            System.out.printf ("ID: %s | Name: %s | Price: $%1.2f\n", itemID, itemName, itemPrice);
            //Check to see if the user wants to re-enter the data
            if (yesNoQuestion ("Would you like to keep this data?", input)) {
                Main.addToInventory (new InventoryItem (itemName, itemID, itemPrice));
            }
            
        }
    }
    
    //This will have the program ask the user a yes or no question based on the message sent and return
    //a boolean based on the users response
    private static boolean yesNoQuestion (String message, Scanner input)
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
    
    //This method will make sure the user enters in a number
    private static double onlyNumberEntry (String message, Scanner input)
    {
        //Initialize the variable to return later
        double userInput;
        //Start a loop so the user has to keep entering something in until they enter a double in
        while (true) {
            System.out.print (message + " >> ");
            try {
                //Get the users input
                userInput = input.nextDouble ();
                //If the user entered in a number break out of the loop
                break;
            } catch (Exception e) {
                //If the user didn't enter in a number this will catch it and not stop the program out right
                System.out.println ("You must enter in numbers!\n");
                input.nextLine ();
            }
        }
        //Now return the users number
        return userInput;
    }
    
}
