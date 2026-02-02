package Command;

import Game.Game;

public class EndCommand implements Command{

    private Game game;

    public EndCommand(Game game){
        this.game = game;
    }

    public String execute(String info){
        return "";
    }
}
