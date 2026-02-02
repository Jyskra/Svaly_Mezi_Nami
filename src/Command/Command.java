package Command;

public interface Command {
    default String execute(String info){return "";}
}
