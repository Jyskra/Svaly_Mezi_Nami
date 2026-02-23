package Game;
/**
 * this class is basically the holder of all player storage
 * @author Jiří Baudyš
 */
public class Player {
    private Inventory inventory;
    private Book book;

    public Player() {
        this.inventory = new Inventory(1);
        this.book = new Book();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Book getBook() {
        return book;
    }
}
