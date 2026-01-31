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
}
