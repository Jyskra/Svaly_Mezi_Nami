public class Room {
    private Character character;
    private String name;
    private String description;

    public Room() {}

    public Character getCharacter(){return null;}
    public String getDescription(){return this.description;}
    public String getName(){return this.name;}

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Room{" +
                "character=" + character +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
