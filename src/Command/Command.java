package Command;
/**
 * this class is a template for all descending commands
 * @author Jiří Baudyš
 */
public interface Command {
    default String execute(String info){return "";}
}
