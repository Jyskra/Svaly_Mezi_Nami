package Command;

import Game.*;

public class MoveCommand implements Command{
    public String execute(Player player, Room room){
        boolean completed = player.moveTo(room);
        if (completed){
            return "Moved to " + room.getName();
        }
        return "Unable to move to " + room.getName();
    }
}
