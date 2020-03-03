
import java.util.ArrayList;

/**
* This is a text based Adventure Game
* This class represents a running scenerio, used to test the game itself
* @author Abel Akponine
* @version 2019.12.16
*/

public class main {
    /** this main class represents a test framework for game **/
    //public static void main(String[] args) {
    main (){
        /** Testing Adventure Game **/
        // create player
        Player player = new Player();
        // item list
        ArrayList<Item> items = new ArrayList<Item>();
        // set item list
        player.setListItems(items);
        // create game board
        GameBoard game = new GameBoard(player,items);
        // create scenes
        DiceRolling diceRolling = new DiceRolling();
        CombatStage combatStage = new CombatStage();
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        SpecialRoom specialRoom = new SpecialRoom();
        SpecialItem specialItem = new SpecialItem();
        // create items
        Weapon weapon = new Weapon();
        Shield shield = new Shield();
        Key key = new Key();
        
        // start game board
        player.StartGame(game);
        
        // move player to coordinate x & y
        player.moveUp();
        player.moveUp();
        player.moveDown();
        player.moveDown();
        player.moveRight();
        player.moveRight();
        player.moveLeft();
        player.moveLeft();
        
        //set game scenes at indexes (x,y, scene)
        game.setSceneAtIndex(0,0,diceRolling);
        game.setSceneAtIndex(0,1,combatStage);
        game.setSceneAtIndex(0,2,rockPaperScissors);
        game.setSceneAtIndex(0,3,specialRoom);
        
        // play rolling game scene according to index
        //enter area and lunch game, can be used to collect items before lunching (player lunch)
        player.enterArea(0,items,null,player);
        // lunch game method - combat game, similar to enterArea (game board lunch)
        game.lunchGame(1,items,weapon,player);
        // play rockPaperScissors game
        player.enterArea(2,items,null,player);
        // collect special item to enterArea (game board lunch)
        game.lunchGame(3,items,specialItem,player);
        
    }

}
