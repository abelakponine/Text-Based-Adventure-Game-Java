
import java.util.ArrayList;
import java.util.Random;

/**
* This is a text based Adventure Game
* This class represents a dice rolling game scene
* @author Abel Akponine
* @version 2019.12.16
*/

public class DiceRolling extends SceneObject
{
    // instance variables - replace the example below with your own
    private int diceX;
    private int diceY;
    private int expectedX;
    private int expectedY;
    private double result;
    private Random[][] dice;
    private double expected;
    private ArrayList<String> instruction;
    private String required;
    private Random randNum;
    private int action;
    private Opponent computer;
    private int currentPlayer;
    private Narrator narrator;

    /** this is a constructor for dice rolling game **/
    public DiceRolling(){
        this.setName("DiceRolling");
        this.setType("GameScene");
        randNum = new Random();
        computer = new Opponent();
        currentPlayer = randNum.nextInt(2)+1;
        instruction = new ArrayList<String>();
        required = null;
        instruction.add("multiply");
        instruction.add("divide");
        instruction.add("add");
        instruction.add("subtract");
        dice = new Random[1][2];
        dice[0][0] = randNum;
        dice[0][1] = randNum;
        
    }

    /** this method defines instructions and call narrator **/
    public void getInstruction(){
        action = randNum.nextInt(4);
        expectedX = dice[0][0].nextInt(6)+1;
        expectedY = dice[0][1].nextInt(6)+1;
        expected = operate(expectedX,expectedY);
        
        if (action == 0){
            required = instruction.get(0);
        }
        if (action == 1){
            required = instruction.get(1);
        }
        if (action == 2){
            required = instruction.get(2);
        }
        if (action == 3){
            required = instruction.get(3);
        }
        
        //initialize narrator
        narrator = new Narrator(required, expected);
        narrator.getInstruction(this.getName());
        
    }

    /** this method simulates a rolling dice **/
    public void rollDice(Character player){
        diceX = dice[0][0].nextInt(6)+1;
        diceY = dice[0][1].nextInt(6)+1;
        result = operate(diceX,diceY);
        System.out.println("Dice ("+player.getName()+") : "+diceX+","+diceY+"("+result+")\n");
        if (result == expected){
            if (player.getName() == "You"){
                System.out.println("\n#### Congratulations! : You Won ####\n");
            }
            else {
                System.out.println("\n*** Sorry! :( You Lost to Opponent ***\n");
            }
        }
    }

    /** this method simulates the game automatically **/
    public void simulateGame(Player player){
        while (result != expected){
            if (currentPlayer == 1){
                this.rollDice(player);
                currentPlayer = 2;
            }
            else if (currentPlayer == 2){
                this.rollDice(computer);
                currentPlayer = 1;
            }
        }
    }

    /** this method returns a double variable **/
    public double operate(int x, int y){
        double result = 0;
        if (action == 0){
            result = x+y;
        }
        if (action == 1){
            result = x/y;
        }
        if (action == 2){
            result = x+y;
        }
        if (action == 3){
            result = x-y;
        }
        return result;
    }
}
