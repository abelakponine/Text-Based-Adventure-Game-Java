
import java.util.ArrayList;
import java.util.Random;

/**
* This is a text based Adventure Game
* This class represents a combat game scene
* @author Abel Akponine
* @version 2019.12.16
*/

public class CombatStage extends SceneObject
{
    // instance variables - replace the example below with your own
    private Random rand;
    private int firstAttack; // determines who attacks first
    private Attacker attacker;
    private Narrator narrator;

    /** this is a constructor for combat stage **/
    public CombatStage(){
        rand = new Random();
        attacker = new Attacker();
        firstAttack = rand.nextInt(2)+1;
        this.setName("CombatStage");
        this.setType("GameScene");
        narrator = new Narrator(this.getName());
    }

    /** this method calls the narrator **/
    public void getInstruction(){
        narrator.getInstruction(this.getName());
    }

    /** this method simulates attack during combat **/
    public void attack(Player player){
        if (firstAttack == 1){
            player.attack(attacker);
            firstAttack = 2;
        }
        if (firstAttack == 2){
            attacker.attack(player);
            firstAttack = 1;
        }
    }

    /** this method simulates game fight scene **/
    public void simulateAttack(Player player){
        while (player.getHealthStatus() > 0 && attacker.getHealthStatus() > 0){
            if (firstAttack == 1){
                player.attack(attacker);
                firstAttack = 2;
            }
            else if (firstAttack == 2){
                attacker.attack(player);
                firstAttack = 1;
            }
        }
    }
}
