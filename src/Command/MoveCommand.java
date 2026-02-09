package Command;

import Game.*;

public class MoveCommand implements Command{

    private Game game;

    public MoveCommand(Game game){this.game = game;}

    public String execute(String roomId){
        if(roomId == ""){return "Type rooms to see all valid exits.";}
        boolean completed = game.canMoveTo(roomId);
        if (completed){
            game.moveTo(roomId);
            return game.getCurrentRoom().getDescription();
        }
        return "Unable to move to " + roomId;
    }
}
