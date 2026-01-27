package Game;

public class Character {
    private String name;
    private String description;
    private Task task;
    private int state;

    public Character() {}

    public String getName(){return this.name;}
    public String getDescription(){return this.description;}

    public Task getTask() {
        return task;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String talk(){
        //TODO add dialogue logic, meaning different outputs based on how advanced the state is.
        return null;
    };

    @Override
    public String toString() {
        return "Game.Character{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", task=" + task +
                '}';
    }
}
