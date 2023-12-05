package JavaCartPro.src.model;

import java.util.List;

/**
 * Represents a seller user in the shopping cart application
 * Extends the User class and includes methods specific to sellers
 */
public class Seller extends User {

    private List<Product> inventory;

    /**
     * Constructs a new Seller object with the given username and password
     * @param username The username of the seller
     * @param password The password of the seller
     */
    public Seller(String username, String password) {
        super(username, password, "seller");
        this.inventory = initializeInventory();
    }

    /**
     * Gets the inventory of the seller
     * @return The list of products in the seller's inventory
     */
    public List<Product> getInventory() {
        return inventory;
    }

    /**
     * Adds a new product to the seller's inventory
     * @param product The product to be added
     */
    public void addProduct(Product product) {
        inventory.add(product);
    }

    /**
     * Removes a product from the seller's inventory
     * @param product The product to be removed
     */
    public void removeProduct(Product product) {
        inventory.remove(product);
    }

    /**
     * Updates the information of a product in the seller's inventory
     * @param product         The product to be updated
     * @param newDescription  The new description for the product
     * @param newPrice        The new price for the product
     */
    public void updateProduct(Product product, String newDescription, double newPrice) {
        if (inventory.contains(product)) {
            product.setDescription(newDescription);
            product.setPrice(newPrice);
        }
    }

    /**
     * Initializes the seller's inventory
     * @return The initialized list of products in the seller's inventory
     */
    private List<Product> initializeInventory() {
        // Implement this method to initialize the seller's inventory
        // Example: return Arrays.asList(new Product("Product1", "Description1", 10.0), new Product("Product2", "Description2", 15.0));
        return null;
    }
}
