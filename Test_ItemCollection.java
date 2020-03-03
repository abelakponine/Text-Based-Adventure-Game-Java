
import java.util.ArrayList;

/**
 * Write a description of class Test_ItemCollection here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test_ItemCollection
{
    public Test_ItemCollection(){
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
    }
}
