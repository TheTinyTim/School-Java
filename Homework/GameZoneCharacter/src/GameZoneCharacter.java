import java.util.Scanner;

public class GameZoneCharacter {
    
    //The characters attributes
    public static String characterName;
    public static String characterClass;
    public static String characterAge;
    
    public static void main (String[] args)
    {
        //Initialize the Scanner
        Scanner input = new Scanner (System.in);
    
        System.out.println ("What is your characters name?");
        String userCharacterName = input.nextLine ();
    
        System.out.println ("What is your characters class (optional)");
        String userCharacterClass = input.nextLine ();
    
        System.out.println ("What is your characters age (optional)");
        String userCharacterAge = input.nextLine ();
        
        //Now check all the variables if the user has set any of them to nothing
        //First make sure the user entered a character name and if not they can't continue the program
        if (!userCharacterName.equals ("")) {
            //Now find out what variables they didn't enter and use the correct overloaded method
            if (!userCharacterAge.equals ("")) {
                createCharacter (userCharacterName, userCharacterClass, userCharacterAge);
            } else if (!userCharacterClass.equals ("")) {
                createCharacter (userCharacterName, userCharacterClass);
            } else {
                createCharacter (userCharacterName);
            }
        } else {
            System.out.println ("You need to enter a name for the character.");
        }
    }
    
    public static void createCharacter (String name)
    {
        characterName = name;
        characterClass = "";
        characterAge = "";
    
        System.out.println (characterName);
    }
    
    public static void createCharacter (String name, String cClass)
    {
        characterName = name;
        characterClass = cClass;
        characterAge = "";
    
        System.out.println (characterName);
        System.out.println (characterClass);
    }
    
    public static void createCharacter (String name, String cClass, String age)
    {
        characterName = name;
        characterClass = cClass;
        characterAge = age;
    
        System.out.println (characterName);
        if (!characterClass.equals (""))
            System.out.println (characterClass);
        System.out.println (characterAge);
    }
}
