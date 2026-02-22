package Command;

import Game.Game;

public class EndCommand implements Command{

    private Game game;

    public EndCommand(Game game){
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public String execute(String info){
        game.setPlaying(false);
        game.status = false;
        return "Ending game...";
    }
}
