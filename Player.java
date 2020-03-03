
import java.util.ArrayList;

/**
* This is a text based Adventure Game
* This class represents a player character, inherited from Chracter main class
* This character play's the game
* @author Abel Akponine
* @version 2019.12.16
*/

public class Player extends Character
{
    /** this class represents a player character **/
    // player's default item list
    private ArrayList<Item> items;
    //Gameboard
    private GameBoard gameBoard;
    private SceneObject game;
    //Items
    private Weapon weapon;
    private Key key;
    private HealthPack healthPack;
    private SpecialItem specialItem;
    private Shield shield;
    private Item item;
    private Weapon dummyCombatWeapon;
    //initial coordinates before movements
    private Position currentPosition;
    private int intCoordX;
    private int intCoordY;
    private String position;
    
    public Player(){
        /** this represents the player's constructor **/
        //default values
        this.setName("You");
        currentPosition = new Position();
        weapon = new Weapon();
        key = new Key();
        healthPack = new HealthPack();
        specialItem = new SpecialItem();
        shield = new Shield();
        //ArrayList & Items
        items = new ArrayList<Item>();
        item = new Item();
        // create dummy combat weapon for weapon check
        dummyCombatWeapon = new Weapon();
        game = null;
    }

    /** this method starts the gamebord **/
    public void StartGame(GameBoard board){
        gameBoard = board;
    }
    /** this returns the player's array list **/
    public ArrayList<Item> getItems(){
        return this.items;
    }
    /** this method sets a new array list for player **/
    public void setListItems(ArrayList<Item> list){
        this.items = list;
    }
    /** this method is used to search items in the array list **/
    public boolean searchItems(String query){
        ArrayList<String> found = new ArrayList<String>();
        boolean result = false;
        for (Item x:this.getItems()){
            if (x.getName() == query){
                found.add("found");
            }
        }
        if (found.size() > 0){
            result = true;
        }
        return result;
    }
    /** this returns the coordinate Y of the player's position **/
    public int getCoordY(){
        return currentPosition.getCoordY();
    }
    /** this returns the coordinate X of the player's position **/
    public int getCoordX(){
        return currentPosition.getCoordX();
    }
    
    /** returns initializes player's position to enable going back position, if error occurs in player's movement **/
    public void intCoord(){
        intCoordX = currentPosition.getCoordX();
        intCoordY = currentPosition.getCoordY();
    }

    /** this method simulates player's up movement **/
    public void moveUp(){
        intCoord(); //initialize coordinate
        if (currentPosition.getCoordY() < 1 &&  currentPosition.getCoordY() >= -7 || currentPosition.getCoordY() == 0){
            currentPosition.setCoordY(currentPosition.getCoordY()+1);
            position = "Up (coordX:"+currentPosition.getCoordX()+", coordY:"+currentPosition.getCoordY()+")";
            System.out.println("... Moved "+position+"\n");
            this.enterArea();
        }
        else {
            System.out.println("\nSorry! you can't move up at this point, you are at the edge of the arena");
        }
    }

    /** this method simulates player's down movement **/
    public void moveDown(){
        intCoord(); //initialize coordinate
        if (currentPosition.getCoordY() <= 1 &&  currentPosition.getCoordY() > -7 || currentPosition.getCoordY() == 0){
            currentPosition.setCoordY(currentPosition.getCoordY()-1);
            position = "Down (coordX:"+currentPosition.getCoordX()+", coordY:"+currentPosition.getCoordY()+")";
            System.out.println("... Moved "+position+"\n");
            this.enterArea();
        }
        else {
            System.out.println("\nSorry! you can't move down at this point, you are at the edge of the arena");
        }
    }

    /** this method simulates player's left movement **/
    public void moveLeft(){
        intCoord(); //initialize coordinate
        if (currentPosition.getCoordX() > 0 &&  currentPosition.getCoordX() <= 8){
            currentPosition.setCoordX(currentPosition.getCoordX()-1);
            position = "Left (coordX:"+currentPosition.getCoordX()+", coordY:"+currentPosition.getCoordY()+")";
            System.out.println("... Moved "+position+"\n");
            this.enterArea();
        }
        else {
            System.out.println("\nSorry! you can't move left at this point, you are at the edge of the arena");
        }
    }

    /** this method simulates player's right movement **/
    public void moveRight(){
        intCoord(); //initialize coordinate
        if (currentPosition.getCoordX() >= 0 &&  currentPosition.getCoordX() < 8){
            currentPosition.setCoordX(currentPosition.getCoordX()+1);
            position = "Right (coordX:"+currentPosition.getCoordX()+", coordY:"+currentPosition.getCoordY()+")";
            System.out.println("... Moved "+position+"\n");
            this.enterArea();
        }
        else {
            System.out.println("\nSorry! you can't move left at this point, you are at the edge of the arena");
        }
    }

    /** this method simulates playing games automatic **/
    public void playgame(SceneObject games){
        if (games.getName() == "DiceRolling"){
            DiceRolling game = (DiceRolling) games;
            game.getInstruction();
            game.simulateGame(this);
        }
        if (games.getName() == "CombatStage"){
            CombatStage game = (CombatStage) games;
            game.getInstruction();
            game.simulateAttack(this);
        }
        if (games.getName() == "RockPaperScissors"){
            RockPaperScissors game = (RockPaperScissors) games;
            game.getInstruction();
            game.simulateGame(this);
        }
    }

    /** this method returns item requirement for specific game scenes **/
    public Item getSceneRequirement(GameObject gameObject){
        Item required = null;
    
        if (gameObject.getName() == "CombatStage"){
            required = dummyCombatWeapon;
        }
        if (gameObject.getName() == "SpecialRoom"){
            required = specialItem;
        }
        
        if (gameObject.getName() == "CollectKey"){
            required = key;
        }
        
        if (gameObject.getName() == "CollectShield"){
            required = shield;
        }
        
        if (gameObject.getName() == "CollectWeapon"){
            required = weapon;
        }
        
        if (gameObject.getName() == "CollectHealthPack"){
            required = healthPack;
        }
        
        return required;
    }

    /** this method simulates player entering a game scene **/
    public void enterArea(){
        //entering area 1
        if (currentPosition.getCoordX() == 0 && currentPosition.getCoordY() == 1){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 1 **");
            this.enterArea(0,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(0,0)),this);
        }
        //entering area 2
        if (currentPosition.getCoordX() == 2 && currentPosition.getCoordY() == 1){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 2 **");
            this.enterArea(1,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(0,1)), this);
        }
        //entering area 3
        if (currentPosition.getCoordX() == 4 && currentPosition.getCoordY() == 1){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 3 **");
            this.enterArea(2,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(0,2)), this);
        }
        //entering area 4
        if (currentPosition.getCoordX() == 6 && currentPosition.getCoordY() == 1){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 4 **");
            this.enterArea(3,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(0,3)), this);
        }
        //entering area 5
        if (currentPosition.getCoordX() == 8 && currentPosition.getCoordY() == 1){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 5 **");
            this.enterArea(4,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(0,4)), this);
        }
        //entering area 6
        if (currentPosition.getCoordX() == 0 && currentPosition.getCoordY() == -1){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 6 **");
            this.enterArea(5,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(1,0)), this);
        }
        //entering area 7
        if (currentPosition.getCoordX() == 2 && currentPosition.getCoordY() == -1){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 7 **");
            this.enterArea(6,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(1,1)), this);
        }
        //entering area 8
        if (currentPosition.getCoordX() == 4 && currentPosition.getCoordY() == -1){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 8 **");
            this.enterArea(7,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(1,2)), this);
        }
        //entering area 9
        if (currentPosition.getCoordX() == 6 && currentPosition.getCoordY() == -1){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 9 **");
            this.enterArea(8,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(1,3)), this);
        }
        //entering area 10
        if (currentPosition.getCoordX() == 8 && currentPosition.getCoordY() == -1){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 10 **");
            this.enterArea(9,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(1,4)), this);
        }
        //entering area 11
        if (currentPosition.getCoordX() == 0 && currentPosition.getCoordY() == -3){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 11 **");
            this.enterArea(10,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(2,0)), this);
        }
        //entering area 12
        if (currentPosition.getCoordX() == 2 && currentPosition.getCoordY() == -3){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 12 **");
            this.enterArea(11,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(2,1)), this);
        }
        //entering area 13
        if (currentPosition.getCoordX() == 4 && currentPosition.getCoordY() == -3){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 13 **");
            this.enterArea(12,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(2,2)), this);
        }
        //entering area 14
        if (currentPosition.getCoordX() == 6 && currentPosition.getCoordY() == -3){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 14 **");
            this.enterArea(13,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(2,3)), this);
        }
        //entering area 15
        if (currentPosition.getCoordX() == 8 && currentPosition.getCoordY() == -3){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 15 **");
            this.enterArea(14,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(2,4)), this);
        }
        //entering area 16
        if (currentPosition.getCoordX() == 0 && currentPosition.getCoordY() == -5){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 16 **");
            this.enterArea(15,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(3,0)), this);
        }
        //entering area 17
        if (currentPosition.getCoordX() == 2 && currentPosition.getCoordY() == -5){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 17 **");
            this.enterArea(16,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(3,1)), this);
        }
        //entering area 18
        if (currentPosition.getCoordX() == 4 && currentPosition.getCoordY() == -5){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 18 **");
            this.enterArea(17,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(3,2)), this);
        }
        //entering area 19
        if (currentPosition.getCoordX() == 6 && currentPosition.getCoordY() == -5){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 19 **");
            this.enterArea(18,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(3,3)), this);
        }
        //entering area 20
        if (currentPosition.getCoordX() == 8 && currentPosition.getCoordY() == -5){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 20 **");
            this.enterArea(19,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(3,4)), this);
        }
        //entering area 21
        if (currentPosition.getCoordX() == 0 && currentPosition.getCoordY() == -7){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 21 **");
            this.enterArea(20,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(4,0)), this);
        }
        //entering area 22
        if (currentPosition.getCoordX() == 2 && currentPosition.getCoordY() == -7){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 22 **");
            this.enterArea(21,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(4,1)), this);
        }
        //entering area 23
        if (currentPosition.getCoordX() == 4 && currentPosition.getCoordY() == -7){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 23 **");
            this.enterArea(22,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(4,2)), this);
        }
        //entering area 24
        if (currentPosition.getCoordX() == 6 && currentPosition.getCoordY() == -7){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 24 **");
            this.enterArea(23,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(4,3)), this);
        }
        //entering area 25
        if (currentPosition.getCoordX() == 8 && currentPosition.getCoordY() == -7){
            //check game area requirement and enter
            System.out.println("\n** You just entered: Area 25 **");
            this.enterArea(24,items, this.getSceneRequirement(gameBoard.getSceneAtIndex(4,4)), this);
        }
    }
    
    /** this method simulates player entering a game scene with specific requirements **/
    // overload for areas that require entry item criteria
    public void enterArea(int areaIndex, ArrayList<Item> entryCriteria, Item item, Player player){
        //enter area if met requirement
        if (item == dummyCombatWeapon){
            // check if player has weapon for combat stage
            if (entryCriteria.contains(weapon)){
                gameBoard.lunchGame(areaIndex, entryCriteria, weapon, player);
            }
            else {
                System.out.println("\nSorry! you do not have a required item ("+item.getName()+") for this area");
                System.out.println("\n<<< Going back to previous position");
                // go back to previous coordinates
                currentPosition.setCoordX(intCoordX);
                currentPosition.setCoordY(intCoordY);
                position = "(coordX:"+currentPosition.getCoordX()+", coordY:"+currentPosition.getCoordY()+")";
                System.out.println("... Done! "+position+"\n");
            }
        }
        else if (item == specialItem){
            // check if player has a key to unlock special room to collect special item
            if (entryCriteria.contains(key)){
                gameBoard.lunchGame(areaIndex, entryCriteria, specialItem, player);
            }
            else {
                System.out.println("\nSorry! you do not have a required item ("+item.getName()+") for this area");
                System.out.println("\n<<< Going back to previous position");
                // go back to previous coordinates
                currentPosition.setCoordX(intCoordX);
                currentPosition.setCoordY(intCoordY);
                position = "(coordX:"+currentPosition.getCoordX()+", coordY:"+currentPosition.getCoordY()+")";
                System.out.println("... Done! "+position+"\n");
            }
        }
        else {
            gameBoard.lunchGame(areaIndex, entryCriteria, item, player);
        }
    }
    
}
