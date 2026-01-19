public class Player {
    private Task currentTask;
    private Inventory inventory;
    private Book book;
    private Room currentRoom;

    public Task getCurrentTask(){return null;}
    public Room getCurrentRoom(){return null;}
    public boolean moveTo(Room room){return false;}
}
