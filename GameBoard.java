
import java.util.ArrayList;

/**
* This is a text based Adventure Game
* This class represents a game board which lunches game scenes
* @author Abel Akponine
* @version 2019.12.16
*/

public class GameBoard
{
    // instance variables - replace the example below with your own
    private GameObject[][] sceneList;
    private int areaIndex = 0;
    private boolean hasSpecialItem;

    /** this is a constructor for the game board **/
    public GameBoard(Player player, ArrayList<Item> items){
        // initialise instance variables
        sceneList = new GameObject[5][5];
        hasSpecialItem = false;
        
        System.out.print("\n\n");
        // automatically create scenes and assign indexes to the scenes
        for (int i=0;i<sceneList.length;i++){
            
            for (int j=0;j<sceneList[i].length;j++){
                Scene scene = new Scene(player, items);
                GameObject oldScene = scene.getScene();
                GameObject activeScene;
                
                if (hasSpecialItem == true && oldScene.getName() == "SpecialRoom"){
                    scene.removeScene(oldScene);
                    activeScene = scene.getScene();
                }
                else {
                    activeScene = oldScene;
                }
                activeScene.setIndex(areaIndex); //assign index to new scene
                
                //remove already implemented Special Room to prevent duplicate Special Item
                if (activeScene instanceof SceneObject && activeScene.getName() == "SpecialRoom"){
                    scene.removeScene(activeScene);
                    hasSpecialItem = true;
                }
                
                sceneList[i][j] = activeScene;
                
                areaIndex++;
                
                System.out.print(" "+sceneList[i][j].getName()+"\t ");
                
            }
            System.out.println("\n==============================================================================================================");
            System.out.println("==============================================================================================================");
        }
        System.out.println("\n");
    }

    /** this is used for returning a game scene at the given indexes **/
    public GameObject getSceneAtIndex(int x, int y){
        return this.sceneList[x][y];
    }

    /** this is used to set indexes of game scenes at given coordinates  **/
    public void setSceneAtIndex(int x, int y, GameObject scene){
        this.sceneList[x][y] = scene;
    }
    
    /** this method lunches the game from game board **/ 
    public void lunchGame(int gameAreaIndex, ArrayList<Item> entryCriteria, Item item, Player player){
        for (GameObject[] i:sceneList){
            for (GameObject x:i){
                
                // if area is a game scene and has an index of the "gameAreaIndex", then set it as active game scene.
                if (x instanceof SceneObject && x.getIndex() == gameAreaIndex){
                    
                    SceneObject scene = (SceneObject) x;
                    if (x.getName() == "DiceRolling"){
                        DiceRolling game = new DiceRolling();
                        player.playgame(game);
                    }
                    if (x.getName() == "CombatStage"){
                        CombatStage game = new CombatStage();
                        player.playgame(game);
                    }
                    if (x.getName() == "RockPaperScissors"){
                        RockPaperScissors game = new RockPaperScissors();
                        player.playgame(game);
                    }
                    // item collection areas
                    if (x.getName() == "SpecialRoom"){
                        SpecialRoom game = new SpecialRoom();
                        game.collectItem(entryCriteria, item, scene);
                    }
                    if (x.getName() == "CollectWeapon"){
                        CollectWeapon game = new CollectWeapon();
                        game.collectItem(entryCriteria, item, scene);
                    }
                    if (x.getName() == "CollectHealthPack"){
                        CollectHealthPack game = new CollectHealthPack();
                        game.collectItem(entryCriteria, item, scene);
                    }
                    if (x.getName() == "CollectKey"){
                        CollectKey game = new CollectKey();
                        game.collectItem(entryCriteria, item, scene);
                    }
                    if (x.getName() == "CollectShield"){
                        CollectShield game = new CollectShield();
                        game.collectItem(entryCriteria, item, scene);
                    }
                    
                }
            }
        }
    }
}
