import java.util.ArrayList;

/**
* This is a text based Adventure Game
* This class represents an item object, which is collected from game scenes
* @author Abel Akponine
* @version 2019.12.16
*/

public class Item extends GameObject
{
    private String description;
    private ArrayList<Item> items;

    /** this is a constructor for item object **/
    public Item(){
        items = new ArrayList<Item>();
        description = null;
        this.setObjectType("Item");
    }

    /** this method adds item object to item list **/
    public void addItemToList(Item item){
        items.add(item);
    }

    /** this method removes item object from item list **/
    public void removeItemFromList(Item item){
        items.remove(item);
    }

    /** this method returns the item list size **/
    public int getItemListSize(){
        return items.size();
    }

    /** this method loop and prints item list names **/
    public void printItemList(){
        for (Item x:items){
            System.out.println(x.getName());
        }
    }

    /** this method sets the description of item object **/
    public void setDescription(String details){
        this.description = details;
    }

    /** this method gets the of item objects **/
    public String getDescription(){
        return this.description;
    }
    
}
