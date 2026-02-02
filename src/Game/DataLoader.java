package Game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    private static Room getCharacterParent(List<Room> rooms, Character character){
        for (Room room : rooms){
            if(character.getParentId().equals(room.getId())){
                return room;
            }
        }
        return null;
    }

    public static List<Room> insertRoomCharacters(List<Room> rooms, List<Character> characters){
        for(Character character : characters){
            Room room = getCharacterParent(rooms, character);
            if(room != null){
                room.setCharacter(character);
            }
        }
        return rooms;
    }

}
