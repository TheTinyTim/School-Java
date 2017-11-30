public class Main {
    
    public static void main (String[] args)
    {
        
        try {
            InventoryItem item1 = new InventoryItem ("Item1", "I01", 9.99);
            Food item2 = new Food ("Item2", "I02", 1.99);
            Clothing item3 = new Clothing ("Item3", "I01", 15.99);
        } catch (IllegalArgumentException e) {
            System.out.println (e.getMessage ());
        }
        
    }
    
}
