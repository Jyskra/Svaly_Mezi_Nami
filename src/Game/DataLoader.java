package Game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/**
 * this class loads the entire game up from json files so all the data can be easily changed and interacted with
 * @author Jiří Baudyš
 */
public class DataLoader {
    private static ObjectMapper parser = new ObjectMapper();


    public static String loadMonologue(String monologuePath){
        try{
            InputStream input = DataLoader.class.getClassLoader().getResourceAsStream(monologuePath);
            return parser.readValue(input, String.class);
        }catch(IOException e){
            throw new RuntimeException();
        }
    }

    /**
     * loads up all data about rooms in the game
     * @param roomDataPath path to the rooms json
     * @return a list of all the rooms
     */
    public static List<Room> loadRoomData(String roomDataPath){
        try{

            InputStream input = DataLoader.class.getClassLoader().getResourceAsStream(roomDataPath);

            List<Room> rooms = parser.readValue(input, new TypeReference<List<Room>>() {});

            return rooms;

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * loads up all the data about characters in the game
     * @param characterDataPath path to the characters json
     * @return a list of all the characters inside the game rooms
     */
    public static List<Character> loadCharacterData(String characterDataPath){
        try{

            InputStream input = DataLoader.class.getClassLoader().getResourceAsStream(characterDataPath);

            List<Character> characters = parser.readValue(input, new TypeReference<List<Character>>() {});

            return characters;

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * loads up all the data about tasks in the game
     * @param taskDataPath path to the tasks json
     * @return a list of all the tasks inside the characters
     */
    public static List<Task> loadTaskData(String taskDataPath){
        try{

            InputStream input = DataLoader.class.getClassLoader().getResourceAsStream(taskDataPath);

            List<Task> tasks = parser.readValue(input, new TypeReference<List<Task>>() {});

            return tasks;

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * loads up all the data about items in the game
     * @param itemDataPath path to the items json
     * @return a list of all the game items
     */
    public static List<Item> loadItemData(String itemDataPath){
        try{

            InputStream input = DataLoader.class.getClassLoader().getResourceAsStream(itemDataPath);

            List<Item> items = parser.readValue(input, new TypeReference<List<Item>>() {});

            return items;

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * loads all the note data in the game
     * @param noteDataPath path to the notes json
     * @return a list of all the notes
     */
    public static List<Note> loadNoteData(String noteDataPath){
        try{

            InputStream input = DataLoader.class.getClassLoader().getResourceAsStream(noteDataPath);

            List<Note> notes = parser.readValue(input, new TypeReference<List<Note>>() {});

            return notes;

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * inserts all notes in their corresponding character
     * @param characters the list of characters
     * @param notes the list of notes
     */
    public static void insertCharacterNotes(List<Character> characters, List<Note> notes) {
        for(Character character : characters){
            for(Note note : notes){
                if(note.getParentId().equals(character.getId())){
                    character.setNote(note);
                }
            }
        }
    }

    /**
     * inserts all items into their corresponding rooms
     * @param rooms the list of rooms
     * @param items the list of items
     */
    public static void insertRoomItems(List<Room> rooms, List<Item> items){
        for(Item item : items){
            for (Room room : rooms){
                if (item.getTargetRoomId().equals(room.getId())){
                    room.setItem(item);
                }
            }
        }
    }

    /**
     * gets the room parent of a character based on their id
     * @param rooms list of rooms
     * @param character the character the parent is in search of
     * @return the room that is the parent of the character
     */
    private static Room getCharacterParent(List<Room> rooms, Character character){
        for (Room room : rooms){
            if(character.getParentId().equals(room.getId())){
                return room;
            }
        }
        return null;
    }

    /**
     * inserts all charcters into their corresponding rooms
     * @param rooms list of all the rooms in the gme
     * @param characters list of all the characters in the game
     */
    public static void insertRoomCharacters(List<Room> rooms, List<Character> characters){
        for(Character character : characters){
            Room room = getCharacterParent(rooms, character);
            if(room != null){
                room.setCharacter(character);
            }
        }
    }

    /**
     * gets the character parent of a task
     * @param characters list of all the characters
     * @param task the task of which the parent is in search of
     * @return the character which is the parent of the task
     */
    public static Character getTaskParent(List<Character> characters, Task task){
        for (Character character : characters){
            if(task.getParentId().equals(character.getId())){
                return character;
            }
        }
        return null;
    }

    /**
     * inserts all tasks into their respective character
     * @param characters list of all the characters
     * @param tasks list of all the tasks
     */
    public static void insertCharacterTasks(List<Character> characters, List<Task> tasks){
        for(Task task : tasks){
            Character character = getTaskParent(characters, task);
            if(character != null){
                character.setTask(task);
            }
        }
    }

}
