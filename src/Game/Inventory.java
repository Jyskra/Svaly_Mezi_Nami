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

    public Note removeNote(int index){
        return currentNotes.remove(index);
    }

    public int getLength(){
        return currentNotes.size();
    }

    public String addNote(Note note){
        if(currentNotes.size() < capacity){
            currentNotes.add(note);
            return "Successfully added note";
        }
        return "Inventory is full";
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "currentNotes=" + currentNotes.toString() +
                ", capacity=" + capacity +
                '}';
    }
}
