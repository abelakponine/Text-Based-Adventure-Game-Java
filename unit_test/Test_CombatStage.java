
/**
 * Write a description of class Test_CombatStage here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test_CombatStage
{
    private Player player;
    private CombatStage combatStage;
    
    public Test_CombatStage(){
        player = new Player();
        combatStage = new CombatStage();
        
        player.setName("Abel");
        combatStage.getInstruction();
        combatStage.attack(player);
        
        // simulate figfght
        System.out.println("\n#### Simulating Fight ####");
        combatStage.simulateAttack(player);
    }
}
