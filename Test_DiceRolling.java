
/**
 * Write a description of class Test_DiceRolling here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test_DiceRolling
{
    private Player player;
    private DiceRolling diceRolling;
    
    public Test_DiceRolling(){
        player = new Player();
        diceRolling = new DiceRolling();
        
        player.setName("Abel");
        diceRolling.getInstruction();
        diceRolling.rollDice(player);
        
        // simulate figfght
        System.out.println("\n#### Simulating Fight ####");
        diceRolling.simulateGame(player);
    }
}
