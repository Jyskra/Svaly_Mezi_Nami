package Command;

import Game.Game;
/**
 * this class shows the player all the current available commands
 * @author Jiří Baudyš
 */
public class HelpCommand implements Command{

    private Game game;

    public HelpCommand(Game game){
        this.game = game;
    }

    /**
     * since the game automatically gives the player the list of all available commands every loop, there is no need to print out all commands again, so it
     * simply skips the current turn
     * @return skips the players turn at using commands
     */
    public String execute(String s){
        return "Here is the list of all available commands:";
    }
}
