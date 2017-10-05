import java.util.Scanner;

public class GameZoneQuizQuestions {
    
    //Set up the question and answer arrays
    static String[] questions = new String[] {
            "1) Who is the fastest of these video game characters?\n" +
                    "A) Mario\n" +
                    "B) Sonic\n" +
                    "C) Donkey Kong\n",
            "2) In the game Halo, what is the name of Master Chief's AI Sidekick?\n" +
                    "A) Cortana\n" +
                    "B) Arbiter\n" +
                    "C) 343 Guilty Spark\n",
            "3) What is the Konami code?\n" +
                    "A) Up-Down-Up-Down-Left-Left-Right-Right-A-B-Start\n" +
                    "B) Up-Up-Down-Down-Left-Right-Left-Right-B-A-Start\n" +
                    "C) Down-Down-Up-Up-Right-Left-Right-Left-B-A-Select\n",
            "4) What video game console has the highest number of sales of all time?\n" +
                    "A) Xbox 360\n" +
                    "B) Wii\n" +
                    "C) Playstation 2\n",
            "5) Which of these do you not do in We Love Katamari, the sequel to Katamari Damacy?\n" +
                    "A) Roll around under water\n" +
                    "B) Roll around a summo Wrestler\n" +
                    "C) Roll around on the moon\n",
            "6) Which of these bands is not featured in Guitar Hero III: Legends of Rock?\n" +
                    "A) Metallica\n" +
                    "B) Weezer\n" +
                    "C) Iron Maiden\n",
            "7) What was Nintendos first try at an arcade game?\n" +
                    "A) Super Mario Brothers\n" +
                    "B) Donkey Kong Jr.\n" +
                    "C) Donkey Kong\n",
            "8) Which company created Tails?\n" +
                    "A) Sega\n" +
                    "B) Nintendo\n" +
                    "C) Rare\n",
            "9) Which game is considered a 3D platformer?\n" +
                    "A) Overwatch\n" +
                    "B) Banjo-Kazooie\n" +
                    "C) Zelda\n",
            "10) What developer created Silent Hill?\n" +
                    "A) Konami\n" +
                    "B) Nintendo\n" +
                    "C) Sega\n"
    };
    
    static String[] answers = new String[] {
            "B",
            "A",
            "B",
            "C",
            "C",
            "C",
            "C",
            "A",
            "B",
            "A"
    };
    
    public static void main (String[] args)
    {
        //Set up some variables for later use
        int answersCorrect = 0;
        int questionIndex = 0;
        //Start the while loop
        while (questionIndex < questions.length) {
            //Display and get the users answer
            String usersAnswer = askPlayerQuestion (questionIndex);
            //Make sure the users answer is A, B, or C
            if ("ABC".contains (usersAnswer)) {
                //The user has typed a correct response now check if the answer is correct
                if (checkAnswer (questionIndex, usersAnswer)) {
                    System.out.println ("You are correct!\n");
                    answersCorrect++;
                } else {
                    System.out.println ("You are incorrect. The answer is: " + answers[questionIndex] + "\n");
                }
                //Add onto the question index to go onto the next question
                questionIndex++;
            } else {
                //Tell the user they didn't enter in an A, B, or C and must try again
                System.out.println ("You must either enter an A, B, or C. Please try again.");
            }
        }
        
        //Tell the user how they did
        System.out.printf ("You got %d/%d correct!", answersCorrect, questions.length);
    }
    
    private static String askPlayerQuestion (int questionIndex)
    {
        //Initialize the Scanner
        Scanner input = new Scanner (System.in);
        //Ask the question
        System.out.println (questions[questionIndex]);
        //Now get the users input and uppercase it
        System.out.printf ("Enter your answer > ");
        return input.next ().toUpperCase ().substring (0,1);
    }
    
    private static boolean checkAnswer (int questionIndex, String userAnswer)
    {
        if (answers[questionIndex].equals (userAnswer)) {
            return true;
        } else {
            return false;
        }
    }
}
