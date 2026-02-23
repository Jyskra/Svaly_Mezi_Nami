package Command;

import Game.*;
/**
 * this class executes character dialogues
 * @author Jiří Baudyš
 */
public class CharacterInteractCommand implements Command{

    private Game game;

    public CharacterInteractCommand(Game game){
        this.game = game;
    }

    /**
     * @return the text that the current character needs to tell the player
     */
    public String execute(){
        return game.getCurrentRoom().getCharacter().talk(game.getPlayer());
    }
}
