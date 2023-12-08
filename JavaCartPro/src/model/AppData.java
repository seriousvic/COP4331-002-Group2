package JavaCartPro.src.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * data stored by the program
 */
public class AppData implements Serializable {
    /**
     * constructor for appData
     */
    public AppData() {
        this.users = new ArrayList<>();
        this.inventory = Inventory.getInstance();
    }

    /**
     * get function for users
     * @return users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * get function for inventory
     * @return inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * set function for users
     * @param users users to be set
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * function to add a user to program's memory
     * @param user user to be added
     */
    public void addUser(User user) {
        if (user != null && !this.users.contains(user)) {
            this.users.add(user);
        }
    }

    /**
     * function to add a product to the program's memory
     * @param sellerAccount seller adding the product
     * @param seller seller's name
     * @param name product name
     * @param description product description
     * @param cost product cost
     * @param price product price
     * @param stock product stock
     */
    public void addProduct(Seller sellerAccount, String seller, String name, String description, double cost, double price, int stock) {
        if (seller != null && name != null && description != null && price > 0 && stock > 0) {
            this.inventory.addProduct(sellerAccount, seller,name,description, cost, price, stock);
        }
    }





    private List<User> users;
    private Inventory inventory;
}
