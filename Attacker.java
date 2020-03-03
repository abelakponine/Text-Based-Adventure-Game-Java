
import java.util.Random;

/**
* This is a text based Adventure Game
* This is a sub class of main Character class
* This class represents an attacker character,
* which fights agains the main player during combat scene
* @author Abel Akponine
* @version 2019.12.16
*/

public class Attacker extends Opponent
{
    // instance variables - replace the example below with your own
    private boolean hasShield;
    private Random rand;
    private int shield;
    
    /** this a constructor for the attacher character **/
    public Attacker(){
        // initialise instance variables
        this.setName("Attacker");
        rand = new Random();
        shield = rand.nextInt(2); // maximum shield an attacker can have is 1 @random
    }

    /** this method returns the number of shield attacker has **/
    public int getShield(){
        return this.shield;
    }

    /** this method is used to add or deduct number of shield attacker has **/
    public void setShield(){
        if (this.shield > 0){
            this.shield = this.shield-1;
        }
    }
}
