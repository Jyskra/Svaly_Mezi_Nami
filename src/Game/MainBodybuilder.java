package Game;

import Command.EndCommand;
/**
 * this class is the final boss of the whole game, the player either wins or loses by talking to this monster
 * @author Jiří Baudyš
 */
public class MainBodybuilder extends Character{
    public MainBodybuilder() {
        super();
    }

    private EndCommand end;

    public void setEnd(EndCommand end){
        this.end = end;
    }

    /**
     * custom functions for when the player wants to talk to this titan
     * @param player the current player
     * @return what the main bodybuilder has to say to the player
     */
    public String talk(Player player) {

        if(super.getCurrentState("isWaitingForAnAnswer")){

            int numberOfNotes = player.getBook().getNotes().size();
            if (numberOfNotes == Game.totalAmountOfNotes){
                super.taskDone();
            }

        }else{

            end.execute("");
            return "You forgot to talk to some of the fellow bodybuilders, which is a huge disrespect in my culture, TAKE THIS!";

        }

        if(super.getCurrentState("notePickedUp")){
            end.execute("");
            end.getGame().status = true;
        }

        String str = super.talk(player);

        return str;

    }
}
