package Command;

import Game.Game;

public class ThankCommand implements Command{

    private Game game;

    public ThankCommand(Game game){
        this.game = game;
    }

    public String execute(String info){
        return game.getCurrentRoom().getCharacter().getDialogueBit("thanks");
    }
}
