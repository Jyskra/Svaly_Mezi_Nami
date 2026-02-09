package Command;

import Game.Game;
import Game.*;

public class UseCommand implements Command{

    private Game game;

    public UseCommand(Game game){
        this.game = game;
    }

    public String execute(String info){
        Room currentRoom = game.getCurrentRoom();
        if(currentRoom.hasItem()){
            boolean attempt = currentRoom.getCharacter().getTask().attemptCompletion(info);
            if(attempt){
                currentRoom.getCharacter().taskDone();
                return currentRoom.getItem().use();
            }
            return currentRoom.getItem().getDescription();
        }
        return "This room doesnt even contain an item.";
    }
}
