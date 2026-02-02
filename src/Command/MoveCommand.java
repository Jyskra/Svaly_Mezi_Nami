package Command;

import Game.*;

public class MoveCommand implements Command{

    private Game game;

    public MoveCommand(Game game){this.game = game;}

    public String execute(String roomId){
        boolean completed = game.canMoveTo(roomId);
        if (completed){
            game.moveTo(roomId);
            return "Moved to " + roomId;
        }
        return "Unable to move to " + roomId;
    }
}
