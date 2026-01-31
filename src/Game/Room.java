package Game;

public class Room {
    private Character character;
    private String name;
    private String description;
    private String id;
    private String[] exits;

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

    @Override
    public String toString() {
        return "Game.Room{" +
                "character=" + character +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
