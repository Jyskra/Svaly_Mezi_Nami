package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private boolean playing;
    private Player player;
    private Room currentRoom;
    private UserInterface ui;
    private List<String> validCommands = new ArrayList<>();
    public static List<Room> roomsList = new ArrayList<>();

    public Game(){
    }

    public boolean canMoveTo(String roomId){
        for (Room room : roomsList){
            if (roomId.equalsIgnoreCase(room.getId())){
                return true;
            }
        }
        return false;
    }

    public void moveTo(String roomId){
        for (Room room : roomsList){
            if (roomId.equalsIgnoreCase(room.getId())){
                currentRoom = room;
            }
        }
    }

    private void loadData(){

        roomsList = DataLoader.loadRoomData("resources/rooms.json");
        List<Character> charactersList = DataLoader.loadCharacterData("resources/characters.json");
        List<Task> tasks = DataLoader.loadTaskData("resources/tasks.json");

        DataLoader.insertRoomCharacters(roomsList, charactersList);
        DataLoader.insertCharacterTasks(charactersList, tasks);

    }

    private void loadValidCommands(){

        validCommands.add("move");
        validCommands.add("save");
        validCommands.add("end");
        validCommands.add("help");
        validCommands.add("hint");

        if(currentRoom.getCharacter().getCurrentState("isWaitingForAnAnswer")){
            validCommands.add("answer");
        }

        if(currentRoom.getCharacter() != null){
            validCommands.add("talk");
        }

        if(currentRoom.getCharacter().getCurrentState("taskFinished")){
            validCommands.add("thank");
            validCommands.add("pickup");
        }

        if(currentRoom.hasItem()){
            validCommands.add("use");
        }

    }

    private void gameLoop(){
        while(playing){

            loadValidCommands();

            String commandInfo = ui.takeUserInput("");

        }
    }

    public void startGame(){

        loadData();

        this.ui = new UserInterface(this);


    }
}
