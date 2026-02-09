package Game;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.HashMap;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "id",
        visible = true,
        defaultImpl = Character.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MainBodybuilder.class, name = "main_bodybuilder")
})

public class Character {
    private String name;
    private String description;
    private String id;
    private String parentId;
    private Task task;
    private Note note;
    private HashMap<String, Boolean> states = new HashMap<>();
    private HashMap<String, String> dialogue = new HashMap<>();

    public Character() {
        states.put("taskFinished", false);
        states.put("isWaitingForAnAnswer", false);
        states.put("taskGiven", false);
        states.put("noteDropped", false);
        states.put("notePickedUp", false);
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

    public String getDialogueBit(String key){
        return dialogue.get(key);
    }

    public Note getNote() {
        return note;
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

    public void setNote(Note note) {
        this.note = note;
    }

    public String taskDone(){
        states.put("taskFinished", true);
        states.put("isWaitingForAnAnswer", false);
        states.put("noteDropped", true);
        states.put("notePickedUp", false);
        note.setCanBePickedUp(true);
        return talk();
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

        } else if (states.get("noteDropped") & !states.get("notePickedUp")) {

            talkString = dialogue.get("taskDone") + "\n" + dialogue.get("noteDropped");

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
