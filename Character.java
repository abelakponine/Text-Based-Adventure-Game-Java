
import java.util.ArrayList;

/**
* This is a text based Adventure Game
* This class represents a human character, which other human sub classes inherit
* @author Abel Akponine
* @version 2019.12.16
*/

public class Character implements CharacterInterface
{
    /** this class represents a human character **/
    private String name;
    private String type;
    private int health;

    /** this class represents a constructor of character **/
    public Character(){
        name = null;
        health = 100;
    }
    /** this sets the name of the character **/
    public void setName(String name){
        this.name = name;
    }
    /** this returns the name of the character **/
    public String getName(){
        return this.name = name;
    }
    /** this sets the health status of the character **/
    public void setHealthStatus(int health){
        this.health = health;
    }
    /** this returns the health status of the character **/
    public int getHealthStatus(){
        return this.health;
    }

    /** this triggers attack during combat scene **/
    public void attack(Character character){
        // attack damages are worth 10 bars of player's health
        // ensure both players' life are not less than 0
        if (this.getHealthStatus() > 0 && character.getHealthStatus() > 0) {
            // cast character to player if true
            if (character instanceof Player){
                Player player = (Player) character;
                if (player.searchItems("Shield") == false){
                    player.setHealthStatus(player.getHealthStatus()-10);
                    System.out.println("!!! ("+player.getName()+") Oops Damages caused - Health ("+player.getHealthStatus()+"%)");
                }
                else {
                    System.out.println("*** ("+player.getName()+") Defended with a Shield ***");
                }
            }
            // cast character to attacker is true
            else if (character instanceof Attacker){
                Attacker attacker = (Attacker) character;
                if (attacker.getShield() < 1){
                    attacker.setHealthStatus(attacker.getHealthStatus()-10);
                    System.out.println("!!! ("+attacker.getName()+") Oops Damages caused - Health ("+attacker.getHealthStatus()+"%)");
                }
                else if (attacker.getShield() >= 1) {
                    System.out.println("*** ("+attacker.getName()+") Defended with a Shield ***");
                    attacker.setShield();
                }
            }
        }
        // do this if any of the player's health is less than 0
        if (this.getHealthStatus() <= 0 || character.getHealthStatus() <= 0){
            // casting..
            if (character instanceof Attacker){
                Attacker attacker = (Attacker) character;
                if (attacker.getHealthStatus() <= 0) {
                    System.out.println("\n#### Congratulations! : You Won the fight ####");
                    System.out.print("Your Health: "+this.getHealthStatus()+"% ");
                    System.out.println("Attacker's Health: "+attacker.getHealthStatus()+"%");
                }
                else if (this.getHealthStatus() <= 0) {
                    System.out.println("\n*** You are dead! :( You Lost to the fight ***");
                    System.out.print("Your Health: "+this.getHealthStatus()+"% ");
                    System.out.println("Attacker's Health: "+attacker.getHealthStatus()+"%\n");
                }
            }
            // casting..
            else if (character instanceof Player){
                Player player = (Player) character;
                if (player.getHealthStatus() <= 0){
                    System.out.println("\n*** You are dead! :( You Lost to the fight ***");
                    System.out.print("Your Health: "+player.getHealthStatus()+"% ");
                    System.out.println("Attacker's Health: "+this.getHealthStatus()+"%");
                }
                else if (this.getHealthStatus() <= 0){
                    System.out.println("\n#### Congratulations! : You Won the fight ####");
                    System.out.print("Your Health: "+player.getHealthStatus()+"% ");
                    System.out.println("Attacker's Health: "+this.getHealthStatus()+"%\n");
                }
            }
        }
        // defered implementation for removing used shield
        // loop item list and remove first used shield, if Shield >= 1
        // this is to ensure player does not remain immortal using shield
        if (character instanceof Player){
            Player player = (Player) character;
            for (Item x:player.getItems()){
                if (x.getName() == "Shield"){
                    player.getItems().remove(x);
                    return; //stop loop after first removal
                }
            }
        }
        
    }
}
