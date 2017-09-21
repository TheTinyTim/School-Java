import java.util.Scanner;

public class OrderThreeCities {
    
    public static void main (String[] args)
    {
        //Initialize the scanner
        Scanner input = new Scanner (System.in);
        
        //Get the three cities from the user
        System.out.println ("Enter the first city: ");
        String firstCity = input.nextLine ();
    
        System.out.println ("Enter the second city: ");
        String secondCity = input.nextLine ();
    
        System.out.println ("Enter the third city: ");
        String thirdCity = input.nextLine ();
        
        //Now order the strings based on the first letter
        String firstCityLetter = firstCity.toUpperCase ().substring (0);
        String secondCityLetter = secondCity.toUpperCase ().substring (0);
        String thirdCityLetter = thirdCity.toUpperCase ().substring (0);
        
        String cityOne = "";
        String cityTwo = "";
        String cityThree = "";
    
        if (firstCityLetter.compareTo (secondCityLetter) < 0 && firstCityLetter.compareTo (thirdCityLetter) < 0)
            cityOne = firstCity;
        else if (firstCityLetter.compareTo (secondCityLetter) < 0 && firstCityLetter.compareTo (thirdCityLetter) > 0)
            cityTwo = firstCity;
        else if (firstCityLetter.compareTo (secondCityLetter) > 0 && firstCityLetter.compareTo (thirdCityLetter) < 0)
            cityTwo = firstCity;
        else
            cityThree = firstCity;
    
        if (secondCityLetter.compareTo (firstCityLetter) < 0 && secondCityLetter.compareTo (thirdCityLetter) < 0)
            cityOne = secondCity;
        else if (secondCityLetter.compareTo (firstCityLetter) > 0 && secondCityLetter.compareTo (thirdCityLetter) < 0)
            cityTwo = secondCity;
        else if (secondCityLetter.compareTo (firstCityLetter) < 0 && secondCityLetter.compareTo (thirdCityLetter) > 0)
            cityTwo = secondCity;
        else
            cityThree = secondCity;
    
        if (thirdCityLetter.compareTo (firstCityLetter) < 0 && thirdCityLetter.compareTo (secondCityLetter) < 0)
            cityOne = thirdCity;
        else if (thirdCityLetter.compareTo (firstCityLetter) > 0 && thirdCityLetter.compareTo (secondCityLetter) < 0)
            cityTwo = thirdCity;
        else if (thirdCityLetter.compareTo (firstCityLetter) < 0 && thirdCityLetter.compareTo (secondCityLetter) > 0)
            cityTwo = thirdCity;
        else
            cityThree = thirdCity;
    
        System.out.printf ("The three cities in alphabetical order are %s, %s, %s", cityOne, cityTwo, cityThree);
    }
}
