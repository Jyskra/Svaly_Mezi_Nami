package Game;

import Command.*;

import java.util.HashMap;
import java.util.Scanner;
/**
 * this class handles all interface with the player
 * @author Jiří Baudyš
 */
public class UserInterface {
    HashMap<String, Command> commands = new HashMap<String, Command>();
    private Game game;
    private Scanner scanner;

    public UserInterface(Game game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    /**
     * loads up all the command into a hashmap so they can be executed very easily
     */
    public void loadCommands(){
        EndCommand end = new EndCommand(game);
        game.addEndToMainBodybuilder(end);

        commands.put("move", new MoveCommand(game));
        commands.put("talk", new CharacterInteractCommand(game));
        commands.put("answer", new AnswerCommand(game));
        commands.put("thank", new ThankCommand(game));
        commands.put("pickup", new PickupCommand(game));
        commands.put("save", new SaveCommand(game));
        commands.put("use", new UseCommand(game));
        commands.put("end", end);
        commands.put("hint", new HintCommand(game));
        commands.put("help", new HelpCommand(game));
        commands.put("rooms", new RoomsCommand(game));
    }

    /**
     * prints out data to the user
     * @param data data that needs to be printed to the console
     */
    public void print(String data){
        System.out.println(data);
    }

    /**
     * takes user input
     * @param prompt the prompt said to the player whenever some input is needed
     * @return the taken user input
     */
    public String takeUserInput(String prompt){
        print(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    /**
     * executes a given command
     * @param command the data of the command that is supposed to be executed
     */
    public void execCommand(String command){

        String[] commandData = command.split(" ");

        String initialCommand = commandData[0];
        String commandParam = "";
        if(commandData.length > 1){
            commandParam = commandData[1];
        }

        boolean commandExists = commands.containsKey(initialCommand);
        if(!commandExists){
            print("Invalid Command");
        }else {
            String commandExecutionData = commands.get(initialCommand).execute(commandParam);
            print(commandExecutionData);
        }

    }
}
