package Command;

import Game.*;
import Game.Character;

/**
 * this class executes any answer attempt in the game
 * @author Jiří Baudyš
 */

public class AnswerCommand implements Command{

    private Game game;

    public AnswerCommand(Game game){
        this.game = game;
    }

    /**
     * @param info passes the actual answer attempt from the player to the method
     * @return if the answer was incorrect or whatever happens when the answer is correct
     */
    public String execute(String info){

        Character currentCharacter = game.getCurrentRoom().getCharacter();

        boolean status = currentCharacter.getTask().attemptCompletion(info);
        if(status){
            return currentCharacter.taskDone();
        }
        return "Incorrect answer";
    }
}
