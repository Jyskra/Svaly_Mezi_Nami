package Command;

import Game.Game;

public class PickupCommand implements Command{

    private Game game;

    public PickupCommand(Game game){
        this.game = game;
    }

    public String execute(String info){
        return "";
    }
}
