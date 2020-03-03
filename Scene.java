
import java.util.ArrayList;
import java.util.Random;

/**
* This is a text based Adventure Game
* This is a main scene class, creates and assign scenes automatically 
* @author Abel Akponine
* @version 2019.12.16
*/

public class Scene
{
    // instance variables - replace the example below with your own
    private ArrayList<GameObject> stages;
    private Random randomScene;
    private GameObject activeScene;

    /**
     * Constructor for objects of class Scene
     */
    public Scene(Player player, ArrayList<Item> items){
        // initialise instance variables
        stages = new ArrayList<GameObject>();
        
        CombatStage combatStage = new CombatStage();
        DiceRolling diceRolling =  new DiceRolling();
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        SpecialRoom specialRoom = new SpecialRoom();
        CollectWeapon collectWeapon = new CollectWeapon();
        CollectHealthPack collectHealthPack = new CollectHealthPack();
        CollectKey collectKey = new CollectKey();
        CollectShield collectShield = new CollectShield();
        
        stages.add(combatStage);
        stages.add(diceRolling);
        stages.add(rockPaperScissors);
        stages.add(specialRoom);
        stages.add(collectWeapon);
        stages.add(collectHealthPack);
        stages.add(collectKey);
        stages.add(collectShield);
        
        randomScene = new Random();
        activeScene = null;
    }

    /** this method sets and return the activeScene **/
    public GameObject getScene(){
        
        int rand = randomScene.nextInt(stages.size());
        
        if (rand == 0){
            activeScene = stages.get(0);
        }
        
        if (rand == 1){
            activeScene = stages.get(1);
        }
        
        if (rand == 2){
            activeScene = stages.get(2);
        }
        
        if (rand == 3){
            activeScene = stages.get(3);
        }
        
        if (rand == 4){
            activeScene = stages.get(4);
        }
        
        if (rand == 5){
            activeScene = stages.get(5);
        }
        
        if (rand == 6){
            activeScene = stages.get(6);
        }
        
        if (rand == 7){
            activeScene = stages.get(7);
        }
        
        return activeScene;
    }
    
    /** this method removes a scene from created scene list **/
    public void removeScene(GameObject activeScene){
        stages.remove(activeScene);
    }
}
