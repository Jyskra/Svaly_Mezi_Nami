package Game;

public class Note extends Item{
    private String muscleGroup;
    private String noteData;

    public Note() {
    }

    public String getMuscleGroup() {return muscleGroup;}
    public String getNoteData(){return this.noteData;}

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public void setNoteData(String noteData) {
        this.noteData = noteData;
    }
}
