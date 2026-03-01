package Game;

import java.util.ArrayList;
import java.util.List;
/**
 * this class holds all notes temporarily before they are moved by the player into the book
 * @author Jiří Baudyš
 */
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

    public boolean isFull(){
        return currentNotes.size() == capacity;
    }

    public Note removeNote(int index){
        return currentNotes.remove(index);
    }

    public int getLength(){
        return currentNotes.size();
    }

    /**
     * adds a note to the inventory after pickup
     * @param note the note picked up
     * @return status of the addition
     */
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
