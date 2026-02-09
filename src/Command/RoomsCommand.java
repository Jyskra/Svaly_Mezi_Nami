package Command;

import Game.Game;

import java.util.Arrays;

public class RoomsCommand implements Command{

    private Game game;

    public RoomsCommand(Game game){
        this.game = game;
    }

    public String execute(String info){
        return Arrays.toString(game.getCurrentRoom().getExits());
    }
}
