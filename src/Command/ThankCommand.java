package Command;

import Game.*;

public class ThankCommand implements Command{

    private Game game;

    public ThankCommand(Game game){
        this.game = game;
    }

    public String execute(String info){
        if(game.getCurrentRoom().getCharacter().getClass() == MainBodybuilder.class){
            game.getCurrentRoom().getCharacter().talk(game.getPlayer());
        }
        return game.getCurrentRoom().getCharacter().getDialogueBit("thanks");
    }
}
