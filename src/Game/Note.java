package Game;
/**
 * this class is the note, which the player is trying to get ahold of
 * @author Jiří Baudyš
 */
public class Note extends Item{
    private String muscleGroup;
    private String noteData;
    private String id;
    private String parentId;
    private boolean canBePickedUp;

    public Note() {
    }

    public String getMuscleGroup() {return muscleGroup;}
    public String getNoteData(){return this.noteData;}

    public String getId() {
        return id;
    }

    public String getParentId() {
        return parentId;
    }

    public boolean isCanBePickedUp() {
        return canBePickedUp;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public void setNoteData(String noteData) {
        this.noteData = noteData;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setCanBePickedUp(boolean canBePickedUp) {
        this.canBePickedUp = canBePickedUp;
    }

    @Override
    public String toString() {
        return muscleGroup ;
    }
}
