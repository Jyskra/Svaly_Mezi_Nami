package Game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private boolean playing;
    private Player player;
    private Room currentRoom;
    private UserInterface ui;
    private List<String> validCommands = new ArrayList<>();
    public static List<Room> roomsList = new ArrayList<>();
    public int totalAmountOfNotes;

    public Game(){
        this.playing = true;
        this.player = new Player();
    }

    public Player getPlayer() {
        return this.player;
    }

    public boolean canMoveTo(String roomId){
        for (Room room : roomsList){
            if (roomId.equalsIgnoreCase(room.getId())){
                return true;
            }
        }
        return false;
    }

    public void setPlaying(boolean state){
        this.playing = state;
    }

    public Room getCurrentRoom() {
        return currentRoom;
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
        List<Item> items = DataLoader.loadItemData("resources/items.json");
        List<Note> notes = DataLoader.loadNoteData("resources/notes.json");

        DataLoader.insertCharacterNotes(charactersList, notes);
        DataLoader.insertRoomCharacters(roomsList, charactersList);
        DataLoader.insertCharacterTasks(charactersList, tasks);
        DataLoader.insertRoomItems(roomsList, items);

        totalAmountOfNotes = notes.size();
    }

    private void loadValidCommands(){

        validCommands.clear();

        validCommands.add("move");
        validCommands.add("rooms");
        validCommands.add("save");
        validCommands.add("end");
        validCommands.add("help");
        validCommands.add("hint");

        if(currentRoom.getCharacter() != null){
            validCommands.add("talk");
            if(currentRoom.getCharacter().getCurrentState("isWaitingForAnAnswer") & !currentRoom.hasItem()){
                validCommands.add("answer");
            }


            if(currentRoom.getCharacter().getCurrentState("taskFinished")){
                if(currentRoom.getCharacter().getCurrentState("notePickedUp")){

                    validCommands.add("thank");

                }else if(currentRoom.getCharacter().getNote().isCanBePickedUp()){

                    validCommands.add("pickup");

                }
            }
        }

        if(currentRoom.hasItem()){
            validCommands.add("use");
        }

    }

    private boolean validateCommand(String command){
        String initialCommand = command.split(" ")[0];

        return validCommands.contains(initialCommand);
    }

    private void gameLoop(){
        while(playing){

            loadValidCommands();

            ui.print(validCommands.toString());
            String commandInfo = ui.takeUserInput("Type out a command you want to use with a coresponding parameter.");
            if (validateCommand(commandInfo)){
                ui.execCommand(commandInfo);
            }else{
                ui.print("Command isnt available.");
            }

        }
    }

    private void initializeStart(){
        String firstRoomId = "main_hall";
        for(Room room : roomsList){
            if(firstRoomId.equals(room.getId())){
                this.currentRoom = room;
            }
        }
    }

    public void startGame(){

        loadData();

        this.ui = new UserInterface(this);
        ui.loadCommands();

        initializeStart();

        gameLoop();


    }
}
