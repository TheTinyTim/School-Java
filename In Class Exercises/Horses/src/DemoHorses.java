public class DemoHorses {
    
    public static void main (String[] args)
    {
        Horse normalHorse = new Horse ();
        normalHorse.setName ("Sea Biscuit");
        normalHorse.setColor ("Brown");
        normalHorse.setBirthYear (2010);
    
        System.out.printf ("Horse Name: %s\nColor: %s\nBirth Year: %d\n\n",
                normalHorse.getName (), normalHorse.getColor (), normalHorse.getBirthYear ());
        
        RaceHorse raceHorse = new RaceHorse ();
        raceHorse.setName ("Lightning");
        raceHorse.setColor ("White");
        raceHorse.setBirthYear (2011);
        raceHorse.addRaces (4);
        raceHorse.addRaces (1);
    
        System.out.printf ("Race Horse Name: %s\nColor: %s\nBirth Year: %d\nNumber Of Races: %d\n\n",
                raceHorse.getName (), raceHorse.getColor (), raceHorse.getBirthYear (), raceHorse.getNumOfRaces ());
    }
    
}
