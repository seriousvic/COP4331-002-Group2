package JavaCartPro.src.model;

import java.io.Serializable;

/**
 * class representing a customer
 */
public class Customer extends User implements Serializable {
    /**
     * constructor
     * @param username customer's username
     * @param password customer's password
     */
    public Customer(String username, String password) {
        super(username, password, "CUSTOMER");
        this.shoppingCart = new ShoppingCart();
    }

    /**
     * get function for shopping cart
     * @return customer's shopping cart
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    private ShoppingCart shoppingCart;
    private static final long serialVersionUID = 123455L;
}
