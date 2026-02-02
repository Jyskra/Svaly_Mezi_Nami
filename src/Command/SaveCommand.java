package Command;

import Game.Game;

public class SaveCommand implements Command{

    private Game game;

    public SaveCommand(Game game){
        this.game = game;
    }

    public String execute(String info){
        return "";
    }
}
