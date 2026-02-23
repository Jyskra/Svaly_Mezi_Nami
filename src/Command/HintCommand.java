package Command;

import Game.Game;
/**
 * this class tells the player what the main objective of the game is
 * @author Jiří Baudyš
 */
public class HintCommand implements Command{

    private Game game;

    public HintCommand(Game game){
        this.game = game;
    }

    /**
     * @return the lore of what the game is about
     */
    public String execute(){
        return "The objective of the game is to collect all notes from all bodybuilders by helping them with their tasks, saving those notes" +
                " in your book and then delivering that book to the main bodybuilder.";
    }
}
