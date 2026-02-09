package Game;

import java.util.ArrayList;
import java.util.List;

public class Book extends Item{
    private List<Note> notes;

    public Book() {
        notes = new ArrayList<Note>();
    }

    public void addNote(Note note){
        notes.add(note);
    }

    public List<Note> getNotes(){
        return notes;
    }

    public boolean containsAllNotes(){return false;}

    @Override
    public String toString() {
        return "Book{" +
                "notes=" + notes.toString() +
                '}';
    }
}
