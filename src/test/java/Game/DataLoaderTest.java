package Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataLoaderTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void loadRoomData() {
        List<Room> rooms = DataLoader.loadRoomData("resources/rooms.json");
        assertNotNull(rooms, "The list of rooms should not be null");
    }

    @Test
    void loadCharacterData() {
        List<Character> characters = DataLoader.loadCharacterData("resources/characters.json");
        assertNotNull(characters, "The list of characters should not be null");
    }

    @Test
    void loadTaskData() {
        List<Task> tasks = DataLoader.loadTaskData("resources/tasks.json");
        assertNotNull(tasks, "The list of tasks should not be null");
    }

    @Test
    void loadItemData() {
        List<Item> items = DataLoader.loadItemData("resources/items.json");
        assertNotNull(items, "The list of tasks should not be null");
    }

    @Test
    void loadNoteData() {
        List<Note> notes = DataLoader.loadNoteData("resources/notes.json");
        assertNotNull(notes, "The list of tasks should not be null");
    }

    @Test
    void insertCharacterNotes(){
        Character character = new Character();
        character.setId("TestCharacter");

        Note note = new Note();
        note.setParentId("TestCharacter");

        List<Character> characters = List.of(character);
        List<Note> notes = List.of(note);

        DataLoader.insertCharacterNotes(characters, notes);

        assertNotNull(character.getNote(), "The character should have a note assigned");
        assertEquals(note, character.getNote(), "The assigned note should be the one created");
    }

    @Test
    void insertRoomItems(){
        Room room = new Room();
        room.setId("TestRoom");

        Item item = new Item();
        item.setTargetRoomId("TestRoom");

        List<Room> rooms = List.of(room);
        List<Item> items = List.of(item);

        DataLoader.insertRoomItems(rooms, items);

        assertNotNull(room.getItem(), "The room should have an item assigned");
        assertEquals(item, room.getItem(), "The assigned item should be the one created");
    }
}