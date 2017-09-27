import java.util.Scanner;

public class CelsiusAndFahrenheitConversion {
    
    public static void main (String[] args)
    {
//        //With input

//        //Initialize the Scanner
//        Scanner input = new Scanner (System.in);
//
//        //Prompt the user if they want to convert celsius or fahrenheit
//        System.out.println ("Do you want to convert (C)elsius to Fahrenheit? Or (F)ahrenheit to Celsius?");
//        char userConversion = input.next ().toUpperCase ().charAt (0);
//
//        //Figure out which one they're wanting to do
//        if (userConversion == 'C') {
//            //Prompt the user to enter in a degree in celsius
//            System.out.println ("Please enter in the Temperature you want converted from Celsius to Fahrenheit");
//            double celsius = input.nextDouble ();
//            //Now display the results
//            System.out.printf ("%1.02f° Celsius -> %1.02f° Fahrenheit", celsius, celsiusToFahrenheit (celsius));
//        } else if (userConversion == 'F') {
//            //Prompt the user to enter in a degree in fahrenheit
//            System.out.println ("Please enter in the Temperature you want converted from Fahrenheit to Celsius");
//            double fahrenheit = input.nextDouble ();
//            //Now display the results
//            System.out.printf ("%1.02f° Fahrenheit -> %1.02f° Celsius", fahrenheit, fahrenheitToCelsius (fahrenheit));
//        } else {
//            System.out.println ("You did not enter in a valid conversion!");
//        }
        
//        //With table
//
//        //First set the starting celsius and fahrenheit variables
//        double currentCelsius = 40.0d;
//        double currentFahrenheit = 120.0d;
//
//        //Now print out the top of the table
//        System.out.println ("Celsius    Fahrenheit    |    Fahrenheit    Celsius");
//        //Now draw the line under it by going through a for loop based on the length of the top string
//        for (int i = 0; i < "Celsius    Fahrenheit    |    Fahrenheit    Celsius".length (); i++) {
//            System.out.printf ("-");
//        }
//
//        //Now loop 9 times getting the converted degrees for both the current celsius/fahrenheit and display them
//        for (int i = 0; i <= 9; i++) {
//
//            String firstSpaces = getSpacesBasedOnLengthCelsius (doubleToStringOneDec (currentCelsius));
//            String secondSpaces = getSpacesBasedOnLengthFahrenheit (doubleToStringOneDec (celsiusToFahrenheit (currentCelsius)));
//            String thirdSpaces = getSpacesBasedOnLengthFahrenheit (doubleToStringOneDec (currentFahrenheit));
//            //String fourthSpaces = getSpacesBasedOnLength (doubleToStringOneDec (fahrenheitToCelsius (currentFahrenheit)));
//
//            System.out.printf ("\n%1.01f°%s%1.01f°%s|    %1.01f°%s%1.01f°",
//                    currentCelsius, firstSpaces, celsiusToFahrenheit (currentCelsius), secondSpaces,
//                    currentFahrenheit, thirdSpaces, fahrenheitToCelsius (currentFahrenheit));
//
//            //Now subtract 1 from celsius
//            currentCelsius--;
//            //And 10 from fahrenheit
//            currentFahrenheit -= 10;
//        }
    
        //With table and input
    
        //Initialize the Scanner
        Scanner input = new Scanner (System.in);
        //Prompt the user to put in a starting celsius value
        System.out.println ("Please enter in the starting value for Celsius");
        double currentCelsius = input.nextDouble ();
        //Now prompt the user to put in the starting fahrenheit value
        System.out.println ("Please enter in the starting value for Fahrenheit");
        double currentFahrenheit = input.nextDouble ();
        //Now prompt the user how much they want the program to loop through the number and subtract from it
        System.out.println ("How many times do you want me to convert the number and subtract from your starting values?");
        int loopNum = input.nextInt ();
        
        //Now make a space to make things look neat
        System.out.println ("");
    
        //Now print out the top of the table
        System.out.println ("Celsius    Fahrenheit    |    Fahrenheit    Celsius");
        //Now draw the line under it by going through a for loop based on the length of the top string
        for (int i = 0; i < "Celsius    Fahrenheit    |    Fahrenheit    Celsius".length (); i++) {
            System.out.printf ("-");
        }
    
        //Now loop 9 times getting the converted degrees for both the current celsius/fahrenheit and display them
        for (int i = 0; i <= loopNum; i++) {
        
            String firstSpaces = getSpacesBasedOnLengthCelsius (doubleToStringOneDec (currentCelsius));
            String secondSpaces = getSpacesBasedOnLengthFahrenheit (doubleToStringOneDec (celsiusToFahrenheit (currentCelsius)));
            String thirdSpaces = getSpacesBasedOnLengthFahrenheit (doubleToStringOneDec (currentFahrenheit));
            //String fourthSpaces = getSpacesBasedOnLength (doubleToStringOneDec (fahrenheitToCelsius (currentFahrenheit)));
        
            System.out.printf ("\n%1.01f°%s%1.01f°%s|    %1.01f°%s%1.01f°",
                    currentCelsius, firstSpaces, celsiusToFahrenheit (currentCelsius), secondSpaces,
                    currentFahrenheit, thirdSpaces, fahrenheitToCelsius (currentFahrenheit));
        
            //Now subtract 1 from celsius
            currentCelsius--;
            //And 10 from fahrenheit
            currentFahrenheit -= 10;
        }
    }
    
    public static double celsiusToFahrenheit (double celsius)
    {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }
    
    public static double fahrenheitToCelsius (double fahrenheit)
    {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }
    
    public static String doubleToStringOneDec (double decimal)
    {
        String stringDouble = Double.toString (decimal);
        String[] stringArr = stringDouble.split ("\\.");
        return (stringArr[0] + "." + stringArr[1].substring (0,1) + "°");
    }
    
    public static String getSpacesBasedOnLengthCelsius (String value)
    {
        String spacesToReturn = "";
        
        //Loop through the characters and add a space for each one and then 4 more for the tabbed spaces
        for (int i = 0; i < ("Celsius".length () - value.length ()) + 4; i++) {
            spacesToReturn += " ";
        }
        
        return spacesToReturn;
    }
    
    public static String getSpacesBasedOnLengthFahrenheit (String value)
    {
        String spacesToReturn = "";
        
        //Loop through the characters and add a space for each one and then 4 more for the tabbed spaces
        for (int i = 0; i < ("Fahrenheit".length () - value.length ()) + 4; i++) {
            spacesToReturn += " ";
        }
        
        return spacesToReturn;
    }
}
