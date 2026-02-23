package Command;

import Game.*;
/**
 * this class executes all of player movement between rooms
 * @author Jiří Baudyš
 */
public class MoveCommand implements Command{

    private Game game;

    public MoveCommand(Game game){this.game = game;}

    /**
     * this function attempt to move a player into a room and if its able to do so, it executes that
     * @param roomId the id of a room the player is trying to go in
     * @return whether the player got into a new room successfully or not
     */
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
