/**
* This is a text based Adventure Game
* This class represents the position of a player character
* @author Abel Akponine
* @version 2019.12.16
*/

public class Position
{
    // instance variables - replace the example below with your own
    private int coordX;
    private int coordY;
    
    public Position(){
        /** this represents a constructor characters' position **/
        // initialise instance variables
        coordX = 0;
        coordY = 0;
    }
    
    public void setCoordX(int value){
        /** this method sets the coordinate X position of character **/
        this.coordX = value;
    }
    
    public void setCoordY(int value){
        /** this method sets the coordinate Y position of character **/
        this.coordY = value;
    }
    
    public int getCoordX(){
        /** this method returns the coordinate X position of character **/
        return coordX;
    }
    
    public int getCoordY(){
        /** this method returns the coordinate Y position of character **/
        return coordY;
    }
}
