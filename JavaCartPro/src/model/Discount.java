package JavaCartPro.src.model;

/**
 * interface for Discount class
 */
public interface Discount {

    /**
     * applies a discount to a purchase
     * @param shoppingCart transaction to apply a discount to
     */
    void applyDiscount(ShoppingCart shoppingCart, double amount);
}
//