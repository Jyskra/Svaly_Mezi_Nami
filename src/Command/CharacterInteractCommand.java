package Command;

import Game.*;

public class CharacterInteractCommand implements Command{

    private Game game;

    public CharacterInteractCommand(Game game){
        this.game = game;
    }

    public String execute(String info){
        return game.getCurrentRoom().getCharacter().talk(game.getPlayer());
    }
}
