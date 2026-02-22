package Game;

import Command.EndCommand;

public class MainBodybuilder extends Character{
    public MainBodybuilder() {
        super();
    }

    private EndCommand end;

    public void setEnd(EndCommand end){
        this.end = end;
    }

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
