package Game;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Note> currentNotes;
    private int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
        this.currentNotes = new ArrayList<Note>();
    }

    public List<Note> getNotes(){
        return currentNotes;
    }

    public Note getNote(int index){
        return currentNotes.get(index);
    }

    public void addNote(Note note){
        if(currentNotes.size() < capacity){
            currentNotes.add(note);
        }
    }
}
