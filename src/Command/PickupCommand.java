package Command;

import Game.Game;
import Game.Room;
/**
 * this class executes item (note) pickups
 * @author Jiří Baudyš
 */
public class PickupCommand implements Command{

    private Game game;

    public PickupCommand(Game game){
        this.game = game;
    }

    /**
     * picks up an item that is left in a proximity
     * @return status of what happened
     */
    public String execute(){
        Room currentRoom = game.getCurrentRoom();
        if(currentRoom.getCharacter().getNote().isCanBePickedUp()){
            currentRoom.getCharacter().getNote().setCanBePickedUp(false);
            currentRoom.getCharacter().setState("notePickedUp", true);
            return game.getPlayer().getInventory().addNote(currentRoom.getCharacter().getNote());
        }
        return "Unable to pickup note, no note to pickup or inventory is full.";
    }
}
