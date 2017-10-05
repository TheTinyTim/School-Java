public class FeetAndMeterConversion {
    
    public static void main (String[] args)
    {
    
        double currentMeter = 20.0d;
        double currentFoot = 1.0d;
    
        System.out.printf("%4s%10s%20s%10s\n", "Feet", "Meters", "Meters", "Feet");
        System.out.println("---------------------------------------------");
        
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%4.1f%10.3f%20.1f%10.3f\n", currentFoot, footToMeter(currentFoot), currentMeter, meterToFoot(currentMeter));
            currentMeter += 5;
            currentFoot++;
        }
    
    }
    
    public static double footToMeter (double foot)
    {
        return 0.305d * foot;
    }
    
    public static double meterToFoot (double meter)
    {
        return 1 / 0.305d * meter;
    }
}
