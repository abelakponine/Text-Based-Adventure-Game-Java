
import java.util.ArrayList;

/**
 * Write a description of class Test_GameBoard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test_GameBoard
{
    private Player player;
    private GameBoard gameBoard;
    
    public Test_GameBoard(){
        // create player
        Player player = new Player();
        // item list
        ArrayList<Item> items = new ArrayList<Item>();
        // set item list
        player.setListItems(items);
        // create game board
        gameBoard = new GameBoard(player, items);
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
        
        // set game scene at index
        diceRolling.setIndex(2);
        gameBoard.setSceneAtIndex(0,2,diceRolling); // setting scene 3 in row first row
        
        // get game scene at index
        System.out.println("Game Scene: "+gameBoard.getSceneAtIndex(0,2));
        gameBoard.lunchGame(2, items, null, player); // null means no item required
    }
}
