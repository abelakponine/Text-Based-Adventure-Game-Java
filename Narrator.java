/**
* This is a text based Adventure Game
* This is a sub class of main Character class
* This class represents a narrator which gives instruction about games
* @author Abel Akponine
* @version 2019.12.16
*/

public class Narrator extends Character
{
    // instance variables - replace the example below with your own
    private String required;
    private double expected;

    /** this is a narrator constructor for dice rolling **/
    public Narrator(String required, double expected){
        // initialise instance variables
        this.setName("Game Narrator");
        this.required = required;
        this.expected = expected;
    }
    
    /** this is an overlaod narrator constructor for generic gametype other than dice rolling **/ 
    public Narrator(String gameName){
        this.setName("Game Narrator");
    }

    /** this is a narration of game instruction **/
    public void getInstruction(String gameName){
        if (gameName == "DiceRolling"){
            System.out.println("\n ****** Welcome to DiceRolling ****** ");
            System.out.println("("+this.getName()+"): You are required to get two numbers, when you "+required+" Them it gives ("+expected+")\n");
        }
        if (gameName == "CombatStage"){
            System.out.println("\n ****** Welcome to Combat Arena ****** ");
            System.out.println("("+this.getName()+"): You are to use your weapon to fight for survival, using Shield can save you from more damages\n");
        }
        if (gameName == "RockPaperScissors"){
            System.out.println("\n ****** Welcome to Rock Paper Scissors ****** ");
            System.out.println("("+this.getName()+"): The following are winning requirements.\n");
            System.out.println("Be the papper while opponent be the rock");
            System.out.println("Be the rock while opponent be the scissors");
            System.out.println("Be the scissors while opponent be the papper \nHave some fun!\n");
        }
    }
}
