package JavaCartPro.src.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AppData implements Serializable {

    public AppData() {
        this.users = new ArrayList<>();
        this.inventory = Inventory.getInstance();
    }

    public List<User> getUsers() {
        return users;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        if (user != null && !this.users.contains(user)) {
            this.users.add(user);
        }
    }

    public void addProduct(String seller, String name, String description, double price, int stock) {
        if (seller != null && name != null && description != null && price > 0 && stock > 0) {
            this.inventory.addProduct(seller,name,description,price, stock);
        }
    }



    private List<User> users;
    private Inventory inventory;
}
