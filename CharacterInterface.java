
import java.util.ArrayList;

/**
* This is a text based Adventure Game
* This class represents a human character interface, which other human characters inherit
* @author Abel Akponine
* @version 2019.12.16
*/

public interface CharacterInterface
{
    /** this class represents a character interface **/
    
    public void setName(String name); // sets name of character
    public String getName(); // gets the name of character
    public void setHealthStatus(int health); // sets health status of character
    public int getHealthStatus(); // gets health status of character
    public void attack(Character character); // stiggers attack in combat scene
}
