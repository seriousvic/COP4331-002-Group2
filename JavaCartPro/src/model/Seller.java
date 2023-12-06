package JavaCartPro.src.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * The Seller class represents a seller user in the shopping cart application
 */
public class Seller extends User implements Serializable {

    @Serial
    private static final long serialVersionUID = 987654321L;
    private FinancialHistory financialHistory;

    /**
     * Constructs a new Seller object with the specified username, password, and sets the role to "SELLER"
     * @param username the username of the seller
     * @param password the password of the seller
     */
    public Seller(String username, String password) {
        super(username, password, "SELLER");
        financialHistory = new FinancialHistory();
    }

    public FinancialHistory getFinancialHistory() {
        return financialHistory;
    }

    /**
     * Adds a new product to the seller's inventory
     * @param name        the name of the product
     * @param description the description of the product
     * @param price       the price of the product
     * @param stock       the stock quantity of the product
     */
    public void addProductToInventory(String name, String description, double price, int stock) {
        Inventory.getInstance().addProduct(getUsername(), name, description, price, stock);
    }

    /**
     * Removes a product from the seller's inventory
     * @param name the name of the product to be removed
     */
    public void removeProductFromInventory(String name) {
        Inventory.getInstance().removeProduct(name, getUsername());
    }

    /**
     * Updates the details of a product in the seller's inventory
     * @param name        the name of the product to be updated
     * @param description the new description of the product
     * @param price       the new price of the product
     * @param stock       the new stock quantity of the product
     */
    public void updateProductInInventory(String name, String description, double price, int stock) {
        Inventory.getInstance().updateProduct(getUsername(), name, description, price, stock);
    }

    /**
     * Gets the seller's current product inventory
     * @return a list of products in the seller's inventory
     */
    public List<ProductInterface> getInventory() {
        return Inventory.getInstance().getProducts();
    }
}
