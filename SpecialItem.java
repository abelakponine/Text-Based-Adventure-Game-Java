/**
* This is a text based Adventure Game
* This class represents a special item, which when collected determines the completion of game
* @author Abel Akponine
* @version 2019.12.16
*/

public class SpecialItem extends Item
{
    /** this is a constructor for special item **/
    public SpecialItem(){
        // initialise instance variables
        this.setName("Special Item");
        this.setDescription("This special item that defines the completion of the game stage when collected.");
    }

}
