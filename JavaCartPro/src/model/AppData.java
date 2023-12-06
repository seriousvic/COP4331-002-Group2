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

    public void addProduct(Product product) {
        if (product != null && !this.inventory.getProducts().contains(product)) {
            this.inventory.addProduct(product);
        }
    }



    private List<User> users;
    private Inventory inventory;
}
