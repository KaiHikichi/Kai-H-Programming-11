import java.util.Scanner;
public class main {
    public static void main(String args[]){
        boolean gameEnd = false;
        int wins = 0;
        int losses = 0;
        while(gameEnd==false) {

            // player choice
            System.out.println("Choose 'rock' 'paper' 'scissors' or 'exit'");
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();

            //check for exit
            if(choice.equals("exit")){
                gameEnd = true;
                break;
            }
            //random computer choice
            int ran = (int) (Math.random() * 3);
            String cmpChoice = "default";
            if (ran == 0) {
                cmpChoice = "rock";
            } else if (ran == 1) {
                cmpChoice = "paper";
            } else if (ran == 2) {
                cmpChoice = "scissors";
            } else {
                System.out.println("error");
            }

            //determine outcome
            String outcome = "";
            if (choice.equals(cmpChoice)) {
                outcome="Draw!";
            }
            else if (choice.equals("rock")) {
                if (cmpChoice.equals("paper")) {
                    outcome="You lose!";
                } else if (cmpChoice.equals("scissors")) {
                    outcome="You win!";
                } else {
                    System.out.println("error");
                }
            } else if (choice.equals("paper")) {
                if (cmpChoice.equals("scissors")) {
                    outcome="You lose!";
                } else if (cmpChoice.equals("rock")) {
                    outcome="You win!";
                } else {
                    System.out.println("error");
                }
            } else if (choice.equals("scissors")) {
                if (cmpChoice.equals("rock")) {
                    outcome="You lose!";
                } else if (cmpChoice.equals("paper")) {
                    outcome="You win!";
                } else {
                    System.out.println("error");
                }
            } else {
                System.out.println("Invalid input");
            }
            System.out.println(outcome);
            System.out.println("Your choice: " + choice + "\nComputer choice: " + cmpChoice);

            //display score
            if(outcome.equals("You win!")){
                wins++;
            }
            else if(outcome.equals("You lose!")){
                losses++;
            }
            System.out.println("Wins: " + wins + "\tLosses: " + losses);
            System.out.println("======================================================");
        }
        System.out.println("Thanks for playing!");
    }
}
