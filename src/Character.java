public class Character {
    private String name;
    private String description;
    private Task task;

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

    public void talk(int state){};

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", task=" + task +
                '}';
    }
}
