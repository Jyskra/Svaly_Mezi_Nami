import Game.DataLoader;
import Game.Room;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Room> list = DataLoader.loadRoomData("resources/rooms.json");
    }
}