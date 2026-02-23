package Command;

import Game.Game;
import Game.Player;
/**
 * this class saves notes from inventory to the players book
 * @author Jiří Baudyš
 */
public class SaveCommand implements Command{

    private Game game;

    public SaveCommand(Game game){
        this.game = game;
    }

    /**
     * @return what was done with the current note the player tried to save
     */
    public String execute(){
        Player player = game.getPlayer();
        if(player.getInventory().getLength() > 0) {
            player.getBook().addNote(player.getInventory().removeNote(0));
            return "Current note saved to your book";
        }
        return "No note to be saved";
    }
}
