package Command;

import Game.*;
import Game.Character;

public class AnswerCommand implements Command{

    private Game game;

    public AnswerCommand(Game game){
        this.game = game;
    }

    public String execute(String info){

        Character currentCharacter = game.getCurrentRoom().getCharacter();

        boolean status = currentCharacter.getTask().attemptCompletion(info);
        if(status){
            return currentCharacter.taskDone();
        }
        return "Incorrect answer";
    }
}
