public class DemoItemsAndPets {
    
    public static void main (String[] args)
    {
        ItemSold itemSoldOne = new ItemSold ();
        itemSoldOne.setDescription ("A squeak toy for dogs");
        itemSoldOne.setInvoiceNum (1);
        itemSoldOne.setPrice (9.99);
    
        System.out.printf ("Item Description: %s\nInvoice Number: %d\nPrice: $%1.02f\n\n",
                itemSoldOne.getDescription (), itemSoldOne.getInvoiceNum (), itemSoldOne.getPrice ());
    
        ItemSold itemSoldTwo = new ItemSold ();
        itemSoldTwo.setDescription ("A laser pointer toy for cats");
        itemSoldTwo.setInvoiceNum (2);
        itemSoldTwo.setPrice (4.99);
    
        System.out.printf ("Item Description: %s\nInvoice Number: %d\nPrice: $%1.02f\n\n",
                itemSoldTwo.getDescription (), itemSoldTwo.getInvoiceNum (), itemSoldTwo.getPrice ());
        
        PetSold dogSold = new PetSold ();
        dogSold.setDescription ("A lovable little puppy");
        dogSold.setInvoiceNum (3);
        dogSold.setPrice (99.99);
        dogSold.setHouseBroken (false);
        dogSold.setVaccinated (true);
        dogSold.setNeutered (false);
    
        System.out.printf ("Item Description: %s\nInvoice Number: %d\nPrice: $%1.02f\n" +
                        "Is House Broken: %s\nIs Vaccinated: %s\nIs Neutered: %s\n\n",
                dogSold.getDescription (), dogSold.getInvoiceNum (), dogSold.getPrice (),
                dogSold.isHouseBroken (), dogSold.isVaccinated (), dogSold.isNeutered ());
        
        PetSold catSold = new PetSold ();
        catSold.setDescription ("An older cat that loves to cuddle");
        catSold.setInvoiceNum (4);
        catSold.setPrice (99.99);
        catSold.setHouseBroken (true);
        catSold.setVaccinated (true);
        catSold.setNeutered (true);
    
        System.out.printf ("Item Description: %s\nInvoice Number: %d\nPrice: $%1.02f\n" +
                        "Is House Broken: %s\nIs Vaccinated: %s\nIs Neutered: %s\n\n",
                catSold.getDescription (), catSold.getInvoiceNum (), catSold.getPrice (),
                catSold.isHouseBroken (), catSold.isVaccinated (), catSold.isNeutered ());
    }
    
}
