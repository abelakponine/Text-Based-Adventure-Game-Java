/**
* This is a text based Adventure Game
* This class represents an health pack used in boosting player's health
* @author Abel Akponine
* @version 2019.12.16
*/

public class HealthPack extends Item
{
    /** this constructor for health pack object **/
    public HealthPack(){
        // initialise instance variables
        this.setName("Health Pack");
        this.setDescription("This item refills player's health.");
    }

}
