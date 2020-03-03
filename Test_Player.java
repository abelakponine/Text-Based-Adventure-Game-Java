
import java.util.ArrayList;

/**
* This is a text based Adventure Game
* This class represents a player character, inherited from Chracter main class
* This class tests the player class
* @author Abel Akponine
* @version 2019.12.18
*/

public class Test_Player
{
    private Player player;
    
    /** This is a constructor for testing player class **/
    Test_Player(){
        // create player
        Player player = new Player();
        // item list
        ArrayList<Item> items = new ArrayList<Item>();
        // set item list
        player.setListItems(items);
        // create game board
        GameBoard game = new GameBoard(player,items);
        //weapon item
        Weapon weapon = new Weapon();
        Shield shield = new Shield();
        //collect items
        CollectWeapon scene1 = new CollectWeapon();
        CollectShield scene2 = new CollectShield();
        // new Dice Rolling game
        DiceRolling diceRolling = new DiceRolling();
        // new Combat game
        CombatStage combatStage = new CombatStage();
        
        /** Running Tests **/
        player.StartGame(game); // start game dependencies
        player.setName("Abel"); // set name
        System.out.println("Player's Name: "+player.getName()); // print name
        scene1.collectItem(items,weapon,scene1); // collect weapon
        scene2.collectItem(items,shield,scene2); // collect Shield
        System.out.println(player.getItems()); // print item list
        System.out.println("Search found: "+player.searchItems("Weapon")); // search for a weapon by name (case sensitive)
        System.out.println("Search found: "+player.searchItems("Key")); // search for a key item by name (case sensitive)
        System.out.println("Player's coordinate: ("+player.getCoordX()+","+player.getCoordY()+")"); // get player's coordinate
        // move up
        player.moveUp();
        // move down
        player.moveDown();
        // move left
        player.moveLeft();
        // move right
        player.moveRight();
        // play Dice Rolling game
        player.playgame(diceRolling);
        // play Combat game
        player.playgame(combatStage);
        // get game scene requirement
        System.out.println("Game requirement: "+player.getSceneRequirement(combatStage));
        System.out.println("\n#### Entering game scene 4 ####");
        // enter game scene 4
        player.enterArea(4,items,weapon,player);
    }
}
