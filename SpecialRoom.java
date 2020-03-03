
import java.util.ArrayList;

/**
* This is a text based Adventure Game
* This class represents a special room where special items are collected
* @author Abel Akponine
* @version 2019.12.16
*/

public class SpecialRoom extends SceneObject
{
    private ArrayList<GameObject> stages;
    
    /** this is a constructor for collection of special item scene **/
    public SpecialRoom(){
        this.setName("SpecialRoom");
        this.setType("ItemScene");
    }

}
