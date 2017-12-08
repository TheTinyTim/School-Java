import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Clothing extends InventoryItem {
    
    //Static variables/methods
    
    //This method will set up a clothing item from an xml node
    public static InventoryItem setUpFromXML (Node itemNode)
    {
        //Convert the node into an element
        Element element = (Element) itemNode;
        //Get all the different nodes that would be in a food item node
        String id = element.getAttribute ("id");
        String name = element.getElementsByTagName ("name").item (0).getTextContent ();
        double price = Double.parseDouble (element.getElementsByTagName ("price").item (0).getTextContent ());
        String color = element.getElementsByTagName ("color").item (0).getTextContent ();
        String size = element.getElementsByTagName ("size").item (0).getTextContent ();
    
        return new Clothing (name, id, price, color, size);
    }
    
    //Strings
    private String color;
    public String getColor () { return color; }
    
    private String size;
    public String getSize () { return size; }
    
    public Clothing (String productName, String productID, double productPrice, String clothingColor, String clothingSize)
    {
        super (productName, productID, productPrice);
        
        color = clothingColor;
        size = clothingSize;
    }
    
    //This method will take all the relevant data and turn it into a string and return it
    public String toString () { return getProductID () + "\t" + size + "\t" + color + "\t" + name + "\t$" + price; }
    
}
