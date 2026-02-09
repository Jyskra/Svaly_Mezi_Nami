package Command;

import Game.Game;
import Game.Player;

public class SaveCommand implements Command{

    private Game game;

    public SaveCommand(Game game){
        this.game = game;
    }

    public String execute(String info){
        Player player = game.getPlayer();
        if(player.getInventory().getLength() > 0) {
            player.getBook().addNote(player.getInventory().removeNote(0));
            return "Current note saved to your book";
        }
        return "No note to be saved";
    }
}
