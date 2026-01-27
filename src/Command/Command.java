package Command;

import Game.Player;

public interface Command {
    default String execute(Player player){return "";}
}
