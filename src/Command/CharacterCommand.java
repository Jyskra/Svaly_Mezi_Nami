package Command;

import Game.Character;
import Game.*;

public class CharacterCommand implements Command{
    public String execute(Player player, Character character){
        return character.talk();
    }
}
