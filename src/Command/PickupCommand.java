package Command;

import Game.Game;
import Game.Room;

public class PickupCommand implements Command{

    private Game game;

    public PickupCommand(Game game){
        this.game = game;
    }

    public String execute(String info){
        Room currentRoom = game.getCurrentRoom();
        if(currentRoom.getCharacter().getNote().isCanBePickedUp()){
            currentRoom.getCharacter().getNote().setCanBePickedUp(false);
            currentRoom.getCharacter().setState("notePickedUp", true);
            return game.getPlayer().getInventory().addNote(currentRoom.getCharacter().getNote());
        }
        return "No note to pickup";
    }
}
