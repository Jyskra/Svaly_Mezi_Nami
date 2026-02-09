package Game;

import java.util.HashMap;
import java.util.Map;

public class Character {
    private String name;
    private String description;
    private String id;
    private String parentId;
    private Task task;
    private HashMap<String, Boolean> states = new HashMap<>();
    private HashMap<String, String> dialogue = new HashMap<>();

    public Character() {
        states.put("taskFinished", false);
        states.put("isWaitingForAnAnswer", false);
        states.put("taskGiven", false);
    }

    public String getName(){return this.name;}
    public String getDescription(){return this.description;}

    public Task getTask() {
        return task;
    }

    public String getId() {
        return id;
    }

    public String getParentId() {
        return parentId;
    }

    public boolean getCurrentState(String data){
        return states.get(data);
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

    public void setId(String id) {
        this.id = id;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setDialogue(HashMap<String, String> dialogue) {
        this.dialogue = dialogue;
    }

    public String taskDone(){
        states.put("taskFinished", true);
        states.put("isWaitingForAnAnswer", false);
        return talk();
        //TODO add reward
    }

    public String talk(){
        String talkString = "";
        if(states.get("isWaitingForAnAnswer")){

            talkString = dialogue.get("waitingForTaskToBeDone");

        }else if(!states.get("taskGiven")){

            talkString = dialogue.get("intro");
            talkString += "\n" + task.getDescription();
            states.put("isWaitingForAnAnswer", true);
            states.put("taskGiven", true);

        } else if (states.get("taskFinished")) {

            talkString = dialogue.get("taskDone");

        }
        return talkString;
    }

    @Override
    public String toString() {
        return "Game.Character{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", task=" + task +
                '}';
    }
}
