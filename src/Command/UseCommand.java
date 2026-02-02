package Command;

import Game.Game;

public class UseCommand implements Command{

    private Game game;

    public UseCommand(Game game){
        this.game = game;
    }

    public String execute(String info){
        return "";
    }
}
