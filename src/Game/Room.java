package Game;

import java.util.Arrays;

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
