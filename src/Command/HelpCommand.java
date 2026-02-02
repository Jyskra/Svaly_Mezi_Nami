package Command;

import Game.Game;

public class HelpCommand implements Command{

    private Game game;

    public HelpCommand(Game game){
        this.game = game;
    }

    public String execute(String info){
        return "";
    }
}
