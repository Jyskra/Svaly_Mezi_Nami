package Game;
/**
 * this class is a usable item
 * @author Jiří Baudyš
 */
public class Item {

    private String itemId;
    private String name;
    private String description;
    private String action;
    private String targetRoomId;

    public Item() {
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAction() {
        return action;
    }

    public String getTargetRoomId() {
        return targetRoomId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setTargetRoomId(String targetRoomId) {
        this.targetRoomId = targetRoomId;
    }

    public String use(){
        return this.action;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", action='" + action + '\'' +
                ", targetRoomId='" + targetRoomId + '\'' +
                '}';
    }
}
