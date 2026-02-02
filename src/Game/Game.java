package Game;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private Room currentRoom;
    public static List<Room> roomsList = new ArrayList<>();

    public Game(){

    }

    public boolean canMoveTo(String roomId){
        for (Room room : roomsList){
            if (roomId.equalsIgnoreCase(room.getId())){
                return true;
            }
        }
        return false;
    }

    public void moveTo(String roomId){
        for (Room room : roomsList){
            if (roomId.equalsIgnoreCase(room.getId())){
                currentRoom = room;
            }
        }
    }

    private void loadData(){

        roomsList = DataLoader.loadRoomData("resources/rooms.json");
        List<Character> charactersList = DataLoader.loadCharacterData("resources/characters.json");

        DataLoader.insertRoomCharacters(roomsList, charactersList);

    }

    public void startGame(){

        loadData();

        UserInterface ui = new UserInterface(this);


    }
}
