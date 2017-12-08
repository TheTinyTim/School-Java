import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;

public class FileManagement {
    
    static final String KEY = "18a7592095l382hg";
    
    public static ArrayList<InventoryItem> loadFile ()
    {
        //Get the root path of the program
        String rootPath = System.getProperty ("user.dir");
        
        //Check to see if a file already exists and if not create one
        File inventoryFile = new File (rootPath + "\\inventory.xml");
        if (!inventoryFile.exists ()) {
            //Return an empty inventory item list
            return new ArrayList<InventoryItem> ();
        }
    
        //Since the inventory xml file exists let's decrypt it
        fileCrypto (inventoryFile, Cipher.DECRYPT_MODE);
        //Let's reload the decrypted file
        inventoryFile = new File (rootPath + "\\inventory.xml");
        //Set up the variable that will store if the file has been corrupted
        boolean corrupted = false;
    
        //Create the inventory list that will store the items read
        ArrayList<InventoryItem> inventoryItems = new ArrayList<> ();
        try {
            //Create a factory object that will allow us to create a file parser
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance ();
            //Let's create the document builder so we can parse the file
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder ();
            //Let's actually parse the xml file so we can read it
            Document xmlDoc = dBuilder.parse (inventoryFile);
            //Let's normalize the file so that there is no weird spaces in it
            xmlDoc.getDocumentElement ().normalize ();
    
            //Now that we have parsed the file and normalized it let's get all the different nodes of the file
            NodeList foodList = xmlDoc.getElementsByTagName ("food");
            NodeList clothingList = xmlDoc.getElementsByTagName ("clothing");
            NodeList miscList = xmlDoc.getElementsByTagName ("misc");
    
            //Now let's go through each list and loop through all the items and assign them to their appropriate classes
    
            //First the food list
            for (int i = 0; i < foodList.getLength (); i++) {
                Node foodNode = foodList.item (i);
    
                //Let's make sure this node is actually an element node
                if (foodNode.getNodeType () == Node.ELEMENT_NODE) {
                    inventoryItems.add (readFoodItem (foodNode));
                }
            }
    
            //Then the clothing list
            for (int i = 0; i < clothingList.getLength (); i++) {
                Node clothingNode = clothingList.item (i);
    
                //Let's make sure this node is actually an element node
                if (clothingNode.getNodeType () == Node.ELEMENT_NODE) {
                    inventoryItems.add (readClothingItem (clothingNode));
                }
            }
    
            //And finally the misc list
            for (int i = 0; i < miscList.getLength (); i++) {
                Node miscNode = miscList.item (i);
    
                //Let's make sure this node is actually an element node
                if (miscNode.getNodeType () == Node.ELEMENT_NODE) {
                    inventoryItems.add (readMiscItem (miscNode));
                }
            }
        } catch (SAXParseException e) {
            //This will catch if the file has been tampered with and in turn is corrupted so inform the user and ask if they want to quit the program or continue with a
            //new save file being created
            corrupted = true;
            //Delete the file
            inventoryFile.delete ();
            //Reset the inventory items in case something got added to it
            inventoryItems = new ArrayList<InventoryItem> ();
            System.out.println ("Oops! Your inventory file seems to have been corrupted.\n" +
                    "If you've tried editing the file outside of the program please don't do this.\n" +
                    "Your file will now be deleted.");
        } catch (ParserConfigurationException | SAXException | IOException e) { e.printStackTrace (); }
        
        //Now that we've read all the data from the file let's encrypt the file again so that if the user quits the program in the incorrect way it's still decrypted
        //Only encrypt the file if the file hasn't been corrupted
        if (!corrupted)
            fileCrypto (inventoryFile, Cipher.ENCRYPT_MODE);
        
        return inventoryItems;
    }
    
    //Create the methods that will load the correct data and store them into their correct classes for all possible inventory items
    private static InventoryItem readMiscItem (Node node)
    {
        //Convert the node into an element
        Element element = (Element) node;
        //Get all the different nodes that would be in a food item node
        String id = element.getAttribute ("id");
        String name = element.getElementsByTagName ("name").item (0).getTextContent ();
        double price = Double.parseDouble (element.getElementsByTagName ("price").item (0).getTextContent ());
        
        return new InventoryItem (name, id, price);
    }
    
    private static Food readFoodItem (Node node)
    {
        //Convert the node into an element
        Element element = (Element) node;
        //Get all the different nodes that would be in a food item node
        String id = element.getAttribute ("id");
        String name = element.getElementsByTagName ("name").item (0).getTextContent ();
        double price = Double.parseDouble (element.getElementsByTagName ("price").item (0).getTextContent ());
        String foodType = element.getElementsByTagName ("type").item (0).getTextContent ();
        int shelfLife = Integer.parseInt (element.getElementsByTagName ("shelflife").item (0).getTextContent ());
        
        return new Food (name, id, price, foodType, shelfLife);
    }
    
    private static Clothing readClothingItem (Node node)
    {
        //Convert the node into an element
        Element element = (Element) node;
        //Get all the different nodes that would be in a food item node
        String id = element.getAttribute ("id");
        String name = element.getElementsByTagName ("name").item (0).getTextContent ();
        double price = Double.parseDouble (element.getElementsByTagName ("price").item (0).getTextContent ());
        String color = element.getElementsByTagName ("color").item (0).getTextContent ();
        String size = element.getElementsByTagName ("size").item (0).getTextContent ();
        
        return new Clothing (name, id, price, color, size);
    }
    
    //When saving all the product data we will be given a list of InventoryItems which will even contain ALL
    //sub classes of InventoryItem. So it is our job to make sure we find out what type of class and store
    //that information into the save file. We can do this by using the getClass() method
    //This explains how to use it:
    // http://javarevisited.blogspot.com/2012/09/how-to-determine-type-of-object-runtime-identification.html
    public static void saveData (ArrayList<InventoryItem> inventoryItems)
    {
        //Get the root path of the program
        String rootPath = System.getProperty ("user.dir");
        
        try {
            //Create the object that will give access to the document builder
            DocumentBuilderFactory fileFactory = DocumentBuilderFactory.newInstance ();
            DocumentBuilder xmlBuilder = fileFactory.newDocumentBuilder ();
            
            //Let's create the root element of the xml file
            Document doc = xmlBuilder.newDocument ();
            Element rootElement = doc.createElement ("inventory");
            doc.appendChild (rootElement);
            
            //Now loop through all the inventory items in the array list and create xml elements for it based on the type of class it is
            for (InventoryItem item : inventoryItems) {
                //Find out what the main class of the file is and set the element based on the class
                Element itemElement;
                if (item.getClass () == Food.class) {
                    itemElement = doc.createElement ("food");
                    //Now store all the extra data from the food class
                    Food fItem = (Food)item;
                    
                    Element foodType = doc.createElement ("type");
                    foodType.appendChild (doc.createTextNode (fItem.getFoodType ()));
                    itemElement.appendChild (foodType);
                    
                    Element shelfLife = doc.createElement ("shelflife");
                    shelfLife.appendChild (doc.createTextNode (Integer.toString (fItem.getShelfLife ())));
                    itemElement.appendChild (shelfLife);
                } else if (item.getClass () == Clothing.class) {
                    itemElement = doc.createElement ("clothing");
                    //Now store all the extra data from the clothing class
                    Clothing cItem = (Clothing)item;
                    
                    Element color = doc.createElement ("color");
                    color.appendChild (doc.createTextNode (cItem.getColor ()));
                    itemElement.appendChild (color);
                    
                    Element size = doc.createElement ("size");
                    size.appendChild (doc.createTextNode (cItem.getSize ()));
                    itemElement.appendChild (size);
                    
                } else {
                    itemElement = doc.createElement ("misc");
                }
                
                //Now add all the generic data to the item element
                //First the attribute of the element
                Attr attribute = doc.createAttribute ("id");
                attribute.setValue (item.getProductID ());
                itemElement.setAttributeNode (attribute);
                
                Element name = doc.createElement ("name");
                name.appendChild (doc.createTextNode (item.name));
                itemElement.appendChild (name);
                
                Element price = doc.createElement ("price");
                price.appendChild (doc.createTextNode (Double.toString (item.price)));
                itemElement.appendChild (price);
                
                //Now append this element to the root element
                rootElement.appendChild (itemElement);
            }
            
            //Now let's actually write all this data to an xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance ();
            Transformer transformer = transformerFactory.newTransformer ();
            DOMSource source = new DOMSource (doc);
            StreamResult result = new StreamResult (new File (rootPath + "\\inventory.xml"));
            
            transformer.transform (source, result);
        } catch (Exception e) { e.printStackTrace (); }
    
        //Now encrypt the file
        File xmlFile = new File (rootPath + "\\inventory.xml");
        fileCrypto (xmlFile, Cipher.ENCRYPT_MODE);
    }
    
    //Let's decrypt or encrypt the file based on the mode passed
    private static void fileCrypto (File file, int mode)
    {
        try {
            //Let's turn the key we set up into a usable key by the cipher
            Key key = new SecretKeySpec (KEY.getBytes (), "AES");
            Cipher cipher = Cipher.getInstance ("AES");
            cipher.init (mode, key);
    
            //Let's create an input stream of the file to read from
            FileInputStream inputStream = new FileInputStream (file);
            //Create an array with the length set to how many bytes there are in the file
            byte[] inputBytes = new byte[(int) file.length ()];
            //Let's actually read the bytes of the file
            inputStream.read (inputBytes);
            
            //Decrypt or encrypt the bytes from the input file, based on the mode, and create an array list that holds the decrypted/encrypted file
            byte[] outputBytes = cipher.doFinal (inputBytes);
            
            //Now create an output stream so we can write the decrypted/encrypted data to the file
            FileOutputStream outputStream = new FileOutputStream (file);
            //Write to the output file
            outputStream.write (outputBytes);
            
            //Finally make sure to close the file streams
            inputStream.close ();
            outputStream.close ();
        } catch (Exception e) {  }
    }
    
}
