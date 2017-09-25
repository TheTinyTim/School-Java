import java.util.Scanner;

public class RockPaperScissors {
    
    public static void main (String[] args)
    {
        //Initialize the input scanner
        Scanner input = new Scanner (System.in);

        //Set up all the variables needed for the program
        int playerNumber;
        int computerNumber;
        String playerChoice;
        String computerChoice;
        String gameResult;

        //Prompt the user to input a number for their choice of either scissor (0), rock (1), paper (2)
        System.out.println ("What is your choice? Scissors (0), Rock (1), or Paper (2)");
        playerNumber = input.nextInt ();

        //Figure out what their choice was
        if (playerNumber == 0)
            playerChoice = "Scissors";
        else if (playerNumber == 1)
            playerChoice = "Rock";
        else if (playerNumber == 2)
            playerChoice = "Paper";
        else
            playerChoice = "N/A";

        //Now get the computers choice
        computerNumber = (int) (Math.random () * 3);

        //Now convert that number to something between 0-2
        if (computerNumber == 0) {
            computerChoice = "Scissors";
        } else if (computerNumber == 1) {
            computerChoice = "Rock";
        } else if (computerNumber == 2) {
            computerChoice = "Paper";
        } else {
            computerChoice = "Something went wrong";
            System.out.println (computerNumber);
        }

        //Now find out if the user won, lost, or drew with the computer
        if (computerChoice == playerChoice)
            gameResult = "It is a draw.";
        else if ((computerChoice == "Scissors" && playerChoice == "Rock") || (computerChoice == "Rock" && playerChoice == "Paper") || (computerChoice == "Paper" && playerChoice == "Scissors"))
            gameResult = "You won!";
        else
            gameResult = "You lost.";

        System.out.println ("The computer is: " + computerChoice +
                            ". You are: " + playerChoice +
                            ". " + gameResult);
    }
}
