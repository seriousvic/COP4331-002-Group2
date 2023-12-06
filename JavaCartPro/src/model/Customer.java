package JavaCartPro.src.model;

import java.io.Serializable;

public class Customer extends User implements Serializable {
    public Customer(String username, String password) {
        super(username, password, "CUSTOMER");
        this.shoppingCart = new ShoppingCart();
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    private ShoppingCart shoppingCart;
    private static final long serialVersionUID = 123455L;
}
