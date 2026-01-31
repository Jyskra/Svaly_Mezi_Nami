package Game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private List<Room> roomsList = new ArrayList<>();

    public Game(){

    }

    public void startGame(){
        List<Room> rooms = DataLoader.loadRoomData("resources/rooms.json");
        System.out.println(rooms);
    }
}
