
import java.util.ArrayList;
import java.util.Random;

/**
* This is a text based Adventure Game
* This class represents a rock paper scissors game scene
* @author Abel Akponine
* @version 2019.12.16
*/

public class RockPaperScissors extends SceneObject
{
    // instance variables - replace the example below with your own
    private int odd;
    private String playerX;
    private String playerY;
    private Random rand;
    private Narrator narrator;
    private String outcome;

    /** this is a constructor for rock paper scissors game **/
    public RockPaperScissors(){
        this.setName("RockPaperScissors");
        this.setType("GameScene");
        rand = new Random();
        odd = 0;
    }

    /** this method calls the narrator of the game **/
    public void getInstruction(){
        //initialize narrator
        narrator = new Narrator(this.getName());
        narrator.getInstruction(this.getName());
    }

    /** this method returns the next random index **/
    public String getOutcome(){
        odd = rand.nextInt(4)+1;
        if (odd == 1){
            outcome = "rock";
        }
        else if (odd == 2){
            outcome = "paper";
        }
        else if (odd == 3){
            outcome = "scissors";
        }
        return outcome;
    }
    
    /** this is a method used to play the game **/
    public void playGame(){
       playerX = this.getOutcome();
       playerY = this.getOutcome();
        
        if (playerX == playerY){
            System.out.println("Hmmm! What a tie");
        }
        else if (playerX == "rock" && playerY == "scissors"){
            System.out.println("*** You Win you are the "+playerX+" (opponent:"+playerY+") ***");
        }
        else if (playerX == "rock" && playerY == "paper"){
            System.out.println("+++ You Loose! :( you are the "+playerX+" (opponent:"+playerY+") +++");
        }
        else if (playerX == "paper" && playerY == "scissors"){
            System.out.println("+++ You Loose! :( you are the "+playerX+" (opponent:"+playerY+") +++");
        }
        else if (playerX == "paper" && playerY == "rock"){
            System.out.println("*** You Win you are the "+playerX+" (opponent:"+playerY+") ***");
        }
        else if (playerX == "scissors" && playerY == "paper"){
            System.out.println("*** You Win you are the "+playerX+" (opponent:"+playerY+") ***");
        }
        else if (playerX == "scissors" && playerY == "rock"){
            System.out.println("+++ You Loose! :( you are the "+playerX+" (opponent:"+playerY+") +++");
        }
        System.out.println("\n");
    }

    /** this is a method used to automatically simulate the game **/
    public void simulateGame(Character player){
        this.playGame();
    }
}
