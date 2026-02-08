package Game;

import Command.*;

import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {
    HashMap<String, Command> commands = new HashMap<String, Command>();
    private Game game;
    private Scanner scanner;

    public UserInterface(Game game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    public void loadCommands(){
        commands.put("move", new MoveCommand(game));
        commands.put("talk", new CharacterInteractCommand(game));
        commands.put("answer", new AnswerCommand(game));
        commands.put("thank", new ThankCommand(game));
        commands.put("pickup", new PickupCommand(game));
        commands.put("save", new SaveCommand(game));
        commands.put("use", new UseCommand(game));
        commands.put("end", new EndCommand(game));
        commands.put("hint", new HintCommand(game));
        commands.put("help", new HelpCommand(game));
    }

    public void print(String data){
        System.out.println(data);
    }

    public String takeUserInput(String prompt){
        String userInput = scanner.nextLine();
        return userInput;
    }

    private void execCommand(String command){

        String[] commandData = command.split(" ");

        String initialCommand = commandData[0];
        String commandParam = commandData[1];

        boolean commandExists = commands.containsKey(command);
        if(!commandExists){
            print("Invalid Command");
        }else {
            String commandExecutionData = commands.get(initialCommand).execute(commandParam);
            print(commandExecutionData);
        }

    }
}
