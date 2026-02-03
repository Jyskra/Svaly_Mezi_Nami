package Game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataLoader {
    private static ObjectMapper parser = new ObjectMapper();

    public static List<Room> loadRoomData(String roomDataPath){
        try{

            InputStream input = new FileInputStream(roomDataPath);

            List<Room> rooms = parser.readValue(input, new TypeReference<List<Room>>() {});

            return rooms;

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    public static List<Character> loadCharacterData(String roomDataPath){
        try{

            InputStream input = new FileInputStream(roomDataPath);

            List<Character> characters = parser.readValue(input, new TypeReference<List<Character>>() {});

            return characters;

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static List<Task> loadTaskData(String roomDataPath){
        try{

            InputStream input = new FileInputStream(roomDataPath);

            List<Task> tasks = parser.readValue(input, new TypeReference<List<Task>>() {});

            return tasks;

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    private static Room getCharacterParent(List<Room> rooms, Character character){
        for (Room room : rooms){
            if(character.getParentId().equals(room.getId())){
                return room;
            }
        }
        return null;
    }

    public static void insertRoomCharacters(List<Room> rooms, List<Character> characters){
        for(Character character : characters){
            Room room = getCharacterParent(rooms, character);
            if(room != null){
                room.setCharacter(character);
            }
        }
    }

    public static Character getTaskParent(List<Character> characters, Task task){
        for (Character character : characters){
            if(task.getParentId().equals(character.getId())){
                return character;
            }
        }
        return null;
    }

    public static void insertCharacterTasks(List<Character> characters, List<Task> tasks){
        for(Task task : tasks){
            Character character = getTaskParent(characters, task);
            if(character != null){
                character.setTask(task);
            }
        }
    }

}
