import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;

public class InventoryItem {
    
    //Set up all the needed static variables/methods for the class
    //Create a static list to store all of the current product id's made
    private static ArrayList<String> productIDs = new ArrayList<> ();
    //Set up a setter for this array list however it will only ever be used when the program first
    //starts up and we're reading from the text file. Since the file is encrypted we shouldn't have to deal
    //with checking for duplicate IDs
    public void addProductID (String id) { productIDs.add (id); }
    
    //This method will make sure the product ID being created isn't currently in use with any of the other products
    public static boolean checkIfProductIDExists (String id)
    {
        if (productIDs.contains (id))
            return true;
        else
            return false;
    }
    
    //This method will set up a inventory item from an xml node
    public static InventoryItem setUpFromXML (Node itemNode)
    {
        //Convert the node into an element
        Element element = (Element) itemNode;
        //Get all the different nodes that would be in a food item node
        String id = element.getAttribute ("id");
        String name = element.getElementsByTagName ("name").item (0).getTextContent ();
        double price = Double.parseDouble (element.getElementsByTagName ("price").item (0).getTextContent ());
    
        return new InventoryItem (name, id, price);
    }
    
    //Set up all the needed variables for a base inventory item
    //Strings
    public String name;
    
    private String productID;//Restrict the access to the product ID so it can't be set to anything after item creation
    public String getProductID () { return productID; }
    
    //Doubles
    public double price;
    
    public InventoryItem (String productName, String productID, double productPrice)
    {
        //First lets make sure that the product ID passed isn't already being used by something
        if (checkIfProductIDExists (productID)) {
            //If it is already in use throw an error to be caught
            throw new IllegalArgumentException ("Product ID: " + productID + " for product " + productName + " already exists!");
        }
        
        //Since the product ID doesn't already exist we can go ahead and set up the variables
        name = productName;
    
        //Make sure when we're setting the product ID we also add it to the list of product IDs
        this.productID = productID;
        addProductID (productID);
        
        price = productPrice;
    }
    
    //This method will take all the relevant data and turn it into a string and return it
    public String toString () { return productID + "\t" + name + "\t$" + price; }
    
}
