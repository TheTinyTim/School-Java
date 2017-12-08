import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Food extends InventoryItem {
    
    //Static variables/methods
    
    //This method will set up a food item from an xml node
    public static InventoryItem setUpFromXML (Node itemNode)
    {
        //Convert the node into an element
        Element element = (Element) itemNode;
        //Get all the different nodes that would be in a food item node
        String id = element.getAttribute ("id");
        String name = element.getElementsByTagName ("name").item (0).getTextContent ();
        double price = Double.parseDouble (element.getElementsByTagName ("price").item (0).getTextContent ());
        String foodType = element.getElementsByTagName ("type").item (0).getTextContent ();
        int shelfLife = Integer.parseInt (element.getElementsByTagName ("shelflife").item (0).getTextContent ());
    
        return new Food (name, id, price, foodType, shelfLife);
    }
    
    //Strings
    private String foodType;
    public String getFoodType () { return foodType; }
    
    //Ints
    private int shelfLife;
    public int getShelfLife () { return shelfLife; }
    
    public Food (String productName, String productID, double productPrice, String foodType, int shelfLife)
    {
        super (productName, productID, productPrice);
    
        //First lets make sure the shelf life isn't set to a 0 or a negative number
        if (shelfLife <= 0) {
            //Because the shelf life is less than or equal to 0 we need to throw an exception telling
            //the program this can't be done
            throw new IllegalArgumentException (productName + "'s shelf life can't be less than or equal to 0!");
        }
        
        //Now set the variables since the shelf life is correct
        this.foodType = foodType;
        this.shelfLife = shelfLife;
    }
    
    //This method will take all the relevant data and turn it into a string and return it
    public String toString () { return getProductID () + "\t" + name + "\t" + foodType + "\t" + shelfLife + "\t$" + price; }
    
}
