package Command;

import Game.Game;
/**
 * this class executes the end of the game
 * @author Jiří Baudyš
 */
public class EndCommand implements Command{

    private Game game;

    public EndCommand(Game game){
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    /**
     * @return text telling the player that the game is actively ending
     */
    public String execute(){
        game.setPlaying(false);
        game.status = false;
        return "Ending game...";
    }
}
