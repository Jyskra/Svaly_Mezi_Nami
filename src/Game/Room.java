package Game;

import java.util.Arrays;
/**
 * this class is a physical room the player enters and where they interact with all characters inside the game
 * @author Jiří Baudyš
 */
public class Room {
    private Character character;
    private String name;
    private String description;
    private String id;
    private String[] exits;
    private Item item;

    public Room() {}

    public Character getCharacter(){return this.character;}
    public String getDescription(){return this.description;}
    public String getName(){return this.name;}

    public String getId() {
        return id;
    }

    public String[] getExits() {
        return exits;
    }

    public Item getItem() {
        return item;
    }

    public void setExits(String[] exits) {
        this.exits = exits;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean hasItem(){
        return this.item != null;
    }

    /**
     * checks if an exit the player is trying to access is valid respective to this room or not
     * @param exitName the exit the player is trying to access
     * @return whether it is or is not a valid exit
     */
    public boolean isValidExit(String exitName){
        if(exitName != null){
            for(String exit : exits){
                if(exitName.equalsIgnoreCase(exit)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Room{" +
                "character=" + character +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", exits=" + Arrays.toString(exits) +
                '}';
    }
}
