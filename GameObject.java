/**
* This is a text based Adventure Game
* This class represents a game object,
* which other sub classes like SceneObject and Item inherit
* @author Abel Akponine
* @version 2019.12.16
*/

public class GameObject
{
    // instance variables - replace the example below with your own
    private String name;
    private String objectType;
    private int index;

    /** this is a constructor for Game object **/
    public GameObject(){
        // initialise instance variables
        objectType = null;
        index = 0;
    }
    /** this method sets the name of Game object **/
    public void setName(String name){
        this.name = name;
    }
    /** this method returns the name of Game object **/
    public String getName(){
        return this.name;
    }
    /** this method sets the type of Game object **/
    public void setObjectType(String type){
    }
    /** this method returns the type of Game object **/
    public String getObjectType(){
        return objectType;
    }

    /** this method assigns index position Game object in arrays **/
    public void setIndex(int i){
        this.index = i;
    }

    /** this method returns the index position of Game object **/
    public int getIndex(){
        return index;
    }
    
}
