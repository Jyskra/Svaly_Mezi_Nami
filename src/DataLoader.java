import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class DataLoader {
    private static ObjectMapper parser = new ObjectMapper();

    public static void loadRoomData(String roomDataPath){
        try{

            InputStream input = new FileInputStream(roomDataPath);

            Map<String, Room> rooms = parser.readValue(input, new TypeReference<Map<String, Room>>() {});

            rooms.forEach((id, room) -> System.out.println(id + ": " + room));

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
