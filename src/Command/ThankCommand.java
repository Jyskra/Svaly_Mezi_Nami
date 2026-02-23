package Command;

import Game.*;
/**
 * this class enables players to show gratitude in the game
 * @author Jiří Baudyš
 */
public class ThankCommand implements Command{

    private Game game;

    public ThankCommand(Game game){
        this.game = game;
    }

    /**
     * this method enables the players to show gratitude towards their ascendants
     * @return what the characters had to say in return to the shown gratitude
     */
    public String execute(){
        if(game.getCurrentRoom().getCharacter().getClass() == MainBodybuilder.class){
            game.getCurrentRoom().getCharacter().talk(game.getPlayer());
        }
        return game.getCurrentRoom().getCharacter().getDialogueBit("thanks");
    }
}
