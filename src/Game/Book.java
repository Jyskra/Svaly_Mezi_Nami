package Game;

import java.util.ArrayList;
import java.util.List;
/**
 * this class stores all player acquired notes
 * @author Jiří Baudyš
 */
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

    @Override
    public String toString() {
        return "Book:" +
                " notes = " + notes.toString();
    }
}
