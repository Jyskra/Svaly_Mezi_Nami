package Command;

import Game.Game;

public class HelpCommand implements Command{

    private Game game;

    public HelpCommand(Game game){
        this.game = game;
    }

    //shows all available commands
    public String execute(String info){
        return "Here is the list of all available commands:";
    }
}
