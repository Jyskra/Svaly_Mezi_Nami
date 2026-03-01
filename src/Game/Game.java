package Game;

import Command.EndCommand;

import java.util.ArrayList;
import java.util.List;
/**
 * this class contains the main game loop and merges all the game functions together
 * @author Jiří Baudyš
 */
public class Game {
    private boolean playing;
    public boolean status;
    private String monologue;
    private Player player;
    private Room currentRoom;
    private UserInterface ui;
    private List<String> validCommands = new ArrayList<>();
    public static List<Room> roomsList = new ArrayList<>();
    public static int totalAmountOfNotes;


    public Game(){
        this.playing = true;
        this.player = new Player();
    }

    public Player getPlayer() {
        return this.player;
    }

    public boolean canMoveTo(String roomId){

        return currentRoom.isValidExit(roomId);
    }

    public void setPlaying(boolean state){
        this.playing = state;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * moves the player into their desired room if available
     * @param roomId the room id the player is trying to access
     */
    public void moveTo(String roomId){
        for (Room room : roomsList){
            if (roomId.equalsIgnoreCase(room.getId())){
                currentRoom = room;
            }
        }
    }

    /**
     * adds the ability for the main bodybuilder to end the game whenever he feels disappointed
     * @param end the command that ends the game
     */
    public void addEndToMainBodybuilder(EndCommand end){
        for(Room room : roomsList){
            if(room.getCharacter() != null){
                if(room.getCharacter().getClass() == MainBodybuilder.class){
                    room.getCharacter().setEnd(end);
                }
            }
        }
    }

    /**
     * initializes all the game data loading happening in data loader
     */
    private void loadData(){

        monologue = DataLoader.loadMonologue("resources/monologue.json");

        roomsList = DataLoader.loadRoomData("resources/rooms.json");
        List<Character> charactersList = DataLoader.loadCharacterData("resources/characters.json");
        List<Task> tasks = DataLoader.loadTaskData("resources/tasks.json");
        List<Item> items = DataLoader.loadItemData("resources/items.json");
        List<Note> notes = DataLoader.loadNoteData("resources/notes.json");

        DataLoader.insertCharacterNotes(charactersList, notes);
        DataLoader.insertRoomCharacters(roomsList, charactersList);
        DataLoader.insertCharacterTasks(charactersList, tasks);
        DataLoader.insertRoomItems(roomsList, items);

        totalAmountOfNotes = notes.size() - 1;
    }

    /**
     * loads all commands available to the player after each loop
     */
    private void loadValidCommands(){

        validCommands.clear();

        validCommands.add("move");
        validCommands.add("rooms");
        validCommands.add("end");
        validCommands.add("help");
        validCommands.add("hint");

        if(player.getInventory().getLength() > 0){
            validCommands.add("save");
        }

        if(currentRoom.getCharacter() != null){
            validCommands.add("talk");
            if(currentRoom.getCharacter().getCurrentState("isWaitingForAnAnswer") & !currentRoom.hasItem()
                    & currentRoom.getCharacter().getClass() != MainBodybuilder.class){
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

    /**
     * checks if a command provided by the player is an actual existing command
     * @param command the string provided by the player
     * @return validity of the command
     */
    private boolean validateCommand(String command){
        String initialCommand = command.split(" ")[0];

        return validCommands.contains(initialCommand);
    }

    /**
     * the main game loop, goes until the player wins or ends the game either by upsetting the main bodybuilder or ending it manually
     */
    private void gameLoop(){
        //ui.printAnimated(monologue);

        while(playing){

            loadValidCommands();

            ui.print(validCommands.toString());
            String commandInfo = ui.takeUserInput("Type out a command you want to use with a coresponding parameter.");
            if (validateCommand(commandInfo)){
                ui.execCommand(commandInfo);
            }else{
                ui.print("Command isnt available.");
            }

            ui.print("\n");

        }
        if(status){
            ui.print("You have successfully beaten the game.");
        }else{
            ui.print("You have sadly lost the game, try again!");
        }

    }

    /**
     * makes the starting room the main hall
     */
    private void initializeStart(){
        String firstRoomId = "main_hall";
        for(Room room : roomsList){
            if(firstRoomId.equals(room.getId())){
                this.currentRoom = room;
            }
        }
    }

    /**
     * initializes the use of all functions
     */
    public void startGame(){
        loadData();

        this.ui = new UserInterface(this);
        ui.loadCommands();

        initializeStart();

        gameLoop();


    }
}
