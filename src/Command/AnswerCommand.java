package Command;

import Game.Game;

public class AnswerCommand implements Command{

    private Game game;

    public AnswerCommand(Game game){
        this.game = game;
    }

    public String execute(String info){
        return "";
    }
}
