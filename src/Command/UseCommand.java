package Command;

import Game.Game;
import Game.*;
/**
 * this class executes any item activity
 * @author Jiří Baudyš
 */
public class UseCommand implements Command{

    private Game game;

    public UseCommand(Game game){
        this.game = game;
    }

    /**
     *
     * @param info what item the player is trying to use
     * @return feedback what happened when the player tried to use an item
     */
    public String execute(String info){
        Room currentRoom = game.getCurrentRoom();
        if(currentRoom.hasItem()){
            boolean attempt = currentRoom.getCharacter().getTask().attemptCompletion(info);
            if(attempt){
                return currentRoom.getItem().use() + "\n" + currentRoom.getCharacter().taskDone();
            }
            return currentRoom.getItem().getDescription();
        }
        return "This room doesnt even contain an item.";
    }
}
