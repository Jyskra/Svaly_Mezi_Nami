package Command;

import Game.Game;

import java.util.Arrays;
/**
 * this class tells the player what rooms they are able to access currently
 * @author Jiří Baudyš
 */
public class RoomsCommand implements Command{

    private Game game;

    public RoomsCommand(Game game){
        this.game = game;
    }

    /**
     * @return a list of currently accessible rooms
     */
    public String execute(){
        return Arrays.toString(game.getCurrentRoom().getExits());
    }
}
