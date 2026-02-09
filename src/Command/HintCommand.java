package Command;

import Game.Game;

public class HintCommand implements Command{

    private Game game;

    public HintCommand(Game game){
        this.game = game;
    }
    //TODO finish hint magic
    public String execute(String info){
        return "";
    }
}
