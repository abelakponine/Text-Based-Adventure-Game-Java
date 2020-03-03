
import java.util.ArrayList;

/**
* This is a text based Adventure Game
* This is a main scene object class, which other game scenes inherit
* @author Abel Akponine
* @version 2019.12.16
*/

public class SceneObject extends GameObject
{
    // instance variables - replace the example below with your own
    private int quantity;
    private String type;

    /** this is a constructor for Scene objects **/
    public SceneObject(){
        this.setObjectType("SceneObject");
        this.quantity = 1;
    }

    /** this sets the type of a screne object **/
    public void setType(String type){
        this.type = type;
    }
    
    /** this is used to set the amount of items located in a scene **/
    public void setQuantity(int Q){
        this.quantity = Q;
    }

    /** this returns the qmount of quantity items **/
    public int getQuantity(){
        return this.quantity;
    }

    /** this returns the scene object type **/
    public String getType(String type){
        return this.type;
    }

    /** this is a method used to collect items in a scene **/
    public void collectItem(ArrayList<Item> items, Item item, SceneObject scene){
        if (this.getName() == "SpecialRoom"){
            System.out.println("\n#### Congratulations! : You won - Special Item Found ####\n");
        }
        else if (scene.quantity >= 1){
            items.add(item);
            scene.quantity = scene.quantity-1;
            System.out.println("\n#### Woohoo! : An item ("+item.getName()+") has been collected ####");
            System.out.println("\n++++ "+item.getDescription()+" ++++");
        }
        else {
            System.out.println("\n** Empty room! : item in this room has already been collected ** ");
        }
    }
}
