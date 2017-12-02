public class Clothing extends InventoryItem {

    //Strings
    private String color;
    private String size;
    
    public Clothing (String productName, String productID, double productPrice, String clothingColor, String clothingSize)
    {
        super (productName, productID, productPrice);
        
        color = clothingColor;
        size = clothingSize;
    }
    
    //This method will take all the relevant data and turn it into a string and return it
    public String toString () { return getProductID () + " " + size + " " + color + " " + name + " " + " $" + price; }
    
}
