
/**
 * Write a description of class Test_RockPaperScissors here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test_RockPaperScissors
{
    private Player player;
    private RockPaperScissors rockPaperScissors;
    
    public Test_RockPaperScissors(){
        player = new Player();
        rockPaperScissors = new RockPaperScissors();
        
        player.setName("Abel");
        rockPaperScissors.getInstruction();
        rockPaperScissors.getOutcome();
        rockPaperScissors.playGame();
        
        // simulate figfght
        System.out.println("\n#### Simulating Fight ####");
        rockPaperScissors.simulateGame(player);
    }
}
